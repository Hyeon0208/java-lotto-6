package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.PurchasePriceValidator;
import lotto.view.validator.WinningNumberValidator;

public class InputView {

    public String inputPurchasePrice() {
        String price = Console.readLine();
        PurchasePriceValidator.validate(price);
        return price;
    }

    public String inputWinningNumber() {
        String winningNumber = Console.readLine();
        WinningNumberValidator.validate(winningNumber);
        return winningNumber;
    }
}
