document.addEventListener("DOMContentLoaded", function() {
    loadCart(); // Lädt den Warenkorb, sobald die Seite geladen ist
});

function loadCart() {
    let cart = JSON.parse(localStorage.getItem('cart')) || []; 
    // Ruft den Warenkorb aus dem Local Storage ab oder initialisiert ihn als leeres Array
    const cartItems = document.getElementById('cartItems'); 
    // Referenz auf das Element mit der ID 'cartItems'
    const totalAmountElement = document.getElementById('totalAmount'); 
    // Referenz auf das Element mit der ID 'totalAmount'
    cartItems.innerHTML = ''; // Leert den Inhalt des Warenkorb-Elements
    let totalAmount = 0; // Initialisiert den Gesamtbetrag

    cart.forEach(item => { // Iteriert über jedes Element im Warenkorb
        const totalItemPrice = item.price * item.quantity; 
        // Berechnet den Gesamtpreis für das jeweilige Element
        totalAmount += totalItemPrice; // Addiert den Gesamtpreis zum Gesamtbetrag

        const row = document.createElement('tr'); // Erstellt eine neue Tabellenzeile
        row.innerHTML = `
            <td>${item.name}</td>
            <td>${item.quantity}</td>
            <td>${totalItemPrice.toFixed(2)}</td>
        `; // Fügt HTML-Inhalt zur Tabellenzeile hinzu
        cartItems.appendChild(row); // Hängt die neue Zeile an das Warenkorb-Element an
    });

    totalAmountElement.textContent = totalAmount.toFixed(2); 
    // Setzt den Gesamtbetrag in das entsprechende Element
}

function submitOrder() {
    const agbCheck = document.getElementById('agbCheck').checked; 
    // Überprüft, ob die AGB akzeptiert wurden
    const tischnummer = document.getElementById('tischnummer').value.trim(); 
    // Holt die eingegebene Tischnummer und trimmt Leerzeichen

    if (!agbCheck) { // Prüft, ob die AGB nicht akzeptiert wurden
        alert('Bitte akzeptieren Sie die AGB.'); // Zeigt eine Warnmeldung an
        return; // Bricht die Funktion ab
    }

    if (tischnummer === '') { // Prüft, ob die Tischnummer leer ist
        alert('Bitte geben Sie Ihre Tischnummer ein.'); // Zeigt eine Warnmeldung an
        return; // Bricht die Funktion ab
    }

    let cart = JSON.parse(localStorage.getItem('cart')) || []; 
    // Ruft den Warenkorb aus dem Local Storage ab oder initialisiert ihn als leeres Array
    cart.forEach(item => { // Iteriert über jedes Element im Warenkorb
        let order = { // Erstellt ein Bestellobjekt
            itemName: item.name,
            price: item.price,
            quantity: item.quantity,
            tableNumber: tischnummer
        };
        
        console.log('Submitting order:', order);  // Debugging-Ausgabe der Bestellung

        $.ajax({
            type: 'POST',
            url: '/orders', // URL zum Senden der Bestellung
            data: JSON.stringify(order), // Wandelt das Bestellobjekt in einen JSON-String um
            contentType: 'application/json', // Setzt den Content-Type auf JSON
            success: function(response) { // Callback-Funktion bei erfolgreichem Senden
                console.log('Order submitted:', response); // Debugging-Ausgabe der Antwort
                localStorage.removeItem('cart'); // Entfernt den Warenkorb aus dem Local Storage
                loadCart(); // Lädt den Warenkorb neu
                window.location.href = 'bestellt.html'; // Leitet zur Bestätigungsseite weiter
            },
            error: function(error) { // Callback-Funktion bei Fehler
                console.error('Error submitting order:', error); // Debugging-Ausgabe des Fehlers
                alert('Fehler beim Aufgeben der Bestellung.'); // Zeigt eine Fehlermeldung an
            }
        });
    });
}
