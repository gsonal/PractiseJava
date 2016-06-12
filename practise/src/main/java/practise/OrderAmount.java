package practise;

import org.apache.commons.lang3.text.WordUtils;

public class OrderAmount {

	public static String getAmountInText(Double d) {
		System.out.println("Original Amt: " + d);
		Integer intVal = roundOrderAmountToNearestInteger(d);
		System.out.println("Rounded off value : " + intVal);
		
		String retVal = convertToText(intVal);
		if(retVal.isEmpty())
			retVal = "zero";
		return WordUtils.capitalizeFully(retVal.trim());
	}

	private static Integer roundOrderAmountToNearestInteger(Double amtInDecimals) {
		String[] orderAmtArr = (String.valueOf(amtInDecimals)).split("\\.");
		Integer intAmount = Integer.valueOf(orderAmtArr[0]);
		
		if(orderAmtArr.length > 1) {
			Double decimalPartOfOrigAmt = Double.valueOf("0." + orderAmtArr[1]);
			System.out.println("decimalPartOfOrigAmt: " + decimalPartOfOrigAmt);
			
			if(decimalPartOfOrigAmt >= 0.5) {
				intAmount += 1;
			}
		}
				
		return intAmount;
	}
	
	/*private static String convertToText(Integer intVal) {
		if(intVal < 1) {
			return "Zero";
		} else {
			return "One";
		}
	}*/

	///////////////// reference : http://www.rgagnon.com/javadetails/java-0426.html
	
	private static final String[] tensNames = {
	    "",
	    " ten",
	    " twenty",
	    " thirty",
	    " forty",
	    " fifty",
	    " sixty",
	    " seventy",
	    " eighty",
	    " ninety"
	  };

	  private static final String[] numNames = {
	    "",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine",
	    " ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"
	  };

	  private static String convertToText(int number) {
	    String soFar;

	    if (number % 100 < 20){
	      soFar = numNames[number % 100];
	      number /= 100;
	    }
	    else {
	      soFar = numNames[number % 10];
	      number /= 10;

	      soFar = tensNames[number % 10] + soFar;
	      number /= 10;
	    }
	    if (number == 0) return soFar;
	    return numNames[number] + " hundred" + soFar;
	  }
}
