package ru.jafix.studying.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jafix.studying.entities.Author;
import ru.jafix.studying.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    protected AuthorRepository authorRepository;

    public Author getAuthorById(UUID id) {
        Optional<Author> author = authorRepository.findById(id);

        if (author.isEmpty()) {
            throw new RuntimeException("Автора с таким ID не существует");
        }

        return author.get();
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author editAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(UUID id) {
        authorRepository.deleteById(id);
    }
}
