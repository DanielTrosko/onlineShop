<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="up.jsp" %>

            <div class="container">
                <div class="row">
                    <div class="col">Image</div>
                    <div class="col">Marka</div>
                    <div class="col">Model</div>
                    <div class="col">Rok</div>
                    <div class="col">Cena</div>
                    <div class="w-100"></div>
                    <c:forEach items="${auctions}" var="auctions">
                        <div class="col">SooN</div>
                        <div class="col">auctions.getMark</div>
                        <div class="col">auctions.getModel</div>
                        <div class="col">auctions.getYear</div>
                        <div class="col">auctions.getPrice</div>
                    </c:forEach>


                </div>
            </div>






<%@ include file="down.jsp" %>