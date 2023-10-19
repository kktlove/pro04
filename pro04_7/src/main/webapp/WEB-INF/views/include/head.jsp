<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%--<c:set var="path0" value="${pageContext.request.contextPath }" />--%>
<c:set var="path0" value="${pageContext.servletContext.contextPath }" />
<!-- 메타포 -->
<!-- 오픈그래프 -->
<!-- 기타 설정 -->
<!-- 폰트 -->
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="${path0}/resources/css/normalize.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation-prototype.min.css">
<link href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/js/foundation.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.js"></script>
<script>
    $(document).ready(function(){
        $(document).foundation();
    });
</script>
<style>
/* 공통 사용자 정의 스타일 */
#ft { border-top:3px solid #369; }
.control { margin-top:10px; margin-bottom:10px; }
h2.title { text-align: center; }
.form-check { width:960px; margin:20px auto; text-align: center; }
.breadcrumbs { border-top:5px solid #f0f0f0; border-bottom:5px solid #f0f0f0; padding-top:12px; padding-bottom:12px; background:#f0f0f0; padding-left:24px; }
form { width:1280px; margin:20px auto; }
.inner-table { width:800px; margin:20px auto; }
.tb_pagenation { width:300px; margin:20px auto; }
.curpage { display:inline-block; width:38px; height:38px; text-align:center; line-height:38px; border-radius:20px; background-color:#3c3c3c; color:#fff; }
.contents { min-height:55vw;}
</style>
