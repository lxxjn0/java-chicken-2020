package domain.order.menu;

public class Menu {

	private final String name;
	private final Category category;
	private final int price;

	public Menu(final String name, final Category category, final int price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getMenuInfo(final int number) {
		return category + " " + number + " - " + name + " : " + price + "원";
	}

}
