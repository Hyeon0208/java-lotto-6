package lotto.view.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.StringConvertor;

public class WinningNumberValidator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private WinningNumberValidator() {
    }

    public static void validate(String input) {
        validateComma(input);
        validateLottoSize(input);
        validateInputFormat(input);
        validateBlank(input);
        validateDuplication(input);
        validateNumberRange(input);
    }

    private static void validateComma(String input) {
        if (!input.contains(Separator.COMMA.getSeparator())) {
            throw new IllegalArgumentException("쉼표로 구분하여 입력해야 합니다.");
        }
    }


    private static void validateLottoSize(String input) {
        String[] numbers = Separator.COMMA.split(input);
        if (numbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨번호는 6개를 입력해야 합니다.");
        }
    }

    private static void validateInputFormat(String input) {
        for (String number : Separator.COMMA.split(input)) {
            if (!RegexPattern.ONLY_NUMBER.matches(number)) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }

    private static void validateBlank(String input) {
        for (String number : Separator.COMMA.split(input)) {
            if (number.isBlank()) {
                throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
            }
        }
    }

    private static void validateDuplication(String input) {
        String[] numbers = Separator.COMMA.split(input);
        Set<String> deDuplicatedNumbers = new HashSet<>(List.of(numbers));
        if (numbers.length != deDuplicatedNumbers.size()) {
            throw new IllegalArgumentException("중복된 번호를 입력할 수 없습니다.");
        }
    }

    private static void validateNumberRange(String input) {
        for (String number : Separator.COMMA.split(input)) {
            int num = StringConvertor.convertStringToInt(number);
            if (num < MIN_RANGE || num > MAX_RANGE) {
                throw new IllegalArgumentException("1 ~ 45 범위의 숫자를 입력해야 합니다.");
            }
        }
    }
}
