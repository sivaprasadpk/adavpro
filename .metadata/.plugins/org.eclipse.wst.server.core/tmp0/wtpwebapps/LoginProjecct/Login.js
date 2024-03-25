
// Function for form validation
function loginValidation() {
    var username = document.getElementById("UserName").value;
    var password = document.getElementById("Password").value;

    if (username === "") {
        alert("Please enter your username");
        return false;
    }

    if (password === "") {
        alert("Please enter your password");
        return false;
    }

    // You can add more complex validation logic if needed

    return true;
}