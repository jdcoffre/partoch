package org.jd.partoch.web.view;

import org.jd.partoch.music.*;
import org.jd.partoch.web.model.Chords;
import org.jd.partoch.web.model.Lyrics;
import org.jd.partoch.web.model.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongHandlerTest {
    @Test
    void displayEmptySong(){
        SongHandler handler = new SongHandler();
        assertEquals("", handler.display(null));
    }
    @Test
    void displayPartSongThatIsNotChord(){
        SongHandler handler = new SongHandler();
        assertEquals("", handler.display(new Chords()));
    }

    @Test
    void getDisplayFullSong() throws MusicFormatException {
        SongHandler handler = new SongHandler();

        Chord chord = new Chord();
        chord.setTone(Tone.C);
        chord.setQuality(Quality.MAJOR);

        ChordChart chordChart = new ChordChart();
        chordChart.load("{0,3,2,0,1,0}");
        chord.setChordChart(chordChart);

        Song song = new Song();
        String songTitle = "Best Song Ever";
        song.setTitle(songTitle);

        Chords chords = new Chords();
        chords.addChord(chord);
        song.addSongPart(chords);

        Lyrics lyricsParagraph = new Lyrics();
        String lyrics = "lalala lala lala la lalala lala lala la";
        lyricsParagraph.set(lyrics);
        song.addSongPart(lyricsParagraph);

        assertEquals("<h1>"+ songTitle +"</h1>\n" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\">\n" +
                "  <defs>\n" +
                "    <style>\n" +
                "      .cls-1{fill:none;stroke:#000;stroke-miterlimit:10;stroke-width:1px}\n" +
                "      .cls-2{font-size:12px;font-family:Arial}\n" +
                "    </style>\n" +
                "  </defs>\n" +
                "  <title>Chord " + chord.getTone()+ chord.getQuality() +"</title>\n" +
                "    <path d=\"M23 16 h45\"class=\"cls-1\"/>\n" +
                "    <path d=\"M23 32 h45\"class=\"cls-1\"/>\n" +
                "    <path d=\"M23 48 h45\"class=\"cls-1\"/>\n" +
                "    <path d=\"M23 64 h45\"class=\"cls-1\"/>\n" +
                "    <path d=\"M23 80 h45\"class=\"cls-1\"/>\n" +
                "    <path d=\"M23 96 h45\"class=\"cls-1\"/>\n" +
                "    <path d=\"M23 16 V96\"class=\"cls-1\"/>\n" +
                "    <path d=\"M32 16 V96\"class=\"cls-1\"/>\n" +
                "    <path d=\"M41 16 V96\"class=\"cls-1\"/>\n" +
                "    <path d=\"M50 16 V96\"class=\"cls-1\"/>\n" +
                "    <path d=\"M59 16 V96\"class=\"cls-1\"/>\n" +
                "    <path d=\"M68 16 V96\"class=\"cls-1\"/>\n" +
                "    <circle fill=\"white\" stroke=\"black\" cx=\"23\" cy=\" 8\" r=\"4\"/>\n" +
                "    <circle cx=\"32\" cy=\" 56\" r=\"5\"/>\n" +
                "    <circle cx=\"41\" cy=\" 40\" r=\"5\"/>\n" +
                "    <circle fill=\"white\" stroke=\"black\" cx=\"50\" cy=\" 8\" r=\"4\"/>\n" +
                "    <circle cx=\"59\" cy=\" 24\" r=\"5\"/>\n" +
                "    <circle fill=\"white\" stroke=\"black\" cx=\"68\" cy=\" 8\" r=\"4\"/>\n" +
                "</svg>\n" +
                "\n" +
                "<p>\n" +
                lyrics+"\n" +
                "</p>\n", handler.display(song));
    }

}