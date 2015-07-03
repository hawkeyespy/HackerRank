package ds.string;

public class MinimumRotation {

	/*
	 * public static void main(String[] args) {
	 * System.out.println(findMinRotation("baabccd")); }
	 * 
	 * private static int findMinRotation(String str) { int n = str.length();
	 * str += str;// # Concatenate string to self to avoid modular arithmetic //
	 * int f = [-1 for c in S] # Failure function int k = 0;// # Least rotation
	 * of string found so far for (int j = 1; j <= 2 * n; j++) { int i = (j - k
	 * - 1) < n ? j - k - 1 : -1; while ((i != -1) && (str.charAt(j) !=
	 * str.charAt(k + i + 1))) { if (str.charAt(j) < str.charAt(k + i + 1)) k =
	 * j - i - 1; i = i < n ? i : -1; } if ((i == -1) && (str.charAt(j) !=
	 * str.charAt(k + i + 1))) { if (str.charAt(j) < str.charAt(k + i + 1)) { k
	 * = j; i = -1; } } else { i = i + 1; } }
	 * 
	 * return k; }
	 */

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		String g = "GAHYHDHYYSAHYHSWSAHYHA";
		g="A";

		int k = 0;

		k = strrot(g, k, 1, 0);

		System.out.println(k);

		System.out.println(g.substring(k) + g.substring(0, k));

	}

	public static int strrot(String g, int k, int i, int ind) {

		int length = g.length();
		if ((int) g.charAt(k) > (int) g.charAt(i)) {

			k = (i - ind + length) % g.length();

			System.out.println("k i ind in >: " + k + " " + i + " " + ind);

			if (i == g.length() - 1)

				return k;

			k = strrot(g, k, (i + 1 - ind + length) % length, 0);

		}

		else if ((int) g.charAt(k) == (int) g.charAt(i)) {

			System.out.println("k i ind in ==: " + k + " " + i + " " + ind);

			if (i == length - 1)

				k = strrot(g, k + 1, 0, ++ind);

			else

				k = strrot(g, k + 1, i + 1, ++ind);

		}

		else {

			System.out.println("k i ind in <: " + k + " " + i + " " + ind);

			if (i == length - 1)

				return k;

			k = strrot(g, k - ind, (i + 1 - ind + length) % length, 0);

		}

		return k;

	}

}
