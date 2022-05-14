// Name: Angelo Dela Cruz
// Student Id:501 096 839
package Assignment2;

import Assignment2.Product.Category;

public class Shoes extends Product{
	private String sizes;
	private String colours;
	
    //Stock related information (Inherited stock is total amount, each size/colour pairing has it's own stock)
    int brown6Stock = 0;
    int brown7Stock = 0;
    int brown8Stock = 0;
    int brown9Stock = 0;
    int brown10Stock = 0;
    int black6Stock = 0;
    int black7Stock = 0;
    int black8Stock = 0;
    int black9Stock = 0;
    int black10Stock = 0;
    //Shoes initialization
    public Shoes(String name, String id, double price, int brown6Stock, int brown7Stock, int brown8Stock, int brown9Stock, int brown10Stock, int black6Stock, int black7Stock, int black8Stock, int black9Stock, int black10Stock, String size,String colour)
    {
        super(name, id, price, 0, Product.Category.SHOES);
        this.sizes = size;
        this.colours = colour;
        this.brown6Stock = brown6Stock;
        this.brown7Stock = brown7Stock;
        this.brown8Stock = brown8Stock;
        this.brown9Stock = brown9Stock;
        this.brown10Stock = brown10Stock;
        this.black6Stock = black6Stock;
        this.black7Stock = black7Stock;
        this.black8Stock = black8Stock;
        this.black9Stock = black9Stock;
        this.black10Stock = black10Stock;
        int stock = brown6Stock + brown7Stock + brown8Stock + brown9Stock + brown10Stock + black6Stock + black7Stock + black8Stock + black9Stock + black10Stock;
        super.setStockCount(stock, colour);
    }
	// Overrides validOptions in the super class
	public boolean validOptions(String productOptions)
	{
		//Checks if the given productOptions is a valid size/Colour combination
		//Returns true if either of these, false otherwise
		if (productOptions.equals("6 Black") || productOptions.equals("7 Black") || productOptions.equals("8 Black") || productOptions.equals("9 Black") || productOptions.equals("10 Black") || productOptions.equals("6 Brown") || productOptions.equals("7 Brown") || productOptions.equals("8 Brown") || productOptions.equals("9 Brown") || productOptions.equals("10 Brown"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Overrides getStockCount() in the super class.
	public int getStockCount(String productOptions)
	{
		//Uses productOptions to check for the respective stock count, otherwise returns the total stock count.
		if (productOptions.contains("Brown"))
		{
			if (productOptions.contains("6"))
			{
				return brown6Stock;
			}
			else if (productOptions.contains("7"))
			{
				return brown7Stock;
			}
			else if (productOptions.contains("8"))
			{
				return brown8Stock;
			}
			else if (productOptions.contains("9"))
			{
				return brown9Stock;
			}
			else if (productOptions.contains("10"))
			{
				return brown10Stock;
			}
		}
		else if (productOptions.contains("Black"))
		{
			if (productOptions.contains("6"))
			{
				return black6Stock;
			}
			else if (productOptions.contains("7"))
			{
				return black7Stock;
			}
			else if (productOptions.contains("8"))
			{
				return black8Stock;
			}
			else if (productOptions.contains("9"))
			{
				return black9Stock;
			}
			else if (productOptions.contains("10"))
			{
				return black10Stock;
			}
		}
			return super.getStockCount(productOptions);
	}
	
	public void setStockCount(int stockCount, String productOptions)
	{
		//Sets the respective stock count based on product options
		//Uses productOptions to check for the respective stock count
		if (productOptions.contains("Brown"))
		{
			if (productOptions.contains("6"))
			{
				brown6Stock = stockCount;
			}
			else if (productOptions.contains("7"))
			{
				brown7Stock = stockCount;
			}
			else if (productOptions.contains("8"))
			{
				brown8Stock = stockCount;
			}
			else if (productOptions.contains("9"))
			{
				brown9Stock = stockCount;
			}
			else if (productOptions.contains("10"))
			{
				brown10Stock = stockCount;
			}
		}			
		else if (productOptions.contains("Black"))
		{
			if (productOptions.contains("6"))
			{
				black6Stock = stockCount;
			}
			else if (productOptions.contains("7"))
			{
				black7Stock = stockCount;
			}
			else if (productOptions.contains("8"))
			{
				black8Stock = stockCount;
			}
			else if (productOptions.contains("9"))
			{
				black9Stock = stockCount;
			}
			else if (productOptions.contains("10"))
			{
				black10Stock = stockCount;
			}
		}
	}
	
	public void reduceStockCount(String productOptions)
	{
		//Decrements the stock count specified in productOptions
		if (productOptions.contains("Brown"))
		{
			if (productOptions.contains("6"))
			{
				brown6Stock--;
			}
			else if (productOptions.contains("7"))
			{
				brown7Stock--;
			}
			else if (productOptions.contains("8"))
			{
				brown8Stock--;
			}
			else if (productOptions.contains("9"))
			{
				brown9Stock--;
			}
			else if (productOptions.contains("10"))
			{
				brown10Stock--;
			}
		}
		else if (productOptions.contains("Black"))
		{
			if (productOptions.contains("6"))
			{
				black6Stock--;
			}
			else if (productOptions.contains("7"))
			{
				black7Stock--;
			}
			else if (productOptions.contains("8"))
			{
				black8Stock--;
			}
			else if (productOptions.contains("9"))
			{
				black9Stock--;
			}
			else if (productOptions.contains("10"))
			{
				black10Stock--;
			}
		}
			super.reduceStockCount(productOptions);
	}
	
	//Print product information override
	public void print()
	{
		super.print();
		System.out.print("  Sizes: " + sizes + "  Colours: " + colours);
	}
	
	
}
