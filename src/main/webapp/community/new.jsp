<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 10. 21.
  Time: 오후 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>가제 - 게시글 등록</title>
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
                <h2>함께 할 때 더 즐거운 순간</h2>
                <div>
                    <b>${logonUser.nickname}</b>님 지식공유 플랫폼 가제에서 다양한 사람을 만나고 생각의 폭을 넓혀보세요.
                </div>
            </div>
            <div>
                <form action="/community/new" method="post">
                    <div>
                        <label>토픽</label>
                        <div>
                            <select class="input-100" name="topic">
                                <option value="">토픽을 선택해주세요.</option>
                                <option value="life">사는얘기</option>
                                <option value="gathering">모임&스터디</option>
                                <option value="feedback">피드백</option>
                            </select>
                        </div>
                    </div>
                    <div>
                        <label>제목</label>
                        <div>
                            <input type="text" class="input-100" name="title"/>
                        </div>
                    </div>
                    <div>
                        <label>본문</label>
                        <div>
                            <textarea class="input-100" style="height: 300px; resize: none"
                                      name="content"></textarea>
                        </div>
                    </div>
                    <div style="display: flex; justify-content: space-between">
                        <button type="reset" class="bt-submit">취소</button>
                        <button type="submit" class="bt-submit">등록</button>
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
