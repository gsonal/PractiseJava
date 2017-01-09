package com.practise.tddstreams;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class AddressWithOptionalFieldShould {
	AddressWithOptionalField addressWithOptionalField;
	
	@Before
	public void doSetup() {
		addressWithOptionalField = new AddressWithOptionalField("PwD Rd, Mahadevpure", "Bangalore", null);
	}
	
	@Test
	public void return_street_name() {
		assertThat(addressWithOptionalField.getStreet(), containsString("PwD Rd"));	
	}
	
	@Test
	public void return_city_name() {
		assertThat(addressWithOptionalField.getCity(), equalTo("Bangalore"));	
	}
	
	@Test
	public void return_not_null_postcode() {
		assertThat(addressWithOptionalField.getPostCode(), notNullValue());	
		assertEquals(new Integer(0), addressWithOptionalField.getPostCode().orElse(0));
		
	}
}
