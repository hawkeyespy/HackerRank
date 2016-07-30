package rc.ds.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindDigits {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(in.readLine());
		ArrayList<Integer> strArr = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			strArr.add(i, Integer.parseInt(in.readLine()));
		}

		for (Integer st : strArr) {
			System.out.println(findDigits(st));
		}
	}

	private static int findDigits(Integer st) {
		String no = st + "";
		int size = no.length();
		int digit;
		int counter = 0;
		for (int i = 0; i < size; i++) {
			digit = Integer.parseInt(no.charAt(i) + "");
			if (!(digit == 0)) {
				if ((st % digit) == 0) {
					counter++;
				}
			}
		}
		return counter;
	}
}
