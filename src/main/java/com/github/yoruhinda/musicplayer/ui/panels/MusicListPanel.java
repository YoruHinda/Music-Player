package com.github.yoruhinda.musicplayer.ui.panels;

import com.github.yoruhinda.musicplayer.model.MusicFile;
import com.github.yoruhinda.musicplayer.util.Colors;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MusicListPanel extends JPanel {
    private DefaultListModel<MusicFile> defaultMusicNameListModel = new DefaultListModel<>();
    private JList<MusicFile> musicNameList = new JList<>(defaultMusicNameListModel);
    private JScrollPane scrollPane = new JScrollPane(musicNameList);

    public MusicListPanel() {
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(250, 100));

        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Music List",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("sans-sarif", Font.BOLD, 12),
                Color.WHITE));

        scrollPane.setBackground(Colors.AQUA_MARINE);
        musicNameList.setBackground(Colors.AQUA_MARINE);

        musicNameList.setForeground(Color.white);
        musicNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        musicNameList.setLayoutOrientation(JList.VERTICAL);

        add(scrollPane);
    }

    public DefaultListModel<MusicFile> getDefaultMusicNameListModel() {
        return defaultMusicNameListModel;
    }

    public JList<MusicFile> getMusicNameList() {
        return musicNameList;
    }
}
