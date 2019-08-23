<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="up.jsp" />
<table class="table table-bordered">
    <tbody>
    <c:forEach items="${auctions}" var="auctions">
        <tr>
            <th scope="row">SooN</th>
            <td>${auctions.mark}</td>
            <td>${auctions.model}</td>
            <td>${auctions.year}</td>
            <td>${auctions.price}</td>
        </tr>

    </c:forEach>

    </tbody>
</table>


<jsp:include page="down.jsp" />