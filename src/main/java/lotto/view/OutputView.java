package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.enums.Rank;

public class OutputView {

    private OutputView() {
    }

    public static void printPurchaseMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseCount(int purchaseCount) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
    }

    public static void printPurchaseLottoTickets(List<Lotto> lottos) {
        StringBuilder lottoPrinter = new StringBuilder();
        lottos.stream()
                .forEach(lotto -> lottoPrinter.append(lotto).append("\n"));
        System.out.println(lottoPrinter);
    }

    public static void printWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(Rank.values())
                .forEach(rank -> System.out.printf(rank.getMatchInfo(), lottoResult.findMatchCountFor(rank)));
    }

    public static void printRateOfReturn(double rateOfReturn) {
        DecimalFormat df = new DecimalFormat("#,##0.0");
        System.out.printf("총 수익률은 %s%%입니다.", df.format(rateOfReturn));
    }

    public static void printErrorMessageFor(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
