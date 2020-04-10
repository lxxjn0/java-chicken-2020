package domain.order.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenuTest {

	@Test
	void Menu_NameAndCategoryAndPrice_GenerateInstance() {
		assertThat(new Menu("후라이드", Category.CHICKEN, new Price(16_000))).isInstanceOf(Menu.class);
	}

	@Test
	void getMenuInfo_Number_ReturnMenuInformation() {
		final int number = 1;
		final Menu menu = new Menu("후라이드", Category.CHICKEN, new Price(16_000));

		final String expected = String.format("[치킨] %d - 후라이드 : 16000원", number);
		assertThat(menu.getMenuInfo(number)).isEqualTo(expected);
	}

	@Test
	void isChicken_MenuCategoryIsChicken_ReturnTrue() {
		final Menu menu = new Menu("후라이드", Category.CHICKEN, new Price(16_000));

		assertThat(menu.isChicken()).isTrue();
	}

	@Test
	void isChicken_MenuCategoryIsNotChicken_ReturnFalse() {
		final Menu menu = new Menu("콜라", Category.BEVERAGE, new Price(1_000));

		assertThat(menu.isChicken()).isFalse();
	}

}