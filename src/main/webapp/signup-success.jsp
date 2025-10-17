<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2025-10-17
  Time: 오후 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>가제</title>
    <style>
        body {
            margin: 0px;
        }

        .signup-wrap {
            margin: 6rem 0rem;
            display: flex;
            justify-content: center;
        }

        .signup-success {
            max-width: 46rem;
        }

        .text-center {
            text-align: center;
        }
        .text-gray {
            color : #8f8f8f
        }
        .text-blue {
            color : rgba(0,144,249,1);
        }
        .bt-login {
            background-color: rgba(0,144,249, 0.5);
            border: none;
            border-radius: 0.375rem;
            color: white;
            cursor: pointer;
            width: 12rem;
            padding : 0.5rem 1rem;
        }
        .bt-login:hover{
            background-color: rgba(0, 144, 249, 1);
        }
    </style>
</head>
<body>
<div class="signup-wrap">
    <div class="signup-success">
        <div>
            <div class="text-center">
                <img src="/images/check.svg" alt="체크 아이콘" width="140" height="140">
            </div>
            <div class="text-center">
                <h2>
                    환영합니다!<br/>
                    <span class="text-blue">${nickname}</span>님
                </h2>
            </div>
        </div>
        <div>
            <p class="text-gray text-center">
                회원가입이 성공적으로 완료되었습니다.<br/>
                아래 로그인 버튼을 눌러 다시한번 로그인 해주세요.
            </p>
            <div class="text-center">
                <a href="/login"><button class="bt-login">
                    로그인</button></a>
            </div>
        </div>

    </div>
</div>
</body>
</html>
