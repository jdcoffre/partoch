package org.jd.partoch.web.model;

import org.jd.partoch.music.Chord;
import org.jd.partoch.web.view.ChordHandler;
import org.jd.partoch.web.view.ViewHandler;

import java.util.ArrayList;
import java.util.List;

public class Chords implements Displayable {

    private List<Chord> chordsList = new ArrayList<>();

    public List<Chord> getChords() {
        return chordsList;
    }

    public void addChord(Chord chord) {
        this.chordsList.add(chord);
    }

    @Override
    public ViewHandler getViewHandler() {
        return new ChordHandler();
    }
}
