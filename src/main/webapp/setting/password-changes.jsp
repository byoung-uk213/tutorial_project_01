<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 24.
  Time: 오후 7:29
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
    <div style="flex:4">
        <h2>비밀번호 변경하기</h2>
    </div>
    <div class="signup-wrap">
        <div class="signup">
            <a href="/">로고</a>
            <h2 class="text-center">변경하실 비밀번호를 입력해주세요</h2>
            <form class="signup-form" action="/setting/password-changes" method="post">
                <div>
                    <label for="password"><small>현재 비밀번호</small></label>
                    <div class="mt-1">
                        <input type="password" class="input" name="password" id="password"/>
                    </div>
                </div>
                <div>
                    <label for="newPassword"><small>새 비밀번호</small></label>
                    <div class="mt-1">
                        <input type="password" class="input" name="newPassword" id="newPassword"/>
                    </div>
                </div>
                <div>
                    <label for="newPasswordConfirm"><small>새 비밀번호 확인</small></label>
                    <div class="mt-1">
                        <input type="password" class="input" name="newPasswordConfirm" id="newPasswordConfirm"/>
                    </div>
                </div>
                <div>
                    <button id="loginBt" class="bt-submit" >변경하기</button>
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
