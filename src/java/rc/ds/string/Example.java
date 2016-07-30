package rc.ds.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Example {
	
	public static void main(String[] args) {
		String word ="shai";
		String sentence = "tis is a girl";
		
		Collection<Character> list = new ArrayList<>();
		for(int i=0;i<word.length(); i++){
			list.add(word.charAt(i));
		}
		List<Character> list1 = new ArrayList<>();
		for(int i=0;i<sentence.length(); i++){
			list.add(sentence.charAt(i));
		}
		
		if(list1.containsAll(list)){
			System.out.println("contais all letter");;
		}else{
			System.out.println("Doesnt contain all letter");
		}
		
		
	}

}
