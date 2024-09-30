package shopcart;

import java.util.ArrayList;

public class ProductCart {
	
	ArrayList<Product> items;
	
	public ProductCart() {
		items = new ArrayList<Product>();
	}
	
	public void addItem(Product product) {
		items.add(product);
	}
	
	public int getItemsCount() {
		return items.size();
		
	}

	public void deleteItems(Product name) throws CustomError {
		if (items.contains(name)) {
			items.remove(name);			
		} else {
			throw new CustomError("Item doesn't exist!");			
		}
		
		
	}
	
}
