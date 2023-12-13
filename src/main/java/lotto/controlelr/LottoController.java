package lotto.controlelr;

import lotto.view.OutputView;
import lotto.view.handler.InputHandler;

public class LottoController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public LottoController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printPurchasePriceInputMessage();
        inputHandler.receiveValidatedPurchasePrice();
        outputView.printNewLine();
    }
}
