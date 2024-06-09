package org.examnosql.backendlib.repositories;

import org.examnosql.backendlib.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    Book findByIsbn(String isbn);
}

