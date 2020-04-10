package domain.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import domain.order.menu.Menu;
import domain.order.menu.MenuQuantity;

public class Order {

	private static final int DISCOUNT_QUANTITY_UNIT = 10;
	private static final int DISCOUNT_AMOUNT_UNIT = 10_000;

	private final Map<Menu, MenuQuantity> order;

	public Order(final Map<Menu, MenuQuantity> order) {
		Objects.requireNonNull(order, "주문이 null입니다.");
		this.order = order;
	}

	public Order() {
		this(new HashMap<>());
	}

	public void add(final Menu menu, final MenuQuantity menuQuantity) {
		Objects.requireNonNull(menu, "메뉴가 null입니다.");
		Objects.requireNonNull(menuQuantity, "수량이 null입니다,");
		MenuQuantity totalMenuQuantity = addMenuQuantityIfPresent(menu, menuQuantity);
		order.put(menu, totalMenuQuantity);
	}

	private MenuQuantity addMenuQuantityIfPresent(final Menu menu, final MenuQuantity menuQuantity) {
		if (order.containsKey(menu)) {
			return order.get(menu).add(menuQuantity);
		}
		return menuQuantity;
	}

	public double calculateDiscountedAmount() {
		return calculateTotalAmount() - calculateDiscountAmount();
	}

	private double calculateTotalAmount() {
		return order.entrySet().stream()
			.mapToDouble(entry -> {
				Menu menu = entry.getKey();
				MenuQuantity menuQuantity = entry.getValue();
				return menu.getPrice().multiply(menuQuantity);
			})
			.sum();
	}

	private double calculateDiscountAmount() {
		final int totalChickenQuantity = order.entrySet().stream()
			.filter(entry -> entry.getKey().isChicken())
			.map(Map.Entry::getValue)
			.mapToInt(MenuQuantity::getMenuQuantity)
			.sum();

		return calculateDiscountUnit(totalChickenQuantity) * Order.DISCOUNT_AMOUNT_UNIT;
	}

	private int calculateDiscountUnit(final int totalChickenQuantity) {
		return totalChickenQuantity / DISCOUNT_QUANTITY_UNIT;
	}

}