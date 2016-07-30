package rc.ds.string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedPalindromeTest {

	@Parameter(value=0)
	public String string;
	@Parameter(value=1)
	public Boolean result;
	
//	public void ParameterizedPalindromeTest(String input, Boolean output)
//	{
//		string = input;
//		result = output;
//	}
	
	@Parameters
	public static Collection<Object[]> parameters()
	{
		return Arrays.asList(new Object[][]{
			{"ABA", true},
			{"ABC", false},
			{"ABC", false}
			});
	}
	
	@Test
	public void palindromeTest()
	{
		System.out.println("Checking : "+ string);
		assertEquals(result, Palindrome.isPalindrome_using_stringBuffer(string));
	}
}
