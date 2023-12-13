package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    public void printPurchasePriceInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseCount(int purchaseCount) {
        System.out.printf("%d개를 구매했습니다.", purchaseCount);
        printNewLine();
    }

    public void printPurchaseLottos(Lottos lottos) {
        StringBuilder purchseLottos = new StringBuilder();
        for (int i = 0; i < lottos.getSize(); i++) {
            purchseLottos.append(lottos.getLottoNumberBy(i) + "\n");
        }
        System.out.println(purchseLottos);
    }

    public void printWinningNumberInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printNewLine() {
        System.out.println();
    }
}
