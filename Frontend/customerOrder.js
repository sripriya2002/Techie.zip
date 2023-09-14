document.addEventListener('DOMContentLoaded', function () {
    const productForm = document.getElementById('productForm');
    const productList = document.getElementById('productList');
    const cartList = document.getElementById('cartList');
    const shippingCostInput = document.getElementById('shippingCost');
    const totalOrderValueSpan = document.getElementById('totalOrderValue');
    let productIdCounter = 1;

    // Conversion rate: 1 USD = 75 INR (replace with the actual rate)
    const conversionRate = 75;

    function updateTotalOrderValue() {
        const productRows = cartList.querySelectorAll('tr');
        let total = 0;

        productRows.forEach((row) => {
            const priceINR = parseFloat(row.querySelector('[data-price]').getAttribute('data-price'));
            const quantity = parseInt(row.querySelector('[data-quantity]').getAttribute('data-quantity'));
            total += priceINR * quantity;
        });

        const shippingCostINR = parseFloat(shippingCostInput.value) || 0;
        const totalOrderValue = total + shippingCostINR;
        totalOrderValueSpan.textContent = totalOrderValue.toFixed(2) + ' INR'; // Display total in INR
    }

    productForm.addEventListener('submit', function (e) {
        e.preventDefault();

        const productId = document.getElementById('productId').value;
        const productName = document.getElementById('productName').value;
        const priceINR = parseFloat(document.getElementById('price').value);
        const quantityToAdd = parseInt(document.getElementById('quantityToAdd').value);

        // Create a new row for the product
        const newRow = document.createElement('tr');
        newRow.innerHTML = `
            <td>${productId}</td>
            <td>${productName}</td>
            <td data-price="${priceINR}">${priceINR.toFixed(2)} INR</td> <!-- Display price in INR -->
            <td data-quantity="${quantityToAdd}">${quantityToAdd}</td>
            <td><button class="addToCartBtn" data-product-id="${productIdCounter}">Add to Cart</button></td>
        `;

        // Add the new row to the table
        productList.appendChild(newRow);

        productIdCounter++;

        // Reset the form
        productForm.reset();
    });

    productList.addEventListener('click', function (e) {
        if (e.target.classList.contains('addToCartBtn')) {
            const productRow = e.target.closest('tr');
            const productId = productRow.children[0].textContent;
            const productName = productRow.children[1].textContent;
            const price = parseFloat(productRow.querySelector('[data-price]').getAttribute('data-price'));
            const quantityToAdd = parseInt(productRow.querySelector('[data-quantity]').getAttribute('data-quantity'));

            // Create a new row for the cart
            const newCartRow = document.createElement('tr');
            newCartRow.innerHTML = `
                <td>${productId}</td>
                <td>${productName}</td>
                <td data-price="${price}">$${price.toFixed(2)}</td>
                <td data-quantity="${quantityToAdd}">${quantityToAdd}</td>
                <td><button class="removeFromCartBtn" data-product-id="${productIdCounter}">Remove</button></td>
            `;

            // Add the new cart row to the table
            cartList.appendChild(newCartRow);

            productIdCounter++;

            // Update the total order value
            updateTotalOrderValue();
        }
    });

    cartList.addEventListener('click', function (e) {
        if (e.target.classList.contains('removeFromCartBtn')) {
            const productIdToRemove = e.target.getAttribute('data-product-id');
            const cartRowToRemove = e.target.closest('tr');
            cartRowToRemove.remove();

            // Update the total order value
            updateTotalOrderValue();
        }
    });

    shippingCostInput.addEventListener('input', function () {
        // Update the total order value when shipping cost changes
        updateTotalOrderValue();
    });
});


function quote() {
    const cartRows = cartList.querySelectorAll('tr');
    const isSuccess = cartRows.length > 0;

    if (isSuccess) {
        alert('Quote submitted successfully!');
    } else {
        alert('Quote submission failed. Please add products to your cart before submitting.');
    }
}