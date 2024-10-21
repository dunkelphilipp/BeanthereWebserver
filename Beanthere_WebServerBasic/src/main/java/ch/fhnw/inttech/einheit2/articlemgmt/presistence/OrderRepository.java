package ch.fhnw.inttech.einheit2.articlemgmt.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Annotation zur Kennzeichnung der Klasse als Repository-Komponente in Spring
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // JpaRepository stellt grundlegende CRUD-Operationen zur Verfügung
    // Die generischen Typen <Order, Integer> spezifizieren die Entity-Klasse und den Typ des Primärschlüssels
}
