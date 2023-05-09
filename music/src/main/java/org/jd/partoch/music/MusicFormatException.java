package org.jd.partoch.music;

public class MusicFormatException extends Exception {

    public static final String MALFORMED_CHORDCHART = "Cannot load malformed chord chart";

    public MusicFormatException(String message) {
        super(message);
    }
}
