package ch.fhnw.inttech.einheit2.articlemgmt.presistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Annotation zur Kennzeichnung der Klasse als JPA-Entity
public class Article {
    @Id // Kennzeichnung des Primärschlüssels
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Automatische Generierung des Primärschlüssels
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Boolean deleted;

    // Standardkonstruktor
    public Article() {
        this.id = 0; // Initialisierung der ID mit 0
    }

    // Getter und Setter für die ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter und Setter für den Namen
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter und Setter für die Beschreibung
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter und Setter für den Preis
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter und Setter für das Deleted-Flag
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
