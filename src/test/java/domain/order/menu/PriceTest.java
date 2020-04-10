package domain.order.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

	@Test
	void Price_Price_GenerateInstance() {
		assertThat(new Price(10_000)).isInstanceOf(Price.class);
	}

	@ParameterizedTest
	@ValueSource(doubles = -1)
	void validate_InvalidPrice_ExceptionThrown(final double price) {
		assertThatThrownBy(() -> new Price(price))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효한 금액이 아닙니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {"10000,2,20000", "20000,0,0"})
	void multiply_MultipliedNumber_ReturnMultipliedResult(final double value, final int number, final double expected) {
		assertThat(new Price(value).multiply(number)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"10000,-1"})
	void multiply_InvalidMultipliedNumber_ExceptionThrown(final double value, final int multiplied) {
		assertThatThrownBy(() -> new Price(value).multiply(multiplied))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효한 피연산자가 아닙니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {"10000,2,20000", "20000,0,0"})
	void multiply_MenuQuantity_ReturnMultipliedResult(final double value, final int number, final double expected) {
		MenuQuantity menuQuantity = MenuQuantity.of(number);
		assertThat(new Price(value).multiply(menuQuantity)).isEqualTo(expected);
	}

	@ParameterizedTest
	@NullSource
	void multiply_InvalidMultipliedNumber_ExceptionThrown(final MenuQuantity menuQuantity) {
		assertThatThrownBy(() -> new Price(10_000).multiply(menuQuantity))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("수량이 null입니다.");
	}

}