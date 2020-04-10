package view;

import java.util.List;
import java.util.Map;

import domain.order.Orders;
import domain.order.menu.Menu;
import domain.order.table.Table;

public class OutputView {

	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ %s ┘";
	private static final String PAYING_MARKING = "₩";
	private static final String NON_PAYING_MARKING = "-";

	public static void printTables(final List<Table> tables, final Orders orders) {
		System.out.println("## 테이블 목록");
		printTopLine(TOP_LINE, tables);
		printTableNumbers(tables);
		printBottomLine(BOTTOM_LINE, tables, orders);
	}

	public static void printMenus(final Map<Integer, Menu> menus) {
		for (final Map.Entry<Integer, Menu> entry : menus.entrySet()) {
			final int number = entry.getKey();
			final Menu menu = entry.getValue();

			System.out.println(menu.getMenuInfo(number));
		}
	}

	private static void printTopLine(final String topLine, final List<Table> tables) {
		for (Table table : tables) {
			System.out.print(topLine);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	private static void printBottomLine(final String bottomLine, final List<Table> tables, final Orders orders) {
		for (Table table : tables) {
			System.out.printf(bottomLine, getPayingMarking(table, orders));
		}
		System.out.println();
	}

	private static String getPayingMarking(final Table table, final Orders orders) {
		if (orders.contains(table)) {
			return PAYING_MARKING;
		}
		return NON_PAYING_MARKING;
	}

}
