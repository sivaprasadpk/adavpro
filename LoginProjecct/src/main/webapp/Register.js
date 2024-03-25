function validateForm() {
    var name = document.getElementById("Name").value;
    var username = document.getElementById("UserName").value;
    var password = document.getElementById("Password").value;
    var confirm_password = document.getElementById("confrim").value;
    var email = document.getElementById("email").value;
    var mobile = document.getElementById("Mobile").value;

    // Check if any field is empty
    if (name.trim()==="" || username.trim() === "" || password.trim() === "" || confirm_password.trim() === "" || email.trim() === "" || mobile.trim() === "")
     {
        alert("All fields must be filled out");
        return false;
    }

    // Check if the password and confirm password match
    if (password !== confirm_password) {
        alert("Passwords do not match");
        return false;
    }

    // Validate email format
    var email_regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!email.match(email_regex)) {
        alert("Invalid email address");
        return false;
    }

    // Validate mobile number (assuming a simple format with 10 digits)
    var mobile_regex = /^\d{10}$/;
    if (!mobile.match(mobile_regex)) {
        alert("Invalid mobile number");
        return false;
    }

    // Additional validation logic can be added as needed

    // If all validations pass, return true to submit the form
    return true;
}
