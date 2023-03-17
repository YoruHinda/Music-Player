package com.github.yoruhinda.musicplayer.ui.panels;

import com.github.yoruhinda.musicplayer.util.Colors;
import com.github.yoruhinda.musicplayer.util.ImagesUtil;

import javax.swing.*;
import java.awt.*;

public class MusicInfoPanel extends JPanel {
    private JSlider musicTime = new JSlider();
    private JLabel musicImage = new JLabel();
    private JLabel musicName = new JLabel();


    public MusicInfoPanel() {
        initialize();
    }

    private void initialize() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        setLayout(new GridBagLayout());
        setBackground(Colors.AQUA_MARINE);

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        musicName.setHorizontalAlignment(SwingConstants.CENTER);
        musicImage.setHorizontalAlignment(SwingConstants.CENTER);

        musicName.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        musicImage.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        musicImage.setIcon(ImagesUtil.defaultImageIcon);

        musicName.setText("Click in play button");
        musicName.setFont(new Font("sans-sarif", Font.BOLD, 15));
        musicName.setForeground(Color.WHITE);

        musicTime.setBackground(Colors.AQUA_MARINE);
        musicTime.setValue(0);
        musicTime.setEnabled(false);

        add(musicImage, gridBagConstraints);
        add(musicName, gridBagConstraints);
        add(musicTime, gridBagConstraints);
    }
}
