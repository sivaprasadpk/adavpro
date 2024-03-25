 function convertToInr()
 {
	 //read  a data from form and store in a variable
	 const dollar=document.getElementById("Dollar").value;
	 
	 //convert a dollar into inr
	 const inr=(parseFloat(dollar))*81.7;
	 
	 //set output  to inr in form 
	 document.getElementById("inr").value=inr.toFixed(2); 
	 
 }