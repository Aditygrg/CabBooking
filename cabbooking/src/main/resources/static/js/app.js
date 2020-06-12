function validate() {
	var namepattern = /^[a-zA-Z]*$/;
	var name = document.getElementById("name").value;
	if (name == '') {
		document.getElementById('errorname').innerHTML="Name should not be empty!!!";
		document.getElementById('errorname').style.color = "#ff0000";
		return false;
	} 
	if(!namepattern.test(name)){
		document.getElementById('errorname').innerHTML="Name should contain characters only!!!";
		document.getElementById('errorname').style.color = "#ff0000";
		return false;
	}
	var latValue = document.getElementById("latitude").value;
	var latPattern = /^(([1-8]?[0-9])(\.[0-9]{1,9})?|90(\.0{1,9})?)$/
	if (latValue == '') {
		document.getElementById('errorname').innerHTML="Latitude should not be empty!!!";
		document.getElementById('errorname').style.color = "#ff0000";
		return false;
	} 
	if(!latPattern.test(latValue)){
		document.getElementById('errorname').innerHTML="Invalid latitude!!!";
		document.getElementById('errorname').style.color = "#ff0000";
		return false;
	}
	var longValue = document.getElementById("longitude").value;
	var longPattern = /^((([1-9]?[0-9]|1[0-7][0-9])(\.[0-9]{1,9})?)|180(\.0{1,9})?)$/
	if (longValue == '') {
		document.getElementById('errorname').innerHTML="longitude should not be empty!!!";
		document.getElementById('errorname').style.color = "#ff0000";
		return false;
	} 
	if(!longPattern.test(longValue)){
		document.getElementById('errorname').innerHTML="invalid longitude!!!";
		document.getElementById('errorname').style.color = "#ff0000";
		return false;
	}
	return true;
}