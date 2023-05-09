package org.jd.partoch.web.view;

import org.jd.partoch.web.model.Displayable;
import org.jd.partoch.web.model.Song;


public class SongHandler implements ViewHandler {
    @Override
    public String display(Displayable displayable) {

        if(!(displayable instanceof Song song)){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<h1>");
        sb.append(song.getTitle());
        sb.append("</h1>\n");
        for(Displayable songPart: song.getSongParts()){
            ViewHandler handler = songPart.getViewHandler();
            sb.append(handler.display(songPart));
            sb.append("\n");
        }

        return sb.toString();
    }
}
