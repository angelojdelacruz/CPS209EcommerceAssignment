// Name: Angelo Dela Cruz
// Student Id:501 096 839
package Assignment2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import Assignment2.Book;
import Assignment2.Product;
import Assignment2.Shoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;


/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem
{
    public class CustomerNotFoundException extends RuntimeException
    {
    	public CustomerNotFoundException (String str)
    	{
    		super(str);
    	}
    }
    public class ProductNotFoundException extends RuntimeException
    {
    	public ProductNotFoundException (String str)
    	{
    		super(str);
    	}
    }
    public class OrderNotFoundException extends RuntimeException
    {
    	public OrderNotFoundException (String str)
    	{
    		super(str);
    	}
    }
    public class InvalidException extends RuntimeException
    {
    	public InvalidException (String str)
    	{
    		super(str);
    	}
    }
    public class NoStockException extends RuntimeException
    {
    	public NoStockException (String str)
    	{
    		super(str);
    	}
    }
	
	
	private Map<String, Object>  products = new TreeMap<String, Object>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    private Map <String, Integer> stats = new TreeMap<String, Integer>();
    // Method to access products in other classes
    public Map<String, Object> getProductsMap() {
    	return products;
    }
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    Exception errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
    	
    	// Create some products. Notice how generateProductId() method is used
/**
    	try
    	{
    		File file = new File("products.txt");
    		Scanner in = new Scanner(file);
    		Product.Category productCategory;
    		String productId;
    		while (in.hasNextLine())
    		{
    			productId = generateProductId();
    			String line = in.nextLine();
    			if (line.equals("COMPUTERS"))
    			{
    				productCategory = Product.Category.COMPUTERS;
    			}
    			else if (line.equals("FURNITURE"))
    			{
    				productCategory = Product.Category.FURNITURE;
    			}
    			else if (line.equals("CLOTHING"))
    			{
    				productCategory = Product.Category.CLOTHING;
    			}
    			else if (line.equals("BOOKS"))
    			{
    				productCategory = Product.Category.BOOKS;
    			}
    			else if (line.equals("SHOES"))
    			{
    				productCategory = Product.Category.SHOES;
    			}
    			else
    			{
    				productCategory = Product.Category.GENERAL;
    			}
    			String productName = in.nextLine();
    			String productPrice = in.nextLine();
    			
    			if (productCategory == Product.Category.BOOKS)
    			{
    				String productOptions = in.nextLine();
    				String[] productStocks = productOptions.split(" ");
    				String paperbackStock = productStocks[0];
    				String hardcoverStock = productStocks[1];
    				
    				productOptions = in.nextLine();
    				String[] bookInformation = productOptions.split(":");
    				String bookTitle = bookInformation[0];
    				String bookAuthor = bookInformation[1];
    				
    				products.put(productId, new Book(productName, productId, Double.parseDouble(productPrice), Integer.parseInt(paperbackStock), Integer.parseInt(hardcoverStock), bookTitle, bookAuthor));
    			}
    			
    			else if(productCategory == Product.Category.SHOES)
    			{
    				String productOptions = in.nextLine();
    				String[] productStocks = productOptions.split(" ");
    				String brown6Stock = productStocks[0];
    				String brown7Stock = productStocks[1];
    				String brown8Stock = productStocks[2];
    				String brown9Stock = productStocks[3];
    				String brown10Stock = productStocks[4];
    				String black6Stock = productStocks[5];
    				String black7Stock = productStocks[6];
    				String black8Stock = productStocks[7];
    				String black9Stock = productStocks[8];
    				String black10Stock = productStocks[9];
    				
    				productOptions = in.nextLine();
    				String[] shoeInformation = productOptions.split(":");
    				String shoeSizes = shoeInformation[0];
    				String shoeColours = shoeInformation[1];
    				
    				products.put(productId, new Shoes(productName, productId, Double.parseDouble(productPrice), Integer.parseInt(brown6Stock), Integer.parseInt(brown7Stock), Integer.parseInt(brown8Stock), Integer.parseInt(brown9Stock), Integer.parseInt(brown10Stock), Integer.parseInt(black6Stock), Integer.parseInt(black7Stock), Integer.parseInt(black8Stock), Integer.parseInt(black9Stock), Integer.parseInt(black10Stock), shoeSizes, shoeColours));
    			}
    			
    			else
    			{
    				String stock = in.nextLine();
    				String productOptions = in.nextLine();
    				products.put(productId, new Product(productName, productId, Double.parseDouble(productPrice), Integer.parseInt(stock), productCategory));
    			}
    			
    		}
    	}
    	catch (FileNotFoundException error)
    	{
    		error.printStackTrace();
    	}
*/

        String newProductId = generateProductId();
        products.put(newProductId, new Product("Acer Laptop", newProductId, 989.0, 99, Product.Category.COMPUTERS));
        newProductId = generateProductId();
        products.put(newProductId, new Product("Apex Desk", newProductId, 1378.0, 12, Product.Category.FURNITURE));
        newProductId = generateProductId();
        products.put(newProductId, new Book("Book", newProductId, 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney"));
        newProductId = generateProductId();
        products.put(newProductId, new Product("DadBod Jeans", newProductId, 24.0, 50, Product.Category.CLOTHING));
        newProductId = generateProductId();
        products.put(newProductId, new Product("Polo High Socks", newProductId, 5.0, 199, Product.Category.CLOTHING));
        newProductId = generateProductId();
        products.put(newProductId, new Product("Tightie Whities", newProductId, 15.0, 99, Product.Category.CLOTHING));
        newProductId = generateProductId();
        products.put(newProductId, new Book("Book", newProductId, 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast"));
        newProductId = generateProductId();
        products.put(newProductId, new Book("Book", newProductId, 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive"));
        newProductId = generateProductId();
        products.put(newProductId, new Book("Book", newProductId, 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney"));
        newProductId = generateProductId();
        products.put(newProductId, new Product("Rock Hammer", newProductId, 10.0, 22, Product.Category.GENERAL));
        newProductId = generateProductId();
        products.put(newProductId, new Shoes("Swanky Soles Shoes", newProductId, 40.0, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "6, 7, 8, 9, 10", "Brown, black"));

    	for (String prodId: products.keySet())
    	{
    		stats.put(prodId, 0);
    	}


    	
    	// Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    }
    
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public String getErrorMessage() throws Exception
    {
    	throw errMsg;
    }
    
    public Product getProduct(String productId)
    {
    	for (Map.Entry<String, Object> product: products.entrySet())
    	{
    		if (product.getKey().equals(productId))
    		{
    			return ((Product) product.getValue());
    		}
    	}
    	throw new ProductNotFoundException("Product Id not found");
		
    }
    
    public void printAllProducts()
    {
    	for (Map.Entry<String, Object> product: products.entrySet())
    	{
    		((Product) product.getValue()).print();
    	}
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
    	for (Map.Entry<String, Object> book: products.entrySet())
    	{
    		if (((Product) book.getValue()).getCategory() == Product.Category.BOOKS)
    		{
    			((Product) book.getValue()).print();
    		}
    	}
    }
    
    // Print all current orders
    public void printAllOrders()
    {
    	for (ProductOrder order: orders)
    	{
    		order.print();
    	}
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
    	for (ProductOrder order: shippedOrders)
    	{
    		order.print();
    	}
    }
    
    // Print all customers
    public void printCustomers()
    {
    	for (Customer customer: customers)
    	{
    		customer.print();
    	}
    }
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public boolean printOrderHistory(String customerId) throws CustomerNotFoundException
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	// ... code here
    	boolean customerFound = false;
    	Customer orderCustomer = null;
    	for (Customer customer: customers)
    	{
    		if (customer.getId().equals(customerId))
    		{
    			customerFound = true;
    			orderCustomer = customer;
    		}
    	}
    	if (!customerFound)
    	{
    		throw new CustomerNotFoundException("Customer Id not found");
    	}
    	
    	// Print current orders of this customer 
    	System.out.println("Current Orders of Customer " + customerId);
    	// enter code here
    	for (ProductOrder order: orders)
    	{
    		if (order.getCustomer().equals(orderCustomer))
    		{
    			order.print();
    		}
    	}
    	// Print shipped orders of this customer 
    	System.out.println("\nShipped Orders of Customer " + customerId);
    	//enter code here
    	for (ProductOrder order: shippedOrders)
    	{
    		if (order.getCustomer().equals(orderCustomer))
    		{
    			order.print();
    		}
    	}
    	
    	return true;
    }
    
    //flag
    public String orderProduct(String productId, String customerId, String productOptions) throws NoStockException, CustomerNotFoundException, ProductNotFoundException, InvalidException
    {

    	Object ordProduct = null;
    	Customer ordCustomer = null;
    	boolean idFound = false;
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object
    	for (Customer customer: customers)
    	{
    		if (customer.getId().equals(customerId))
    		{
    			ordCustomer = customer;
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
    		throw new CustomerNotFoundException("Customer Id not found");
    	}

    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 
    	idFound = false;
    	for (Map.Entry<String, Object> product: products.entrySet())
    	{
    		if (((Product) product.getValue()).getId().equals(productId))
    		{
    			ordProduct = product.getValue();
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
    		throw new ProductNotFoundException("Product Id not found");
    	}

    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
    	if (((Product)ordProduct).getCategory() == Product.Category.BOOKS)
    	{
    		if (((Book)ordProduct).validOptions(productOptions) == false)
    		{
    			throw new InvalidException("Book option is invalid or doesn't exist");
    		}
    	}
    	else
    	{
    		if (((Product)ordProduct).validOptions(productOptions) == false)
    		{
    			throw new InvalidException("Product option is invalid or doesn't exist");
    		}
    		
    	}
    	

    	
    	// Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null
    	if (((Product) ordProduct).getCategory() == Product.Category.BOOKS)
    	{
    		if (((Book)ordProduct).getStockCount(productOptions) == 0)
    		{
    			throw new NoStockException("Book option is out of stock");
    		}
    	}
    	else
    	{
    		if (((Product) ordProduct).getStockCount(productOptions) == 0)
    		{
    			throw new NoStockException("Product option is out of stock");
    		}
    		
    	}

    	
    	
      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string

    	String newOrderNumber = generateOrderNumber();
    	orders.add(new ProductOrder(newOrderNumber, (Product) ordProduct, ordCustomer, productOptions)) ;
    	if (productOptions != null)
    	{
    		((Book)ordProduct).reduceStockCount(productOptions);
    	}
    	else
    	{
    		((Product) ordProduct).reduceStockCount(productOptions);
    	}
    	// Increment stat after order
    	int productIdStat = stats.get(productId);
    	stats.replace(productId, productIdStat += 1);
    	
    	return "Order number #" + newOrderNumber;
    }
    
    //Method specifically for ordering shoes. Follows roughly the same process as orderProduct.
    public String orderShoes(String productId, String customerId, String productOptions) throws NoStockException, CustomerNotFoundException, ProductNotFoundException, InvalidException
    {
    	Object ordProduct = null;
    	Customer ordCustomer = null;
    	boolean idFound = false;
    	
    	// check if customer exists
    	for (Customer customer: customers)
    	{
    		if (customer.getId().equals(customerId))
    		{
    			ordCustomer = customer;
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
			throw new CustomerNotFoundException("Customer Id not found");
    	}
    	
    	// Check if product exists
    	idFound = false;
    	for (Map.Entry<String, Object> product: products.entrySet())
    	{
    		if (((Product) product.getValue()).getId().equals(productId))
    		{
    			ordProduct = product.getValue();
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
    		throw new ProductNotFoundException("Product Id not found");
    	}
    	
    	// Check if product options is valid(Valid options are ones with a combination of size and colour (I.E. "8 Black" or "10 Brown")
    	if (((Shoes)ordProduct).validOptions(productOptions) == false)
    	{
			throw new InvalidException("Product option is invalid or doesn't exist");
    	}
    	
    	// Check if specific product is in stock
    	if (((Shoes)ordProduct).getStockCount(productOptions) == 0)
    	{
			throw new NoStockException("Size " + productOptions + " versions of this product are out of stock.");
    	}
    	
    	// Creating product order
    	String newOrderNumber = generateOrderNumber();
    	orders.add(new ProductOrder(newOrderNumber, (Assignment2.Product) ordProduct, ordCustomer, productOptions)) ;
    	if (productOptions != null)
    	{
    		((Shoes)ordProduct).reduceStockCount(productOptions);
    	}
    	else
    	{
    		((Product) ordProduct).reduceStockCount(productOptions);
    	}
    	
    	// Increment stat after order
    	int productIdStat = stats.get(productId);
    	stats.replace(productId, productIdStat += 1);
    	
    	return "Order number #" + newOrderNumber;
    	
    }
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
    
    public boolean createCustomer(String name, String address) throws InvalidException
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter
    	if (name.equals("") || name.equals(null))
    	{
			throw new InvalidException("Name is invalid");
    	}
    	if (address.equals("") || address.equals(null))
    	{
			throw new InvalidException("Address is invalid");
    	}
    	// Create a Customer object and add to array list
    	customers.add(new Customer(generateCustomerId(), name, address));
    	return true;
    	
    }
    
    public ProductOrder shipOrder(String orderNumber) throws OrderNotFoundException
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
    	boolean orderFound = false;
    	ProductOrder orderToBeShipped = null;
    	for (ProductOrder order: orders)
    	{
    		if (order.getOrderNumber().equals(orderNumber))
    		{
    			orderFound = true;
    			orderToBeShipped = order;
    		}
    	}
    	if (!orderFound)
    	{
			throw new OrderNotFoundException("Order not found");
    	}
    	shippedOrders.add(orderToBeShipped);
    	orders.remove(orderToBeShipped);
    	return orderToBeShipped;
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public boolean cancelOrder(String orderNumber) throws OrderNotFoundException
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	boolean orderFound = false;
    	ProductOrder cancelledOrder = null;
    	for (ProductOrder order: orders) //Checks through orders for the matching order num
    	{
    		if (order.getOrderNumber().equals(orderNumber))
    		{
    			orderFound = true;
    			cancelledOrder = order;
    		}
    	}
    	if (!orderFound)
    	{
			throw new OrderNotFoundException("Order not found or already shipped.");
    	}
    	orders.remove(cancelledOrder);
    	return true;
    }
    
    // Print product stats
    public void printStats()
    {
    	stats = stats.entrySet().stream().sorted(Comparator.comparing(Entry<String, Integer>::getValue).reversed()).collect(LinkedHashMap<String, Integer>::new, (newMap, e) -> newMap.put(e.getKey(), e.getValue()),LinkedHashMap::putAll);
    	for (Map.Entry<String, Integer> statPair: stats.entrySet())
    	{
    		System.out.println("Product Id # " + statPair.getKey() + " Times ordered: " + statPair.getValue());
    	}
    }
    
    // Add item to customer cart
    public void addItemToCart(String productId, String customerId, String productOptions)
    {
    	Object cartProduct = null;
    	Customer cartCustomer = null;
    	boolean idFound = false;
    	// Find customer
    	for (Customer customer: customers)
    	{
    		if (customer.getId().equals(customerId))
    		{
    			cartCustomer = customer;
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
    		throw new CustomerNotFoundException("Customer Id not found");
    	}
    	// Find Product
    	idFound = false;
    	for (Map.Entry<String, Object> product: products.entrySet())
    	{
    		if (((Product) product.getValue()).getId().equals(productId))
    		{
    			cartProduct = product.getValue();
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
    		throw new ProductNotFoundException("Product Id not found");
    	}
    	// Check if productOptions are valid
    	if (((Product) cartProduct).getCategory() == Product.Category.BOOKS)
    	{
    		if (((Book)cartProduct).validOptions(productOptions) == false)
    		{
    			throw new InvalidException("Book option is invalid or doesn't exist");
    		}
    	}
    	else if (((Product) cartProduct).getCategory() == Product.Category.SHOES)
    	{
    		if (((Shoes)cartProduct).validOptions(productOptions) == false)
    		{
    			throw new InvalidException("Product option is invalid or doesn't exist");
    		}
    	}
    	else
    	{
    		productOptions = null;
    	}
    	
    	// Add product to customer's cart
    	cartCustomer.getCart().addCartItem((Product) cartProduct, productOptions);
    	System.out.println("Product successfully added");
    }
    
    public void printCart(String customerId)
    {
    	Customer cartCustomer = null;
    	boolean idFound = false;
    	// Find customer
    	for (Customer customer: customers)
    	{
    		if (customer.getId().equals(customerId))
    		{
    			cartCustomer = customer;
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
    		throw new CustomerNotFoundException("Customer Id not found");
    	}
    	
    	cartCustomer.getCart().print();
    }
    
    // Method to remove an item from a customer's cart
    public void removeCartItem(String productId, String customerId)
    {
    	Object cartProduct = null;
    	Customer cartCustomer = null;
    	boolean idFound = false;
    	// Find customer
    	for (Customer customer: customers)
    	{
    		if (customer.getId().equals(customerId))
    		{
    			cartCustomer = customer;
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
    		throw new CustomerNotFoundException("Customer Id not found");
    	}
    	// Find Product
    	idFound = false;
    	for (Map.Entry<String, Object> product: products.entrySet())
    	{
    		if (((Product) product.getValue()).getId().equals(productId))
    		{
    			cartProduct = product.getValue();
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
    		throw new ProductNotFoundException("Product Id not found");
    	}
    	
    	cartCustomer.getCart().removeCartItem((Product) cartProduct);
    	System.out.println("Item removed successfully");
    }
    
    // Method to order all items in a customer's cart
    public void orderCartItems(String customerId)
    {
    	Customer cartCustomer = null;
    	boolean idFound = false;
    	// Find customer
    	for (Customer customer: customers)
    	{
    		if (customer.getId().equals(customerId))
    		{
    			cartCustomer = customer;
    			idFound = true;
    		}
    	}
    	if (!idFound)
    	{
    		throw new CustomerNotFoundException("Customer Id not found");
    	}
    	
    	// Get cart from customer
    	ArrayList<CartItem> itemsToOrder = cartCustomer.getCart().getCartItems();
    	
    	// Order all items in cart
    	for (CartItem item: itemsToOrder)
    	{
    		String orderHeld = "";
    		if ((item.getProduct().getCategory() == Product.Category.SHOES))
    		{
    			orderHeld = orderShoes(item.getId(), customerId, item.getOptions());
    		}
    		else
    		{
    			orderHeld = orderProduct(item.getId(), customerId, item.getOptions());
    		}
    		System.out.println(orderHeld);
    	}
    	
    	for (CartItem item: itemsToOrder)
    	{
    		cartCustomer.getCart().removeCartItem(item.getProduct());
    	}
		System.out.println("Items ordered");
    	
    }
    
    
    
    // Sort products by increasing price
    public void sortByPrice()
    {
    	ArrayList<Product>  productsList = new ArrayList<Product>();
    	for (Map.Entry<String, Object> product: products.entrySet())
    	{
    		productsList.add((Product) product.getValue());
    	}
    	
    	productsList.sort(Comparator.comparing(Product::getPrice));
    	for (Product product: productsList)
    	{
    		product.print();
    	}
    }
    
    
    // Sort products alphabetically by product name
    public void sortByName()
    {
    	ArrayList<Product>  productsList = new ArrayList<Product>();
    	for (Map.Entry<String, Object> product: products.entrySet())
    	{
    		productsList.add((Product) product.getValue());
    	}
    	
  	  productsList.sort(Comparator.comparing(Product::getName));
  	  for (Product product: productsList)
  	  {
  		  	product.print();
  	  }
    }
    
        
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
  	  customers.sort(Comparator.comparing(Customer::getName));
    }
}
