package com.github.yoruhinda.musicplayer.ui;

import com.github.yoruhinda.musicplayer.ui.panels.MusicPlayerPanel;
import com.github.yoruhinda.musicplayer.util.ImagesUtil;

import javax.swing.*;

public class MusicPlayerFrame extends JFrame {
    private final int width = 640, height = 320;
    private MusicPlayerPanel musicPlayerPanel = new MusicPlayerPanel();

    public MusicPlayerFrame() {
        initializeFrame();
    }

    private void initializeFrame() {
        setIconImage(ImagesUtil.iconImage.getImage());
        setTitle("Music Player");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(musicPlayerPanel);
        setVisible(true);
    }

}
