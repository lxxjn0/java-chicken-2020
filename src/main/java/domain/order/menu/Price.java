package domain.order.menu;

import java.util.Objects;

public class Price {

	private final double price;

	public Price(final double price) {
		validate(price);
		this.price = price;
	}

	private void validate(final double price) {
		if (price < 0) {
			throw new IllegalArgumentException("유효한 금액이 아닙니다.");
		}
	}

	public double multiply(final int multiplied) {
		if (multiplied < 0) {
			throw new IllegalArgumentException("유효한 피연산자가 아닙니다.");
		}

		return this.price * multiplied;
	}

	public double multiply(final MenuQuantity menuQuantity) {
		Objects.requireNonNull(menuQuantity, "수량이 null입니다.");
		return multiply(menuQuantity.getMenuQuantity());
	}

	public double getPrice() {
		return price;
	}

	@Override
	public boolean equals(final Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		final Price that = (Price)object;
		return Double.compare(that.price, price) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price);
	}

}
