package com.github.yoruhinda.musicplayer.model;

import java.io.File;

public class MusicFile {
    private File music;

    public MusicFile(File music) {
        this.music = music;
    }

    public File getMusic() {
        return music;
    }

    @Override
    public String toString() {
        return music.getName();
    }
}
