package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.LotteryResult;
import lotto.domain.Lottos;
import lotto.domain.RateOfReturn;

public class OutputView {
    private static final String RATE_FORMAT = "#,##0.0";

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
            purchseLottos.append(lottos.getLottoNumberBy(i)).append("\n");
        }
        System.out.println(purchseLottos);
    }

    public void printWinningNumberInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLotteryResult(LotteryResult lotteryResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lotteryResult.getFifthPlaceCount());
        System.out.printf("4개 일치 (50,000원) - %d개\n", lotteryResult.getFourthPlaceCount());
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lotteryResult.getThirdPlaceCount());
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lotteryResult.getSecondPlaceCount());
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lotteryResult.getFirstPlaceCount());
    }

    public void printRateOfReturn(RateOfReturn rateOfReturn) {
        DecimalFormat formatter = new DecimalFormat(RATE_FORMAT);
        System.out.printf("총 수익률은 %s%%입니다.", formatter.format(rateOfReturn.getRate()));
    }

    public void printNewLine() {
        System.out.println();
    }
}
