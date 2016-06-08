package ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;


/*
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature, i.e., if A is friend of B and B is friend of C, then A is also friend of C. A friend circle is a group of students who are directly or indirectly friends.

You have to complete a function int friendCircles(char[][] friends) which returns the number of friend circles in the class. Its argument, friends, is a NxN matrix which consists of characters 'Y' or 'N'.  If friends[i][j] = 'Y', then ith and jth students are friends with each other, otherwise not. You have to return the total number of friend circles in the class.

Note: The method signature will differ by language. For example, Java will have 'int friendCircles(String[] friends)' where "friends" is an array of strings, which can be viewed as a 2-dimensional array of characters.
Constraints
•1 <= N <= 300.
•Each element of matrix friends will be 'Y' or 'N'.
•Number of rows and columns will be equal in friends.
•friends[i][i] = 'Y', where 0 <= i < N.
•friends[i][j] = friends[j][i], where 0 <= i < j < N.
  

 

Sample Input #1
 YYNN
 YYYN
 NYYN
 NNNY
Sample Output #1: 

2
  

Explanation #1: 

There are two pairs of friends (0, 1) and (1, 2). So (0, 2) is also a pair of friends by transitivity. So first friend circle contains (0, 1, 2), and second friend circle contains only student 3.

 

Sample Input #2

 YNNNN
NYNNN
 NNYNN
 NNNYN
 NNNNY
  

Sample Output #2: 

5


Explanation #2: 

No student is friends with any other, so each friend circle will contain of only one student {0}, {1}, {2}, {3}, {4}.

 */
public class FriendCircle {
private static int count=0;
	public static void main(String[] args) {
		String [][]frnds = {{"Y","Y","N","N"},{"Y","Y","Y","N"}
		,{"N","Y","Y","N"},{"N","N","N","Y"}};
		
		String [][]frnds1 = {{"Y","N","N","N","N"},{"N","Y","N","N","N"}
		,{"N","N","Y","N","N"},{"N","N","N","Y","N"},{"N","N","N","N","Y"}};
		System.out.println("Count = "+findFriendCircle(frnds));
	}
 static int findFriendCircle(String frnds[][])
 {
	 
	 int noOfCircles = 0;
	 noOfCircles = build(reduce(frnds));
	 return noOfCircles;
 }
 
private static int build(HashMap<Integer, ArrayList<Integer>> build) {
	
	
	for(Entry<Integer, ArrayList<Integer>> entry:build.entrySet())
	{
		searchChain(build, entry.getKey());
		
	}
	return count;
}

	private static int searchChain(HashMap<Integer, ArrayList<Integer>> build,
			int index) {
        int chainCount = 0;
		for (Integer next : build.get(index)) {
			if (next > index) {
				chainCount+=searchChain(build, next);
				chainCount++;
			}
		}
		return chainCount;
	}

	private static HashMap<Integer, ArrayList<Integer>> reduce(String[][] frnds) {
		HashMap<Integer, ArrayList<Integer>> reduceList = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> temp;

		for (int i = 0; i < frnds.length; i++) {
			temp = new ArrayList<Integer>();
			for (int j = 0; j < frnds[i].length; j++) {
				if (!(i == j) && "Y".equals(frnds[i][j])) {
					temp.add(j);
				}
			}

			if (!temp.isEmpty()) {
				reduceList.put(i, temp);
			} else {
				count++;
			}
		}
		System.out.println(reduceList);
		return reduceList;
	}
}
