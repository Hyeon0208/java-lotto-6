package lotto.domain;

import java.util.Map;

public class LotteryResult {
    private final Map<Rank, Integer> result;

    public LotteryResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public int getFifthPlaceCount() {
        return result.getOrDefault(Rank.FIFTH_PLACE, 0);
    }

    public int getFourthPlaceCount() {
        return result.getOrDefault(Rank.FOURTH_PLACE, 0);
    }

    public int getThirdPlaceCount() {
        return result.getOrDefault(Rank.THIRD_PLACE, 0);
    }

    public int getSecondPlaceCount() {
        return result.getOrDefault(Rank.SECOND_PLACE, 0);
    }

    public int getFirstPlaceCount() {
        return result.getOrDefault(Rank.FIRST_PLACE, 0);
    }
}

