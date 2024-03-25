 function convertToReverse()
 {
	 //read  a data from form and store in a variable
	 const name=document.getElementById("string").value;
	 
	 //convert a dollar into inr
	 var na="";
	  for(i=name.length;i>=0;i--)
	  		na=na+name.charAt(i);
	 
	 //set output  to inr in form 
	 document.getElementById("Reverse").value=na
	 
 }