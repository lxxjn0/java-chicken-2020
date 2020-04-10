package domain.order;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import domain.order.menu.Category;
import domain.order.menu.Menu;
import domain.order.table.Table;

class OrdersTest {

	@Test
	void Orders_MapOfTableAndOrder_GenerateInstance() {
		assertThat(new Orders(new HashMap<>())).isInstanceOf(Orders.class);
	}

	@Test
	void Orders_EmptyOrders_GenerateInstance() {
		assertThat(new Orders()).isInstanceOf(Orders.class);
	}

	@ParameterizedTest
	@NullSource
	void Orders_NullOrders_ExceptionThrown(final Map<Table, Order> orders) {
		assertThatThrownBy(() -> new Orders(orders))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("주문들이 null입니다.");
	}

	@Test
	void add_TableAndOrder_AddTableOrder() {
		final Menu menu = new Menu("후라이드", Category.CHICKEN, 16_000);
		final Order order = new Order(Arrays.asList(menu));
		final Orders orders = new Orders();
		final Table table = Table.of(1);
		orders.add(table, order);

		Map<Table, Order> expected = new HashMap<>();
		expected.put(table, order);
		assertThat(orders).extracting("orders").isEqualTo(expected);
	}

	@ParameterizedTest
	@NullSource
	void add_NullTable_ExceptionThrown(final Table table) {
		Orders orders = new Orders();

		assertThatThrownBy(() -> orders.add(table, new Order()))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("테이블이 null입니다.");
	}

	@ParameterizedTest
	@NullSource
	void add_NullOrder_ExceptionThrown(final Order order) {
		Orders orders = new Orders();

		assertThatThrownBy(() -> orders.add(Table.of(1), order))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("주문이 null입니다.");
	}

	@Test
	void contains_TableContains_ReturnTrue() {
		final Menu menu = new Menu("후라이드", Category.CHICKEN, 16_000);
		final Order order = new Order(Arrays.asList(menu));
		final Orders orders = new Orders();
		final Table table = Table.of(1);
		orders.add(table, order);

		assertThat(orders.contains(table)).isTrue();
	}

	@Test
	void contains_TableNotContains_ReturnFalse() {
		final Menu menu = new Menu("후라이드", Category.CHICKEN, 16_000);
		final Order order = new Order(Arrays.asList(menu));
		final Orders orders = new Orders();
		final Table table = Table.of(1);
		orders.add(table, order);

		assertThat(orders.contains(Table.of(2))).isFalse();
	}

	@ParameterizedTest
	@NullSource
	void contains_NullTable_ExceptionThrown(final Table table) {
		Orders orders = new Orders();

		assertThatThrownBy(() -> orders.contains(table))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("테이블이 null입니다.");
	}

}