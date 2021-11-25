package com.infoxit.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infoxit.springsecuritydemo.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	public Item findByItemName(String itemName);
}
