package com.practise.tddstreams;

import java.util.Optional;

public class AddressWithOptionalField {
	private String street;
	private String city;
	private Integer postCode;
	
	public AddressWithOptionalField(String street, String city, Integer postCode) {
		this.street = street;
		this.city = city;
		this.postCode = postCode;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public Optional<Integer> getPostCode() {
		return Optional.ofNullable(postCode);
	}

}
