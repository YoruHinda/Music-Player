package com.github.yoruhinda.musicplayer.ui.panels;

import com.github.yoruhinda.musicplayer.util.Colors;
import com.github.yoruhinda.musicplayer.util.ImagesUtil;

import javax.swing.*;
import java.awt.*;

public class MusicInfoPanel extends JPanel {
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

        musicName.setText("Click in button");
        musicName.setFont(new Font("sans-sarif", Font.BOLD, 20));
        musicName.setForeground(Color.WHITE);

        add(musicImage, gridBagConstraints);
        add(musicName, gridBagConstraints);
    }

    public JLabel getMusicName() {
        return musicName;
    }
}
