package com.chris.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chris.mvc.models.Book;
import com.chris.mvc.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
	// Delete Book
	public String deleteBook(Long id) {
		this.bookRepository.deleteById(id);
		return "Book has been deleted";
	}
}
//	@Autowired
//	private BookRepository bRepo;
//	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	// Create Book
//	public Book createBook(Book book) {
//		return this.bRepo.save(book);
//	}
//	
//	// Delete Book
//	public String deleteBook(Long id) {
//		this.bRepo.deleteById(id);
//		return "Book has been deleted";
//	}


