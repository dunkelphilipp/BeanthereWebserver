package ch.fhnw.inttech.einheit2.articlemgmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ch.fhnw.inttech.einheit2.articlemgmt.presistence.Order;
import ch.fhnw.inttech.einheit2.articlemgmt.presistence.OrderRepository;

import java.util.List;

@RestController // Annotation zur Kennzeichnung der Klasse als REST-Controller
public class OrderController {

    @Autowired // Automatische Einfügung des OrderRepository
    private OrderRepository orderRepository;

    // Endpoint zum Erstellen einer neuen Bestellung
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order); // Speichern und Rückgabe der neuen Bestellung
    }

    // Endpoint zum Abrufen aller Bestellungen
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderRepository.findAll(); // Rückgabe der Liste aller Bestellungen
    }
}
