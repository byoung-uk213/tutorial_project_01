<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 27.
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원탈퇴 - 가제</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="signup-wrap">
     <div class="signup">
         <a href="/">로고</a>
         <h2>회원 탈퇴 시 아래와 같이 처리됩니다.</h2>
         <p style="width: 400px">
             회원 탈퇴일로부터 계정과 닉네임을 포함한 계정 정보(아이디/이메일/닉네임)는
             개인정보 보호정책에 따라 60일간 보관(잠김)되며, 60일 경과된 후에는 모든 개인 정보는 완전히 삭제되며
             더 이상 복구할 수 없게 됩니다.
         </p>
         <form action="/setting/withdraw" method="post">
             <button type="button">취소</button>
             <button type="submit">예 탈퇴하겠습니다.</button>
         </form>
     </div>
</div>
</body>
</html>
