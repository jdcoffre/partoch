package org.jd.partoch.music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChordChartTest {

    @Test
    public void emptyChordChartToString() {
        ChordChart chordChart = new ChordChart();
        assertEquals("{X,X,X,X,X,X}", chordChart.toString());
    }

    @Test
    public void allStringsFreeChordChartToString() {
        ChordChart chordChart = new ChordChart();
        chordChart.setFretOnString(0, 0);
        chordChart.setFretOnString(1, 0);
        chordChart.setFretOnString(2, 0);
        chordChart.setFretOnString(3, 0);
        chordChart.setFretOnString(4, 0);
        chordChart.setFretOnString(5, 0);
        assertEquals("{0,0,0,0,0,0}", chordChart.toString());
    }

    @Test
    public void regularChordChartToString() {
        ChordChart chordChart = new ChordChart();
        chordChart.setFretOnString(0, 0);
        chordChart.setFretOnString(1, 0);
        chordChart.setFretOnString(2, 2);
        chordChart.setFretOnString(3, 2);
        chordChart.setFretOnString(4, 1);
        chordChart.setFretOnString(5, 0);
        assertEquals("{0,0,2,2,1,0}", chordChart.toString());
    }

    @Test
    public void someStringNotUsedChordChartToString() {
        ChordChart chordChart = new ChordChart();
        chordChart.setFretOnString(2, 0);
        chordChart.setFretOnString(3, 2);
        chordChart.setFretOnString(4, 3);
        chordChart.setFretOnString(5, 2);
        assertEquals("{X,X,0,2,3,2}", chordChart.toString());
    }

    @Test
    public void loadEmptyChordChart() throws MusicFormatException {
        ChordChart chordChart = new ChordChart();
        chordChart.load("{0,0,0,0,0,0}");
        assertEquals(0, chordChart.getFretOnString(0));
        assertEquals(0, chordChart.getFretOnString(1));
        assertEquals(0, chordChart.getFretOnString(2));
        assertEquals(0, chordChart.getFretOnString(3));
        assertEquals(0, chordChart.getFretOnString(4));
        assertEquals(0, chordChart.getFretOnString(5));
    }

    @Test
    public void loadRegularChordChart() throws MusicFormatException {
        ChordChart chordChart = new ChordChart();
        chordChart.load("{0,0,2,2,1,0}");
        assertEquals(0, chordChart.getFretOnString(0));
        assertEquals(0, chordChart.getFretOnString(1));
        assertEquals(2, chordChart.getFretOnString(2));
        assertEquals(2, chordChart.getFretOnString(3));
        assertEquals(1, chordChart.getFretOnString(4));
        assertEquals(0, chordChart.getFretOnString(5));
    }

    @Test
    public void loadRegularChordChart_TwoDigits() throws MusicFormatException {
        ChordChart chordChart = new ChordChart();
        chordChart.load("{0,0,0,12,13,12}");
        assertEquals(0, chordChart.getFretOnString(0));
        assertEquals(0, chordChart.getFretOnString(1));
        assertEquals(0, chordChart.getFretOnString(2));
        assertEquals(12, chordChart.getFretOnString(3));
        assertEquals(13, chordChart.getFretOnString(4));
        assertEquals(12, chordChart.getFretOnString(5));
    }

    @Test
    public void loadChordChartWithEmptyStrings() throws MusicFormatException {
        ChordChart chordChart = new ChordChart();
        chordChart.load("{X,X,0,2,3,2}");
        assertEquals(null, chordChart.getFretOnString(0));
        assertEquals(null, chordChart.getFretOnString(1));
        assertEquals(0, chordChart.getFretOnString(2));
        assertEquals(2, chordChart.getFretOnString(3));
        assertEquals(3, chordChart.getFretOnString(4));
        assertEquals(2, chordChart.getFretOnString(5));
    }

    @Test
    public void loadCorruptedChordChart_TooLong() {
        ChordChart chordChart = new ChordChart();
        Exception exception = assertThrows(MusicFormatException.class, () -> chordChart.load("{0,2,2,1,0}"));
        assertEquals(MusicFormatException.MALFORMED_CHORDCHART, exception.getMessage());
    }

    @Test
    public void loadCorruptedChordChart_TooShort() {
        ChordChart chordChart = new ChordChart();
        Exception exception = assertThrows(MusicFormatException.class, () -> chordChart.load("{0,0,2,2,1,0,0}"));
        assertEquals(MusicFormatException.MALFORMED_CHORDCHART, exception.getMessage());
    }

}