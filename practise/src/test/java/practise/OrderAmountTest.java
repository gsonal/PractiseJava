package practise;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderAmountTest {

	@Test
	public void testForZeroOrderAmountInText() {
		assertEquals("Zero", OrderAmount.getAmountInText(0.0));
	}
	
	@Test
	public void testForOneDecimalOrderAmountInText() {
		assertEquals("Zero", OrderAmount.getAmountInText(0.1));
	}
	
	@Test
	public void testForTwoDecimalPlacesOrderAmountInText() {
		assertEquals("One", OrderAmount.getAmountInText(0.50));
	}
	
	@Test
	public void testForTwoDigitOrderAmountInText() {
		assertEquals("Ten", OrderAmount.getAmountInText(10.45));
	}
	
	@Test
	public void testForThreeDigitOrderAmountInText() {
		assertEquals("One Hundred Sixteen", OrderAmount.getAmountInText(115.75));
	}
	
	//@Test
	public void testForFourDigitOrderAmountInText() {
		assertEquals("Two Thousand Three Hundred Twenty Five", OrderAmount.getAmountInText(2324.68));
	}
		
	//null check needed ??? -- numeric values are defaulted to zeros...???
}
