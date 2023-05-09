package org.jd.partoch.web.view;

import org.jd.partoch.web.model.Chords;
import org.jd.partoch.web.model.Lyrics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LyricsHandlerTest {


    @Test
    void displayPartSongNull(){
        LyricsHandler drawer = new LyricsHandler();
        assertEquals("", drawer.display(null));
    }
    @Test
    void displayPartSongThatIsNotChord(){
        LyricsHandler drawer = new LyricsHandler();
        assertEquals("", drawer.display(new Chords()));
    }

    @Test
    void getDisplayFromEmptyLyricsParagraph() {
        LyricsHandler handler = new LyricsHandler();

        assertEquals("<p>\n</p>", handler.display(new Lyrics()));
    }

    @Test
    void getDisplayLyricsParagraph() {
        LyricsHandler handler = new LyricsHandler();
        String lyrics = "lalala lala lala la";
        Lyrics lyricsParagraph = new Lyrics();
        lyricsParagraph.set(lyrics);

        assertEquals("<p>\n" +
                lyrics + "\n" +
                "</p>", handler.display(lyricsParagraph));
    }

}