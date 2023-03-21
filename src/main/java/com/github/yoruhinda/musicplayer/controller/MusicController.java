package com.github.yoruhinda.musicplayer.controller;

import com.github.yoruhinda.musicplayer.listeners.FinishedListener;
import com.github.yoruhinda.musicplayer.listeners.MusicListener;
import com.github.yoruhinda.musicplayer.listeners.MusicMouseListener;
import com.github.yoruhinda.musicplayer.model.MusicFile;
import com.github.yoruhinda.musicplayer.model.enums.PlayingStatus;
import com.github.yoruhinda.musicplayer.ui.panels.MusicControlPanel;
import com.github.yoruhinda.musicplayer.ui.panels.MusicInfoPanel;
import com.github.yoruhinda.musicplayer.ui.panels.MusicListPanel;
import com.github.yoruhinda.musicplayer.util.ImagesUtil;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class MusicController {
    private MusicListener musicListener = new MusicListener(this);
    private MusicMouseListener mouseListener = new MusicMouseListener(this);
    private Thread playThread;
    private AdvancedPlayer advancedPlayer;
    private BufferedInputStream bufferedInputStream;
    private PlayingStatus playingStatus = PlayingStatus.STOP;
    private int pausedOnFrame;
    private File selectedSong;

    private MusicInfoPanel musicInfoPanel;
    private MusicControlPanel musicControlPanel;
    private MusicListPanel musicListPanel;

    public MusicController(MusicInfoPanel musicInfoPanel, MusicControlPanel musicControlPanel, MusicListPanel musicListPanel) {
        this.musicInfoPanel = musicInfoPanel;
        this.musicControlPanel = musicControlPanel;
        this.musicListPanel = musicListPanel;
        addListener();
    }

    public void addListener() {
        musicControlPanel.getPlay().addActionListener(musicListener);
        musicControlPanel.getAdvance().addActionListener(musicListener);
        musicControlPanel.getRetreat().addActionListener(musicListener);
        musicListPanel.getMusicNameList().addMouseListener(mouseListener);
    }

    public void chooseMusicsAddInList() {
        JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Music"));
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("only mp3 files", "mp3");
        fileChooser.setFileFilter(extensionFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.showOpenDialog(musicControlPanel);
        for (File selectedFile : fileChooser.getSelectedFiles()) {
            musicListPanel.getDefaultMusicNameListModel().addElement(new MusicFile(selectedFile));
        }
        musicListPanel.getMusicNameList().setSelectedIndex(0);
    }

    public void playMusic(File musicFile) {
        if (playingStatus == PlayingStatus.PAUSED || playingStatus == PlayingStatus.FINISHED || playingStatus == PlayingStatus.STOP) {
            setPlayingStatus(PlayingStatus.PLAYING);
            musicControlPanel.getPlay().setIcon(ImagesUtil.pauseImageIcon);
            musicInfoPanel.getMusicName().setText(getFileNameWithoutExtension(musicFile));
            try {
                InputStream inputStream = new FileInputStream(musicFile);
                bufferedInputStream = new BufferedInputStream(inputStream);
                advancedPlayer = new AdvancedPlayer(bufferedInputStream);
                advancedPlayer.setPlayBackListener(new FinishedListener(this));
                playThread = new Thread(() -> {
                    try {
                        advancedPlayer.play(pausedOnFrame, Integer.MAX_VALUE);
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                });
                playThread.start();
            } catch (FileNotFoundException | JavaLayerException e) {
                System.out.println("Problem in file" + musicFile.getName());
                e.printStackTrace();
            }
        }
    }

    public void stopMusic() {
        if (playingStatus == PlayingStatus.FINISHED) return;
        setPlayingStatus(PlayingStatus.STOP);
        selectedSong = null;
        close();
        setPausedOnFrame(0);
    }

    public void pauseMusic() {
        if (playingStatus == PlayingStatus.FINISHED) return;
        if (playingStatus == PlayingStatus.PLAYING) {
            setPlayingStatus(PlayingStatus.PAUSED);
            musicControlPanel.getPlay().setIcon(ImagesUtil.playButtonIcon);
            advancedPlayer.stop();
            close();
        }
    }

    public void close() {
        if (advancedPlayer != null) {
            advancedPlayer.setPlayBackListener(null);
            advancedPlayer.close();
            advancedPlayer = null;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bufferedInputStream = null;
        }
    }

    public boolean isEmptyMusicList() {
        return musicListPanel.getDefaultMusicNameListModel().isEmpty();
    }

    public String getFileNameWithoutExtension(File musicFile){
        String substring = musicFile.getName().substring(0, musicFile.getName().indexOf(".mp3"));
        String name;
        if(substring.length() >= 30){
            name = substring.substring(0,30);
        }else {
            name = substring;
        }
        return name;
    }


    public File getActualSong() {
        if (selectedSong == null) {
            selectedSong = musicListPanel.getMusicNameList().getSelectedValue().getMusic();
            return selectedSong;
        }
        return selectedSong;
    }

    public void setSelectedSong(File selectedSong) {
        this.selectedSong = selectedSong;
    }

    public File getNextSong() {
        int index = musicListPanel.getMusicNameList().getSelectedIndex() + 1;
        musicListPanel.getMusicNameList().setSelectedIndex(index);
        selectedSong = musicListPanel.getDefaultMusicNameListModel().get(index).getMusic();
        return selectedSong;
    }

    public File getPreviousSong() {
        int index = musicListPanel.getMusicNameList().getSelectedIndex() - 1;
        musicListPanel.getMusicNameList().setSelectedIndex(index);
        selectedSong = musicListPanel.getDefaultMusicNameListModel().get(index).getMusic();
        return selectedSong;
    }

    public int getPausedOnFrame() {
        return pausedOnFrame;
    }

    public void setPausedOnFrame(int pausedOnFrame) {
        this.pausedOnFrame = pausedOnFrame;
    }

    public PlayingStatus getPlayingStatus() {
        return playingStatus;
    }

    public void setPlayingStatus(PlayingStatus playingStatus) {
        if (this.getPlayingStatus() == playingStatus) {
            return;
        }
        this.playingStatus = playingStatus;
    }
}
