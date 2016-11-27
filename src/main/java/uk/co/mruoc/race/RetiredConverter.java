package uk.co.mruoc.race;

public class RetiredConverter {

    private static final String FLAG = "R";
    private static final int VALUE = -1;

    public boolean isValidFlag(String input) {
        return input.equals(FLAG);
    }

    public int toValue(String input) {
        if (isValidFlag(input))
            return VALUE;
        throw new InvalidRetiredFlagException(input);
    }

    public boolean isRetired(int value) {
        return VALUE == value;
    }

    public boolean isRetired(String flag) {
        return FLAG.equals(flag);
    }

}
