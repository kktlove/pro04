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
    <title>교재 목록</title>
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
                    <span class="show-for-sr">Current: </span> Book List
                </li>
            </ul>
        </nav>
        <form action="${path1}/book/list2.do" method="post">
            <h2 class="title">교재 목록</h2>
            <hr>
            <table>
                <tbody>
                    <tr>
                        <td>
                            <input type="hidden" id="curpage" name="curpage" value="${page.curpage}">
                            <select id="field" name="field" required>
                                <option value="">선택안함</option>
                                <option value="title">교재명</option>
                                <option value="bcoment">교재내용</option>
                            </select>
                        </td>
                        <td><input type="text" id="query" name="query" placeholder="검색어 입력" required></td>
                        <td><input type="submit" id="searchBtn" value="검색" class="button"></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <ul class="grid-x grid-margin-x small-up-1 medium-up-2 large-up-3" style="width:1280px;margin:20px auto;list-style:none;">
            <c:forEach var="book" items="${bookList}">
                <li class="cell" style="list-style:none;">
                    <div class="callout">
                        <a href="${path1}/book/get.do?bookno=${book.bookno}">
                            <div class="card-divider"><h4>${book.title}</h4></div>
                            <p class="card-image" style="width:335px;height:310px;overflow:hidden;">
                                <img src="${path1}/resources/book/upload/${book.fcover}" alt="${book.title}" style="display:block; width:auto; height:auto;"/>
                            </p>
                            <div class="card-section">
                                <p>출판사 : ${book.pubcom}</p>
                                <p>출판일 : ${book.pubdate}</p>
                                <p>저자 : ${book.author}</p>
                                <p>가격 : ${book.price}</p>
                                <p>남은 수량 : ${book.amount}</p>
                            </div>
                        </a>
                    </div>
                </li>
            </c:forEach>
            <c:if test="${empty bookList}">
                <li class="cell" style="text-align: center">교재가 존재하지 않습니다.</li>
            </c:if>
        </ul>
        <div class="pagination-centered">
            <ul class="pagination" style="width:230px;margin:10px auto;">
                <c:forEach var="i" begin="1" end="${page.pageCount}" step="1">
                    <c:if test="${page.curpage>=6}">
                        <li class="arrow unavailable" aria-disabled="true"><a href="">&laquo; Previous</a></li>
                    </c:if>
                    <c:if test="${page.curpage eq i}">
                        <li class="current"><span>${i}</span></li>
                    </c:if>
                    <c:if test="${page.curpage!=i and (empty query)}">
                        <li><a href="${path1}/book/list.do?curpage=${i}">${i}</a></li>
                    </c:if>
                    <c:if test="${page.curpage!=i and !(empty query)}">
                        <li><a href="${path1}/book/list2.do?curpage=${i}&field=${field}&query=${query}">${i}</a></li>
                    </c:if>
                    <c:if test="${page.pageCount>=6}">
                        <li class="arrow"><a href="">Next &raquo;</a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
        <ul class="button-group" style="list-style:none;width:100px;margin:10px auto;">
            <c:if test="${sid.equals('admin')}">
                <li><a href="${path1 }/book/write.do" class="button">교재 등록</a></li>
            </c:if>
        </ul>
    </div>
    <!-- 푸터 부분 인클루드 -->
    <jsp:include page="../include/ft.jsp"></jsp:include>
</div>
</body>
</html>
