package practise;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CheckoutCartItemsTest {

	CheckoutCartItems checkoutItemsObj;
	Map<String, Double> itemsSkuPriceMap;
	Map<String, Integer> itemQntyCartMap;
	
	@Before
	public void setUp(){
		//System.out.println("in setup"); 
		//TODO: check if there is a way setup and teardown are called only once in a test suite
		checkoutItemsObj = new CheckoutCartItems();
		populateItemPriceMap();
	}
	
	@Test
	public void calculateTotalForZeroItemInCart() {
		assertEquals(new Double(0.0), checkoutItemsObj.calculateCartTotal(itemQntyCartMap));
	}
	
	@Test
	public void calculateTotalForOneItemOneQuantityInCart() {
		itemQntyCartMap = new HashMap<>();
		itemQntyCartMap.put("A", 1);
		assertEquals(new Double(0.50), checkoutItemsObj.calculateCartTotal(itemQntyCartMap));
	}
	
	@Test
	public void calculateTotalForMultipleItemsSingleQuantityInCart() {
		itemQntyCartMap = new HashMap<>();
		itemQntyCartMap.put("A", 1);
		itemQntyCartMap.put("B", 1);
		itemQntyCartMap.put("C", 1);
		assertEquals(new Double(1.75), checkoutItemsObj.calculateCartTotal(itemQntyCartMap));
	}
	
	@Test
	public void calculateTotalForSingleItemTwoQuantityInCart() {
		itemQntyCartMap = new HashMap<>();
		itemQntyCartMap.put("A", 2);
		assertEquals(new Double(1.00), checkoutItemsObj.calculateCartTotal(itemQntyCartMap));
	}
	
	@Test
	public void calculateTotalFormultipleItemsVariedQuantityInCart() {
		itemQntyCartMap = new HashMap<>();
		itemQntyCartMap.put("D", 3);
		itemQntyCartMap.put("A", 1);
		itemQntyCartMap.put("B", 3);
		itemQntyCartMap.put("C", 2);
		assertEquals(new Double(5.50), checkoutItemsObj.calculateCartTotal(itemQntyCartMap));
	}
	
	@Test
	public void calculateTotalForSingleItemWithDiscountInCart() {
		itemQntyCartMap = new HashMap<>();
		itemQntyCartMap.put("A", 3);
		assertEquals(new Double(1.30), checkoutItemsObj.calculateCartTotal(itemQntyCartMap));
	}
	
	@Test
	public void calculateTotalForMultipleItemsSomeDiscounted() {
		itemQntyCartMap = new HashMap<>();
		itemQntyCartMap.put("A", 3);
		itemQntyCartMap.put("C", 2);
		itemQntyCartMap.put("B", 4);
		assertEquals(new Double(4.30), checkoutItemsObj.calculateCartTotal(itemQntyCartMap));
	}
	
	@After
	public void tearDown() {
		//System.out.println("in teardown");
		checkoutItemsObj = null;
		
	}
	
	private void populateItemPriceMap() {
		itemsSkuPriceMap = new HashMap<>();
		//price stored in dollars
		itemsSkuPriceMap.put("A", new Double(0.5));
		itemsSkuPriceMap.put("B", new Double(0.25));
		itemsSkuPriceMap.put("C", new Double(1.0));
		itemsSkuPriceMap.put("D", new Double(0.75));
	}
	
}

