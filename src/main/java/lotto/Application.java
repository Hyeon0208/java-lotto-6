package lotto;

import lotto.controlelr.LottoController;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.handler.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = initHandler();
        OutputView outputView = new OutputView();
        LottoController controller = new LottoController(inputHandler, outputView);
        controller.start();
    }

    private static InputHandler initHandler() {
        InputView inputView = new InputView();
        ErrorView errorView = new ErrorView();
        return new InputHandler(inputView, errorView);
    }
}