package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Convertor;
import lotto.validation.LottoNumberValidator;

public class WinningNumber {
    private final List<Integer> numbers;

    private WinningNumber(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    public static WinningNumber from(String input) {
        List<Integer> winningNumbers = Arrays.stream(Convertor.splitByComma(input))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new WinningNumber(winningNumbers);
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }
}
