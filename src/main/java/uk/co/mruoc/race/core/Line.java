package uk.co.mruoc.race.core;

public class Line {

    private final int number;
    private final String value;

    public Line(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }

    public String[] splitValue() {
        return value.split(" ");
    }

    public String debug() {
        return number + " : " + value;
    }

}
