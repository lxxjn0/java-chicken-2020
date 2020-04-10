package domain.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import domain.order.menu.Menu;

public class Order {

	private final List<Menu> menus;

	private Order(final List<Menu> menus) {
		this.menus = menus;
	}

	public Order() {
		this(new ArrayList<>());
	}

	public void addMenu(final Menu menu) {
		Objects.requireNonNull(menu, "메뉴가 null입니다.");
		menus.add(menu);
	}

}