package practise.model;

/**
 * This class object will represent single Discount Offer row 
 */
public class Discount {

	private String itemOnDiscount;
	
	private int eligibleQuantity;
	
	private Double discountedPrice;

	public String getItemOnDiscount() {
		return itemOnDiscount;
	}

	public void setItemOnDiscount(String itemOnDiscount) {
		this.itemOnDiscount = itemOnDiscount;
	}

	public int getEligibleQuantity() {
		return eligibleQuantity;
	}

	public void setEligibleQuantity(int eligibleQuantity) {
		this.eligibleQuantity = eligibleQuantity;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	
}
