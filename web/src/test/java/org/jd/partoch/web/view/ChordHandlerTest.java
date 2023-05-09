package org.jd.partoch.web.view;

import org.jd.partoch.music.MusicFormatException;
import org.jd.partoch.music.Chord;
import org.jd.partoch.music.ChordChart;
import org.jd.partoch.web.model.Lyrics;
import org.jd.partoch.web.model.Displayable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChordHandlerTest {

    @Test
    public void getSVGFromEmptyChord() {
        ChordHandler drawer = new ChordHandler();
        ChordChart chordChart = new ChordChart();
        Chord chord = new Chord();
        chord.setChordChart(chordChart);

        assertEquals("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\">\n" +
                "  <defs>\n" +
                "    <style>\n" +
                "      .cls-1{fill:none;stroke:#000;stroke-miterlimit:10;stroke-width:1px}\n" +
                "      .cls-2{font-size:12px;font-family:Arial}\n" +
                "    </style>\n" +
                "  </defs>\n" +
                "  <title>Chord nullnull</title>\n" +
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
                "    <text class=\"cls-2\" transform=\"translate(20 14)\">X</text>\n" +
                "    <text class=\"cls-2\" transform=\"translate(29 14)\">X</text>\n" +
                "    <text class=\"cls-2\" transform=\"translate(38 14)\">X</text>\n" +
                "    <text class=\"cls-2\" transform=\"translate(47 14)\">X</text>\n" +
                "    <text class=\"cls-2\" transform=\"translate(56 14)\">X</text>\n" +
                "    <text class=\"cls-2\" transform=\"translate(65 14)\">X</text>\n" +
                "</svg>", drawer.display(chord));
    }

    @Test
    public void getSVGFromChordWithEmptyStrings() throws MusicFormatException {
        ChordHandler drawer = new ChordHandler();
        ChordChart chordChart = new ChordChart();
        chordChart.load("{0,0,2,2,1,0}");

        Chord chord = new Chord();
        chord.setChordChart(chordChart);

        assertEquals("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\">\n" +
                "  <defs>\n" +
                "    <style>\n" +
                "      .cls-1{fill:none;stroke:#000;stroke-miterlimit:10;stroke-width:1px}\n" +
                "      .cls-2{font-size:12px;font-family:Arial}\n" +
                "    </style>\n" +
                "  </defs>\n" +
                "  <title>Chord nullnull</title>\n" +
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
                "    <circle fill=\"white\" stroke=\"black\" cx=\"32\" cy=\" 8\" r=\"4\"/>\n" +
                "    <circle cx=\"41\" cy=\" 40\" r=\"5\"/>\n" +
                "    <circle cx=\"50\" cy=\" 40\" r=\"5\"/>\n" +
                "    <circle cx=\"59\" cy=\" 24\" r=\"5\"/>\n" +
                "    <circle fill=\"white\" stroke=\"black\" cx=\"68\" cy=\" 8\" r=\"4\"/>\n" +
                "</svg>", drawer.display(chord));
    }

    @Test
    public void getSVGFromChord() throws MusicFormatException {
        ChordHandler drawer = new ChordHandler();
        ChordChart chordChart = new ChordChart();
        chordChart.load("{1,1,3,3,2,1}");

        Chord chord = new Chord();
        chord.setChordChart(chordChart);

        assertEquals("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\">\n" +
                "  <defs>\n" +
                "    <style>\n" +
                "      .cls-1{fill:none;stroke:#000;stroke-miterlimit:10;stroke-width:1px}\n" +
                "      .cls-2{font-size:12px;font-family:Arial}\n" +
                "    </style>\n" +
                "  </defs>\n" +
                "  <title>Chord nullnull</title>\n" +
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
                "    <circle cx=\"23\" cy=\" 24\" r=\"5\"/>\n" +
                "    <circle cx=\"32\" cy=\" 24\" r=\"5\"/>\n" +
                "    <circle cx=\"41\" cy=\" 56\" r=\"5\"/>\n" +
                "    <circle cx=\"50\" cy=\" 56\" r=\"5\"/>\n" +
                "    <circle cx=\"59\" cy=\" 40\" r=\"5\"/>\n" +
                "    <circle cx=\"68\" cy=\" 24\" r=\"5\"/>\n" +
                "</svg>", drawer.display(chord));
    }

    @Test
    public void getSVGFromChordWithMutedString() throws MusicFormatException {
        ChordHandler drawer = new ChordHandler();
        ChordChart chordChart = new ChordChart();
        chordChart.load("{X,X,2,2,1,0}");

        Chord chord = new Chord();
        chord.setChordChart(chordChart);

        assertEquals("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\">\n" +
                "  <defs>\n" +
                "    <style>\n" +
                "      .cls-1{fill:none;stroke:#000;stroke-miterlimit:10;stroke-width:1px}\n" +
                "      .cls-2{font-size:12px;font-family:Arial}\n" +
                "    </style>\n" +
                "  </defs>\n" +
                "  <title>Chord nullnull</title>\n" +
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
                "    <text class=\"cls-2\" transform=\"translate(20 14)\">X</text>\n" +
                "    <text class=\"cls-2\" transform=\"translate(29 14)\">X</text>\n" +
                "    <circle cx=\"41\" cy=\" 40\" r=\"5\"/>\n" +
                "    <circle cx=\"50\" cy=\" 40\" r=\"5\"/>\n" +
                "    <circle cx=\"59\" cy=\" 24\" r=\"5\"/>\n" +
                "    <circle fill=\"white\" stroke=\"black\" cx=\"68\" cy=\" 8\" r=\"4\"/>\n" +
                "</svg>", drawer.display(chord));
    }

    @Test
    public void displayPartSongNull(){
        ChordHandler drawer = new ChordHandler();
        assertEquals("", drawer.display((Displayable) null));
    }
    @Test
    public void displayPartSongThatIsNotChord(){
        ChordHandler drawer = new ChordHandler();
        assertEquals("", drawer.display(new Lyrics()));
    }

}