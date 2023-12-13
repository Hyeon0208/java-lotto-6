package lotto.domain;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public enum Rank {
    NONE(0, 0),
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000);

    private final int matchCondition;
    private final int prize;


    Rank(int matchCondition, int prize) {
        this.matchCondition = matchCondition;
        this.prize = prize;
    }

    public static Map<Rank, Integer> getRankResult(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (int i = 0; i < lottos.getSize(); i++) {
            Lotto lotto = lottos.getLottoBy(i);
            int matchCount = lotto.getMatchCountBy(winningNumber);
            boolean matchBonus = lotto.matchBonus(bonusNumber);
            Rank rank = getMeetsConditionsRank(matchCount, matchBonus);
            result.put(rank, (result.getOrDefault(rank, 0)) + 1);
        }
        return result;
    }

    private static Rank getMeetsConditionsRank(int matchCount, boolean matchBonus) {
        return EnumSet.allOf(Rank.class).stream()
                .filter(rank -> rank.matchCondition == matchCount)
                .findFirst()
                .map(rank -> {
                    if (matchCount == 5) {
                        if (matchBonus) {
                            return SECOND_PLACE;
                        }
                        return THIRD_PLACE;
                    }
                    return rank;
                })
                .orElse(Rank.NONE);
    }

    public int getPrize() {
        return prize;
    }
}
