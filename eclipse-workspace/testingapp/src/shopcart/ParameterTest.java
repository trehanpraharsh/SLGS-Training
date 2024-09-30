package shopcart;

 
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {
	@Parameter(0)
	public int m1;
	@Parameter(1)
	public int m2;
	@Parameter(2)
	public int result;
	
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data= new Object[][] {
			{1,2,2},{5,3,15},{121,4,484}
		};
		return Arrays.asList(data);
	}
	
	
	class MyClass{
		public int multiply(int i,int j) {
			return i*j;
		}
	}

	@Test
	public void testMultipleValues() {
		MyClass cls= new MyClass();
		assertEquals(result, cls.multiply(m1, m2));
	}

}