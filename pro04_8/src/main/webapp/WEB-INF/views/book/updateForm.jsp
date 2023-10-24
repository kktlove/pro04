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
    <title>교재 정보 수정하기</title>
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
    <div class="contents">
        <nav aria-label="You are here:" role="navigation">
            <ul class="breadcrumbs">
                <li><a href="#">Home</a></li>
                <li><a href="#">Book</a></li>
                <li>
                    <span class="show-for-sr">Current: </span> Book Update
                </li>
            </ul>
        </nav>
        <form action="${path1}/board/update.do" method="post">
            <h2 class="title">교재 정보 수정</h2>
            <hr>
            <table class="inner-table">
                <tbody>
                    <tr>
                        <th>교재 번호</th>
                        <td>
                            <input type="hidden" id="bookno" name="bookno" value="${book.bookno}">
                            ${book.bookno}
                        </td>
                    </tr>
                    <tr>
                        <th>교재명</th>
                        <td><input type="text" id="title" name="title" value="${book.title}" required></td>
                    </tr>
                    <tr>
                        <th>교재 목차</th>
                        <td><textarea id="blist" name="blist" required>${book.blist}</textarea></td>
                    </tr>
                    <tr>
                        <th>글 내용</th>
                        <td><textarea id="bcoment" name="bcoment" required>${book.bcoment}</textarea></td>
                    </tr>
                    <tr>
                        <th>출판사</th>
                        <td>
                            <input type="text" id="pubcom" name="pubcom" value="${book.pubcom}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>출판일</th>
                        <td>
                            <input type="date" id="pubdate" name="pubdate" value="${book.pubdate}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>저자</th>
                        <td>
                            <input type="text" id="author" name="author" value="${book.author}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td>
                            <input type="number" min="1000" max="100000" step="100" id="price" name="price" value="${book.price}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>교재 이미지</th>
                        <td>
                            <h3>원래 이미지</h3>
                            <p>앞 표지 : ${book.fcover}</p>
                            <p>뒤 표지 : ${book.bcover}</p>
                            <p>내지 : ${book.bcover}</p>
                            <hr>
                            <h3>변경할 이미지</h3>
                            앞 표지 : <input type="file" id="fcover" name="files2" accept="image/*" required><br>
                            뒤 표지 : <input type="file" id="bcover" name="files2" accept="image/*" required><br>
                            내지 : <input type="file" id="bpic" name="files2" accept="image/*" required>
                        </td>
                    </tr>
                    <tr>
                        <th>교재 자료</th>
                        <td>
                            <p>${book.pfile}</p>
                            <input type="file" id="pfile" name="files2" accept=".pdf" required><br>
                        </td>
                    </tr>
                    <tr>
                        <th>참고사항</th>
                        <td>
                            <textarea id="memo" name="memo">${book.memo}</textarea>
                        </td>
                    </tr>
                </tbody>
            </table>
            <ul class="button-group" style="list-style:none;width:270px;margin:10px auto;">
                <li><a href="${path1}/book/list.do?curpage=1" class="button">교재 목록</a></li>
                <c:if test="${sid.equals('admin')}">
                    <li><input type="submit" class="button" value="교재 정보 수정"></li>
                    <li><a href="${path1 }/book/delete.do?bno=${book.bookno}" class="button">교재 삭제</a></li>
                </c:if>
            </ul>
        </form>
    </div>
    <!-- 푸터 부분 인클루드 -->
    <jsp:include page="../include/ft.jsp"></jsp:include>
</div>
</body>
</html>
