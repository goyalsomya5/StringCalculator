
public class StringCalculator {

	public int Add(String Input) {

//		When null string is passed as input
		if (Input.equals(""))
			return 0;

		String Numbers[] = Input.split(",");
		
		if(Numbers.length == 1)
			return Integer.parseInt(Numbers[0]);
		
		return Integer.parseInt(Numbers[0]) + Integer.parseInt(Numbers[1]);
	}

	public boolean isEmpty(String Input) {
		if (Input.length() == 0)
			return true;

		return false;
	}
	 
}
