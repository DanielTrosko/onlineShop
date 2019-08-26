<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../up.jsp" />

<table class="table table-hover">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Username</th>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
        <th scope="col">E-mail</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${users}" var="users">
        <tr>
            <th scope="row">${users.id}</th>
            <td>${users.username}</td>
            <td>${users.name}</td>
            <td>${users.surname}</td>
            <td>${users.email}</td>
        </tr>

    </c:forEach>


    </tbody>
</table>

<jsp:include page="../down.jsp" />