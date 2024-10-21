package ch.fhnw.inttech.einheit2.articlemgmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.fhnw.inttech.einheit2.articlemgmt.presistence.Article;
import ch.fhnw.inttech.einheit2.articlemgmt.presistence.ArticleRepository;

import java.util.List;

@RestController // Annotation zur Kennzeichnung der Klasse als REST-Controller
public class ArticleController {

    @Autowired // Automatische Einfügung des ArticleRepository
    private ArticleRepository articleRepository;

    // Endpoint zum Abrufen aller Artikel
    @GetMapping("/api/articles")
    public List<Article> getAllArticles() {
        return articleRepository.findAll(); // Rückgabe der Liste aller Artikel
    }
}
