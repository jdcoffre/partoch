package org.jd.partoch.music;


public class ChordChart {

    public final static int NB_STRING = 6;
    public final static String EMPTY_STRING = "X";
    public final static String STRING_SEPARATOR = ",";

    Integer[] frets = new Integer[NB_STRING];


    public Integer getFretOnString(int stringNumber) {
        return this.frets[stringNumber];
    }

    public void setFretOnString(int stringNumber, int fretNumber) {
        this.frets[stringNumber] = fretNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < NB_STRING; i++) {
            String fret = this.frets[i] == null ? EMPTY_STRING : Integer.toString(this.frets[i]);
            sb.append(fret);
            if (i != NB_STRING - 1) {
                sb.append(STRING_SEPARATOR);
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public void load(String string) throws MusicFormatException {
        String[] stringFrets = string.substring(1, string.length() - 1).split(STRING_SEPARATOR);

        if (stringFrets.length != NB_STRING) {
            throw new MusicFormatException(MusicFormatException.MALFORMED_CHORDCHART);
        }

        for (int i = 0; i < NB_STRING; i++) {
            this.frets[i] = stringFrets[i].equals(EMPTY_STRING) ? null : Integer.valueOf(stringFrets[i]);
        }
    }
}
