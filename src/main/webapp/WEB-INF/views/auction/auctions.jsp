<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../up.jsp" />
<table class="table">
    <thead>
    <tr>
        <th scope="col">Photo</th>
        <th scope="col">Mark</th>
        <th scope="col">Model</th>
        <th scope="col">Year</th>
        <th scope="col">Price</th>
        <th scope="col">User</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${auctions}" var="auctions">
        <tr>
            <th scope="row">SooN</th>
            <td>${auctions.mark}</td>
            <td>${auctions.model}</td>
            <td>${auctions.year}</td>
            <td>${auctions.price}</td>
          <td>  <a class="btn btn-success" href="/showuser?id=${auctions.user.id}" role="button">${auctions.user.name}</a></td>

        </tr>

    </c:forEach>


    </tbody>
</table>
<jsp:include page="../down.jsp" />



