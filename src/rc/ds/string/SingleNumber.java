package ds.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Problem Statement
 * 
 * There are N integers in an array A. All but one integer occur in pairs. Your
 * task is to find out the number that occurs only once.
 * 
 * Constraints

1 <= N < 100
N % 2 = 1 ( N is an odd number )
0 <= A[i] <= 100, ∀ i ∈ [1, N]


 * 
 * @author Ravi_Chandra
 *
 */
public class SingleNumber {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(in.readLine());
		String[] arrs = in.readLine().split(" ");
		HashMap<String, Integer> strArr = new HashMap<String, Integer>(size);
		int i = 0;
		for (String st : arrs) {
			if (!strArr.containsKey(st)) {
				strArr.put(st, 0);
			} else {
				strArr.remove(st);
			}
		}
		System.out.println(strArr.keySet().toArray()[0]);
	}
}

//
// public static void main(String[] args) {
// Scanner in = new Scanner(System.in);
// int res;
//
// int _a_size = Integer.parseInt(in.nextLine());
// int[] _a = new int[_a_size];
// int _a_item;
// String next = in.nextLine();
// String[] next_split = next.split(" ");
//
// for(int _a_i = 0; _a_i < _a_size; _a_i++) {
// _a_item = Integer.parseInt(next_split[_a_i]);
// _a[_a_i] = _a_item;
// }
//
// res = lonelyinteger(_a);
// System.out.println(res);
//
// }