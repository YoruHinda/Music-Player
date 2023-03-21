package com.github.yoruhinda.musicplayer.listeners;

import com.github.yoruhinda.musicplayer.controller.MusicController;
import com.github.yoruhinda.musicplayer.util.ImagesUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicListener implements ActionListener {
    private MusicController musicController;

    public MusicListener(MusicController musicController) {
        this.musicController = musicController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (musicController.isEmptyMusicList()) {
                musicController.chooseMusicsAddInList();
                return;
            }
            if (button.getIcon().equals(ImagesUtil.playButtonIcon)) {
                musicController.playMusic(musicController.getActualSong());
                return;
            }
            if (button.getIcon().equals(ImagesUtil.pauseImageIcon)) {
                musicController.pauseMusic();
                return;
            }
            if (button.getIcon().equals(ImagesUtil.nextButtonIcon)) {
                musicController.stopMusic();
                musicController.playMusic(musicController.getNextSong());
                return;
            }
            if (button.getIcon().equals(ImagesUtil.backButtonIcon)) {
                musicController.stopMusic();
                musicController.playMusic(musicController.getPreviousSong());
            }
        }
    }
}
