package domain.order.table;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TableRepositoryTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 5, 6, 8})
	void of_Number_ReturnInstance(final int number) {
		final Table table1 = TableRepository.of(number);
		final Table table2 = TableRepository.of(number);

		assertThat(table1).isEqualTo(table2);
		assertThat(table1 == table2).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 4, 7, 9})
	void of_InvalidNumber_ExceptionThrown(final int number) {
		assertThatThrownBy(() -> TableRepository.of(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효한 테이블이 아닙니다.");
	}

}