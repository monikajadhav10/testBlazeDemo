package resources;

import cucumber.api.java.After;

public class Browser extends Base {
@After
	public static void teardown()
	{
		
		driver.close();
	
		
	}
	
}
