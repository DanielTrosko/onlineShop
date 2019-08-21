<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Register</title>
</head>
<body>
<h1>Register</h1>



<div class="containter">
<%--@elvariable id="UserDTO" type="it.danieltrosko.shop.dto.UserDTO"--%>
<form:form method="POST" action="/user" modelAttribute="UserDTO">
        <form:input class="formControl" type="text" path="id" hidden="true"/>

    <div class="form-group">
        <form:label path="username">Username</form:label>
        <form:input class="formControl" type="text" required="required" path="username"/>
    </div>
    <div class="form-group">
        <form:label path="password">Password</form:label>
        <form:input class="formControl" type="password" required="required" path="password"/>
    </div>
    <div class="form-group">
        <form:label path="name">Name</form:label>
        <form:input class="formControl" type="text" required="required" path="name"/>
    </div>
    <div class="form-group">
        <form:label path="surname">Surname</form:label>
        <form:input class="formControl" type="text" required="required" path="surname"/>
    </div>
    <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input class="formControl" type="email" required="required" path="email"/>
    </div>
    <div class="form-group">
        <form:label path="city">City</form:label>
        <form:input class="formControl" type="text" required="required" path="city"/>
    </div>
    <div class="form-group">
        <form:label path="street">Street</form:label>
        <form:input class="formControl" type="text" required="required" path="street"/>
    </div>
    <div class="form-group">
        <form:label path="houseNumber">House Number</form:label>
        <form:input class="formControl" type="text" required="required" path="houseNumber"/>
    </div>
    <div class="form-group">
        <form:label path="appartmentNumber">Appartment Number</form:label>
        <form:input class="formControl" type="text" required="required" path="appartmentNumber"/>
    </div>
    <div class="form-group">
        <form:input class="formControl" type="text" path="enabled" hidden="true"/>
    </div>

    <form:button type="submit" class="btn btn-primary" value="Submit">Register</form:button>
</form:form>
</div>






<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>