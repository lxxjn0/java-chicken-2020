package domain.order.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {

	private static final List<Table> tables = new ArrayList<>();

	static {
		tables.add(new Table(1));
		tables.add(new Table(2));
		tables.add(new Table(3));
		tables.add(new Table(5));
		tables.add(new Table(6));
		tables.add(new Table(8));
	}

	static Table of(final int number) {
		return tables.stream()
			.filter(table -> table.isSameTable(number))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("유효한 테이블이 아닙니다."));
	}

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}

}
