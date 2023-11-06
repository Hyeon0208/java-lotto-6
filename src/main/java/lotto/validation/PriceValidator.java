package lotto.validation;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoValue;

public class PriceValidator {

    private PriceValidator() {
    }

    public static void validate(int price) {
        validateZero(price);
        validateDivisibleByThousand(price);
        validateLimit(price);
    }


    private static void validateZero(int price) {
        if (price == 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ZERO.getMessage());
        }
    }

    private static void validateDivisibleByThousand(int price) {
        if (isNotDivisibleByThousand(price)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDE.getMessage());
        }
    }

    private static boolean isNotDivisibleByThousand(int price) {
        if ((price % LottoValue.PRICE_PER_LOTTO.getValue()) != 0) {
            return true;
        }
        return false;
    }

    private static void validateLimit(int price) {
        if (price > LottoValue.PURCHASE_LIMIT_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_LIMIT.getMessage());
        }
    }
}
