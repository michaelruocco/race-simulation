package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class DataLine {

    private final ElapsedTime time;

    public DataLine(ElapsedTime time) {
        this.time = time;
    }

    public ElapsedTime getTime() {
        return time;
    }

}
