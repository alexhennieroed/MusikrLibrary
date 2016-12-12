package com.alexhennieroed.musikrlib.managers;

import com.alexhennieroed.musikrlib.interfaces.SongDataInterface;
import com.alexhennieroed.musikrlib.model.Song;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Connects to the JaudioTagger library
 * @author Alexander Hennie-Roed
 * @version 1.0.1
 */
class JaudioConnector implements SongDataInterface {

    @Override
    public List<String> getData(Song s)
        throws Exception {
        List<String> data = new ArrayList<>();
        AudioFile audioFile = AudioFileIO.read(new File(s.getSongLocation()));
        Tag tag = audioFile.getTag();
        AudioHeader header = audioFile.getAudioHeader();
        data.add(tag.getFirst(FieldKey.TITLE));
        data.add(tag.getFirst(FieldKey.ARTIST));
        data.add(tag.getFirst(FieldKey.ALBUM));
        data.add(tag.getFirst(FieldKey.GENRE));
        data.add(Integer.toString(header.getTrackLength()));
        return data;
    }

}
