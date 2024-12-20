package ru.jafix.studying.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jafix.studying.entities.Book;
import ru.jafix.studying.entities.Category;
import ru.jafix.studying.repositories.AuthorRepository;
import ru.jafix.studying.repositories.BookRepository;
import ru.jafix.studying.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    protected BookRepository bookRepository;
    @Autowired
    protected CategoryRepository categoryRepository;
    @Autowired
    protected AuthorRepository authorRepository;

    public Book getBookById(UUID id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isEmpty()) {
            throw new RuntimeException("Книги с таким ID не существует");
        }

        return book.get();
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book addBook(Book book) {
        if (book.getAuthors() != null && !book.getAuthors().isEmpty()) {

        }

        if (book.getCategory() != null && book.getCategory().getId() == null) {
            Category savedCategory = categoryRepository.save(book.getCategory());
            book.setCategory(savedCategory);
        }

        return bookRepository.save(book);
    }

    public Book editBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(UUID id) {
        bookRepository.deleteById(id);
    }

    public int getBooksCountByCategoryId(UUID categoryId) {
        return bookRepository.getBooksCountByCategoryId(categoryId);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
