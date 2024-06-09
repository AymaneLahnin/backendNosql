package org.examnosql.backendlib.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

import java.util.List;

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String isbn;
    private String title;

    private int nmbCopie;

    private List<Author> authors;

    // Constructors, getters and setters
    public Book() {
    }

    public Book(String isbn, String title, List<Author> authors,int nmbCopie) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.nmbCopie=nmbCopie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNmbCopie() {
        return nmbCopie;
    }

    public void setNmbCopie(int nmbCopie) {
        this.nmbCopie = nmbCopie;
    }
}
