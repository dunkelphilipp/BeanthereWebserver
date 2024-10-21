package ch.fhnw.inttech.einheit2.articlemgmt.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface für das Artikel-Repository, das JpaRepository erweitert
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    // JpaRepository stellt grundlegende CRUD-Operationen zur Verfügung
    // Die generischen Typen <Article, Integer> spezifizieren die Entity-Klasse und den Typ des Primärschlüssels
}
