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
<h2>Taxi service</h2>
<%--@elvariable id="currentUser" type="com.pirogsoft.taxiservice.model.user.User"--%>
You are logged in as <c:out value="${currentUser.surname} ${currentUser.lastname}"/>, <a
        href="${pageContext.request.contextPath}/logout">logout</a>.

<div id = "map" style = "width: 900px; height: 580px"></div>
<div>
    <%--@elvariable id="tripOrder" type="com.pirogsoft.taxiservice.model.tripOrder.TripOrder"--%>
    <form action="${pageContext.request.contextPath}/ordering" method="post">
        <div>
            <label>
                departureX:
                <input type="text" name="departureX" value="${tripOrder.departure.x}">
            </label>
        </div>
        <div>
            <label>
                departureY:
                <input type="text" name="departureY" value="${tripOrder.departure.y}">
            </label>
        </div>
        <div>
            <label>
                departureAddress:
                <input type="text" name="departureAddress" value="${tripOrder.departure.address}">
            </label>
        </div>
        <div>
            <label>
                destinationX:
                <input type="text" name="destinationX" value="${tripOrder.destination.x}">
            </label>
        </div>
        <div>
            <label>
                destinationY:
                <input type="text" name="destinationY" value="${tripOrder.destination.y}">
            </label>
        </div>
        <div>
            <label>
                destinationAddress:
                <input type="text" name="destinationAddress" value="${tripOrder.destination.address}">
            </label>
        </div>
        <div>category:</div>
        <div>
            <label>
                economy:
                <input type="radio" name="category" value="ECONOMY" ${tripOrder.category.name() == 'ECONOMY'?'checked':''}>
            </label>
        </div>
        <div>
            <label>
                business:
                <input type="radio" name="category" value="COMFORT" ${tripOrder.category.name() == 'COMFORT'?'checked':''}>
            </label>
        </div>
        <div>
            <label>
                premium:
                <input type="radio" name="category" value="BUSINESS" ${tripOrder.category.name() == 'BUSINESS'?'checked':''}>
            </label>
        </div>
        <div>
            <label>
                capacity:
                <input type="text" name="capacity" value="${tripOrder.capacity}">
            </label>
        </div>
        <button>Order</button>
        <%--@elvariable id="errors" type="java.util.List<String>"--%>
        <c:if test="${errors != null && not empty errors}">
            <div style="color: red">
                <c:forEach items="${errors}" var="error" >
                    <div><c:out value="${error}"/></div>
                </c:forEach>
            </div>
        </c:if>
    </form>
</div>

<script>
    // Creating map options
    const mapOptions = {
        center: [49.9873, 36.2666],
        zoom: 12
    };

    // Creating a map object
    const map = new L.map('map', mapOptions);

    // Creating a Layer object
    const layer = new L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');

    // Adding layer to the map
    map.addLayer(layer);
    // const markers = new L.marker()
    // map.addLayer(markers);

    // map.events.register('click', map, function handleMapClick(e) {
    //     var clickedLonLat = map.getLonLatFromViewPortPx(e.xy).transform(map.projection, map.displayProjection);
    //     console.log(clickedLonLat);
    // });
</script>

</body>
</html>