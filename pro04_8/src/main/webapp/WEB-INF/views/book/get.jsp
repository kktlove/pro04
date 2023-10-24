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
    <title>교재 정보 상세 보기</title>
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
                    <span class="show-for-sr">Current: </span> Book Detail
                </li>
            </ul>
        </nav>
        <h2 class="title">교재정보 상세보기</h2>
        <hr>
        <table class="inner-table">
            <tbody>
                <tr>
                    <th style="width:20%;">교재 코드</th>
                    <td>${book.bookno}</td>
                </tr>
                <tr>
                    <th>교재명</th>
                    <td>${book.title}</td>
                </tr>
                <tr>
                    <th>교재 기본정보</th>
                    <td>
                        <p>출판사 : ${book.pubcom}</p>
                        <p>출판일 : ${book.pubdate}</p>
                        <p>저자 : ${book.author}</p>
                    </td>
                </tr>
                <tr>
                    <th>교재 가격</th>
                    <td>
                        <h3>${book.price}</h3>
                    </td>
                </tr>
                <tr>
                    <th>교재 이미지</th>
                    <td>
                        <p><img src="${path1}/resources/book/upload/${book.fcover}" alt="${book.title}" style="display:block; width:600px; height:auto;"/></p>
                        <p><img src="${path1}/resources/book/upload/${book.bcover}" alt="${book.title}" style="display:block; width:600px; height:auto;"/></p>
                        <p><img src="${path1}/resources/book/upload/${book.bpic}" alt="${book.title}" style="display:block; width:600px; height:auto;"/></p>
                    </td>
                </tr>
                <tr>
                    <th>교재 설명</th>
                    <td><pre>${book.bcoment}</pre></td>
                </tr>
                <tr>
                    <th>교재목차</th>
                    <td><pre>${book.blist}</pre></td>
                </tr>
                <tr>
                    <th>교재자료</th>
                    <td><a href="${path1}/resources/book/upload/${book.pfile}" download>${book.pfile}</a> </td>
                </tr>
                <tr>
                    <th>추가 정보</th>
                    <td><pre style="">${book.memo}</pre></td>
                </tr>
            </tbody>
        </table>
        <ul class="button-group" style="list-style:none;width:600px;margin:10px auto;">
            <li><a href="${path1}/book/list.do?curpage=1" class="button">교재 목록</a></li>
            <c:if test="${not empty sid}">
                <c:if test="${book.amount>=1}">
                    <li><a href="${path1}/book/sales.do?bookno=${book.bookno}&sid=${sid}" class="button">교재 구입</a></li>
                </c:if>
                <c:if test="${book.amount<1}">
                    <li><a href="${path1}/book/list.do?curpage=1" class="button">절판</a></li>
                </c:if>
            </c:if>
            <c:if test="${sid.equals('admin')}">
                <li><a href="${path1 }/book/update.do?bno=${book.bookno}" class="button">정보 수정</a></li>
                <li><a href="${path1 }/book/delete.do?bno=${book.bookno}" class="button">교재 정보 삭제</a></li>
                <li><a href="${path1 }/book/addInventory.do" class="button">교재 입고</a></li>
            </c:if>
        </ul>
    </div>
    <!-- 푸터 부분 인클루드 -->
    <jsp:include page="../include/ft.jsp"></jsp:include>
</div>
</body>
</html>
