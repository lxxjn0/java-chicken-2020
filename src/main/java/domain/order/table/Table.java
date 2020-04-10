package domain.order.table;

import java.util.Objects;

public class Table {

	private final int number;

	Table(final int number) {
		this.number = number;
	}

	public static Table of(final int number) {
		return TableRepository.of(number);
	}

	public boolean isSameTable(final int number) {
		return this.number == number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	@Override
	public boolean equals(final Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		final Table that = (Table)object;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

}
