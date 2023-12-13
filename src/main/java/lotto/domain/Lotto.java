package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
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
