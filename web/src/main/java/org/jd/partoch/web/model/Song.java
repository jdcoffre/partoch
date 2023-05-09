package org.jd.partoch.web.model;

import org.jd.partoch.web.view.SongHandler;
import org.jd.partoch.web.view.ViewHandler;

import java.util.ArrayList;
import java.util.List;

public class Song implements Displayable{

    private String title;

    private List<Displayable> parts = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Displayable> getSongParts() {
        return parts;
    }

    public void addSongPart(Displayable part) {
        this.parts.add(part);
    }

    @Override
    public ViewHandler getViewHandler() {
        return new SongHandler();
    }
}
