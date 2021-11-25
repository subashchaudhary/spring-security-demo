package com.infoxit.springsecuritydemo.util;

import java.util.ArrayList;
import java.util.List;

import com.infoxit.springsecuritydemo.entity.Item;

public class ItemDataValidate {

	public static List<String> validateDataForSave(Item item) {

		List<String> validationMessages = new ArrayList<String>();

		String itemName = item.getItemName();
		
		Integer price = item.getPrice();
		
		if (itemName.equals("") || itemName == null) {

			validationMessages.add("Item name is empty. Please give some name.");
		}

		if(price == null) {
			validationMessages.add("Item price should not be empty");
		}
		return validationMessages;
	}

	public static List<String> validateDataForUpdate(Item item) {

		List<String> validationMessages = new ArrayList<String>();
		if (item.getId() == null) {
			validationMessages.add("Please provide id for update");
			
			return validationMessages;
		}
		String itemName = item.getItemName();
		Integer price = item.getPrice();

		if (itemName.equals("") || itemName == null) {

			validationMessages.add("Item name is empty. Please give some name.");
		}

		if(price == null) {
			validationMessages.add("Item price should not be empty");
		}
		return validationMessages;
	}
}
