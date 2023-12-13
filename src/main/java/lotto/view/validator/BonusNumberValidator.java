package lotto.view.validator;

import lotto.constant.LottoValue;
import lotto.util.StringConvertor;

public class BonusNumberValidator {

    private BonusNumberValidator() {
    }

    public static void validate(String input) {
        validateInputFormat(input);
        validateBlank(input);
        validateNumberRange(input);
    }

    private static void validateInputFormat(String input) {
        if (!RegexPattern.ONLY_NUMBER.matches(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }

    private static void validateNumberRange(String input) {
        int number = StringConvertor.convertStringToInt(input);
        if (number < LottoValue.MIN_LOTTO_RANGE || number > LottoValue.MAX_LOTTO_RANGE) {
            throw new IllegalArgumentException("1 ~ 45 범위의 숫자를 입력해야 합니다.");
        }
    }
}
