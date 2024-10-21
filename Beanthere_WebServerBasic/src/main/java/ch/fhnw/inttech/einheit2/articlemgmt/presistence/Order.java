package ch.fhnw.inttech.einheit2.articlemgmt.presistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Annotation zur Kennzeichnung der Klasse als JPA-Entity
@Table(name = "orders") // Annotation zur Angabe des Tabellennamens in der Datenbank
public class Order {
    @Id // Kennzeichnung des Primärschlüssels
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Automatische Generierung des Primärschlüssels
    private Integer id;
    private String itemName;
    private double price;
    private int quantity;

    // Getter und Setter für die ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter und Setter für den Artikelname
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter und Setter für den Preis
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter und Setter für die Menge
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
