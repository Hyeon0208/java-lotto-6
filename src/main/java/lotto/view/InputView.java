package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.PurchasePriceValidator;

public class InputView {

    public String inputPurchasePrice() {
        String price = Console.readLine();
        PurchasePriceValidator.validate(price);
        return price;
    }
}
