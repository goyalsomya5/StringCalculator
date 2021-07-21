import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

public class TestCalculator {
	StringCalculator Calculator;

	@Before
	public void initialize() {
		Calculator = new StringCalculator();
	}

	@Test
	public void Test1() {
//		test for blank string

		assertEquals(0, Calculator.Add(""));
	}

	@Test
	public void Test2() {
//		test for a single number
		assertEquals(13, Calculator.Add("13"));
	}

	@Test
	public void Test3() {
//		test for a two numbers
		assertEquals(3, Calculator.Add("1,2"));
	}

}
