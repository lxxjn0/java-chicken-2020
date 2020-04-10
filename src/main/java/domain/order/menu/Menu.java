package domain.order.menu;

public class Menu {

	private final String name;
	private final Category category;
	private final Price price;

	Menu(final String name, final Category category, final Price price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public boolean isChicken() {
		return category.isChicken();
	}

	public String getMenuInfo(final int number) {
		return category + " " + number + " - " + name + " : " + String.format("%d원", (int)price.getPrice());
	}

	public Price getPrice() {
		return price;
	}

}
