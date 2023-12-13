package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.validator.Separator;

public class StringConvertor {

    private StringConvertor() {
    }

    public static int convertStringToInt(String value) {
        return Integer.parseInt(value);
    }

    public static List<Integer> convertCommaSeparatedStringToIntegerList(String value) {
        return Arrays.stream(Separator.COMMA.split(value))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}