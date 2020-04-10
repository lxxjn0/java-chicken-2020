package domain.order.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class MenuQuantity {

	public static final MenuQuantity ZERO = new MenuQuantity(0);
	private static final int LOWER_QUANTITY_BOUND = 0;
	private static final int UPPER_QUANTITY_BOUND = 99;
	private static final Map<Integer, MenuQuantity> MENU_QUANTITY_CACHE = new HashMap<>();

	private final int menuQuantity;

	static {
		IntStream.rangeClosed(LOWER_QUANTITY_BOUND, UPPER_QUANTITY_BOUND)
			.forEach(i -> MENU_QUANTITY_CACHE.put(i, new MenuQuantity(i)));
	}

	private MenuQuantity(final int menuQuantity) {
		validate(menuQuantity);
		this.menuQuantity = menuQuantity;
	}

	private void validate(final int menuQuantity) {
		if (menuQuantity < LOWER_QUANTITY_BOUND || menuQuantity > UPPER_QUANTITY_BOUND) {
			throw new IllegalArgumentException("유효한 메뉴 수량이 아닙니다.");
		}
	}

	public static MenuQuantity of(final int menuQuantity) {
		return MENU_QUANTITY_CACHE.getOrDefault(menuQuantity, new MenuQuantity(menuQuantity));
	}

	public MenuQuantity add(final MenuQuantity menuQuantity) {
		Objects.requireNonNull(menuQuantity, "수량이 null입니다.");
		return MenuQuantity.of(this.menuQuantity + menuQuantity.menuQuantity);
	}

	public int getMenuQuantity() {
		return menuQuantity;
	}

}
