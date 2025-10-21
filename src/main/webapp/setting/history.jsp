<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 21.
  Time: 오전 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>가제</title>
</head>
<body>
<%@include file="/template/header.jsp"%>
    <div>
        <h3>로그인 이력</h3>
        <ul>
            <c:forEach items="${list}" var="one">
                <li>${one.memberId} - ${one.loginAt}</li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
