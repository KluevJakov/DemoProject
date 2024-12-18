package ru.jafix.studying.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jafix.studying.entities.Book;
import ru.jafix.studying.services.BookService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    protected BookService bookService;

    @GetMapping
    public List<Book> getBook(@RequestParam(value = "title", required = false) String title) {
        if (title != null) {
            return bookService.getBooksByTitle(title);
        }
        return bookService.getBooks();
    }

    @GetMapping("/count/{categoryId}")
    public int getBooksCountByCategoryId(@PathVariable("categoryId") UUID categoryId) {
        return bookService.getBooksCountByCategoryId(categoryId);
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable("bookId") UUID id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{bookId}")
    public Boolean deleteBook(@PathVariable("bookId") UUID id) {
        try {
            bookService.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping
    public Book editBook(@RequestBody Book book) {
        return bookService.editBook(book);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
