package org.example.exercicioapilivros.repositories;

import org.example.exercicioapilivros.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BooksRepository extends JpaRepository<Book, UUID> {
}
