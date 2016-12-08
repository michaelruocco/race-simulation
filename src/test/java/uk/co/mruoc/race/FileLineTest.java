package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.race.model.FileLine;

import static org.assertj.core.api.Assertions.assertThat;

public class FileLineTest {

    private final TestFileLineBuilder builder = new TestFileLineBuilder();

    @Test
    public void shouldReturnRetiredIfCheckpointIdIsRetired() {
        FileLine line = builder.withCheckpointId(-1).build();

        assertThat(line.isRetired()).isTrue();
    }

    @Test
    public void shouldNotReturnRetiredIfCheckpointIdIsNotRetired() {
        FileLine line = builder.withCheckpointId(0).build();

        assertThat(line.isRetired()).isFalse();
    }


}
