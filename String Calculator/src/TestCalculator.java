import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

public class TestCalculator {
	StringCalculator Calculator;

	@Before
	public void initialize() {
		Calculator = new StringCalculator();
	}

	@Test
	public void Test1() throws Exception {
//		test for blank string

		assertEquals(0, Calculator.Add(""));
	}

	@Test
	public void Test2() throws Exception {
//		test for a single number
		assertEquals(13, Calculator.Add("13"));
	}

	@Test
	public void Test3() throws Exception {
//		test for a two numbers
		assertEquals(3, Calculator.Add("1,2"));
	}

	@Test
	public void Test4() throws Exception {
//		test for unknown amount of numbers
		assertEquals(15, Calculator.Add("1,2,3,4,5"));
	}

	@Test
	public void Test5() throws Exception {
//		test for numbers separated by a new line.
		assertEquals(10, Calculator.Add("6\n4"));
	}

	@Test
	public void Test6() throws Exception {
//		test for numbers separated by a new line.
		assertEquals(15, Calculator.Add("6\n4,5"));
	}

	@Test
	public void Test7() throws Exception {
//		test for different kinds of delimiters
		assertEquals(3, Calculator.Add("//;\n1;2"));
	}

	@Test(expected = Exception.class)
	public void Test8() throws Exception {
//		test to know whether the function throws exception on passing a negative number 
		Calculator.Add("-1,2,3");
	}

	@Test
	public void Test9() {
//		test : the exception on passing any negative number should contain that number
		try {
			Calculator.Add("1,-2,3");
		} catch (Exception e) {

			String expectedMessage = "negatives not allowed : -2";
			String actualMessage = e.getMessage();
			assertTrue(actualMessage.contains(expectedMessage));
		}

	}

	@Test
	public void Test10() {
//		test : the exception on passing multiple negative numbers should contain all the negative numbers
		try {
			Calculator.Add("1,-2,-3,-5,-7");
		} catch (Exception e) {

			String expectedMessage = "negatives not allowed : -2 -3 -5 -7";
			String actualMessage = e.getMessage();

			assertTrue(actualMessage.contains(expectedMessage));
		}
	}

	@Test
	public void Test11() throws Exception {
//		test : the exception on passing multiple negative numbers should contain all the negative numbers
		Calculator.setCall_Count(0);

		int Call_Time = 5;
		
		for (int call = 0; call < Call_Time; call++) 
			assertEquals(6, Calculator.Add("1,2,3"));
		
		assertEquals(5, Calculator.getCalledCount());
	}
	
	@Test
	public void Test12() throws Exception {
//	test : Numbers greater than 1000 shoulder be ignored.
		assertEquals(1010, Calculator.Add("1,2,3,4,1000,1002"));
	}

}
