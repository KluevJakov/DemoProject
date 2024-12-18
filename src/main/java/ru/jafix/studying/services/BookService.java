package ru.jafix.studying.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.jafix.studying.entities.Book;
import ru.jafix.studying.repositories.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    protected BookRepository bookRepository;

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

    public Book addBook(Book book) {
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
