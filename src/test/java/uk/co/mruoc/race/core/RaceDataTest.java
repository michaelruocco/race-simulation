package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static uk.co.mruoc.race.core.RaceData.*;

public class RaceDataTest {

    private final RaceDataBuilder builder = new RaceDataBuilder();

    @Test
    public void shouldReturnQueryTimes() {
        List<ElapsedTime> queryTimes = Collections.singletonList(new ElapsedTime());
        RaceData raceData = builder
                .setQueryTimes(queryTimes)
                .setCarDataList(Collections.emptyList())
                .build();

        Iterator<ElapsedTime> iterator = raceData.getQueryTimes();

        assertThat(iterator.next()).isEqualTo(queryTimes.get(0));
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void shouldReturnLastEndTime() {
        ElapsedTime endTime1 = new ElapsedTime("00:02:30.000");
        ElapsedTime endTime2 = new ElapsedTime("00:02:35.000");

        FakeCarData carData1 = new FakeCarData(1);
        FakeCarData carData2 = new FakeCarData(2);

        carData1.setEndTime(endTime1);
        carData2.setEndTime(endTime2);

        RaceData raceData = builder
                .setCarDataList(Arrays.asList(carData1, carData2))
                .build();

        assertThat(raceData.getEndTime()).isEqualTo(endTime2);
    }

    @Test
    public void shouldReturnHasFinished() {
        ElapsedTime endTime1 = new ElapsedTime("00:02:30.000");
        ElapsedTime endTime2 = new ElapsedTime("00:02:35.000");

        FakeCarData carData1 = new FakeCarData(1);
        FakeCarData carData2 = new FakeCarData(2);

        carData1.setEndTime(endTime1);
        carData2.setEndTime(endTime2);

        RaceData raceData = builder
                .setCarDataList(Arrays.asList(carData1, carData2))
                .build();

        assertThat(raceData.hasFinished(endTime2)).isTrue();
        assertThat(raceData.hasFinished(endTime2.add(1))).isTrue();
        assertThat(raceData.hasFinished(endTime2.subtract(1))).isFalse();
    }

    @Test
    public void shouldSetTime() {
        FakeCarData carData1 = new FakeCarData(1);
        FakeCarData carData2 = new FakeCarData(2);

        RaceData raceData = builder
                .setCarDataList(Arrays.asList(carData1, carData2))
                .build();

        ElapsedTime time = new ElapsedTime();

        raceData.setTime(time);

        assertThat(carData1.getTime()).isEqualTo(time);
        assertThat(carData2.getTime()).isEqualTo(time);
    }

    @Test
    public void shouldReturnCarStatsIterator() {
        FakeCarData carData1 = new FakeCarData(1);
        FakeCarData carData2 = new FakeCarData(2);

        RaceData raceData = builder
                .setCarDataList(Arrays.asList(carData1, carData2))
                .build();

        Iterator<CarStats> iterator = raceData.getAllCarStats();

        CarStats carStats1 = iterator.next();
        assertThat(carStats1.getCarId()).isEqualTo(1);

        CarStats carStats2 = iterator.next();
        assertThat(carStats2.getCarId()).isEqualTo(2);

        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void shouldReturnRegularCarStatsIterator() {
        FakeCarData carData1 = new FakeCarData(1);
        FakeCarData carData2 = new FakeCarData(2);

        carData1.setRetired(false);
        carData2.setRetired(true);

        RaceData raceData = builder
                .setCarDataList(Arrays.asList(carData1, carData2))
                .build();

        Iterator<CarStats> iterator = raceData.getRegularCarStats();

        CarStats carStats1 = iterator.next();
        assertThat(carStats1.getCarId()).isEqualTo(1);

        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void shouldReturnRetiredCarStatsIterator() {
        FakeCarData carData1 = new FakeCarData(1);
        FakeCarData carData2 = new FakeCarData(2);

        carData1.setRetired(false);
        carData2.setRetired(true);

        RaceData raceData = builder
                .setCarDataList(Arrays.asList(carData1, carData2))
                .build();

        Iterator<CarStats> iterator = raceData.getRetiredCarStats();

        CarStats carStats1 = iterator.next();
        assertThat(carStats1.getCarId()).isEqualTo(2);

        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void shouldReturnCarStatsById() {
        int carId = 1;
        FakeCarData carData1 = new FakeCarData(carId);
        RaceData raceData = builder
                .setCarDataList(Collections.singletonList(carData1))
                .build();

        CarStats carStats1 = raceData.getCarStats(carId);

        assertThat(carStats1.getCarId()).isEqualTo(carId);
    }

    private static class FakeCarData extends CarData {

        private ElapsedTime endTime = new ElapsedTime();
        private ElapsedTime time;
        private boolean retired;

        public FakeCarData(int carId) {
            super(carId, Collections.singletonList(new Lap(1)));
        }

        public void setEndTime(ElapsedTime endTime) {
            this.endTime = endTime;
        }

        public ElapsedTime getEndTime() {
            return endTime;
        }

        public void setTime(ElapsedTime time) {
            this.time = time;
        }

        public ElapsedTime getTime() {
            return time;
        }

        public void setRetired(boolean retired) {
            this.retired = retired;
        }

        public boolean hasRetired() {
            return retired;
        }

    }

}
