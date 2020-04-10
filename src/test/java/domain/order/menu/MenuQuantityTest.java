package domain.order.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuQuantityTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 99})
	void of_QuantityOfMenu_GenerateInstance(final int menuQuantity) {
		assertThat(MenuQuantity.of(menuQuantity)).isInstanceOf(MenuQuantity.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 100})
	void validate_InvalidMenuQuantity_ExceptionThrown(final int menuQuantity) {
		assertThatThrownBy(() -> MenuQuantity.of(menuQuantity))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효한 메뉴 수량이 아닙니다.");
	}

	@Test
	void add_MenuQuantity_AddMenuQuantityToThis() {
		MenuQuantity menuQuantity = MenuQuantity.of(1);

		assertThat(menuQuantity.add(MenuQuantity.of(2))).isInstanceOf(MenuQuantity.class)
			.extracting("menuQuantity").isEqualTo(3);
	}
}