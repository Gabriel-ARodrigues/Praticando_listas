package entities;

public class Products {
	private String name;
	private Double value;
	private Integer quantity;
	
	public Products(String name, double value, int quantity) {
		super();
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}
	
	public Products() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void addProducts(int quantity) {
		this.quantity = quantity;
	}
	
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}
	
	public double totalValue() {
		double sum = quantity * value;
		return sum;
	}

	public String toString() {
		return "Product Name: " + name + " Product Value: " + value + " Product Quantity: " + quantity;
	}

	
	
}
