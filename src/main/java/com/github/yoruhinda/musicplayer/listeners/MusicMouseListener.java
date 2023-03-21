package com.github.yoruhinda.musicplayer.listeners;

import com.github.yoruhinda.musicplayer.controller.MusicController;
import com.github.yoruhinda.musicplayer.model.MusicFile;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MusicMouseListener implements MouseListener {
    private MusicController musicController;

    public MusicMouseListener(MusicController musicController) {
        this.musicController = musicController;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JList source = (JList) e.getSource();
        if (e.getClickCount() == 2) {
            if (source.getSelectedValue() instanceof MusicFile) {
                MusicFile selectedValue = (MusicFile) source.getSelectedValue();
                musicController.stopMusic();
                musicController.setSelectedSong(selectedValue.getMusic());
                musicController.playMusic(selectedValue.getMusic());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
