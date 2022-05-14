// Name: Angelo Dela Cruz
// Student Id:501 096 839
package Assignment2;

public class CartItem 
{
	// Initialized variables
	private Product product;
	private String productOptions;
	
	// Cart item method
	public CartItem(Product product, String productOptions)
	{
		this.product = product;
		this.productOptions = productOptions;
	}
	
	// Get product id
	public String getId()
	{
		return product.getId();
	}
	
	// Get product of cart item
	public Product getProduct()
	{
		return product;
	}
	
	// Get productOptions
	public String getOptions()
	{
		return productOptions;
	}
	
	// Overrides Print method
	public void print()
	{
		System.out.println("Id: " + product.getId() + " Name: " + product.getName());
		if (product.getCategory() == Product.Category.BOOKS) 
		{
			System.out.print("  Title: " + ((Book)product).getTitle() + " / Author: " + ((Book)product).getAuthor() + " / Options: " + productOptions);
		}
		else if (product.getCategory() == Product.Category.SHOES)
		{
			
			System.out.print("  Size/Colour: " + productOptions );
		}
		else{}
	}
}
