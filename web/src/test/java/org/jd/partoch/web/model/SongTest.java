package org.jd.partoch.web.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SongTest {

    @Test
    public void basicValidation() {
        Song song = new Song();
        String songTitle = "Test song";
        Lyrics lyrics = new Lyrics();
        Chords chords = new Chords();

        song.setTitle(songTitle);
        song.addSongPart(chords);
        song.addSongPart(lyrics);

        assertEquals(songTitle, song.getTitle());
        assertEquals(chords, song.getSongParts().get(0));
        assertEquals(lyrics, song.getSongParts().get(1));
    }
}