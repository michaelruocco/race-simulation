package uk.co.mruoc.race.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClasspathFileLoaderTest {

    private final ClasspathFileLoader fileLoader = new ClasspathFileLoader();

    @Test
    public void shouldReturnFileContent() {
        String content = fileLoader.loadContent("/uk/co/mruoc/race/core/test.txt");

        assertThat(content).isEqualTo("some test text");
    }

}
