
public class StringCalculator {

	public int Add(String Input) {

//		When null string is passed in input
		if (Input.equals(""))
			return 0;

		String Numbers[] = Input.split(",");


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

	public int getSum(String Numbers[]) {
		int sum = 0;

		for (String s : Numbers)
			sum += Integer.parseInt(s);

		return sum;
	}
}
