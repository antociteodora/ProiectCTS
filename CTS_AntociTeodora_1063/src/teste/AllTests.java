package teste;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestEveniment.class);
		suite.addTestSuite(TestInvitat.class);
		suite.addTestSuite(TestOrganizator.class);
		suite.addTestSuite(TestRezervare.class);
		//$JUnit-END$
		return suite;
	}

}
