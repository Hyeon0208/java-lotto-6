package lotto.controlelr;

import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.PurchaseHistory;
import lotto.domain.WinningNumber;
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
        int purchasePrice = inputHandler.receiveValidatedPurchasePrice();
        outputView.printNewLine();

        PurchaseHistory purchaseHistory = PurchaseHistory.from(purchasePrice);
        int purchaseCount = purchaseHistory.getPurchaseCount();

        outputView.printPurchaseCount(purchaseCount);
        Lottos lottos = Lottos.from(purchaseCount);
        outputView.printPurchaseLottos(lottos);

        outputView.printWinningNumberInputMessage();
        WinningNumber winningNumber = new WinningNumber(inputHandler.receiveValidatedWinningNumber());
        outputView.printNewLine();

        outputView.printBonusNumberInputMessage();
        BonusNumber bonusNumber = createBonusNumberNotContainsWinningNumber(winningNumber);
        outputView.printNewLine();
    }

    private BonusNumber createBonusNumberNotContainsWinningNumber(WinningNumber winningNumber) {
        int bonusNumber;
        while (true) {
            bonusNumber = inputHandler.receiveValidatedBonusNumber();
            if (!isWinningNumberContainsBonusNumber(winningNumber, bonusNumber)) {
                break;
            }
        }
        return new BonusNumber(bonusNumber);
    }

    private boolean isWinningNumberContainsBonusNumber(WinningNumber winningNumber, int bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }
}