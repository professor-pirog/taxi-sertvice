<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Login</h2>
<div>
    <%--@elvariable id="user" type="com.pirogsoft.taxiservice.model.user.User"--%>
    <form action="registration" method="post">
        <div>
            <label>
                login:
                <input type="text" name="login" value="${user.login}">
            </label>
        </div>
        <div>
            <label>
                password:
                <input type="password" name="password">
            </label>
        </div>
        <div>
            <label>
                confirm password:
                <input type="password" name="confirmPassword">
            </label>
        </div>
        <div>
            <label>
                surname:
                <input type="text" name="surname" value="${user.surname}">
            </label>
        </div>
        <div>
            <label>
                lastname:
                <input type="text" name="lastname" value="${user.lastname}">
            </label>
        </div>
        <div>
            <label>
                phone:
                <input type="text" name="phone" value="${user.phone}">
            </label>
        </div>
        <div>
            <label>
                email:
                <input type="text" name="email" value="${user.email}">
            </label>
        </div>
        <button>Register</button>
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
</body>
</html>
