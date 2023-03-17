package com.github.yoruhinda.musicplayer.ui.panels;

import com.github.yoruhinda.musicplayer.util.Colors;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MusicListPanel extends JPanel {
    private DefaultListModel<String> fileDefaultListModel = new DefaultListModel<>();
    private JList<String> musicList = new JList<>(fileDefaultListModel);
    private JScrollPane jScrollPane = new JScrollPane(musicList);

    public MusicListPanel() {
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(250,100));

        jScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Music List",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("sans-sarif", Font.BOLD,12),
                Color.WHITE));

        jScrollPane.setBackground(Colors.AQUA_MARINE);
        musicList.setBackground(Colors.AQUA_MARINE);

        musicList.setForeground(Color.white);
        musicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        musicList.setLayoutOrientation(JList.VERTICAL);

        add(jScrollPane);
    }
}
