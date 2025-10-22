<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2025-10-17
  Time: 오전 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>커뮤니티</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="signup-wrap">
    <div class="signup">
        <a href="/">로고</a>
        <h2 class="text-center">가제에 오신것을 환영합니다.</h2>
        <p class="text-center text-gray">
            가제는 소프트웨어 개발자를 위한 지식공유 플랫폼입니다.
        </p>
        <form class="signup-form" action="login" method="post">
            <div>
                <label for="id"><small>아이디</small></label>
                <div class="mt-1">
                    <input type="text" class="input" name="id" id="id" onkeyup="updateButtonState()"/>
                </div>
            </div>
            <div>
                <label for="password"><small>비밀번호</small></label>
                <div class="mt-1">
                    <input type="password" class="input" name="password" id="password" onkeyup="updateButtonState()"/>
                </div>
                <div class="mt-1" style="display: flex; justify-content: space-between">
                    <label for="keepLogin"><small>로그인 상태 유지</small></label>
                    <input type="checkbox" name="keepLogin" id="keepLogin" onchange="keepLoginConfirm();"/>
                </div>
            </div>

            <div>
                <button id="loginBt" class="bt-submit" disabled>로그인</button>
            </div>
        </form>
        <p class="text-center">
            아직 회원이 아니신가요? <a href="/signup" style="color: rgba(0,144,249,0.8)">회원가입</a>
        </p>
    </div>
</div>
<script>
    function keepLoginConfirm() {
        if(document.getElementById("keepLogin").checked) {
            if(!window.confirm("공용PC에서는 보안상의 문제가 발생할 수 있습니다.")){
                document.getElementById("keepLogin").checked= false;
            }
        }
    }

    function updateButtonState() {
        const idValue = document.getElementById("id").value;
        const passValue = document.getElementById("password").value;
        if(idValue && passValue) {
            document.getElementById("loginBt").disabled = false;
        } else {
            document.getElementById("loginBt").disabled = true;
        }
    }
</script>
</body>
</html>
