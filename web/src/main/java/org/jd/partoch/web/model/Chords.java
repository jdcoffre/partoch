package org.jd.partoch.web.model;

import org.jd.partoch.music.Chord;
import org.jd.partoch.web.view.ChordHandler;
import org.jd.partoch.web.view.ViewHandler;

import java.util.ArrayList;
import java.util.List;

public class Chords implements Displayable {

    private List<Chord> chords = new ArrayList<>();

    public List<Chord> getChords() {
        return chords;
    }

    public void addChord(Chord chord) {
        this.chords.add(chord);
    }

    @Override
    public ViewHandler getViewHandler() {
        return new ChordHandler();
    }
}
