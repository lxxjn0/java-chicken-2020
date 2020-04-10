package domain.order.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CategoryTest {

	@ParameterizedTest
	@CsvSource(value = {"CHICKEN,true", "BEVERAGE,false"})
	void isChicken_ChickenCategory_ReturnTrue(final Category category, final boolean expected) {
		assertThat(category.isChicken()).isEqualTo(expected);
	}

}