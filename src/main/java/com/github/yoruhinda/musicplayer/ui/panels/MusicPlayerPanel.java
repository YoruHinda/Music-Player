package com.github.yoruhinda.musicplayer.ui.panels;

import javax.swing.*;
import java.awt.*;

public class MusicPlayerPanel extends JPanel {
    private MusicControlPanel controlMusicPanel = new MusicControlPanel();
    private MusicListPanel musicListPanel = new MusicListPanel();
    private MusicInfoPanel musicInfoPanel = new MusicInfoPanel();

    public MusicPlayerPanel() {
        initialize();
    }

    private void initialize(){
        setLayout(new BorderLayout());
        add(controlMusicPanel, BorderLayout.SOUTH);
        add(musicInfoPanel, BorderLayout.CENTER);
        add(musicListPanel, BorderLayout.EAST);
    }
}
