package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

public class RetiredStats {

    private final boolean retired;
    private final ElapsedTime time;

    private RetiredStats(RetiredStatsBuilder builder) {
        this.retired = builder.retired;
        this.time = builder.time;
    }

    public boolean hasRetired() {
        return retired;
    }

    public ElapsedTime getTime() {
        return time;
    }

    public static class RetiredStatsBuilder {

        private boolean retired;
        private ElapsedTime time = new ElapsedTime();

        public RetiredStatsBuilder setRetired(boolean retired) {
            this.retired = retired;
            return this;
        }

        public RetiredStatsBuilder setTime(ElapsedTime time) {
            this.time = time;
            return this;
        }

        public RetiredStats build() {
            return new RetiredStats(this);
        }

    }

}
