<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 23.
  Time: 오후 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>가제 - 수정</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@include file="/template/header.jsp"%>
<div class="main">
    <div style="flex:1">
        인기유저목록
    </div>
    <div style="flex:4">
        <div>
            <h2>게시물 수정하기</h2>
        </div>
        <div>
            <form action="/article/edit" method="post">
                <input type="hidden" name="no" value="${article.no}"/>
                <div class="mt-2">
                    <label>토픽</label>
                    <div>
                        <select class="input-100" name="topic">
                            <option value="">토픽을 선택해주세요.</option>
                            <option value="life" ${article.topic == 'life' ? 'selected' : ''}>사는얘기</option>
                            <option value="gathering" ${article.topic == 'gathering' ? 'selected' : ''}>모임&스터디</option>
                            <option value="feedback" ${article.topic == 'feedback' ? 'selected' : ''}>피드백</option>
                        </select>
                    </div>
                </div>
                <div class="mt-2">
                    <label>제목</label>
                    <div>
                        <input type="text" class="input-100" name="title" value="${article.title}"/>
                    </div>
                </div>
                <div class="mt-2">
                    <label>본문</label>
                    <div>
                            <textarea class="input-100" style="height: 300px; resize: none"
                                      name="content">${article.content}</textarea>
                    </div>
                </div>
                <div class="mt-3" style="display: flex; justify-content: space-between">
                    <button type="reset" class="bt-submit">취소</button>
                    <button type="submit" class="bt-submit">수정</button>
                </div>
            </form>
        </div>
    </div>
    <div style="flex:1">
        인기글
    </div>
</div>

</body>
</html>
