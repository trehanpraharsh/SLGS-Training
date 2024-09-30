package shopcart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {
	
	ProductCart cart = new ProductCart();
	
	@BeforeEach
	public void beforeEach() {
		
		cart.addItem(new Product("soap", 10.0));
		cart.addItem(new Product("comb", 20.0));
		
	}
	
	@Test
	public void testCardAdd() {
		cart.addItem(new Product("towel", 30.0));
		assertEquals(3, cart.getItemsCount());
		
	}
	
	@Test
	public void testDeleteItem() {
		Product pro = new Product("towel", 30.0);
		cart.addItem(pro);
		try { 
		cart.deleteItems(pro);
		} catch(CustomError e) {
			System.out.println(e.getMessage());
		}
		assertEquals(2 , cart.getItemsCount());
	}

}
