// script.js

// Redirect to the import.html page when the "Import New Data" button is clicked
document.getElementById("importButton").addEventListener("click", function() {
    window.location.href = "import.html";
});

// Redirect to the newquote.html page when the "Create New Quote" button is clicked
document.getElementById("createQuoteButton").addEventListener("click", function() {
    window.location.href = "newquote.html";
});

// Handle the Invoice buttons based on their unique IDs
document.getElementById("button1").addEventListener("click", function() {
    window.location.href = "invoice-Divya.html";
});

document.getElementById("button2").addEventListener("click", function() {
    window.location.href = "invoice-Shripriya.html";
});

document.getElementById("button3").addEventListener("click", function() {
    window.location.href = "invoice-Dhanya.html";
});

// Add more event listeners for additional Invoice buttons if needed
