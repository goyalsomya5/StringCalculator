import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	int Call_Count;

	public void setCall_Count(int call_Count) {
//		setting the call_Count 0 for whenever called.
		Call_Count = call_Count;
	}

	public Integer getCalledCount() {
//		return the count of how many times Add function has been invoked
		return Call_Count;
	}

	public int Add(String Input) throws Exception {
		Call_Count++;
//		when null string is passed in input
		if (isEmpty(Input))
			return 0;

		String Numbers[] = getInputSplitByDelimiter(Input);

//		when a single number is passed in input
		if (Numbers.length == 1)
			return Integer.parseInt(Numbers[0]);

//		when a two or more numbers are passed in input
		else {
			return getSum(Numbers);
		}
	}

	public boolean isEmpty(String Input) {
		if (Input.length() == 0)
			return true;

		return false;
	}

	public int getSum(String Numbers[]) throws Exception {
		int sum = 0;

		String negative_numbers = getNegatives(Numbers);

		if (negative_numbers.length() != 0)
			throw new Exception("negatives not allowed : " + negative_numbers);

		for (String s : Numbers) {
			int n = 0;
			if (s.length() != 0)
				n = Integer.parseInt(s);

//			Numbers less than or equal to 1000 will only be considered in the sum
			if (n <= 1000)
				sum += n;
		}

		return sum;
	}

	public String[] getInputSplitByDelimiter(String Input) {

//		Handling the multiple custom Delimiters of any length between the numbers.
		if (Input.startsWith("//")) {

			return splitInputForCustomDelimiters(Input);
		}

//		Handling the new line and commas between the numbers
		else {
			String delimiters = "\n|,";
			return Input.split(delimiters);
		}
	}

	public String getNegatives(String Numbers[]) {
//		Catching all the negative numbers present in the string.
		StringBuilder negative_numbers = new StringBuilder();
		for (String s : Numbers) {
			int n = 0;
			if (s.length() != 0)
				n = Integer.parseInt(s);

			if (n < 0)
				negative_numbers.append(n + " ");
		}

		return negative_numbers.toString();
	}

	public String[] splitInputForCustomDelimiters(String Input) {

//		First : replace all the meta characters(delimiters) with white spaces in the input irrespective of any length.
		Input = Input.replaceAll("[^\\d]", " ");

//		Second : replace all the multiple white spaces from the Input string with a single white space.
		Input = Input.replaceAll(" +", " ");

//		Third : remove any unnecessary white spaces at the starting or at end of the Input. 
		Input = Input.trim();

		return Input.split(" ");
	}
}
