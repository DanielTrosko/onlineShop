<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../up.jsp"/>

    <tr>
        <th scope="col">Name</th>
        <th scope="col">Username</th>
        <th scope="col">Email</th>
    </tr>

    <tr>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.email}</td>
    </tr>




<table class="table table-hover">
<thead class="thead-dark">
<tr>
    <th scope="col">Foto</th>
    <th scope="col">Mark</th>
    <th scope="col">Model</th>
    <th scope="col">Year</th>
    <th scope="col">Price</th>
</tr>
</thead>
<tbody>
<c:forEach items="${userAuction}" var="userAuction">
    <tr>
        <th scope="row">SooN</th>
        <td>${userAuction.mark}</td>
        <td>${userAuction.model}</td>
        <td>${userAuction.year}</td>
        <td>${userAuction.price}</td>
    </tr>

</c:forEach>
</tbody>
</table>


<jsp:include page="../down.jsp"/>