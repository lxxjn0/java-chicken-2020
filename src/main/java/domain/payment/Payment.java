package domain.payment;

public enum Payment {

	CARD(5),
	CASH(0);

	private final int discountRate;

	Payment(final int discountRate) {
		this.discountRate = discountRate;
	}

	public int getDiscountRate() {
		return discountRate;
	}

}
