import java.util.Scanner;

public class SecondTask {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please, enter string:");

		String input = scanner.nextLine();
		scanner.close();

		try{
			int res = myParseToInt(input);

			System.out.println("Result of parsing your string to int:" + res);

		} catch(NumberFormatException error){
			System.out.println(error.getMessage());
		}
	}

	public static int myParseToInt(String str) throws NumberFormatException {
		if (str == null || str.isEmpty()){
			throw new NumberFormatException("String is null or empty!!!");
		}	
		
		int res = 0, sign = 1, startIndex=0;

		if(str.charAt(startIndex) == '-') {
			sign = -1;
			startIndex++;
		}
		else if (str.charAt(startIndex) == '+') {
			startIndex++;
		}

		for(int i = startIndex; i < str.length(); ++i){
			char ch = str.charAt(i);
			int digit = Character.getNumericValue(ch);

			if (digit < 0 || digit > 9) {
				throw new NumberFormatException("Invalid character in input string" + ch);
			}

			res = res * 10 + digit;
		}

		return res * sign;
	}
}
