package org.jd.partoch.web.model;

import org.jd.partoch.web.view.LyricsHandler;
import org.jd.partoch.web.view.ViewHandler;

public class Lyrics implements Displayable {

    String section;

    public String get() {
        return section;
    }

    public void set(String section) {
        this.section = section;
    }

    @Override
    public ViewHandler getViewHandler() {
        return new LyricsHandler();
    }
}
