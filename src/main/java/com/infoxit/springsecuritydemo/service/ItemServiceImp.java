package com.infoxit.springsecuritydemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoxit.springsecuritydemo.entity.Item;
import com.infoxit.springsecuritydemo.repository.ItemRepository;

@Service
public class ItemServiceImp implements ItemService {

	@Autowired
	ItemRepository itemRepo;

	@Override
	public Item saveItem(Item item) throws Exception {

		return itemRepo.save(item);

	}

	@Override
	public Item updateItem(Item item) throws Exception {

		return itemRepo.save(item);

	}

	@Override
	public List<Item> getAllItems() throws Exception {
		return itemRepo.findAll();

	}

	@Override
	public Item getSingleItem(Integer id) throws Exception {

		Optional<Item> item = itemRepo.findById(id);
		if (item.isPresent()) {
			return item.get();
		} else {
			return null;
		}

	}

	@Override
	public boolean deleteItem(Integer id) throws Exception {

		try {
			itemRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Item getSigleItemByName(String itemName) throws Exception {
		 
		return itemRepo.findByItemName(itemName);
		
		 
	}

}
