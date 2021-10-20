package com.chris.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chris.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// This method retrieves all books from the database
	List<Book> findAll();
	// this method finds books with descriptions containing the search string
	List<Book> findByDescriptionContaining(String search);
	// this method counts how many titles contain a certain string
	List<Book> countByTitleContaining(String search);
	// This method deletes a book that starts with a specific title
	List<Book> deleteByTitleStartingWith(String search);
	
	
	
	
	void deleteById(Long id);

}
