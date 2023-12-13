package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoValue;

public class LottoNumberGenerator implements NumberGenerator {
    private static final int MIN_LOTTO_RANGE = LottoValue.MIN_LOTTO_RANGE;
    private static final int MAX_LOTTO_RANGE = LottoValue.MAX_LOTTO_RANGE;
    private static final int LOTTO_SIZE = LottoValue.LOTTO_SIZE;

    @Override
    public List<Integer> generateNumberList() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE, LOTTO_SIZE);
    }
}
