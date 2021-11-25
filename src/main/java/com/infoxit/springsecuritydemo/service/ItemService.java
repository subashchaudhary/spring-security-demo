package com.infoxit.springsecuritydemo.service;

import java.util.List;

import com.infoxit.springsecuritydemo.entity.Item;

public interface ItemService {

	public Item saveItem(Item item) throws Exception;
	
	public Item updateItem(Item item) throws Exception;
	
	public List<Item> getAllItems() throws Exception;
	
	public Item getSingleItem(Integer id) throws Exception;
	
	public boolean deleteItem(Integer id) throws Exception;
	
	public Item getSigleItemByName(String itemName) throws Exception;
}
