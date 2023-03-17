package com.github.yoruhinda.musicplayer.ui.panels;

import com.github.yoruhinda.musicplayer.util.Colors;
import com.github.yoruhinda.musicplayer.util.ImagesUtil;

import javax.swing.*;
import java.awt.*;

public class MusicControlPanel extends JPanel {
    private JButton play = new JButton();
    private JButton advance = new JButton();
    private JButton retreat = new JButton();

    public MusicControlPanel() {
        initialize();
    }

    private void initialize() {
        Dimension buttonDimension = new Dimension(50, 50);

        setLayout(new FlowLayout());
        setBackground(Colors.AQUA_MARINE);

        retreat.setPreferredSize(buttonDimension);
        advance.setPreferredSize(buttonDimension);
        play.setPreferredSize(buttonDimension);

        retreat.setIcon(ImagesUtil.backButtonIcon);
        advance.setIcon(ImagesUtil.nextButtonIcon);
        play.setIcon(ImagesUtil.playButtonIcon);

        retreat.setBorder(BorderFactory.createEmptyBorder());
        advance.setBorder(BorderFactory.createEmptyBorder());
        play.setBorder(BorderFactory.createEmptyBorder());

        retreat.setBackground(Color.LIGHT_GRAY);
        advance.setBackground(Color.LIGHT_GRAY);
        play.setBackground(Color.LIGHT_GRAY);

        retreat.setFocusPainted(false);
        advance.setFocusPainted(false);
        play.setFocusPainted(false);

        add(retreat);
        add(play);
        add(advance);
    }
}
