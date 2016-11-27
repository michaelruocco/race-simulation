package uk.co.mruoc.race;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DataLineTest {

    private static final char RETIRED = 'R';

    private final TestDataLineBuilder builder = new TestDataLineBuilder();

    @Test
    public void shouldReturnRetiredIfCheckpointIdIsRetired() {
        DataLine line = builder.withCheckpointId(RETIRED).build();

        assertThat(line.isRetired()).isTrue();
    }

    @Test
    public void shouldNotReturnRetiredIfCheckpointIdIsNotRetired() {
        DataLine line = builder.withCheckpointId('0').build();

        assertThat(line.isRetired()).isFalse();
    }


}
