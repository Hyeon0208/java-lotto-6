package lotto.domain;

import lotto.util.IntegerConvertor;

public class PurchaseHistory {
    private final int purchasePrice;
    private final int purchaseCount;

    public PurchaseHistory(int purchasePrice, int purchaseCount) {
        this.purchasePrice = purchasePrice;
        this.purchaseCount = purchaseCount;
    }

    public static PurchaseHistory from(int price) {
        return new PurchaseHistory(price, IntegerConvertor.divideByThousand(price));
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
