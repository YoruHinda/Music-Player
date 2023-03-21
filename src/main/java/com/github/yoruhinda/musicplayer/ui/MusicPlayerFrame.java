package com.github.yoruhinda.musicplayer.ui;

import com.github.yoruhinda.musicplayer.controller.MusicController;
import com.github.yoruhinda.musicplayer.ui.panels.MusicControlPanel;
import com.github.yoruhinda.musicplayer.ui.panels.MusicInfoPanel;
import com.github.yoruhinda.musicplayer.ui.panels.MusicListPanel;
import com.github.yoruhinda.musicplayer.util.ImagesUtil;

import javax.swing.*;
import java.awt.*;

public class MusicPlayerFrame extends JFrame {
    private final int width = 640, height = 320;
    private MusicControlPanel musicControlPanel = new MusicControlPanel();
    private MusicListPanel musicListPanel = new MusicListPanel();
    private MusicInfoPanel musicInfoPanel = new MusicInfoPanel();
    private MusicController musicController;

    public MusicPlayerFrame() {
        initializeFrame();
    }

    private void initializeFrame() {
        setTitle("Music Player");
        setIconImage(ImagesUtil.iconImage.getImage());
        setLayout(new BorderLayout());
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        musicController = new MusicController(musicInfoPanel, musicControlPanel, musicListPanel);
        add(musicControlPanel, BorderLayout.SOUTH);
        add(musicInfoPanel, BorderLayout.CENTER);
        add(musicListPanel, BorderLayout.EAST);
        setVisible(true);
    }

}
