<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.kojstarinnovations.jps17.data.request.LoginUser" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/user">JSP Java17</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <c:if test="${LoginUser != null}">
            <div class="dropdown">
                <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                    </svg> MENU
                </button>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href="javascript:void(0);" onclick="submitForm('${pageContext.request.contextPath}/basicUser?action=editProfile')">Editar perfil</a></li>
                    <c:if test="${LoginUser.hasRol('ADMINISTRATOR')}">
                        <li><a class="dropdown-item" href="javascript:void(0);" onclick="submitForm('${pageContext.request.contextPath}/administration')">Administración</a></li>
                    </c:if>
                    <c:if test="${LoginUser.hasRol('ATM')}">
                        <li><a class="dropdown-item" href="javascript:void(0);" onclick="submitForm('${pageContext.request.contextPath}/reception')">Recepción</a></li>
                    </c:if>
                    <c:if test="${LoginUser.hasRol('CLIENT')}">
                        <li><a class="dropdown-item" href="javascript:void(0);" onclick="submitForm('${pageContext.request.contextPath}/client')">Cliente</a></li>
                    </c:if>
                    <li><a class="dropdown-item" href="javascript:void(0);" onclick="submitForm('${pageContext.request.contextPath}/logout')">Cerrar Sesión</a></li>
                </ul>

                <script>
                    function submitForm(action) {
                        const form = document.createElement('form');
                        form.setAttribute('method', 'POST');
                        form.setAttribute('action', action);
                        document.body.appendChild(form);
                        form.submit();
                    }
                </script>
            </div>
        </c:if>
    </div>
</nav>