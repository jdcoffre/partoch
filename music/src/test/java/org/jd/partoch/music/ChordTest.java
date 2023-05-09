package org.jd.partoch.music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChordTest {

    @Test
    public void regularChordToString() {
        Chord chord = new Chord();
        chord.setTone(Tone.C);
        chord.setQuality(Quality.MAJOR);
        chord.setChordChart(new ChordChart());

        assertEquals("C,MAJOR,{X,X,X,X,X,X}", chord.toString());
    }

}