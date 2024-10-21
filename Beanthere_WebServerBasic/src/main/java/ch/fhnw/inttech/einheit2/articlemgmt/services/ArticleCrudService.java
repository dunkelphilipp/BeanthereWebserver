package ch.fhnw.inttech.einheit2.articlemgmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ch.fhnw.inttech.einheit2.articlemgmt.presistence.Article;
import ch.fhnw.inttech.einheit2.articlemgmt.presistence.ArticleRepository;

@RestController // Annotation zur Kennzeichnung der Klasse als REST-Controller
public class ArticleCrudService {

    @Autowired // Automatische Einfügung des ArticleRepository
    private ArticleRepository articleRepository;

    // Methode zum Abrufen eines Artikels nach ID
    @GetMapping(path = "/api/articles/{id}", produces = "application/json")
    public Article getArticle(@PathVariable int id) {
        return articleRepository.findById(id).orElse(null); 
        // Rückgabe des Artikels oder null, falls nicht gefunden
    }

    // Methode zum Löschen eines Artikels nach ID (markiert als gelöscht)
    @DeleteMapping(path = "/api/articles/{id}", produces = "application/json")
    public boolean deleteArticle(@PathVariable int id) {
        Article a = articleRepository.findById(id).orElse(null); // Suche nach Artikel
        if (a == null) return false; // Rückgabe false, falls Artikel nicht gefunden
        a.setDeleted(true); // Markierung als gelöscht
        articleRepository.save(a); // Speicherung des geänderten Artikels
        return true; // Rückgabe true bei erfolgreicher Operation
    }

    // Methode zum Aktualisieren eines Artikels nach ID
    @PutMapping(path = "/api/articles/{id}", produces = "application/json")
    public boolean updateArticle(@PathVariable int id, @RequestBody Article article) {
        Article a = articleRepository.findById(id).orElse(null); // Suche nach Artikel
        if (a == null) return false; // Rückgabe false, falls Artikel nicht gefunden

        // Aktualisierung der Artikelattribute
        a.setName(article.getName());
        a.setPrice(article.getPrice());
        a.setDescription(article.getDescription());

        articleRepository.save(a); // Speicherung des aktualisierten Artikels
        return true; // Rückgabe true bei erfolgreicher Operation
    }

    // Methode zum Erstellen eines neuen Artikels
    @PostMapping(path = "/api/articles/", produces = "application/json")
    public Article createArticle(@RequestBody Article article) {
        Article a = new Article(); // Erstellen eines neuen Artikelobjekts
        // Setzen der Attribute des neuen Artikels
        a.setName(article.getName());
        a.setPrice(article.getPrice());
        a.setDescription(article.getDescription());
        a.setDeleted(false); // Markierung als nicht gelöscht
        articleRepository.save(a); // Speicherung des neuen Artikels
        return a; // Rückgabe des gespeicherten Artikels
    }
}
