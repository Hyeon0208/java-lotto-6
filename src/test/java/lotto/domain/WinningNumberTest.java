package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void validateSize() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_SIZE.getMessage());
    }

    @DisplayName("당첨 번호가 1 ~ 45 범위의 수를 넘으면 예외가 발생한다.")
    @Test
    void validateRange() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_RANGE.getMessage());
    }

    @DisplayName("당첨 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateDuplication() {
        assertThatThrownBy(() -> WinningNumber.from("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_DUPLICATION.getMessage());
    }
}