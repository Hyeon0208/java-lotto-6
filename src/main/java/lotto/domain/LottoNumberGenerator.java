package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {
    private static final int MIN_LOTTO_RANGE = 1;
    private static final int MAX_LOTTO_RANGE = 45;
    private static final int LOTTO_SIZE = 6;

    @Override
    public List<Integer> generateNumberList() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE, LOTTO_SIZE);
    }
}
