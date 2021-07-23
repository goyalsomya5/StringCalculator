import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int Add(String Input) throws Exception {

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

	public int getSum(String Numbers[]) throws Exception{
		int sum = 0;

		for (String s : Numbers) {
			int n = Integer.parseInt(s);
			if(n < 0)
			throw new Exception("negatives not allowed : " + n);	
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

	

}
