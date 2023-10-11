<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path1" value="${pageContext.servletContext.contextPath }" />
<!-- 헤더 내용 기술 -->
<header id="hd" class="container is-fullhd">
    <nav class="top-bar">
        <ul class="menu">
            <li><a class="navbar-item" href=""><img src="https://www.smarthb-eng.co.kr/admin/data/banner/logo_2102180103104.png" width="112"></a></li>
        </ul>

        <ul class="dropdown menu align-center" data-dropdown-menu>
            <li><a class="navbar-item"></a></li>
            <li><a class="navbar-item">Documentation</a></li>
            <li>
                <a class="navbar-link">Community</a>
                <ul class="menu">
                    <li><a href="${path1 }/board/list.do" class="navbar-item">Board</a></li>
                    <li><a href="${path1 }/sample2/list.do" class="navbar-item">Sample</a></li>
                    <li><a href="${path1 }/free/list.do" class="navbar-item">Free</a></li>
                    <li><a href="${path1 }/file/filelist1.do" class="navbar-item">Fileboard</a></li>
                    <c:if test="${sid.equals('admin')}">
                    <li><a href="${path1 }/file/fileupload1.do" class="navbar-item">FileUpload</a></li>
                    </c:if>
                    <li><a class="navbar-item">Contact</a></li>
                    <li><a class="navbar-item">Report an issue</a><li>
                </ul>
            </li>
        </ul>

        <ul class="menu align-right">
            <c:if test="${!empty sid}">
                <li><a href="${path1}/mypage" class="button">
                    <strong>MyPage</strong>
                </a></li>
                <li><a href="${path1}/logout" class="button">
                    LogOut
                </a></li>
            </c:if>
            <c:if test="${empty sid}">
                <li><a href="${path1}/signup" class="button">
                    <strong>Sign up</strong>
                </a></li>
                <li><a href="${path1}/login" class="button">
                    Log in
                </a></li>
            </c:if>
            <c:if test="${sid.equals('admin')}">
                <li><a href="${path1}/userList" class="button">
                    MemberList
                </a></li>
            </c:if>
        </ul>
    </nav>
</header>