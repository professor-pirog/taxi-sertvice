<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Taxi Service</title>
    <link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css"/>
    <script src="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js"></script>
</head>
<body>
<h2>Order</h2>
<div>
    <%--@elvariable id="tripOrder" type="com.pirogsoft.taxiservice.model.trip.TripOrder"--%>
    <%--@elvariable id="newTripInfo" type="com.pirogsoft.taxiservice.model.NewTripInfo"--%>
    You have successfully ordered a tripOrder
    <table>
        <tr>
            <td>Departure address:</td>
            <td>${tripOrder.departure.address}</td>
        </tr>
        <tr>
            <td>Destination address:</td>
            <td>${tripOrder.destination.address}</td>
        </tr>
        <tr>
            <td>Category:</td>
            <td>${tripOrder.category}</td>
        </tr>
        <tr>
            <td>Capacity</td>
            <td>${tripOrder.capacity}</td>
        </tr>
        <tr>
            <td>Order time</td>
            <td>${tripOrder.timestamp}</td>
        </tr>
        <tr>
            <td>Car</td>
            <td>${newTripInfo.car.carNameEng}</td>
        </tr>
        <tr>
            <td>Driver</td>
            <td>${newTripInfo.car.driver.surname} ${newTripInfo.car.driver.lastname}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${newTripInfo.price} ₴</td>
        </tr>
    </table>


</div>
</body>
</html>