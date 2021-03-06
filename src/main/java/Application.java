import java.util.List;
import java.util.Map;

import domain.order.Orders;
import domain.order.menu.Menu;
import domain.order.menu.MenuRepository;
import domain.order.table.Table;
import domain.order.table.TableRepository;
import view.InputView;
import view.OutputView;

public class Application {

	public static void main(String[] args) {
		final Orders orders = new Orders();
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables, orders);

		final int tableNumber = InputView.inputTableNumber();

		final Map<Integer, Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
	}

}
