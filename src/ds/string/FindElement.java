package ds.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FindElement {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(in.readLine());
		int size = Integer.parseInt(in.readLine());
		String[] arrs = in.readLine().split(" ");
		HashMap<String, Integer> strArr = new HashMap<String, Integer>(size);
		int i = 0;
		for (String st : arrs) {
			strArr.put(st, i++);
		}
		System.out.println(strArr.get(no + ""));
	}
}
