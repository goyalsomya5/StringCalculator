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

	@Test
	public void Test4() {
//		test for unknown amount of numbers
		assertEquals(15, Calculator.Add("1,2,3,4,5"));
	}

	@Test
	public void Test5() {
//		test for numbers separated by a new line.
		assertEquals(10, Calculator.Add("6\n4"));
	}

	@Test
	public void Test6() {
//		test for numbers separated by a new line.
		assertEquals(15, Calculator.Add("6\n4,5"));
	}
	
	@Test
	public void Test7() {
//		test for different kinds of delimiters
		assertEquals(3, Calculator.Add("//;\n1;2"));
	}

}
