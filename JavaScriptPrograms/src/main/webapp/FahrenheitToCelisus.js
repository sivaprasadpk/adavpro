function convertToCelisus()
{
	//read  a data from form and store in a variable
	 const name=document.getElementById("number").value;
	 
	 //convert a fahrenheit to celsius
	 const cel=(parseFloat(name-32))*5/9;
	 
	 //set output  to inr in form 
	 document.getElementById("output").value=cel.toFixed(2);
	 
}
