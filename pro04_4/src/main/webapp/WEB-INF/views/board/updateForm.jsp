<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 수정하기</title>
    <jsp:include page="../include/head.jsp"></jsp:include>
</head>
<body>
<div class="container is-fullhd">
    <!-- 헤더 부분 인클루드 -->
    <jsp:include page="../include/hd.jsp"></jsp:include>
    <div class="orbit" role="region" aria-label="Favorite Space Pictures" data-orbit="" data-options="animInFromLeft:fade-in; animInFromRight:fade-in; animOutToLeft:fade-out; animOutToRight:fade-out;" data-resize="qa57d9-orbit" id="qa57d9-orbit" data-e="9eilbx-e">
        <ul class="orbit-container" tabindex="0" style="height:300px;">
            <button class="orbit-previous" tabindex="0"><span class="show-for-sr">Previous Slide</span>◀︎</button>
            <button class="orbit-next" tabindex="0"><span class="show-for-sr">Next Slide</span>▶︎</button>
            <li class="orbit-slide" data-slide="0" style="display: none; position: relative; top: 0px;">
                <img class="orbit-image" src="https://placehold.it/2000x300&amp;text=1st" alt="Space">
                <figcaption class="orbit-caption">Space, the final frontier.</figcaption>
            </li>
            <li class="orbit-slide" data-slide="1" style="position: relative; top: 0px; display: none;">
                <img class="orbit-image" src="https://placehold.it/2000x300&amp;text=2nd" alt="Space">
                <figcaption class="orbit-caption">Lets Rocket!</figcaption>
            </li>
            <li class="orbit-slide" data-slide="2" style="position: relative; top: 0px; display: none;">
                <img class="orbit-image" src="https://placehold.it/2000x300&amp;text=3nd" alt="Space">
                <figcaption class="orbit-caption">Encapsulating</figcaption>
            </li>
            <li class="orbit-slide is-active" data-slide="3" style="position: relative; top: 0px; display: block;" aria-live="polite">
                <img class="orbit-image" src="https://placehold.it/2000x300&amp;text=4nd" alt="Space">
                <figcaption class="orbit-caption">Outta This World</figcaption>
            </li>
        </ul>
        <nav class="orbit-bullets">
            <button class="" data-slide="0"><span class="show-for-sr">First slide details.</span></button>
            <button data-slide="1" class=""><span class="show-for-sr">Second slide details.</span></button>
            <button data-slide="2" class=""><span class="show-for-sr">Third slide details.</span></button>
            <button data-slide="3" class="is-active"><span class="show-for-sr">Fourth slide details.</span><span class="show-for-sr">Current Slide</span></button>
        </nav>
    </div>
    <nav aria-label="You are here:" role="navigation">
        <ul class="breadcrumbs">
            <li><a href="#">Home</a></li>
            <li><a href="#">Board</a></li>
            <li>
                <span class="show-for-sr">Current: </span> Board Update
            </li>
        </ul>
    </nav>
    <form action="${path1}/board/update.do" method="post">
        <table class="inner-table">
            <tbody>
                <tr>
                    <th>글 번호</th>
                    <td>
                        <input type="hidden" id="bno" name="bno" value="${board.bno}">
                        ${board.bno}
                    </td>
                </tr>
                <tr>
                    <th>글 제목</th>
                    <td><input type="text" id="title" name="title" value="${board.title}" required></td>
                </tr>
                <tr>
                    <th>글 내용</th>
                    <td><textarea id="content" name="content" required>${board.content}</textarea></td>
                </tr>
                <tr>
                    <th>작성일시</th>
                    <td>${board.regdate}</td>
                </tr>
                <tr>
                    <th>읽은 횟수</th>
                    <td>${board.visited}</td>
                </tr>
            </tbody>
        </table>
        <table class="tb_pagenation">
            <tr>
                <td><a href="${path1}/board/list.do?curpage=1" class="button">글 목록</a></td>
                <c:if test="${sid.equals('admin')}">
                    <td><input type="submit" class="button" value="글 수정"></td>
                    <td><a href="${path1 }/board/delete.do?bno=${board.bno}" class="button">글 삭제</a></td>
                </c:if>
            </tr>
        </table>
    </form>
    <!-- 푸터 부분 인클루드 -->
    <jsp:include page="../include/ft.jsp"></jsp:include>
</div>
</body>
</html>
