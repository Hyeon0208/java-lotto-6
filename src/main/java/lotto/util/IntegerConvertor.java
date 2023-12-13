package lotto.util;

public class IntegerConvertor {
    private static final int DIVIDE_STANDARD = 1000;

    private IntegerConvertor() {
    }

    public static int divideByThousand(int value) {
        return value / DIVIDE_STANDARD;
    }
}
