package ru.jafix.studying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.jafix.studying.entities.Book;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query(value = "SELECT COUNT(b) FROM Book b WHERE b.category.id = :categoryId")
    int getBooksCountByCategoryId(@Param("categoryId") UUID categoryId);

    List<Book> findByTitle(String title);

    // Пример с нативным SQL
    //@Query(value = "SELECT COUNT(id) FROM books WHERE category_id = :categoryId", nativeQuery = true)
    //int getBooksCountByCategoryId(@Param("categoryId") UUID categoryId);
}
