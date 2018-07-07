package com.example.demo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Item item;
	
	private AvailableToPromiseNetwork available_to_promise_network;
	

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the available_to_promise_network
	 */
	public AvailableToPromiseNetwork getAvailable_to_promise_network() {
		return available_to_promise_network;
	}

	/**
	 * @param available_to_promise_network the available_to_promise_network to set
	 */
	public void setAvailable_to_promise_network(AvailableToPromiseNetwork available_to_promise_network) {
		this.available_to_promise_network = available_to_promise_network;
	}

	
	

}
