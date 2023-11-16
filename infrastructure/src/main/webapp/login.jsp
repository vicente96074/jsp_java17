<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <!--CSS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/menu/menuPrincipal.jsp"/>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h3 class="card-title text-center">Iniciar sesión</h3>
                    <form id="form-login" action="${pageContext.request.contextPath}/user" method="POST">
                        <input type="hidden" name="action" value="login">
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" id="username" name="username">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>

                        <c:if test="${!empty(error)}">
                            <div id="error-alert" class="alert alert-danger alert-dismissible fade show" role="alert" style="display: none;">
                                <strong>¡Login fallido!</strong> ${error}
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>

                        <div class="text-center d-grid gap-2">
                            <button type="submit" class="btn btn-primary ">Iniciar sesión</button>
                        </div>
                    </form>
                    <div class="text-center mt-3">
                        <p>¿No tienes una cuenta? <a href="${pageContext.request.contextPath}/register.jsp">Registrarse</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<script>
    // JavaScript para mostrar el mensaje Toastr
    <c:if test="${!empty(error)}">
    $(document).ready(function () {
        $("#error-alert").fadeIn();
        setTimeout(function () {
            $("#error-alert").fadeOut();
        }, 5000);
    });
    </c:if>
</script>

</body>
</html>