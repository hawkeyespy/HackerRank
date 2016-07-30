package rc.ds.string;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class StringTestRunner {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(StringTestSuit.class);
		
		for(Failure failure:result.getFailures())
		{
			System.out.println(failure.toString());
		}
		
		System.out.println("Test sucessful: "+result.wasSuccessful());
	}

}
