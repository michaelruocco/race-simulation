package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceDataTest {

    private final ElapsedTime time = new ElapsedTime();
    private final List<ElapsedTime> queryTimes = Collections.singletonList(time);

    private final RaceData raceData = new RaceData(queryTimes, new ArrayList<>());

    @Test
    public void shouldReturnQueryTimes() {
        Iterator<ElapsedTime> iterator = raceData.getQueryTimes();

        assertThat(iterator.next()).isEqualTo(queryTimes.get(0));
        assertThat(iterator.hasNext()).isFalse();
    }

}
