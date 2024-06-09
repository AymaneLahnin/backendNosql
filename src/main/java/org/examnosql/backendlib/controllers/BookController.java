package org.examnosql.backendlib.controllers;

import org.examnosql.backendlib.models.Book;
import org.examnosql.backendlib.models.BookNode;
import org.examnosql.backendlib.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("book_id") String bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{book_id}")
    public ResponseEntity<Book> updateBook(@PathVariable("book_id") String bookId, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(bookId, book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> listBooks() {
        return ResponseEntity.ok(bookService.listBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> findBookByIsbn(@PathVariable("isbn") String isbn) {
        return ResponseEntity.ok(bookService.findBookByIsbn(isbn));
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<BookNode> findBookByTitle(@PathVariable("nom") String title) {
        return ResponseEntity.ok(bookService.findBookByTitle(title));
    }
}
