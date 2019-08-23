

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="up.jsp" />
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
                <%--            <td>${auctions.user.name}</td>--%>
                <%--            <td>${auctions.user.name}</td>--%>
            <td>  <a class="btn btn-success" href="/showuser?id=${auctions.user.id}" role="button">${auctions.user.name}</a></td>

        </tr>

    </c:forEach>


    </tbody>
</table>
<jsp:include page="down.jsp" />







<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>

<%--<jsp:include page="up.jsp" />--%>
<%--<table class="table">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th scope="col">Photo</th>--%>
<%--        <th scope="col">Mark</th>--%>
<%--        <th scope="col">Model</th>--%>
<%--        <th scope="col">Year</th>--%>
<%--        <th scope="col">Price</th>--%>
<%--        <th scope="col">User</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--<c:forEach items="${auctions}" var="auctions">--%>
<%--    <tr>--%>
<%--        <th scope="row">SooN</th>--%>
<%--        <td>${auctions.mark}</td>--%>
<%--        <td>${auctions.model}</td>--%>
<%--        <td>${auctions.year}</td>--%>
<%--        <td>${auctions.price}</td>--%>
<%--        <td>${auctions.user.name}</td>--%>
<%--    </tr>--%>

<%--</c:forEach>--%>


<%--    </tbody>--%>
<%--</table>--%>

<%--<jsp:include page="down.jsp" />--%>

<%--&lt;%&ndash;<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>&ndash;%&gt;--%>
<%--&lt;%&ndash;<jsp:include page="up.jsp" />&ndash;%&gt;--%>
<%--&lt;%&ndash;<table class="table">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <thead>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="col">Photo</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="col">Mark</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="col">Model</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="col">Year</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="col">Price</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="col">User</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </thead>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <tbody>&ndash;%&gt;--%>

<%--&lt;%&ndash;    <c:forEach items="${auctions}" var="auctions">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th scope="row">SooN</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${auctions.mark}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${auctions.model}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${auctions.year}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${auctions.price}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${auctions.user.name}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>

<%--&lt;%&ndash;    </c:forEach>&ndash;%&gt;--%>


<%--&lt;%&ndash;    </tbody>&ndash;%&gt;--%>
<%--&lt;%&ndash;</table>&ndash;%&gt;--%>
<%--&lt;%&ndash;<jsp:include page="down.jsp" />&ndash;%&gt;--%>





