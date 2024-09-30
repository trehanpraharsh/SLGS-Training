package shopcart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProductCartTest {

	static ArrayList<Product> items;
	
	@BeforeAll
	public static void callBeforeAll() {
		items = new ArrayList<Product>();
	}
	
	public void callBefore() {
		items.add(new Product("Mobile", 65000.00));
		items.add(new Product("TV", 155000.00));
	}
	
	@Test
	void testAddItem() {
//		fail("Not yet implemented");
		
	}

	@Test
	void testGetItemsCount() {
//		fail("Not yet implemented");
	}

}
