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
    <title>자료실 글 등록</title>
    <jsp:include page="../include/head.jsp"></jsp:include>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div id="app">
    <%-- include header.jsp --%>
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
                    <li><a href="#">FileBoard</a></li>
                    <li>
                        <span class="show-for-sr">Current: </span> FileBoard Detail
                    </li>
                </ul>
            </nav>
            <div class="row">
                <h2 class="title">자료실 글쓰기</h2>
                <hr style="margin-bottom: 50px;">
                <form class="col s12 l6 offset-l3" action="${path1}/fileboard/write.do" method="post" enctype="multipart/form-data">
    <%--                <input type="hidden" name="curpage" value="${curpage}">--%>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">assignment_ind</i>
                            <input type="text" id="member_id" readonly name="author" value="${sid}">
                            <label for="member_id">작성자</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">subtitles</i>
                            <input type="text" id="title" class="validate" name="title">
                            <label for="title">제목</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">subject</i>
                            <textarea id="textarea1" class="materialize-textarea" name="content"></textarea>
                            <label for="textarea1">내용</label>
                        </div>
                    </div>

                    <div class="row">
                        <button type="button" class="button waves-effect waves-light" id="btnAddFile">파일 추가</button>
                    </div>

                    <div class="row" id="fileContainer">
                        <div class="file-field input-field col s12">
                            <div class="button">
                                <span><i class="material-icons left">attach_file</i>첨부 파일</span>
                                <input type="file" name="files" multiple>
                            </div>
                            <div class="file-path-wrapper">
                                <input type="text" class="file-path validate">
                            </div>
                            <span class="helper-text">첨부파일로 업로드 가능한 용량은 최대 50MB 입니다.</span>
                        </div>
                    </div>


                    <div class="row center-align">
                        <div class="col s12 l8 offset-l2">
                            <div class="col s6">
                                <button type="submit" class="button waves-effect waves-light">
                                    <i class="material-icons left">file_upload</i>
                                    새글 등록
                                </button>
                            </div>
                            <div class="col s6">
                                <a class="button waves-effect waves-light" href="${path1}/fileboard/list.do?pageNum=${ pageNum }">
                                    <i class="material-icons left">list</i>
                                    글목록
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <blockquote>
                            [새글 등록] 버튼을 눌러서 새 글을 등록해 보세요.<br>
                            새글쓰기를 하지 않고 글목록으로 가시려면 [글목록] 버튼을 누르세요.
                        </blockquote>
                    </div>
                </form>
            </div>
        </div>
        <!-- end of Forms -->
    </div>
    <!-- end of Container -->

    <!-- Footer -->
    <%-- include footer.jsp --%>
    <jsp:include page="../include/ft.jsp"></jsp:include>
    <!-- end of Footer -->

</div>
<!-- end of App -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script>
    const sideNav = document.querySelector('.sidenav');
    M.Sidenav.init(sideNav, {});
</script>
<script>
    var fileContainer = document.querySelector('#fileContainer');
    var btnAddFile = document.querySelector('#btnAddFile');
    var fileCount = 1; // 첨부파일 선택상자 개수
    btnAddFile.addEventListener('click', function () {
        if (fileCount >= 5) {
            alert('첨부파일은 최대 5개까지만 업로드 가능합니다.')
            return;
        }
        fileCount++; // 추가된 첨부파일 선택상자 개수 반영
        var input = `
            <div class="file-field input-field col s12">
                <div class="btn">
                    <span><i class="material-icons left">attach_file</i>첨부 파일</span>
                    <input type="file" name="files" multiple>
                </div>
                <div class="file-path-wrapper">
                    <input type="text" class="file-path validate">
                </div>
                <span class="helper-text">첨부파일로 업로드 가능한 용량은 최대 50MB 입니다.</span>
            </div>
    		`;
        fileContainer.innerHTML += input;
    });
</script>
</body>
</html>
