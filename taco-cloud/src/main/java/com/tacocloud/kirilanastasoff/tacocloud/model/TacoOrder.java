package com.tacocloud.kirilanastasoff.tacocloud.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Data
public class TacoOrder {
	@jakarta.validation.constraints.NotBlank(message = "Delivery name is required")
	private String deliveryName;
	@jakarta.validation.constraints.NotBlank(message = "Street is required")
	private String deliveryStreet;
	@jakarta.validation.constraints.NotBlank(message = "City is required")
	private String deliveryCity;
	@jakarta.validation.constraints.NotBlank(message = "State is required")
	private String deliveryState;
	@jakarta.validation.constraints.NotBlank(message = "Zip code is required")
	private String deliveryZip;
	@CreditCardNumber(message = "Not a valid credit card number")
	private String ccNumber;
	@jakarta.validation.constraints.Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
	private String ccExpiration;
	@jakarta.validation.constraints.Digits(integer = 3, fraction = 0, message = "Invalid CVV")
	private String ccCVV;
	
	private List<Taco> tacos = new ArrayList<>();

	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}

	public TacoOrder() {
		super();
	}

	public TacoOrder(String deliveryName, String deliveryStreet, String deliveryCity, String deliveryState,
			String deliveryZip, String ccNumber, String ccExpiration, String ccCVV, List<Taco> tacos) {
		super();
		this.deliveryName = deliveryName;
		this.deliveryStreet = deliveryStreet;
		this.deliveryCity = deliveryCity;
		this.deliveryState = deliveryState;
		this.deliveryZip = deliveryZip;
		this.ccNumber = ccNumber;
		this.ccExpiration = ccExpiration;
		this.ccCVV = ccCVV;
		this.tacos = tacos;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public void setDeliveryStreet(String deliveryStreet) {
		this.deliveryStreet = deliveryStreet;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getDeliveryZip() {
		return deliveryZip;
	}

	public void setDeliveryZip(String deliveryZip) {
		this.deliveryZip = deliveryZip;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}

	public List<Taco> getTacos() {
		return tacos;
	}

	public void setTacos(List<Taco> tacos) {
		this.tacos = tacos;
	}

}
