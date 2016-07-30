package rc.ds.string;

import java.io.CharArrayReader;
import java.util.HashSet;

public class LonlyInteger {
public static void main(String[] args) {
	int[] arra = {10,10,20,20,1};
	System.out.println(lonelyInteger(arra));
	System.out.println();
	
	String object = "abcdefgh";
	int objectlength = object.length();
	char c[] = new char[objectlength];
	
	object.getChars(0, objectlength, c, 0);
	
	CharArrayReader in1 = new CharArrayReader(c);
	CharArrayReader in2 = new CharArrayReader(c,1,4);
	
	int i;
	int j;
	
	try{
		while((i=in1.read())==(j=in2.read()))
		{
			System.out.println((char)i);
		}
		}
		catch(Exception e)
		{
			
		}
	
}

static int lonelyInteger(int[] arr) {

	HashSet<Integer> strArr = new HashSet<Integer>(arr.length);
	int i = 0;
	for (int st : arr) {
		if(strArr.contains(st))
			{			
			strArr.remove(st);
		}
		else
		{
			strArr.add(st);
		}
	}
	return strArr.iterator().next();
}

}
