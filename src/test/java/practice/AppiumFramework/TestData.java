package practice.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataforEditField()
	{
		//here introducing only two set of data
		
		Object[][] obj= new Object[][]
		{
			{"hello"},{"@#$!%"}
		};
	
		return obj;
	}
	
	
}
