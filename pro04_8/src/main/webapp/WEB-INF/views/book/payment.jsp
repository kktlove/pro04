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
    <title>교재 구입하기</title>
    <jsp:include page="../include/head.jsp"></jsp:include>
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
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
                    <span class="show-for-sr">Current: </span> Book Insert
                </li>
            </ul>
        </nav>
        <form action="${path1}/book/sales.do" method="post">
            <h2 class="title">교재 구입하기</h2>
            <hr>
            <table class="inner-table">
                <tbody>
                <tr>
                    <th>교재명</th>
                    <td>
                        <input type="hidden" id="pno" name="pno" value="${book.bookno}" />
                        <input type="text" id="title" name="title" value="${book.title}" readonly />
                        <input type="hidden" id="ptype" name="ptype" value="1" />
                        <input type="hidden" id="id" name="id" value="${sid}">
                        <input type="hidden" id="email" name="email" value="${semail}">
                        <input type="hidden" id="stel" name="stel" value="${stel}">
                    </td>
                </tr>
                <tr>
                    <th>가격</th>
                    <td>
                        <input type="number" id="price" name="price" value="${book.price}" readonly>
                    </td>
                </tr>
                <tr>
                    <th>구매 수량</th>
                    <td>
                        <c:if test="${book.amount<=0 or (empty book.amount)}">
                            <div style="color:red;font-weight: bold">품절</div>
                        </c:if>
                        <c:if test="${book.amount>=1}">
                            <input type="number" id="amount" name="amount" min="1" value="1" max="${book.amount}" required>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>결제할 금액</th>
                    <td>
                        <input type="text" id="money" name="money" readonly required>
                        <input type="hidden" id="spass" name="spass" value="nopay">
                    </td>
                </tr>
                <tr>
                    <th>결제 방법</th>
                    <td>
                        <select name="stype" id="stype">
                            <option value="0" selected>선택안함</option>
                            <option value="credit">신용카드</option>
                            <option value="check">체크카드</option>
                            <option value="bank">계좌이체</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>해당 금융 기관</th>
                    <td>
                        <select name="scom" id="scom">
                            <option value="0" selected>선택안함</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th><p id="paytype-text">결제 카드/계좌 번호</p></th>
                    <td>
                        <input type="text" name="snum" id="snum" required>
                        <div id="smsg"></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="button" onclick="return paymentPOST();" class="button" value="결제하기"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><h3>배송 사항 입력</h3></td>
                </tr>
                <tr>
                    <th>받는 사람 연락처</th>
                    <td>
                        <input type="text" name="tel" id="tel" required>
                    </td>
                </tr>
                <tr>
                    <th style="background-color:#dcdcdc">주소</th>
                    <td>
                        <input type="text" name="addr1" id="addr1" placeholder="기본주소 입력" maxlength="150" required><br>
                        <input type="text" name="addr2" id="addr2" placeholder="상세주소 입력" maxlength="90" required><br>
                        <input type="text" name="postcode" id="postcode" placeholder="우편번호 입력" maxlength="9" required>
                        <input type="button" id="isAddrBtn" class="button" value="주소 입력" onclick="findAddr()">
                        <input type="hidden" name="addrck" id="addrck" value="no"/>
                    </td>
                </tr>
                <tr>
                    <th>요청할 사항</th>
                    <td>
                        <textarea rows="3" name="cmemo" id="cmemo" maxlength="200"></textarea>
                    </td>
                </tr>
                </tbody>
            </table>
            <ul class="button-group" style="list-style:none;width:300px;margin:10px auto;">
                <li><a href="${path1}/book/list.do?curpage=1" class="button">교재 목록</a></li>
                <c:if test="${not empty sid}">
                    <c:if test="${book.amount>=1}">
                    <li><input type="submit" class="button" value="교재 주문 완료"></li>
                    </c:if>
                    <c:if test="${book.amount<=0 or (empty book.amount)}">
                        <li><div class="button" style="background-color:#aaa">품절</div></li>
                    </c:if>
                </c:if>
            </ul>
        </form>
        <script>
        $(document).ready(function(){
           $("#stype").change(function(){
               if($(this).val()=="credit"){
                   $("#snum").attr("placeholder", "신용카드 번호를 입력하세요");
               } else if($(this).val()=="check"){
                   $("#snum").attr("placeholder", "체크카드 번호를 입력하세요");
               } else if($(this).val()=="bank"){
                   $("#smsg").html("<strong>해당 계좌로 송금하시기 바랍니다.</strong>");
               } else {
                   $("#snum").attr("placeholder", "결제 방법을 선택하시기 바랍니다.");
               }
              $.ajax({
                  type:"GET",
                  url:"${path1}/book/payLoading.do?stype="+$("#stype").val(),
                  success:function(data){
                     $("#scom").empty();
                     $("#scom").append("<option value='0' selected>선택안함</option>");
                     var pat = "";
                     for(var i=0;i<data.length;i++) {
                         $("#scom").append("<option value='"+data[i].scom+"' data-val='"+data[i].scomn+"' selected>"+(data[i].scomn + ":" + data[i].scom)+"</option>");
                         pat = data[i].pat;
                     }
                     if($("#stype").val()!="bank") {
                         $("#snum").attr("pattern", pat);
                         $("#snum").removeProp("readonly");
                     }
                  },
                  error:function(err){
                    console.log(err);
                  }
              })
           });
            $("#money").val(parseInt($("#price").val())*parseInt($("#amount").val()));
           $("#amount").change(function(){
               $("#money").val(parseInt($("#price").val())*parseInt($("#amount").val()));
           });

            $("#scom").change(function(){
               if($("#stype").val()=="bank"){
                   $.ajax({
                       type:"GET",
                       contentType: "text/html; charset=UTF-8",
                       url:"${path1}/book/bankIdLoading.do?scom="+parseInt($("#scom option:selected").attr("data-val")),
                       success:function(data) {
                           console.log(data);
                            $("#snum").val(data);
                            $("#snum").attr("readonly","readonly");
                       },
                       error:function(err){
                           console.log(err);
                       }
                   });
               } else {
                   $("#snum").val("");
                   $("#smsg").html("<strong>결제할 카드 번호를 입력하시기 바랍니다.</strong>")
               }
            });
        });
        </script>
        <script>
        function check(){
            if( $("#id").val() == "" ){ // 로그인 아이디
                alert("로그인 후 이용 가능합니다.");
                return false;
            }else if( $("#stel").val() == "" ){ // 전화번호
                alert("전화번호를 입력하세요.");
                $("#tel").focus();
                return false;
            }
            else if( $("#stype option:selected").val() == "0" ){ // 메뉴
                alert("결제 방식을 선택하세요.");
                $("#stype option:selected").focus();
                return false;
            }else if( $("#scom option:selected").val() == "0" ){ // 타입
                alert("결제 기관을 선택하세요.");
                $("#scom option:selected").focus();
                return false;
            }else if( $("#snum").val()=="" ){ // 결제 카드 번호
                alert("결제 번호를 입력하세요.");
                $("#snum").focus();
                return false;
            }else if( $("#amount").val() <= 0 ){ // 갯수
                alert("구매 수량을 선택하세요.");
                $("#amount").focus();
                return false;
            }else{
                return true;
            } // if
        } // check()
        function paymentPOST(){
            var returnTF = check();
            if(returnTF == true){
                alert("잠시만 기다리시면 결제창이 열립니다.");
                var email = document.getElementById('email').value;
                var stel = document.getElementById('stel').value;
                var title = document.getElementById('title').value;
                var order_date = new Date();
                var amount = document.getElementById('amount').value;
                var price = document.getElementById('price').value;
                var money = price * amount;
                var message = document.getElementById('description').value;
                var stype = document.getElementById('stype').value;
                document.getElementById('money').value = money;
                IMP.init('imp30100127');
                IMP.request_pay({
                    pg : 'inicis', // version 1.1.0부터 지원.
                    pay_method : 'card',
                    merchant_uid : 'merchant_' + new Date().getTime(), // 영수증번호
                    name : title +': '+ price + "원",
                    amount : price, // 판매 가격
                    buyer_email : email,
                    buyer_name : '',
                    buyer_tel : stel,
                    buyer_addr : '',
                    buyer_postcode : ''
                }, function(rsp) {
                    if( rsp.success ) {
                        alert("결제가 완료되었습니다.");
                        document.getElementById("spass").value = "payok";
                    } else {
                        var msg = '결제에 실패하였습니다.';
                    }
                }); // request_pay
            } // if
        } // paymentPOST()
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
    <!-- 푸터 부분 인클루드 -->
    <jsp:include page="../include/ft.jsp"></jsp:include>
</div>
</body>
</html>