package domain.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {
	@Test
	void Order_EmptyOrder_GenerateInstance() {
		assertThat(new Order()).isInstanceOf(Order.class);
	}
}