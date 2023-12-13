package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoValue;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LottoValue.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 벊호로 이뤄져야 합니다.");
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> deDuplicatedNumbers = new HashSet<>(numbers);
        if (numbers.size() != deDuplicatedNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호를 가질 수 없습니다.");
        }
    }

    public int getMatchCountBy(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(number -> winningNumber.contains(number))
                .count();
    }

    public boolean matchBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
