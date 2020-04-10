package domain.order.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuQuantityTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 99})
	void MenuQuantity_QuantityOfMenu_GenerateInstance(final int menuQuantity) {
		assertThat(new MenuQuantity(menuQuantity)).isInstanceOf(MenuQuantity.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 100})
	void validate_InvalidMenuQuantity_ExceptionThrown(final int menuQuantity) {
		assertThatThrownBy(() -> new MenuQuantity(menuQuantity))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효한 메뉴 수량이 아닙니다.");
	}

}