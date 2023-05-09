package org.jd.partoch.music;

public class Chord {

    private Tone tone;
    private Quality quality;
    private ChordChart chordChart;

    public Tone getTone() {
        return tone;
    }

    public void setTone(Tone tone) {
        this.tone = tone;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public ChordChart getChordChart() {
        return chordChart;
    }

    public void setChordChart(ChordChart chordChart) {
        this.chordChart = chordChart;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(tone.toString());
        sb.append(",");
        sb.append(quality);
        sb.append(",");
        sb.append(chordChart.toString());

        return sb.toString();
    }

}
