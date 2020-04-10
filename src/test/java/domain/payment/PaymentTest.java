package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PaymentTest {

	@ParameterizedTest
	@CsvSource(value = {"CARD, 5", "CASH, 0"})
	void getDiscountRate_Payment_ReturnDiscountRate(final Payment payment, final int expected) {
		assertThat(payment.getDiscountRate()).isEqualTo(expected);
	}

}