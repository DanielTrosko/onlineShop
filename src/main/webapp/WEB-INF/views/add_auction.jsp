<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="up.jsp" />

    <%--@elvariable id="Auction" type="it.danieltrosko.shop.model.Auction"--%>
    <form:form method="POST" action="/auction" modelAttribute="Auction">
        <form:input class="formControl" type="text" path="id" hidden="true"/>

        <div class="form-group">
            <form:label path="mark">Mark</form:label>
            <form:input class="formControl" type="text" required="required" path="mark"/>
        </div>
        <div class="form-group">
            <form:label path="model">Model</form:label>
            <form:input class="formControl" type="text" required="required" path="model"/>
        </div>
        <div class="form-group">
            <form:label path="year">Year</form:label>
            <form:input class="formControl" type="text" required="required" path="year"/>
        </div>
        <div class="form-group">
            <form:label path="price">Price</form:label>
            <form:input class="formControl" type="text" required="required" path="price"/>
        </div>
        <form:input class="formControl" type="text" path="user" hidden="true"/>

        <form:button type="submit" class="btn btn-primary" value="Submit">Register</form:button>
    </form:form>
<jsp:include page="down.jsp" />