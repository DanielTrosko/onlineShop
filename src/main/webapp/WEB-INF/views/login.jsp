<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="up.jsp" />
                <form action='<spring:url value="/signin"/>' method="post">
                    <table>
                        <tr>
                            <label>Username</label>
                            <input type="text" class="form-control" name="username">
                        </tr>
                        <tr>
                            <label>Password</label>
                            <input type="password" class="form-control" name="password">
                        </tr>
                        <br>
                        <tr>
                            <button type="submit" class="btn btn-primary">Login</button>
                        </tr>
                    </table>
                </form>
                <br/>
                <c:if test="${not empty sessionScope.message}">
                    <span style="color:green"><c:out value="${sessionScope.message}"/></span>
                    <c:remove var="message" scope="session" />
                </c:if>

<jsp:include page="down.jsp" />