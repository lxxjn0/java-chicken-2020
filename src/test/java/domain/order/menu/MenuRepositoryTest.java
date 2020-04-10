package domain.order.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuRepositoryTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 21, 22})
	void of_Number_ReturnInstance(final int number) {
		assertThat(MenuRepository.of(number)).isInstanceOf(Menu.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 7, 20, 23})
	void of_InvalidNumber_ExceptionThrown(final int number) {
		assertThatThrownBy(() -> MenuRepository.of(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효한 메뉴 번호가 아닙니다.");
	}
}