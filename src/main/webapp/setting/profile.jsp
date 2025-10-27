<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 24.
  Time: 오후 4:29
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
        <div>
            <div>
                <a href="/setting/profile"><button type="reset" class="bt-submit" >프로필</button></a>
            </div>
            <div class="mt-1">
                <a href="/setting/password-changes"><button type="submit" class="bt-submit">비밀번호 변경</button></a>
            </div>
        </div>
    </div>
    <div style="flex:4">
        <h2>프로필 수정하기</h2>
    </div>
    <div>
        <form action="/setting/profile" method="post">
            <input type="hidden" name="id" value="${member.id}"/>
            <div class="mt-1">
                <label>이름</label>
                <div>
                    <input type="text" class="input-100" name="name" value="${member.name}"/>
                </div>
            </div>
            <div class="mt-1">
                <label>닉네임</label>
                <div>
                    <input type="text" class="input-100" name="nickname" value="${member.nickname}"/>
                </div>
            </div>
            <div class="mt-1">
                <label>이메일(Email)</label>
                <div>
                    <input type="text" class="input-100" name="email" value="${member.email}"/>
                </div>
            </div>
            <div class="mt-1" style="display: flex; justify-content: space-between">
                <button type="reset" class="bt-submit">취소</button>
                <button type="submit" class="bt-submit">수정</button>
            </div>
        </form>
    </div>
    <div style="flex:1">
        인기글
    </div>
</div>
</body>
</html>
