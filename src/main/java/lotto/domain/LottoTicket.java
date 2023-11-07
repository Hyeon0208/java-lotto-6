package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final List<Lotto> tickets;

    private LottoTicket(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static LottoTicket of(PurchasePrice purchasePrice, NumberGenerator lottoNumberGenerator) {
        int purchaseCount = purchasePrice.calculatePurchaseCount();
        return new LottoTicket(pickAutoLottoEqualTo(purchaseCount, lottoNumberGenerator));
    }

    private static List<Lotto> pickAutoLottoEqualTo(int purchaseCount, NumberGenerator lottoNumberGenerator) {
        return IntStream.range(0, purchaseCount)
                .mapToObj(lotto -> new Lotto(lottoNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoTicket() {
        return Collections.unmodifiableList(tickets);
    }

    public String getPrintedLottoTicket() {
        StringBuilder lottoPrinter = new StringBuilder();
        tickets.stream()
                .forEach(lotto -> lottoPrinter.append(lotto).append("\n"));
        return lottoPrinter.toString();
    }

    public int getLottoCount() {
        return tickets.size();
    }
}
