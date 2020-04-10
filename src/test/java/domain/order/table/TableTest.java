package domain.order.table;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TableTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 8, 9})
	void Table_Number_GenerateInstance(final int number) {
		assertThat(new Table(number)).isInstanceOf(Table.class);
	}

	@Test
	void equals_SameNumber_ReturnTrue() {
		Table table1 = new Table(1);
		Table table2 = new Table(1);

		assertThat(table1).isEqualTo(table2);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 5, 6, 8})
	void of_Number_ReturnInstanceFromTableRepository(final int number) {
		assertThat(Table.of(number)).isInstanceOf(Table.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1,true", "1,2,false"})
	void isSameTable_Number_ReturnCompareResult(final int number, final int compare, final boolean expected) {
		Table table = new Table(number);

		assertThat(table.isSameTable(compare)).isEqualTo(expected);
	}

}