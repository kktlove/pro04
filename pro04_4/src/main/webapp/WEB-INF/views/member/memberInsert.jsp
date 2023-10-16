<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <!-- 헤드 부분 인클루드 -->
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
            <li><a href="#">Member</a></li>
            <li>
                <span class="show-for-sr">Current: </span> Join
            </li>
        </ul>
    </nav>
    <div class="content" id="contents">
    <div class="row column text-center">
        <h2 class="h1">회원가입</h2>
        <hr>
        <div class="container">
            <form name="frm1" id="frm1" action="${path1 }/member/insert.do" method="post" onsubmit="return joinCheck(this)">
                <table id="table1">
                    <tbody>
                    <tr>
                        <th style="background-color:#dcdcdc">아이디</th>
                        <td>
                            <input type="text" name="id" id="id" placeholder="아이디 입력" pattern="^[a-z0-9]{5,12}" maxlength="12" required style="width:700px; float:left;">
                            <input type="button" id="idCkBtn" class="button" value="아이디 중복 체크" onclick="idCheck()">
                            <input type="hidden" name="idck" id="idck" value="no"/>
                            <c:if test="${empty qid }">
                                <p id="msg" style="padding-left:0.5rem">아직 아이디 중복 체크를 하지 않으셨습니다.</p>
                            </c:if>
                            <c:if test="${not empty qid }">
                                <p id="msg" style="padding-left:0.5rem">아이디 중복 체크후 수정하였습니다.</p>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th style="background-color:#dcdcdc">비밀번호</th>
                        <td>
                            <input type="password" name="pw" id="pw" placeholder="비밀번호 입력" maxlength="12" required>
                            <!-- pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$"  -->
                        </td>
                    </tr>
                    <tr>
                        <th style="background-color:#dcdcdc">비밀번호 확인</th>
                        <td>
                            <input type="password" name="pw2" id="pw2" placeholder="비밀번호 확인 입력" maxlength="12" required>
                            <!-- pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$"  -->
                        </td>
                    </tr>
                    <tr>
                        <th style="background-color:#dcdcdc">이름</th>
                        <td>
                            <input type="text" name="name" id="name" placeholder="이름 입력" maxlength="40" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="background-color:#dcdcdc">생년월일</th>
                        <td>
                            <input type="date" name="birth" id="birth" placeholder="생년월일 입력" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="background-color:#dcdcdc">이메일</th>
                        <td>
                            <input type="email" name="email" id="email" placeholder="이메일 입력" pattern="^\w+((\.\w+)?)+@\w+.?\w+\.\w+$" maxlength="80" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="background-color:#dcdcdc">전화번호</th>
                        <td>
                            <input type="tel" name="tel" id="tel" placeholder="전화번호 입력" pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}" maxlength="19" required>
                        </td>
                    </tr>
                    <tr>
                        <th style="background-color:#dcdcdc">주소</th>
                        <td>
                            <input type="text" name="addr1" id="addr1" placeholder="기본주소 입력" maxlength="150" required><br><br>
                            <input type="text" name="addr2" id="addr2" placeholder="상세주소 입력" maxlength="90" required><br><br>
                            <input type="text" name="postcode" id="postcode" placeholder="우편번호 입력" maxlength="9" required>
                            <input type="button" id="isAddrBtn" class="button" value="주소 입력" onclick="findAddr()">
                            <input type="hidden" name="addrck" id="addrck" value="no"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" class="submit success button" value="회원 가입" >
                            <input type="reset" class="reset button" value="취소" >
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <script>
                $(document).ready(function(){
                    $("#id").keyup(function(){
                        $("#idck").val("no");
                        if($(this).val()!=""){
                            $("#msg").html("<strong>아이디 입력중입니다.</strong>");
                        } else {
                            $("#msg").html("아직 아이디 중복 체크를 하지 않으셨습니다.");
                        }
                    });
                });
            </script>
            <script>
                function idCheck(){
                    if($("#id").val()==""){
                        alert("아이디를 입력하지 않으셨습니다.");
                        $("#id").focus();
                        return;
                    }
                    var params = {	id : $("#id").val()	} //전송되어질 데이터를 객체로 묶음
                    $.ajax({
                        url:"${path1 }/member/idCheck.do",	//아이디가 전송되어질 곳
                        type:"post",		//전송방식
                        dataType:"json",	//데이터 반환 방식
                        data:params,		//전송방식이 post인 경우 객체로 묶어서 전송
                        success:function(result){
                            console.log(result.result);
                            var idChk = result.result;	//true 또는 false를 받음
                            if(idChk==false){	//사용할 수 없는 아이디
                                $("#idck").val("no");
                                $("#msg").html("<strong style='color:red'>기존에 사용되고 있는 아이디 입니다. 다시 입력하시기 바랍니다.</strong>");
                                $("#id").focus();
                            } else if(idChk==true){	//사용 가능한 아이디
                                $("#idck").val("yes");
                                $("#msg").html("<strong style='color:blue'>사용가능한 아이디 입니다.</strong>");
                            } else if(idck==""){
                                $("#msg").html("<strong>아이디가 확인되지 않았습니다. 다시 시도해주시기 바랍니다.</strong>");
                            }
                        }
                    });
                }
                function joinCheck(f){
                    if(f.pw.value!=f.pw2.value){
                        alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
                        f.pw.focus();
                        return false;
                    }
                    if(f.idck.value!="yes"){
                        alert("아이디 중복 체크를 하지 않으셨습니다.");
                        return false;
                    }
                }
            </script>
            <script>
                function findAddr() {
                    new daum.Postcode({
                        oncomplete: function(data) {
                            console.log(data);
                            var roadAddr = data.roadAddress;
                            var jibunAddr = data.jibunAddress;
                            document.getElementById("postcode").value = data.zonecode;
                            if(roadAddr !== '') {
                                document.getElementById("addr1").value = roadAddr;
                            } else if(jibunAddr !== ''){
                                document.getElementById("addr1").value = jibunAddr;
                            }
                            document.getElementById("addr2").focus();
                        }
                    }).open();
                }
            </script>
            <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        </div>
    </div>
</div>
    <!-- 푸터 부분 인클루드 -->
    <jsp:include page="../include/ft.jsp"></jsp:include>
</div>
</body>
</html>