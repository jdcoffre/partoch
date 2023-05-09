package org.jd.partoch.web.view;

import org.jd.partoch.web.model.Chords;
import org.jd.partoch.web.model.Lyrics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LyricsHandlerTest {


    @Test
    public void displayPartSongNull(){
        LyricsHandler drawer = new LyricsHandler();
        assertEquals("", drawer.display(null));
    }
    @Test
    public void displayPartSongThatIsNotChord(){
        LyricsHandler drawer = new LyricsHandler();
        assertEquals("", drawer.display(new Chords()));
    }

    @Test
    public void getDisplayFromEmptyLyricsParagraph() {
        LyricsHandler handler = new LyricsHandler();

        assertEquals("<p>\n</p>", handler.display(new Lyrics()));
    }

    @Test
    public void getDisplayLyricsParagraph() {
        LyricsHandler handler = new LyricsHandler();
        String lyrics = "lalala lala lala la";
        Lyrics lyricsParagraph = new Lyrics();
        lyricsParagraph.set(lyrics);

        assertEquals("<p>\n" +
                lyrics + "\n" +
                "</p>", handler.display(lyricsParagraph));
    }

}