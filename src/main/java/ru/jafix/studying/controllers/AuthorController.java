package ru.jafix.studying.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jafix.studying.entities.Author;
import ru.jafix.studying.services.AuthorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    protected AuthorService authorService;

    @GetMapping
    public List<Author> getAuthor() {
        return authorService.getAuthors();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable("authorId") UUID id) {
        return authorService.getAuthorById(id);
    }

    @DeleteMapping("/{authorId}")
    public Boolean deleteAuthor(@PathVariable("authorId") UUID id) {
        try {
            authorService.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping
    public Author editAuthor(@RequestBody Author author) {
        return authorService.editAuthor(author);
    }

    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }
}
