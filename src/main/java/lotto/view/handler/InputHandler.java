package lotto.view.handler;

import java.util.List;
import java.util.function.Supplier;
import lotto.util.StringConvertor;
import lotto.view.ErrorView;
import lotto.view.InputView;

public class InputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public InputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public int receiveValidatedPurchasePrice() {
        String price = receiveValidatedInput(inputView::inputPurchasePrice);
        return StringConvertor.convertStringToInt(price);
    }

    public List<Integer> receiveValidatedWinningNumber() {
        String winningNumber = receiveValidatedInput(inputView::inputWinningNumber);
        return StringConvertor.convertCommaSeparatedStringToIntegerList(winningNumber);
    }

    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                errorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}