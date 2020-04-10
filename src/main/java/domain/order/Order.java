package domain.order;

import java.util.ArrayList;
import java.util.List;

import domain.order.menu.Menu;

public class Order {

	private final List<Menu> order;

	private Order(final List<Menu> order) {
		this.order = order;
	}

	public Order() {
		this(new ArrayList<>());
	}

}