package rc.ds.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Palindrome {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(in.readLine());
		ArrayList<String> strArr = new ArrayList<String>(no);
		for (int i = 0; i < no; i++) {
			strArr.add(i, in.readLine());
		}
		for (String st : strArr) {
			System.out.println(findIndex(st));
		}
	}

	public static int findIndex(String sb) {

		if (isPalindrome(sb)) {
			return -1;
		}

		StringBuffer temp;
		temp = new StringBuffer(sb);
		int length = sb.length();
		for (int i = 0; i < length/2; i++) {
			temp = new StringBuffer(sb);
			if (isPalindrome(temp.deleteCharAt(i) + "")) {
				return i;
			}
			temp = new StringBuffer(sb);	
			if (isPalindrome(temp.deleteCharAt(length-i-1) + "")) {
				return length-i-1;
			}
		}
		return 0;
	}

	private static boolean isPalindrome(String sb) {
		int length = sb.length();
		if (length < 2)
			return false;

		for (int i = 0; i < length / 2; i++) {
			if (!(sb.charAt(i) == sb.charAt(length - i - 1))) {
				return false;
			}
		}
		return true;
	}
}
