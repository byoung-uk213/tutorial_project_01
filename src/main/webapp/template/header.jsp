<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 21.
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div>
        로고
    </div>
    <c:choose>
        <c:when test="${auth}">
            <div>
                <button>스크랩</button>
                <button>알림</button>
                <button>설정</button>
                <a href="logout"><button>로그아웃</button></a>
            </div>
        </c:when>
        <c:otherwise>
            <div>
                <a href="/login"><button>로그인</button></a>
                <a href="/signup"><button>회원가입</button></a>
            </div>
        </c:otherwise>
    </c:choose>
</div>
