package com.chris.pandc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.pandc.models.Category;
import com.chris.pandc.models.Product;
import com.chris.pandc.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	// Get one product and category
	public List<Product> getSingleProductNotCategory(Category category){
		return this.pRepo.findByCategoriesNotContains(category);
	}
	// Get one
	public Product getOneProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	// Create one
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}

	public void addCategoryToProduct(Product product, Category category) {
		List<Category> existingCategories = product.getCategories();
		existingCategories.add(category);
		this.pRepo.save(product);
	}
	
}
