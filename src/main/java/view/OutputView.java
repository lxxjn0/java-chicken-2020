package view;

import java.util.List;
import java.util.Map;

import domain.order.menu.Menu;
import domain.order.table.Table;

public class OutputView {

	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printLine(BOTTOM_LINE, size);
	}

	public static void printMenus(final Map<Integer, Menu> menus) {
		for (final Map.Entry<Integer, Menu> entry : menus.entrySet()) {
			final int number = entry.getKey();
			final Menu menu = entry.getValue();

			System.out.println(menu.getMenuInfo(number));
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

}
