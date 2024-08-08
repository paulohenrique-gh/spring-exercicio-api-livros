package org.example.exercicioapilivros.controllers;

import jakarta.validation.Valid;
import org.example.exercicioapilivros.dto.BookDto;
import org.example.exercicioapilivros.exceptions.BookNotFoundException;
import org.example.exercicioapilivros.models.Book;
import org.example.exercicioapilivros.repositories.BooksRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksRepository booksRepository;

    public BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID id) {
        Book book = booksRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(booksRepository.findAll());
    }

    @GetMapping("genres/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre) {
        return ResponseEntity.status(HttpStatus.OK).body(booksRepository.findByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return ResponseEntity.status(HttpStatus.CREATED).body(booksRepository.save(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable UUID id, @RequestBody @Valid BookDto bookDto) {
        Book bookToUpdate = booksRepository.findById(id).orElseThrow(BookNotFoundException::new);
        BeanUtils.copyProperties(bookDto, bookToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(booksRepository.save(bookToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBook(@PathVariable UUID id) {
        Book book = booksRepository.findById(id).orElseThrow(BookNotFoundException::new);
        booksRepository.delete(book);
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("message", "Book deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }
}
