import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

public class TestCalculator {

	@Test
	public void Test1() {
//		test for blank string

		StringCalculator Calculator = new StringCalculator();

		assertEquals(0, Calculator.Add(""));
	}

	@Test
	public void Test2() {
//		test for a single number

		StringCalculator Calculator = new StringCalculator();

		assertEquals(13, Calculator.Add("13"));
	}

}
