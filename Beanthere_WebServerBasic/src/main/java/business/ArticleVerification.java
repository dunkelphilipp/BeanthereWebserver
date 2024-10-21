package business;

// Importieren der notwendigen Klassen
import ch.fhnw.inttech.einheit2.articlemgmt.presistence.Article;
import org.springframework.stereotype.Service;

@Service // Annotation zur Kennzeichnung der Klasse als Service-Komponente in Spring
public class ArticleVerification {

    // Methode zur Validierung eines Artikels
    public boolean validArticle(Article a) {
        // Überprüfung, ob der Artikel null ist
        if (a == null) {
            System.out.println("Validation failed: Article is null."); // Ausgabe einer Fehlermeldung
            return false; // Rückgabe false, wenn der Artikel null ist
        }
        // Überprüfung, ob der Artikelname null oder leer ist
        if (a.getName() == null || a.getName().trim().isEmpty()) {
            System.out.println("Validation failed: Article name is null or empty."); 
            // Ausgabe einer Fehlermeldung
            return false; // Rückgabe false, wenn der Artikelname null oder leer ist
        }
        // Überprüfung, ob der Artikelpreis kleiner als 7.00 ist
        if (a.getPrice() >= 7.00) {
            System.out.println("Validation failed: Article price is less than or equal to 7.00."); 
            // Ausgabe einer Fehlermeldung
            return false; // Rückgabe false, wenn der Artikelpreis kleiner als 7.00 ist
        }
        // Überprüfung, ob der Artikel als gelöscht markiert ist
        if (a.isDeleted()) {
            System.out.println("Validation failed: Article is marked as deleted."); 
            // Ausgabe einer Fehlermeldung
            return false; // Rückgabe false, wenn der Artikel als gelöscht markiert ist
        }
        return true; // Rückgabe true, wenn alle Validierungsbedingungen erfüllt sind
    }
}
