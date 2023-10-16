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
    <title>공지사항 목록</title>
</head>
<body>
    <form action="${path1}/board/list2" method="post">
        <table>
            <tbody>
                <tr>
                    <td>
                        <select id="field" name="field">
                            <option value="">선택안함</option>
                            <option value="title">제목</option>
                            <option value="content">내용</option>
                        </select>
                    </td>
                    <td><input type="text" id="query" name="query" placeholder="검색어 입력"></td>
                    <td><input type="submit" id="searchBtn" value="검색"></td>
                </tr>
            </tbody>
        </table>
    </form>
    <table>
        <thead>
            <tr>
                <th>연번</th><th>제목</th><th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${boardList}">
                <tr>
                    <td>${board.bno}</td>
                    <td>${board.title}</td>
                    <td>${board.regdate}</td>
                </tr>
            </c:forEach>
        <c:if test="${empty boardList}">
            <tr>
                <td colspan="3">게시판 글이 존재하지 않습니다.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</body>
</html>
