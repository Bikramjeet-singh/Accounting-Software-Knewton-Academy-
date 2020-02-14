package com.knewton.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.knewton.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item,Integer>{

	List<Item> findByCategoryId(int categoryId);

	Item findByItemid(int itemId);

	

	
}