// form.js

// Function to handle form submission
function handleSubmit(event) {
    event.preventDefault(); // Prevent the default form submission behavior
    
    // Get form input values
    const customerID = document.getElementById("customerID").value;
    const customerName = document.getElementById("customerName").value;
    const customerGST = document.getElementById("customerGST").value;
    const customerEmail = document.getElementById("customerEmail").value;
    const shippingAddress = document.getElementById("shippingAddress").value;
    const customerPincode = document.getElementById("customerPincode").value;
    const customerPhoneNumber = document.getElementById("customerPhoneNumber").value;
    const orderDate = document.getElementById("orderDate").value;

    // Validate Customer ID (only digits allowed)
    if (!/^\d+$/.test(customerID)) {
        alert("Customer ID must contain only digits.");
        return; // Prevent form submission if validation fails
    }

    // Validate Customer Name (only letters allowed)
    if (!/^[a-zA-Z]+$/.test(customerName)) {
        alert("Customer Name must contain only letters.");
        return; // Prevent form submission if validation fails
    }

    // Validate Customer GST (only digits allowed)
    if (!/^\d+$/.test(customerGST)) {
        alert("Customer GST must contain only digits.");
        return; // Prevent form submission if validation fails
    }

    // Validate Customer Email (must contain @gmail.com)
    if (!customerEmail.endsWith("@gmail.com")) {
        alert("Customer Email must be a Gmail address (e.g., example@gmail.com).");
        return; // Prevent form submission if validation fails
    }

    // Validate Shipping Address (non-empty)
    if (shippingAddress.trim() === "") {
        alert("Shipping Address cannot be empty.");
        return; // Prevent form submission if validation fails
    }

    // Validate Customer Pincode (only digits allowed)
    if (!/^\d+$/.test(customerPincode)) {
        alert("Customer Pincode must contain only digits.");
        return; // Prevent form submission if validation fails
    }

    // Validate Customer Phone Number (only digits allowed)
    if (!/^\d+$/.test(customerPhoneNumber)) {
        alert("Customer Phone Number must contain only digits.");
        return; // Prevent form submission if validation fails
    }

    // Validate Order Date (non-empty)
    if (orderDate.trim() === "") {
        alert("Order Date cannot be empty.");
        return; // Prevent form submission if validation fails
    }

    // Create an object with the form data
    const formData = {
        customerID,
        customerName,
        customerGST,
        customerEmail,
        shippingAddress,
        customerPincode,
        customerPhoneNumber,
        orderDate,
    };

    // You can send the formData to the server using fetch() or AJAX
    
    fetch("submit.php", {
        method: "POST",
        body: JSON.stringify(formData),
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => response.json())
    .then(data => {
        // Handle the response from the server
        console.log(data);
    })
    .catch(error => {
        // Handle any errors
        console.error(error);
    });
}

document.getElementById("quoteForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent the default form submission behavior

    if (areDetailsCorrect()) {
        // If all details are correct, show a success alert
        showSuccessAlert();
    } else {
        // Otherwise, let the default form submission behavior occur
        // You can also display an error message to the user here if needed
    }
});

    
// Add a submit event listener to the form
const form = document.querySelector("form");
form.addEventListener("submit", handleSubmit);

function newquote() {
    
    if (isSuccess) {
        alert('Quote submitted successfully!');
    } else {
        alert('Quote submission failed. Please add products to your cart before submitting.');
    }
}
