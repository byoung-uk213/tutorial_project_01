<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 21.
  Time: 오후 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>가제 - 커뮤니티</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@include file="/template/header.jsp"%>
<div class="main">
    <div style="flex: 1">
        -- 유저 목록 --
    </div>
    <div style="flex: 4">
        <!-- 이미지 배너 -->
        <div>
            이미지 배너
        </div>
        <!-- 네비게이터 -->
        <div>
            전체 글수 : <span>${count}</span>
            <button onclick="location.href='/community/new'">작성하기</button>
        </div>
        <!-- 글 목록 영역 -->
        <div style="flex: 1">
            <c:forEach items="${articles}" var="one">
                <div class="article-item">
                    <div style="display: flex; justify-content: space-between;">
                        <div>
                            <span class="article-topic">${one.topic}</span>
                            <span>${one.writerId}</span>
                            <span>&sdot; ${one.prettyWroteAt}</span>
                        </div>
                        <div>
                            <span style="font-size: small">👁 ${one.viewCnt}</span>
                            <span style="font-size: small">👍 ${one.likeCnt}</span>
                        </div>
                    </div>
                    <div>
                        <a href="/article?no=${one.no}" class="article-link">
                            <span style="font-size: 1.1rem; font-weight: 500">
                                    <c:out value="${one.title}"/></span>
                        </a>
                        <small>💬(${one.commentCnt})</small>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!-- 페이지 링크 영역 -->
        <div style="padding: 1.5rem 0rem">
            <c:forEach var="i" begin="1" end="5">
                <a href="community?page=${i}" class="${page == i ? 'active-page-link':'page-link'}">${i}</a>
            </c:forEach>
        </div>
    </div>
    <div style="flex: 1">
        -- 인기글
    </div>

</div>
</body>
</html>
