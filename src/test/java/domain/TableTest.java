package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

}