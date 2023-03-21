package com.github.yoruhinda.musicplayer.listeners;

import com.github.yoruhinda.musicplayer.controller.MusicController;
import com.github.yoruhinda.musicplayer.model.enums.PlayingStatus;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class FinishedListener extends PlaybackListener {

    private MusicController musicController;

    public FinishedListener(MusicController musicController) {
        this.musicController = musicController;
    }

    @Override
    public void playbackFinished(PlaybackEvent evt) {
        musicController.setPausedOnFrame(musicController.getPausedOnFrame()+evt.getFrame() / 27);
        if(musicController.getPlayingStatus() == PlayingStatus.PLAYING){
            musicController.setPlayingStatus(PlayingStatus.FINISHED);
            musicController.close();
            musicController.setPausedOnFrame(0);
            musicController.setSelectedSong(null);
            musicController.playMusic(musicController.getNextSong());
        }
    }
}
