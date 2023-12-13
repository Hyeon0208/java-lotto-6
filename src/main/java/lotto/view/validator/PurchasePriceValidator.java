package lotto.view.validator;

import lotto.util.StringConvertor;

public class PurchasePriceValidator {
    private static final int DIVIDE_STANDARD = 1000;

    private PurchasePriceValidator() {
    }

    public static void validate(String input) {
        validateBlank(input);
        validateInputFormat(input);
        validateDivideByThousand(input);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("아무런 값을 입력하지 않았습니다.");
        }
    }

    private static void validateInputFormat(String input) {
        if (!RegexPattern.ONLY_NUMBER.matches(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능 합니다.");
        }
    }

    private static void validateDivideByThousand(String input) {
        int price = StringConvertor.convertStringToInt(input);
        if (price % DIVIDE_STANDARD != 0) {
            throw new IllegalArgumentException("로또는 천원 단위로만 구매 가능합니다.");
        }
    }
}
