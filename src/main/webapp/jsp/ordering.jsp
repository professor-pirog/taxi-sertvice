<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Taxi Service</title>
</head>
<body>
<h2>Taxi service</h2>
<%--@elvariable id="user" type="com.pirogsoft.taxiservice.model.User"--%>
You are logged in as <c:out value="${user.surname} ${user.lastname}"/>, <a
        href="${pageContext.request.contextPath}/logout">logout</a>.
</body>
</html>