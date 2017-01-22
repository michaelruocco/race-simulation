package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

public class PitStats {

    private final boolean pitted;
    private final ElapsedTime time;
    private final int lapNumber;

    private PitStats(PitStatsBuilder builder) {
        this.pitted = builder.pitted;
        this.time = builder.time;
        this.lapNumber = builder.lapNumber;
    }

    public boolean hasPitted() {
        return pitted;
    }

    public ElapsedTime getTime() {
        return time;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public static class PitStatsBuilder {

        private boolean pitted;
        private ElapsedTime time;
        private int lapNumber;

        public PitStatsBuilder setPitted(boolean pitted) {
            this.pitted = pitted;
            return this;
        }

        public PitStatsBuilder setTime(ElapsedTime time) {
            this.time = time;
            return this;
        }

        public PitStatsBuilder setLapNumber(int lapNumber) {
            this.lapNumber = lapNumber;
            return this;
        }

        public PitStats build() {
            return new PitStats(this);
        }

    }

}
