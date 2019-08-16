<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>Adding User</title>
</head>

<body>
<div class="container">
    <%--@elvariable id="UserDTO" type="it.danieltrosko.shop.dto.UserDTO"--%>
    <form:form method="POST"
               action="/user" modelAttribute="UserDTO">
        <form:input class="form-control" path="id" hidden="true"/>

        <div class="form-group">
            <form:label path="username">Username</form:label>
            <form:input class="form-control" path="username" required="true"/>
        </div>
        <div class="form-group">
            <form:label path="password">Password</form:label>
            <form:input class="form-control" path="password" required="true"/>
        </div>
        <div class="form-group">
            <form:label path="name">Name</form:label>
            <form:input class="form-control" path="name" required="true"/>
        </div>
        <div class="form-group">
            <form:label path="surname">Surname</form:label>
            <form:input class="form-control" path="surname" required="true"/>
        </div>
        <div class="form-group">
            <form:label path="email">Email</form:label>
            <form:input class="form-control" type="email" path="email" required="true"/>
        </div>

        <form:input class="form-control" path="addressId" hidden="true"/>
        <div class="form-group">
            <form:label path="street">Stret</form:label>
            <form:input class="form-control" path="street" required="true"/>
        </div>
        <div class="form-group">
            <form:label path="city">City</form:label>
            <form:input class="form-control" path="city" required="true"/>
        </div>
        <div class="form-group">
            <form:label path="houseNumber">House Number</form:label>
            <form:input class="form-control" path="houseNumber" required="true"/>
        </div>
        <div class="form-group">
            <form:label path="appartmentNumber">Apartment Number</form:label>
            <form:input class="form-control" path="appartmentNumber"/>
        </div>
        <form:button class="btn btn-primary" type="submit" value="Submit">Submit</form:button>
    </form:form>
</div>
</body>

</html>