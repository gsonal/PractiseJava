package practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import practise.model.Discount;

public class CheckoutCartItems {

	Map<String, Double> itemsSkuPriceMap;
	
	//Approach1 object
	Map<String, Double> discountOffersMap;

	//Approach2 object
	Map<String, Discount> discountOffers;
	
	public CheckoutCartItems(){
		populateItemPriceMap();
		//populateAvailableDiscountOffersMap();
		populateDiscountOffersList();
	}
	
	public Double calculateCartTotal(Map<String, Integer> selectedItemQntyCart) {
		if(selectedItemQntyCart != null) {
			Double totalAmt = new Double(0.0);//cross check syntax for initialize double
			
			for(Entry<String, Integer> individualItem : selectedItemQntyCart.entrySet()) {
				Integer qnty = individualItem.getValue();
				String selectedItem = individualItem.getKey();
				
				//Approach 1: using map to store discounts
				/*if(checkIfSelectedItemIsEligibleForDiscount(selectedItem, qnty)) {
					totalAmt += getDiscountedPriceForItem(selectedItem, qnty);
				} else {
					totalAmt += (itemsSkuPriceMap.get(selectedItem) * qnty);
				}*/
				
				//Approach2: using discount model object to store discount details
				totalAmt += getDiscountedAmtIfItemEligible(selectedItem, qnty);
			
			}
			
			return totalAmt;
		}
		
		return new Double(0.0);
	}
	
	
	/************************************************* Approach 1 ************************************************************************/
	
	private boolean checkIfSelectedItemIsEligibleForDiscount(String cartItemSku, Integer purchasedQnty) {
		
		Set<String> discountedSKUentries = discountOffersMap.keySet();
		Iterator<String> discountKeysItr = discountedSKUentries.iterator();
		while(discountKeysItr.hasNext()) {
			String discountKeyEntry = discountKeysItr.next();
			String[] discountItemQntyArr = discountKeyEntry.split("_");
			if(discountItemQntyArr[1].equals(cartItemSku) && discountItemQntyArr[0].equals(String.valueOf(purchasedQnty))) {
				return true;
			}
		}
		
		return false;
	}
	
	private Double getDiscountedPriceForItem(String cartItemSku, Integer purchasedQnty) {
		StringBuffer keyForDiscount = new StringBuffer(String.valueOf(purchasedQnty)).append("_").append(cartItemSku);
		return discountOffersMap.get(keyForDiscount.toString());
	}
	
	//storing current discount offers in form of a map where key is combination of eligible quantity & Item SKU.
	private void populateAvailableDiscountOffersMap() {
		discountOffersMap = new HashMap<>();
		discountOffersMap.put("3_A", new Double(1.3));
	}
	
	/************************************************* Approach 1 ends ************************************************************************/
	
	
	/************************************************* Approach 2 starts ************************************************************************/
	
	private Double getDiscountedAmtIfItemEligible(String cartItemSku, Integer purchasedQnty) {
		Discount discountObj = discountOffers.get(cartItemSku);
		if(discountObj != null && discountObj.getEligibleQuantity() == purchasedQnty.intValue()) {
			return discountObj.getDiscountedPrice();
		} else {
			return (itemsSkuPriceMap.get(cartItemSku) * purchasedQnty);
		}
	}

	//storing discount offers in object
	private void populateDiscountOffersList() {
		discountOffers = new HashMap<>();
		Discount discountobj1 = new Discount();
		discountobj1.setItemOnDiscount("A");
		discountobj1.setEligibleQuantity(3);
		discountobj1.setDiscountedPrice(new Double(1.3));
		discountOffers.put("A", discountobj1);
	}
	
	/************************************************* Approach 2 ends ************************************************************************/
	
	
	private void populateItemPriceMap() {
		itemsSkuPriceMap = new HashMap<>();
		//price stored in dollars
		itemsSkuPriceMap.put("A", new Double(0.5));
		itemsSkuPriceMap.put("B", new Double(0.25));
		itemsSkuPriceMap.put("C", new Double(1.0));
		itemsSkuPriceMap.put("D", new Double(0.75));
	}
	
}
