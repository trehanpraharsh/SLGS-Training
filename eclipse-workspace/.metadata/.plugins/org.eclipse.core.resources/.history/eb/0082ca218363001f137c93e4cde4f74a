package shopcart;


 
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTestDemo {
	@Parameter(0)
	public int income;
	@Parameter(1)
	public int LWP;
	@Parameter(2)
	public int HRA;
	@Parameter(3)
	public int result;
	
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data= new Object[][] {
			{30,2,10,38},{60,4,30,82},{90,1,10,97}
		};
		return Arrays.asList(data);
	}
	
	
	class MyClass{
		public int multiply(int a,int b,int c) {
			return a+c-((a/30)*b);
		}
	}

	@Test
	@Timeout(3)
	public void testMultipleValues() {
		MyClass cls= new MyClass();
		try {
			Thread.sleep(5000);
			assertEquals(result, cls.multiply(income, LWP, HRA));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}