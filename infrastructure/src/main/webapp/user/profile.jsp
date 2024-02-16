<%@ page import="com.kojstarinnovations.jps17.data.response.UserResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>PROFILE</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script><!-- comment -->
    <link rel="stylesheet" href="/css/profile/profile.css" type="text/css">
</head>
<body>
<jsp:include page="/menu/menuPrincipal.jsp"/>
<c:if test="${UserResponse != null}">
    <div class="text-primary">
        <div class="title">Welcome back...</div>
        <%= ((UserResponse)session.getAttribute("UserResponse")).getUsername() %>
    </div>
</c:if>

</body>
</html>