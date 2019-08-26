<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="up.jsp" />

<script>
    var timer = setTimeout(function() {
        window.location='/'}, 3000);
</script>

<center>
    <h1>${code}</h1>
    <div class="spinner-border text-danger" role="status">
        <span class="sr-only">Loading...</span>
    </div>
    <h2>Something went wrong! </h2>
    <h3>Our Engineers are on it</h3>
    <a href="/" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Go back</a>

</center>


<jsp:include page="down.jsp" />