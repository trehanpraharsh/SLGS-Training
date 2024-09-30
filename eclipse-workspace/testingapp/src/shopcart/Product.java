package shopcart;

import java.util.Objects;

public class Product {
	
	private String ProductName;
	private Double ProductPrice;
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(Double productPrice) {
		ProductPrice = productPrice;
	}
	public Product(String productName, Double productPrice) {
		super();
		ProductName = productName;
		ProductPrice = productPrice;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [ProductName=" + ProductName + ", ProductPrice=" + ProductPrice + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ProductName, ProductPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(ProductName, other.ProductName) && Objects.equals(ProductPrice, other.ProductPrice);
	}
	
	
	
	

}
