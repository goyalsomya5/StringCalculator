import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;



	
public class TestCalculator {
	
	@Test
	public void Test1() {
		
		StringCalculator Calculator = new StringCalculator();
		
		assertEquals(0, Calculator.Add(""));
	}
	
	 
}
