package rc.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Java8Test {
	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(100);
		
		usingPrediction(list, 
				p -> p<100 );
	}

	private static void usingPrediction(List<Integer> intList, Predicate<Integer> predicate) {
		for(Integer integer:intList)
			{
			System.out.println(predicate.test(integer));
			//System.out.println(predicate.);
			}
		
	}
}

