package domain.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import domain.order.table.Table;

public class Orders {

	private final Map<Table, Order> orders;

	public Orders(final Map<Table, Order> orders) {
		Objects.requireNonNull(orders, "주문들이 null입니다.");
		this.orders = orders;
	}

	public Orders() {
		this(new HashMap<>());
	}

	public void add(final Table table, final Order order) {
		Objects.requireNonNull(table, "테이블이 null입니다.");
		Objects.requireNonNull(order, "주문이 null입니다.");
		orders.put(table, order);
	}

	public boolean contains(final Table table) {
		Objects.requireNonNull(table, "테이블이 null입니다.");
		return orders.containsKey(table);
	}

}
