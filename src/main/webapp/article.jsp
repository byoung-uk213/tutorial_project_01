<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 22.
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>${article.title} - 가제</title>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <%@include file="template/header.jsp"%>
    <div class="main">
        <div style="flex: 1"></div>
        <div style="flex: 4">
            <!-- 게시글 내용 -->
            <div>
                <div>
                    커뮤니티 / ${article.topic}
                </div>
                <div style="display: flex; justify-content: space-between">
                    <div>
                        <span>${article.writerId}</span>
                        <span>${article.prettyWroteAt}</span>
                        <span>👁${article.viewCnt}</span>
                    </div>
                    <div>
                        <button>📌</button>
                    </div>
                </div>
                <div>
                    <h2><c:out value="${article.title}"/></h2>
                </div>
                <div style="white-space: pre-line">
                    <c:out value="${article.content}"></c:out>
                </div>
                <div>
                    <button>👍</button>
                </div>
            </div>
            <!-- 댓글 영역 -->
            <div>

            </div>
        </div>
        <div style="flex: 1"></div>

    </div>

</body>
</html>
