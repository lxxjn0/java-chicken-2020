package domain.order.menu;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MenuRepository {

	private static final Map<Integer, Menu> menus = new LinkedHashMap<>();

	static {
		menus.put(1, new Menu("후라이드", Category.CHICKEN, new Price(16_000)));
		menus.put(2, new Menu("양념치킨", Category.CHICKEN, new Price(16_000)));
		menus.put(3, new Menu("반반치킨", Category.CHICKEN, new Price(16_000)));
		menus.put(4, new Menu("통구이", Category.CHICKEN, new Price(16_000)));
		menus.put(5, new Menu("간장치킨", Category.CHICKEN, new Price(17_000)));
		menus.put(6, new Menu("순살치킨", Category.CHICKEN, new Price(17_000)));
		menus.put(21, new Menu("콜라", Category.BEVERAGE, new Price(1_000)));
		menus.put(22, new Menu("사이다", Category.BEVERAGE, new Price(1_000)));
	}

	public static Menu of(final int number) {
		Menu menu = menus().get(number);

		if (Objects.isNull(menu)) {
			throw new IllegalArgumentException("유효한 메뉴 번호가 아닙니다.");
		}
		return menu;
	}

	public static Map<Integer, Menu> menus() {
		return Collections.unmodifiableMap(menus);
	}

}
