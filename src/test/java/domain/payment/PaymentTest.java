package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PaymentTest {

	@ParameterizedTest
	@CsvSource(value = {"CARD,0", "CASH,500"})
	void calculateDiscountedAmount_Payment_ReturnDiscountRate(final Payment payment, final int expected) {
		final double payingAmount = 10000;

		assertThat(payment.calculateDiscountedAmount(payingAmount)).isEqualTo(expected);
	}

}