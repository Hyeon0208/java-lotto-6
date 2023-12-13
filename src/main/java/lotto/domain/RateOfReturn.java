package lotto.domain;

public class RateOfReturn {
    private final double rate;

    private RateOfReturn(double rate) {
        this.rate = rate;
    }

    public static RateOfReturn of(int purchasePrice, int totalPrize) {
        double rate = ((double) totalPrize / purchasePrice) * 100;
        return new RateOfReturn(rate);
    }

    public double getRate() {
        return rate;
    }
}
