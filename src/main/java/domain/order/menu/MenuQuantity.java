package domain.order.menu;

public class MenuQuantity {

	private static final int LOWER_QUANTITY_BOUND = 0;
	private static final int UPPER_QUANTITY_BOUND = 99;

	private final int menuQuantity;

	public MenuQuantity(final int menuQuantity) {
		validate(menuQuantity);
		this.menuQuantity = menuQuantity;
	}

	private void validate(final int menuQuantity) {
		if (menuQuantity < LOWER_QUANTITY_BOUND || menuQuantity > UPPER_QUANTITY_BOUND) {
			throw new IllegalArgumentException("유효한 메뉴 수량이 아닙니다.");
		}
	}

}
