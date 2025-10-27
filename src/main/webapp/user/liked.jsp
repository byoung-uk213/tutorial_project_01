<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 27.
  Time: 오후 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>유저활동내역 - 가제</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@include file="/template/header.jsp"%>
<div class="main">
    <div>
        <h2>활동내역</h2>
    <div>
        <button>내가 쓴 게시물</button>
        <button>내가 좋아요 한 게시물</button>
        <button>내가 댓글 단 게시물</button>
    </div>
    <div>
        <c:forEach var="one" items="${likedArticleList}">
            <div class="article-item">
                <span class="article-topic">${one.topic}</span>
                <a href="/article?no=${one.no}" class="article-link">${one.title}</a>
            </div>
        </c:forEach>
    </div>
    </div>
</div>

</body>
</html>
