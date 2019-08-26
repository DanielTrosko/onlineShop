<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>


<section class="navigation">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href='<spring:url value="/login"/>'>Sign in</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href='<spring:url value="/signout"/>'>Logout</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </nav>
</section>


<section class="section1">
    <div class="container-fluid">
        <div class="row align-items-stretch">
            <div class="left-side-bar col-3">

                <div class="list-group">
                    <a href="/auctions" class="list-group-item list-group-item-action active">Auctions</a>
                    <a href="/user/myauctions" class="list-group-item list-group-item-action">My auctions</a>
                    <a href="/user/addauctions" class="list-group-item list-group-item-action">Add auction</a>
                    <a href="/user/editUser" class="list-group-item list-group-item-action">Settings</a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="/admin/userlist" class="list-group-item list-group-item-action">User List</a>
                        <a href="/admin/deleteUser" class="list-group-item list-group-item-action">Delete User</a>
                    </sec:authorize>



<%--                    <sec:authentication property="principal.authorities" var="authorities" />--%>
<%--                    <c:forEach items="${authorities}" var="authority" varStatus="vs">--%>
<%--                        <p>${authority.authority}</p>--%>
<%--                    </c:forEach>--%>


                </div>

            </div>
            <div class="middle col-6 d-flex">
