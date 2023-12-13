package lotto.domain;

public class PurchaseHistory {
    private final int purchasePrice;
    private final int purchaseCount;

    public PurchaseHistory(int purchasePrice, int purchaseCount) {
        this.purchasePrice = purchasePrice;
        this.purchaseCount = purchaseCount;
    }

    public static PurchaseHistory from(int price) {
        int count = price % 1000;
        return new PurchaseHistory(price, count);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
