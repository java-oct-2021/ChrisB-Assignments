package com.chris.pandc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chris.pandc.models.Category;
import com.chris.pandc.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findAll();
		
	List<Category> findByProductsNotContains(Product product);
}
