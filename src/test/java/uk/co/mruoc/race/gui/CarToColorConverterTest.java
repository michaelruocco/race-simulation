package uk.co.mruoc.race.gui;

import org.junit.Test;

import java.awt.*;

import static java.awt.Color.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CarToColorConverterTest {

    private static final Color DARK_GREEN = new Color(0, 204, 0);
    private static final Color DARK_ORANGE = new Color(255, 128, 0);
    private static final Color DARK_YELLOW = new Color(153, 153, 0);
    private static final Color PURPLE = new Color(160, 32, 240);

    private CarToColorConverter converter = new CarToColorConverter();

    @Test
    public void shouldConvertColorsForCar0() {
        int carId = 0;
        assertThat(converter.toColor(carId)).isEqualTo(RED);
        assertThat(converter.toHex(carId)).isEqualTo("#ff0000");
    }

    @Test
    public void shouldConvertColorsForCar1() {
        int carId = 1;
        assertThat(converter.toColor(carId)).isEqualTo(DARK_YELLOW);
        assertThat(converter.toHex(carId)).isEqualTo("#999900");
    }

    @Test
    public void shouldConvertColorsForCar2() {
        int carId = 2;
        assertThat(converter.toColor(carId)).isEqualTo(MAGENTA);
        assertThat(converter.toHex(carId)).isEqualTo("#ff00ff");
    }

    @Test
    public void shouldConvertColorsForCar3() {
        int carId = 3;
        assertThat(converter.toColor(carId)).isEqualTo(DARK_GREEN);
        assertThat(converter.toHex(carId)).isEqualTo("#00cc00");
    }

    @Test
    public void shouldConvertColorsForCar4() {
        int carId = 4;
        assertThat(converter.toColor(carId)).isEqualTo(DARK_ORANGE);
        assertThat(converter.toHex(carId)).isEqualTo("#ff8000");
    }

    @Test
    public void shouldConvertColorsForCar5() {
        int carId = 5;
        assertThat(converter.toColor(carId)).isEqualTo(PURPLE);
        assertThat(converter.toHex(carId)).isEqualTo("#a020f0");
    }

    @Test
    public void shouldConvertColorsForCar6() {
        int carId = 6;
        assertThat(converter.toColor(carId)).isEqualTo(BLUE);
        assertThat(converter.toHex(carId)).isEqualTo("#0000ff");
    }

    @Test
    public void shouldConvertColorsForCar7() {
        int carId = 7;
        assertThat(converter.toColor(carId)).isEqualTo(BLACK);
        assertThat(converter.toHex(carId)).isEqualTo("#000000");
    }

}
