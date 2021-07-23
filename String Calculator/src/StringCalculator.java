import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	int Call_Count;
	public void setCall_Count(int call_Count) {
		Call_Count = call_Count;
	}
	
	public int Add(String Input) throws Exception {
		Call_Count++;
//		when null string is passed in input
		if (Input.equals(""))
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
			int n = Integer.parseInt(s);
			sum += n;
		}

		return sum;
	}

	public String[] getInputSplitByDelimiter(String Input) {

//		Handling the custom Delimiters between the numbers
		if (Input.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(Input);
			m.matches();
			String customDelimiter = m.group(1);
			String numbers = m.group(2);

			return numbers.split(Pattern.quote(customDelimiter));
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
			int n = Integer.parseInt(s);

			if (n < 0)
				negative_numbers.append(n + " ");
		}

		return negative_numbers.toString();
	}

	public Integer getCalledCount() {
//		return the count of how many times Add function has been invoked
		return Call_Count;
	}

}
