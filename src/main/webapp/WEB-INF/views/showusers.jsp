<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Show users</title>

</head>
<body>
<h1>Users</h1>
<div class="container">
    <div class="row">
         <div class="col"
    <%@ include file="left.jsp" %>
</div>
<div class="col">
    <table class="table table-striped">
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Name</th>
            <th>Surname</th>
            <th>E-mail</th>
        </tr>
        <c:forEach items="${users}" var="users">
            <tr>
                <td>${users.username}</td>
                <td>${users.password}</td>
                <td>${users.name}</td>
                <td>${users.surname}</td>
                <td>${users.email}</td>
                <td>
                    <form action="/deleteUser" method="post" onclick="return confirm('Are you sure you want to delete user?');">
                        <input hidden name="id" value="${users.id}">
                        <button>
                            <i class="fas fa-trash"></i>
                        </button>
                    </form>
                    <form action="/editUser" method="post" >
                        <input hidden name="id" value="${users.id}">
                        <button>
                            <i class="fas fa-cog"></i>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>