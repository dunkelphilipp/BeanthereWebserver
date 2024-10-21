document.addEventListener("DOMContentLoaded", function() {
    // Fetching articles from the server
    fetch('/api/articles')
        .then(response => response.json()) // Parsing the response as JSON
        .then(data => {
            const kaffeeTbody = document.getElementById('kaffee-tbody'); 
            // Reference to the coffee table body
            const kuchenTbody = document.getElementById('kuchen-tbody'); 
            // Reference to the cake table body

            data.forEach(article => { // Iterating through each article
                const row = document.createElement('tr'); // Creating a new table row
                row.innerHTML = `
                    <td>${article.name}</td>
                    <td>${article.price.toFixed(2)}</td>
                    <td>
                        <select>
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </td>
                    <td><button type="button" onclick="addToCart('${article.name}', ${article.price}, this)">Zum Warenkorb hinzufügen</button></td>
                `; // Populating the row with article details
                if (article.description && article.description.toLowerCase().includes('kuchen')) {
                    kuchenTbody.appendChild(row); // Adding row to cake table body
                } else {
                    kaffeeTbody.appendChild(row); // Adding row to coffee table body
                }
            });

            updateCartCount(); // Updating the cart count
        })
        .catch(error => console.error('Error fetching articles:', error)); // Handling fetch errors
});

function addToCart(name, price, button) {
    const row = button.parentNode.parentNode; // Getting the parent row of the button
    const quantitySelect = row.querySelector('select'); // Getting the quantity select element
    const quantity = parseInt(quantitySelect.value); // Parsing the selected quantity

    if (quantity > 0) { // Checking if the quantity is greater than 0
        const cartItem = {
            name: name,
            price: price,
            quantity: quantity
        };

        let cart = JSON.parse(localStorage.getItem('cart')) || []; 
        // Fetching the cart from localStorage or initializing an empty array
        const existingItemIndex = cart.findIndex(item => item.name === name); 
        // Checking if the item already exists in the cart

        if (existingItemIndex !== -1) {
            cart[existingItemIndex].quantity += quantity; 
            // Updating the quantity if the item exists
        } else {
            cart.push(cartItem); // Adding the item to the cart if it doesn't exist
        }

        localStorage.setItem('cart', JSON.stringify(cart)); 
        // Saving the updated cart to localStorage
        console.log(`Added ${quantity} x ${name} for ${price} CHF each to the cart.`);
        alert(`${quantity} x ${name} wurde(n) dem Warenkorb hinzugefügt.`);

        updateCartCount(); // Updating the cart count
    } else {
        console.log(`Please select a quantity greater than 0 for ${name}.`);
        alert(`Bitte wählen Sie eine Menge größer als 0.`);
    }
}

function updateCartCount() {
    const cart = JSON.parse(localStorage.getItem('cart')) || []; 
    // Fetching the cart from localStorage
    const cartCount = cart.reduce((total, item) => total + item.quantity, 0); 
    // Calculating the total quantity of items in the cart
    document.getElementById('cart-count').innerText = cartCount; 
    // Updating the cart count display
}
