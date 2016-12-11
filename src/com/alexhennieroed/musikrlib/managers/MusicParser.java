package com.alexhennieroed.musikrlib.managers;

import com.alexhennieroed.musikrlib.interfaces.MusicInterface;
import com.alexhennieroed.musikrlib.model.Album;
import com.alexhennieroed.musikrlib.model.Artist;
import com.alexhennieroed.musikrlib.model.Song;

import java.util.List;

/**
 * Traverses the provider to create a structure
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
class MusicParser {

    private List<Artist> artistList;
    private List<Album> albumList;
    private List<Song> songList;

    public MusicParser(MusicInterface mi) {
        this.artistList = mi.getArtists();
        this.albumList = mi.getAlbums();
        this.songList = mi.getSongs();
    }

    public List<Artist> getArtistList() { return artistList; }

    public List<Album> getAlbumList() { return albumList; }

    public List<Song> getSongList() { return songList; }
}
