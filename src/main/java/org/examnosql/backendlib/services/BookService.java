package org.examnosql.backendlib.services;

import org.examnosql.backendlib.models.Book;
import org.examnosql.backendlib.models.BookNode;
import org.examnosql.backendlib.repositories.BookNodeRepository;
import org.examnosql.backendlib.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookNodeRepository bookNodeRepository;


    public Book saveBook(Book book) {
        Book savedBook = bookRepository.save(book);
        BookNode bookNode = new BookNode();
        bookNode.setIsbn(savedBook.getIsbn());
        bookNode.setTitle(savedBook.getTitle());
        bookNode.setAuthors(savedBook.getAuthors());
        bookNodeRepository.save(bookNode);
        return savedBook;
    }


    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId);
        //bookNodeRepository.deleteById(Long.valueOf(bookId));
    }


    public Book updateBook(String bookId, Book book) {
        if(bookRepository.existsById(bookId)) {
            book.setId(bookId);
            Book updatedBook = bookRepository.save(book);
            BookNode bookNode = bookNodeRepository.findById(Long.valueOf(bookId)).orElse(null);
            if (bookNode != null) {
                bookNode.setIsbn(updatedBook.getIsbn());
                bookNode.setTitle(updatedBook.getTitle());
                bookNode.setAuthors(updatedBook.getAuthors());
                bookNodeRepository.save(bookNode);
            }
            return updatedBook;
        }
        return null;
    }

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public BookNode findBookByTitle(String title) {
        return bookNodeRepository.findByTitle(title);
    }
}
