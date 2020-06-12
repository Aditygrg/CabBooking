<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<script type="text/javascript">
function initGeolocation()
{
   if( navigator.geolocation )
   {
      // Call getCurrentPosition with success and failure callbacks
      navigator.geolocation.getCurrentPosition(success);
   }
}
function success(position)
{
    document.getElementById('longitude').value = position.coords.longitude;
    document.getElementById('latitude').value = position.coords.latitude
}
function showError(data){
	document.getElementById('errorname').innerHTML="Name should not be empty!!!";
	document.getElementById('errorname').style.color = "#ff0000";
}
</script>
<title>LogiNext</title>
</head>
<body onLoad="initGeolocation();">
   
  <h1>Cab Booking</h1>
  <hr>

  <div class="form">
    <form action="cabbook" method="POST" onsubmit="return validate()">
      <table>
        <tr>
          <td>Enter Your name</td>
          <td><input id="name" name="name"></td>
        </tr>
        <tr>
          <td>Enter Latitude</td>
          <td><input id="latitude" name = "latitude"></td>
        </tr>
        <tr>
          <td>Enter Longitude</td>
          <td><input id="longitude" name = "longitude"></td>
        </tr>
        <tr>
          <td><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </form>
  </div>
  <br><br><br>
  <div>  <c:if test="${not empty error}"><span id="errorname" style="color:red;"><c:out value="${error}"/></span></c:if>
  <c:if test="${empty error}"><span id="errorname"></span></c:if>
  </div>

</body>
</html>