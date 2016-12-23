package uk.co.mruoc.race.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLineTest {

    private final TestFileLineBuilder builder = new TestFileLineBuilder();

    @Test
    public void shouldReturnRetiredIfCheckpointIdIsRetired() {
        FileLine line = builder.setCheckpointId(-1).build();

        assertThat(line.isRetired()).isTrue();
    }

    @Test
    public void shouldNotReturnRetiredIfCheckpointIdIsNotRetired() {
        FileLine line = builder.setCheckpointId(0).build();

        assertThat(line.isRetired()).isFalse();
    }


}
