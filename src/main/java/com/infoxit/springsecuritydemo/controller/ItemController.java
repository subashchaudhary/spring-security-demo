package com.infoxit.springsecuritydemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoxit.springsecuritydemo.entity.Item;
import com.infoxit.springsecuritydemo.service.ItemService;
import com.infoxit.springsecuritydemo.util.ItemDataValidate;
import com.infoxit.springsecuritydemo.util.Response;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping("/save")
	public Response saveItem(@RequestBody Item item) {

		Response response = new Response();

		Item saveItem = null;

		List<String> message = ItemDataValidate.validateDataForSave(item);

		if (message.size() > 0) {
			response.setData(message);
			response.setMessage("Validation failed!!!");
			response.setStatus(false);

			return response;
		}

		try {
			saveItem = itemService.saveItem(item);

			response.setMessage("Successfully save item.");
			response.setStatus(true);
			response.setData(saveItem);
		} catch (Exception e) {

			e.printStackTrace();

			response.setMessage("Oops, Something Went Wrong !!!");
			response.setStatus(false);
		}

		return response;

	}

	@PutMapping("/update")
	public Response updateItem(@RequestBody Item item) {

		Response response = new Response();

		Item updatedItem = null;
		// validate
		List<String> validationMessage = ItemDataValidate.validateDataForUpdate(item);
		if (validationMessage.size() > 0) {
			response.setMessage("Id must be present");
			response.setStatus(false);

			return response;
		}

		try {
			updatedItem = itemService.updateItem(item);

			response.setData(updatedItem);
			response.setMessage("Successfully update item");
			response.setStatus(true);

		} catch (Exception e) {
			response.setMessage("Oops, Something Went Wrong !!!");
			response.setStatus(false);
		}

		return response;

	}

	@GetMapping("/item/{id}")
	public Response getItem(@PathVariable Integer id) {
		Response response = new Response();

		try {
			Item item = itemService.getSingleItem(id);
			if (item != null) {
				response.setData(item);
				response.setMessage("Data Found successfully");
				response.setStatus(true);
			} else {
				response.setMessage("Data Not Found.");
				response.setStatus(false);
			}

		} catch (Exception e) {

			e.printStackTrace();

			response.setMessage("Data Not found");
			response.setStatus(false);
		}

		return response;
	}

	@GetMapping("/items")
	public Response getAllItems() {
		Response response = new Response();

		try {
			List<Item> items = itemService.getAllItems();
			if (items.size() > 0) {
				response.setData(items);
				response.setMessage("Item founds Succesfully");
				response.setStatus(true);
			} else {
				response.setMessage("No Items Present");
				response.setStatus(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public Response deleteItem(@PathVariable Integer id) {
		Response response = new Response();
		try {
			boolean result = itemService.deleteItem(id);
			if(result) {
				response.setMessage("Deleted item Successfully");
				response.setStatus(true);
			}else {
				response.setMessage("Could not deleted Data");
				response.setStatus(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
