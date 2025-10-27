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
    <style>
        body {
            margin: 0px;
        }

        .signup-wrap {
            margin: 6rem 0rem;
            display: flex;
            justify-content: center;
        }

        .signup {
            max-width: 28rem;
        }

        .text-center {
            text-align: center;
        }

        .text-gray {
            color: #8f8f8f
        }

        .mt-1 {
            margin-top: 0.25rem;
        }

        .input {
            width: 100%;
            padding: 0.5rem 0.75rem;
            border-radius: 0.375rem;
            border-color: #8f8f8f;
        }
        .signup-form > div {
            margin-top: 1.5rem;
        }
        .bt-submit {
            width: 100%;
            padding: 0.5rem 1rem;
            border-radius: 0.375rem;
            border: none;
            cursor: pointer;
        }
        .bt-submit:hover {
            background-color: #6f6f6f;
            color: #efefef;
        }
    </style>
</head>
<body>
<div class="signup-wrap">
    <div class="signup">
        <a href="/">로고</a>
        <h2 class="text-center">가제에 오신것을 환영합니다.</h2>
        <p class="text-center text-gray">
            가제는 소프트웨어 개발자를 위한 지식공유 플랫폼입니다.
        </p>
        <form class="signup-form" action="/signup" method="post">
            <div>
                <label for="id"><small>아이디</small></label>
                <div class="mt-1">
                    <input type="text" class="input" name="id" id="id" placeholder="4~15 이내로 입력해주세요"/>
                </div>
            </div>
            <div>
                <label for="password"><small>비밀번호</small></label>
                <div class="mt-1">
                    <input type="password" class="input" name="password" id="password" placeholder="최소 6자 이상(알파벳, 숫자 필수)"/>
                </div>
            </div>
            <div>
                <label for="email"><small>이메일</small></label>
                <div class="mt-1">
                    <input type="text" class="input" name="email" id="email" placeholder="test@test.com"/>
                </div>
            </div>
            <div>
                <label for="name"><small>실명</small></label>
                <div class="mt-1">
                    <input type="text" class="input" name="name" id="name" placeholder="홍길동"/>
                </div>
            </div>
            <div>
                <label for="nickname"><small>닉네임</small></label>
                <div class="mt-1">
                    <input type="text" class="input" name="nickname" id="nickname"
                           placeholder="별명을 알파벳,한글,숫자를 20자 이하로 입력하세요"/>
                </div>
            </div>
            <div>
                <label for="interest"><small>관심태그</small></label>
                <div class="mt-1">
                    <input type="text" class="input" name="interest" id="interest"
                           placeholder="백엔드, 프론트엔드, 모바일, 취업, 신기술,,,"/>
                </div>
            </div>
            <div>
                <div style="display: flex; justify-content: space-between">
                    <label>이메일 수신동의</label>
                    <div>
                    <input type="checkbox" name="agree" value="true"/>
                    </div>
                </div>
                <div class="text-gray mt-1">
                    가제에서 주최하는 다양한 이벤트, 정보성 뉴스레터 및 광고 수신여부를 설정할 수 있습니다.
                </div>
            </div>
            <div>
                <button type="submit" class="bt-submit">회원가입</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
