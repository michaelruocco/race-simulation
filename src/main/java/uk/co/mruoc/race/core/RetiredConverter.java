package uk.co.mruoc.race.core;

public class RetiredConverter {

    private static final String FLAG = "R";
    private static final int VALUE = -1;

    public boolean isValid(String input) {
        return input.equals(FLAG);
    }

    public int toValue(String input) {
        if (isValid(input))
            return VALUE;
        throw new InvalidRetiredFlagException(input);
    }

    public boolean isRetired(int value) {
        return value == VALUE;
    }

}
