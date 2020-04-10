package domain.payment;

import java.util.function.UnaryOperator;

public enum Payment {

	CARD(payingAmount -> 0.0),
	CASH(payingAmount -> payingAmount * 0.05);

	private final UnaryOperator<Double> discountRate;

	Payment(final UnaryOperator<Double> discountRate) {
		this.discountRate = discountRate;
	}

	public double calculateDiscountedAmount(final double payingAmount) {
		return discountRate.apply(payingAmount);
	}

}
