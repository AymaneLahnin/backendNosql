package org.examnosql.backendlib.Repository;

import org.examnosql.backendlib.models.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends Neo4jRepository<Book, Long> {
}
