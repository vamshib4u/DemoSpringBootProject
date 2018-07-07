package com.example.demo.entity;

public class ProductDetails {
	
	private String id;
	private String value;
	private String currency_code;
	private String title;
	
	/**
	 * 
	 */
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param value
	 * @param currency_code
	 * @param title
	 */
	public ProductDetails(String id, String value, String currency_code, String title) {
		super();
		this.id = id;
		this.value = value;
		this.currency_code = currency_code;
		this.title = title;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the currency_code
	 */
	public String getCurrency_code() {
		return currency_code;
	}
	/**
	 * @param currency_code the currency_code to set
	 */
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
