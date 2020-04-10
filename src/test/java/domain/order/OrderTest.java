package domain.order;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import domain.order.menu.Menu;
import domain.order.menu.MenuQuantity;
import domain.order.menu.MenuRepository;

class OrderTest {

	@Test
	void Order_MenuList_GenerateInstance() {
		final Menu menu = MenuRepository.of(1);
		final MenuQuantity menuQuantity = MenuQuantity.of(1);
		final Map<Menu, MenuQuantity> menus = new HashMap<>();
		menus.put(menu, menuQuantity);

		assertThat(new Order(menus)).isInstanceOf(Order.class);
	}

	@Test
	void Order_EmptyOrder_GenerateInstance() {
		assertThat(new Order()).isInstanceOf(Order.class);
	}

	@ParameterizedTest
	@NullSource
	void Order_NullOrder_ExceptionThrown(Map<Menu, MenuQuantity> menus) {
		assertThatThrownBy(() -> new Order(menus))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("주문이 null입니다.");
	}

	@Test
	void add_Menu_AddMenuToOrder() {
		final Menu menu = MenuRepository.of(1);
		final MenuQuantity menuQuantity = MenuQuantity.of(1);
		final Order order = new Order();
		order.add(menu, menuQuantity);

		Map<Menu, MenuQuantity> expected = new HashMap<>();
		expected.put(menu, menuQuantity);
		assertThat(order).extracting("order").isEqualTo(expected);
	}

	@Test
	void addMenuQuantityIfPresent_AddSameMenu_AddMenuQuantityToPresentMenuQuantity() {
		final Menu menu = MenuRepository.of(1);
		final MenuQuantity menuQuantity = MenuQuantity.of(1);
		final Order order = new Order();
		order.add(menu, menuQuantity);
		final MenuQuantity additionalMenuQuantity = MenuQuantity.of(3);
		order.add(menu, additionalMenuQuantity);

		Map<Menu, MenuQuantity> expected = new HashMap<>();
		expected.put(menu, MenuQuantity.of(4));
		assertThat(order).extracting("order").isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"10,150000", "25,380000", "39,594000"})
	void calculateDiscountedAmount_Menus_ReturnDiscountedAmountByChickenQuantity(final int value, final int expected) {
		final Menu menu = MenuRepository.of(1); // 16_000원
		final MenuQuantity menuQuantity = MenuQuantity.of(value);
		final Order order = new Order();
		order.add(menu, menuQuantity);

		assertThat(order.calculateDiscountedAmount()).isEqualTo(expected);
	}

}