function formvalidation() {
	var proId = document.getElementById("proId").value;
	var proName = document.getElementById("proName").value;
	var proPrice = document.getElementById("proPrice").value
	var proBrand = document.getElementById("proBrand").value;
	var proMadeIn = document.getElementById("proMadein").value

	if (proId.trim() === "" || proName.trim() === "" || proBrand.trim() === "" ||
		proMadeIn.trim() === "" || proPrice.trim() === "") {
		alert("All fields must be filled out");
		return false;
	}
	if (parseFloat(proPrice) < 0) {
		alert("pro price must be greatar than 0");
		return false;
	}
	if (proName.length > 50 || proBrand.length > 50) {
		alert("name or brand character must be less then 50");
		return false;
	}
	//get the mfg & exp dates
	var mfgdate = document.getElementById("MfgDate").value;
	var expiry = document.getElementById("Expiry").value;

	//convert into date format
	var m = new Date(mfgdate);
	var v = new Date(expiry);

	//check the validiation of dates
	if (m > v) {
		alert("manufacturing date cannot be greater than expiry date");
		return false;
	}
	return true;
}