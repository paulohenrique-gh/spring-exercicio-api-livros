package org.example.exercicioapilivros.repositories;

import org.example.exercicioapilivros.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BooksRepository extends JpaRepository<Book, UUID> {

    @Query("SELECT b FROM Book b WHERE b.genre ILIKE %:genre%")
    List<Book> findByGenre(@Param("genre") String genre);
}
