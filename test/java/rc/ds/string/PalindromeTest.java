package rc.ds.string;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

public class PalindromeTest {
	
	@BeforeClass
	public static void setup()
	{
		System.out.println("Stating palindrome test case");
	}
	
	@AfterClass
	public static void tearDown()
	{
		System.out.println("Finished palindrome test case");
	}
	
	@Test(timeout=10)
	public void validPalindrome()
	{
		Assert.assertTrue("Correct", Palindrome.isPalindrome_using_stringBuffer("ABA"));
	}
	
	@Test(timeout=100)
	public void inValidPalindrome()
	{
		Assert.assertFalse("Correct", Palindrome.isPalindrome_using_stringBuffer("ABC"));
	}
	
	@Ignore
	public void singleCharacterPalindrome()
	{
		Assert.assertFalse("Correct", Palindrome.isPalindrome_using_stringBuffer("ABC"));
	}
	
	@Test(expected=NullPointerException.class)
	public void validNumberPalindrome()
	{
		throw new NullPointerException();
	}
	
	public void paramerterizedPalindromeTest()
	{
		
	}
}
