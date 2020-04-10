package domain.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.order.menu.Category;
import domain.order.menu.Menu;

class OrderTest {

	@Test
	void Order_EmptyOrder_GenerateInstance() {
		assertThat(new Order()).isInstanceOf(Order.class);
	}

	@Test
	void addMenu_Menu_AddMenuToOrder() {
		final Menu menu = new Menu("후라이드", Category.CHICKEN, 16_000);
		final Order order = new Order();
		order.addMenu(menu);

		assertThat(order).extracting("menus").asList().contains(menu);
	}

}