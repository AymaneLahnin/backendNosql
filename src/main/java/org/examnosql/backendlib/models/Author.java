package org.examnosql.backendlib.models;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissance;



    // Constructors, getters, and setters
    public Author() {
    }

    public Author(String nom, String prenom, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getdateNaissance() {
        return dateNaissance;
    }

    public void setdateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
