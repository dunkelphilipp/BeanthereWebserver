package ch.fhnw.inttech.einheit2;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.fhnw.inttech.einheit2.articlemgmt.presistence.Article;
import ch.fhnw.inttech.einheit2.articlemgmt.presistence.ArticleRepository;

@SpringBootApplication(scanBasePackages = {"ch.fhnw.inttech.einheit2", "business"}) 
// Konfiguration der Spring Boot Anwendung
public class Application {

	@Autowired
	private ArticleRepository articleRepository; // Automatisches Einfügen des ArticleRepository

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args); // Startet die Spring Boot Anwendung
	}

	@PostConstruct // Methode, die nach der Konstruktion des Beans aufgerufen wird
	public void createTestData() {
		// Erstellen und Speichern von Testdaten für Artikel

		Article e = new Article();
		e.setName("Espresso");
		e.setDescription("Kaffee");
		e.setPrice(4.00);
		e.setDeleted(false);
		articleRepository.save(e); // Speichert den Artikel im Repository

		Article c = new Article();
		c.setName("Cappucino");
		c.setDescription("Kaffee");
		c.setPrice(5.50);
		c.setDeleted(false);
		articleRepository.save(c);

		Article a = new Article();
		a.setName("Americano");
		a.setDescription("Kaffee");
		a.setPrice(5.00);
		a.setDeleted(false);
		articleRepository.save(a);

		Article l = new Article();
		l.setName("Latte Macciato");
		l.setDescription("Kaffee");
		l.setPrice(5.50);
		l.setDeleted(false);
		articleRepository.save(l);

		Article f = new Article();
		f.setName("Flat White");
		f.setDescription("Kaffee");
		f.setPrice(5.50);
		f.setDeleted(false);
		articleRepository.save(f);

		Article k = new Article();
		k.setName("Käsekuchen");
		k.setDescription("Kuchen");
		k.setPrice(5.50);
		k.setDeleted(false);
		articleRepository.save(k);

		Article s = new Article();
		s.setName("Schokoladenkuchen");
		s.setDescription("Kuchen");
		s.setPrice(6.00);
		s.setDeleted(false);
		articleRepository.save(s);

		Article z = new Article();
		z.setName("Zitronenkuchen");
		z.setDescription("Kuchen");
		z.setPrice(6.00);
		z.setDeleted(false);
		articleRepository.save(z);

		Article r = new Article();
		r.setName("Rüeblikuchen");
		r.setDescription("Kuchen");
		r.setPrice(6.50);
		r.setDeleted(false);
		articleRepository.save(r);

		Article ap = new Article();
		ap.setName("Apfelkuchen");
		ap.setDescription("Kuchen");
		ap.setPrice(5.50);
		ap.setDeleted(false);
		articleRepository.save(ap);

		Article lk = new Article();
		lk.setName("Limettenkuchen");
		lk.setDescription("Kuchen");
		lk.setPrice(5.50);
		lk.setDeleted(false);
		articleRepository.save(lk);
	}
}
