package org.jd.partoch.web.view;

import org.jd.partoch.music.Chord;
import org.jd.partoch.music.ChordChart;
import org.jd.partoch.web.model.Chords;
import org.jd.partoch.web.model.Displayable;

public class ChordHandler implements ViewHandler {

    private static final Integer SVG_WIDTH = 100;
    private static final Integer SVG_HEIGHT = 100;
    private static final Integer FRET_HEIGHT = 16;
    private static final Integer NUMBER_OF_FRETS = 6;
    private static final Integer NECK_X_START = 23;
    private static final Integer NECK_Y_START = 16;
    private static final Integer NECK_WIDTH = 45;
    private static final Integer NECK_HEIGHT = 96;
    private static final Integer INBETWEEN_STRING_GAP = 9;

    public String display(Displayable displayable){
        if(!(displayable instanceof Chords chords)){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(Chord chord: chords.getChords()){
            sb.append(display(chord));
            sb.append("\n");
        }
        return sb.toString();
    }

    protected String display(Chord chord) {
        StringBuilder sb = new StringBuilder();
        sb.append("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"" + SVG_WIDTH + "\" height=\"" + SVG_HEIGHT + "\">\n");
        sb.append("  <defs>\n");
        sb.append("    <style>\n");
        sb.append("      .cls-1{fill:none;stroke:#000;stroke-miterlimit:10;stroke-width:1px}\n");
        sb.append("      .cls-2{font-size:12px;font-family:Arial}\n");
        sb.append("    </style>\n");
        sb.append("  </defs>\n");
        sb.append("  <title>Chord " + chord.getTone() + chord.getQuality() + "</title>\n");
        sb.append(drawFrets());
        sb.append(drawStrings());
        sb.append(drawChord(chord.getChordChart()));
        sb.append("</svg>");

        return sb.toString();
    }

    private String drawFrets() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < NUMBER_OF_FRETS; i++) {
            int fretY = NECK_Y_START + i * FRET_HEIGHT;
            sb.append("    <path d=\"M" + NECK_X_START + " " + fretY + " " + "h" + NECK_WIDTH + "\"class=\"cls-1\"/>\n");
        }

        return sb.toString();
    }

    private String drawStrings() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < NUMBER_OF_FRETS; i++) {
            int stringX = NECK_X_START + i * INBETWEEN_STRING_GAP;
            sb.append("    <path d=\"M" + stringX + " " + NECK_Y_START + " " + "V" + NECK_HEIGHT + "\"class=\"cls-1\"/>\n");
        }

        return sb.toString();
    }

    private String drawChord(ChordChart chordChart) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ChordChart.NB_STRING; i++) {
            int stringX = NECK_X_START + i * INBETWEEN_STRING_GAP;


            Integer fretNumber = chordChart.getFretOnString(i);
            if (fretNumber == null) {
                sb.append("    <text class=\"cls-2\" transform=\"translate(" + (stringX - 3) + " " + (NECK_Y_START - 2) + ")\">X</text>\n");
            } else if (fretNumber == 0) {
                int fretY = NECK_Y_START - FRET_HEIGHT / 2;
                sb.append("    <circle fill=\"white\" stroke=\"black\" cx=\"" + stringX + "\" cy=\" " + fretY + "\" r=\"4\"/>\n");
            } else {
                int fretY = NECK_Y_START + FRET_HEIGHT * (chordChart.getFretOnString(i) - 1) + FRET_HEIGHT / 2;
                sb.append("    <circle cx=\"" + stringX + "\" cy=\" " + fretY + "\" r=\"5\"/>\n");
            }

        }

        return sb.toString();
    }

}
