package org.jd.partoch.web.view;

import org.jd.partoch.web.model.Lyrics;
import org.jd.partoch.web.model.Displayable;

public class LyricsHandler implements ViewHandler {

    @Override
    public String display(Displayable displayable) {
        if(!(displayable instanceof Lyrics lyrics)){
            return "";
        }

        StringBuilder sb = new StringBuilder();


        sb.append("<p>\n");
        if( lyrics.get() != null ){
            sb.append( lyrics.get() +"\n");
        }
        sb.append("</p>");

        return sb.toString();
    }
}
