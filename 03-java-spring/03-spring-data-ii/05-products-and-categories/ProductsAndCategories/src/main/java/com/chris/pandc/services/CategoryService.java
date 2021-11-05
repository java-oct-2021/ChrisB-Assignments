package com.chris.pandc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.pandc.models.Category;
import com.chris.pandc.models.Product;
import com.chris.pandc.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	public List<Category> getSingleCategoryNotProduct(Product product){
		return this.cRepo.findByProductsNotContains(product);
	}
	public Category getOneCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public void addProductToCateogry(Product product, Category category) {
		List<Product> existingProducts = category.getProducts();
		existingProducts.add(product);
		this.cRepo.save(category);
	}
	
}
