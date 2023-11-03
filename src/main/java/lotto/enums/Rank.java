package lotto.enums;

import java.util.Arrays;

public enum Rank {
    MISS(0, "", 0),
    FIFTH_PLACE(3, "3개 일치 (5,000원) - %d개\n", 5000),
    FOURTH_PLACE(4, "4개 일치 (50,000원) - %d개\n", 50000),
    THIRD_PLACE(5, "5개 일치 (1,500,000원) - %d개\n", 1500000),
    SECOND_PLACE(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30000000),
    FIRST_PLACE(6, "6개 일치 (2,000,000,000원) - %d개\n", 2000000000);

    private final int winningCount;
    private final String matchInfo;
    private final int price;

    Rank(int winningCount, String matchInfo, int price) {
        this.winningCount = winningCount;
        this.matchInfo = matchInfo;
        this.price = price;
    }

    public String getMatchInfo() {
        return matchInfo;
    }

    public int getPrice() {
        return price;
    }

    public static Rank findRank(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND_PLACE;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.winningCount == matchCount)
                .findAny()
                .orElse(MISS);
    }
}

