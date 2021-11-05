package com.chris.pandc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chris.pandc.models.Category;
import com.chris.pandc.models.Product;
import com.chris.pandc.services.CategoryService;
import com.chris.pandc.services.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService pService;
	@Autowired
	private CategoryService cService;
	
	// Create Product
	@GetMapping("/product/create")
	public String add() {
		return "/Products/NewProduct.jsp";
	}
	
	@PostMapping("/createProduct")
	public String createProduct(@RequestParam("name")String name, @RequestParam("description")String description, @RequestParam("price")Double price ) {
		Product product = new Product(name, description, price);
		this.pService.createProduct(product);
		return "redirect:/product/create";
	}
	
	// Show one Product
	@GetMapping("/product/{id}")
	public String showProduct(Model viewModel, @PathVariable("id") Long id ) {
		Product productShow = this.pService.getOneProduct(id);
		viewModel.addAttribute("notInProd", this.cService.getSingleCategoryNotProduct(productShow));
		viewModel.addAttribute("product", productShow);
		return "/Products/ShowProduct.jsp";
	}
	
	@PostMapping("/addCategoryToProduct/{id}")
	public String addCategoryToProduct(@RequestParam("categories")Long id, @PathVariable("id") Long productId) {
		Product productToAddCategoryTo = this.pService.getOneProduct(productId);
		Category categoryToAddtoProduct = this.cService.getOneCategory(id);
		this.pService.addCategoryToProduct(productToAddCategoryTo, categoryToAddtoProduct);
		return "redirect:/product/{id}";
	}
	
	//Create category 
	@GetMapping("/category/create")
	public String addCategory() {
		return "/Categories/NewCategory.jsp";
	}
	
	
	@PostMapping("/createCategory")
	public String createCategory(@RequestParam("category")String name) {
		Category category = new Category(name);
		this.cService.createCategory(category);
		return "redirect:/category/create";
	}
	
	//Show one Category 
	@GetMapping("/category/{id}")
	public String showCategory(Model viewModel, @PathVariable("id") Long id) {
		Category CategoryShow = this.cService.getOneCategory(id);
		viewModel.addAttribute("categoryDetails", this.pService.getSingleProductNotCategory(CategoryShow));
		viewModel.addAttribute("category", CategoryShow);
		return "/Categories/ShowCategory.jsp";
	}
	
	@PostMapping("/addProductToCategory/{id}")
	public String addProductToCategory(@RequestParam("product")Long id, @PathVariable("id") Long categoryId) {
		Product productToAddCategoryTo = this.pService.getOneProduct(id);
		Category categoryToAddtoProduct = this.cService.getOneCategory(categoryId);
		this.cService.addProductToCateogry(productToAddCategoryTo, categoryToAddtoProduct);
		return "redirect:/category/{id}";
	}
}
