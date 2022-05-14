// Name: Angelo Dela Cruz
// Student Id:501 096 839
package Assignment2;

import java.util.ArrayList;


public class Cart 
{
	// Initialized variables
	private ArrayList<CartItem> cartItems;
	
	public Cart()
	{
		this.cartItems = new ArrayList<CartItem>();
	}
	// Get cartItem list
	public ArrayList<CartItem> getCartItems()
	{
		return cartItems;
	}
	
	// Add a cartItem to the cart list
	public void addCartItem(Product product, String productOptions)
	{
		cartItems.add(new CartItem(product, productOptions));
	}
	// Remove a cartItem from the cart list
	public void removeCartItem(Product product)
	{
		for (CartItem cartItem: cartItems)
		{
			if (cartItem.getProduct() == product)
			{
				cartItems.remove(cartItem);
			}
		}
	}
	// Print all cart items
	public void print()
	{
		for (CartItem cartItem: cartItems)
		{
			cartItem.print();
		}
		
	}
	
}
