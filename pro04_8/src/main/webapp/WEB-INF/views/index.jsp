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
    <title>메인</title>
    <!-- 헤드 부분 인클루드 -->
    <jsp:include page="./include/head.jsp"></jsp:include>
    <style>
    .orbit-caption { bottom:30%; background-color: rgba(255,215,0,0.5); }
    .orbit-bullets { position: absolute; bottom: 10%; z-index: 30; left: 50%; margin-left: -50px; }
    .orbit-bullets button { background-color: #999; }
    .orbit-bullets button.is-active { background-color:deepskyblue; opacity:0.8; }
    </style>
</head>
<body>
<div class="container is-fullhd">
    <!-- 헤더 부분 인클루드 -->
    <jsp:include page="./include/hd.jsp"></jsp:include>
    <div class="orbit" role="region" aria-label="Favorite Space Pictures" data-orbit="" data-options="animInFromLeft:fade-in; animInFromRight:fade-in; animOutToLeft:fade-out; animOutToRight:fade-out;" data-resize="qa57d9-orbit" id="qa57d9-orbit" data-e="9eilbx-e">
        <ul class="orbit-container" tabindex="0" style="height:600px;">
            <button class="orbit-previous" tabindex="0"><span class="show-for-sr">Previous Slide</span>◀︎</button>
            <button class="orbit-next" tabindex="0"><span class="show-for-sr">Next Slide</span>▶︎</button>
            <li class="orbit-slide" data-slide="0" style="display: none; position: relative; top: 0px;">
                <img class="orbit-image" src="https://placehold.it/2000x600&amp;text=1st" alt="Space">
                <figcaption class="orbit-caption">Space, the final frontier.</figcaption>
            </li>
            <li class="orbit-slide" data-slide="1" style="position: relative; top: 0px; display: none;">
                <img class="orbit-image" src="https://placehold.it/2000x600&amp;text=2nd" alt="Space">
                <figcaption class="orbit-caption">Lets Rocket!</figcaption>
            </li>
            <li class="orbit-slide" data-slide="2" style="position: relative; top: 0px; display: none;">
                <img class="orbit-image" src="https://placehold.it/2000x600&amp;text=3nd" alt="Space">
                <figcaption class="orbit-caption">Encapsulating</figcaption>
            </li>
            <li class="orbit-slide is-active" data-slide="3" style="position: relative; top: 0px; display: block;" aria-live="polite">
                <img class="orbit-image" src="https://placehold.it/2000x600&amp;text=4nd" alt="Space">
                <figcaption class="orbit-caption">Outta This World</figcaption>
            </li>
        </ul>
        <nav class="orbit-bullets">
            <button class="" data-slide="0"><span class="show-for-sr">First slide details.</span></button>
            <button data-slide="1" class=""><span class="show-for-sr">Second slide details.</span></button>
            <button data-slide="2" class=""><span class="show-for-sr">Third slide details.</span></button>
            <button data-slide="3" class="is-active"><span class="show-for-sr">Fourth slide details.</span><span class="show-for-sr">Current Slide</span></button>
        </nav>
        <script>
        $(document).ready(function(){
            var ht = $(window).height() - 52;
            $(".orbit-image").height(ht);
            $(".orbit-image").each(function(index){
                $(this).attr("src", "https://placehold.it/2000x"+ht+"&amp;text="+(index+1));
                console.log("https://placehold.it/2000x"+ht+"&amp;text="+(index+1))
            });
            $(".orbit-container").height(ht);
        });
        </script>
    </div>
    <div class="content" id="contents">
        <div class="text-center">
            <h2>Our Newest Products</h2>
            <hr>
        </div>
    </div>
    <article class="grid-container">
        <div class="grid-x grid-margin-x small-up-2 medium-up-2 large-up-4">
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/500x600">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button expanded">Buy</a>
            </div>
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/500x600">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button expanded">Buy</a>
            </div>
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/500x600">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button expanded">Buy</a>
            </div>
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/500x600">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button expanded">Buy</a>
            </div>
        </div>

        <hr>

        <div class="grid-x cell">
            <div class="callout small-12 primary">
                <h3>Really big special this week on items.</h3>
            </div>
        </div>

        <hr>

        <div class="text-center">
            <h2>Some Other Neat Products</h2>
            <hr>
        </div>

        <div class="grid-x grid-margin-x small-up-2 medium-up-3 large-up-6">
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/300x400">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button small expanded hollow">Buy</a>
            </div>
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/300x400">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button small expanded hollow">Buy</a>
            </div>
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/300x400">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button small expanded hollow">Buy</a>
            </div>
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/300x400">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button small expanded hollow">Buy</a>
            </div>
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/300x400">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button small expanded hollow">Buy</a>
            </div>
            <div class="cell">
                <img class="thumbnail" src="https://placehold.it/300x400">
                <h5>Nulla At Nulla Justo, Eget</h5>
                <p>$400</p>
                <a href="#" class="button small expanded hollow">Buy</a>
            </div>
        </div>

        <hr>
        <div class="grid-x align-bottom">
            <div class="medium-4 cell">
                <h4>Top Products</h4>
                <div class="media-object">
                    <div class="media-object-section">
                        <img class="thumbnail" src="https://placehold.it/100x100">
                    </div>
                    <div class="media-object-section">
                        <h5>Nunc Eu Ullamcorper Orci</h5>
                        <p>Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque.</p>
                    </div>
                </div>
                <div class="media-object">
                    <div class="media-object-section">
                        <img class="thumbnail" src="https://placehold.it/100x100">
                    </div>
                    <div class="media-object-section">
                        <h5>Nunc Eu Ullamcorper Orci</h5>
                        <p>Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque.</p>
                    </div>
                </div>
                <div class="media-object">
                    <div class="media-object-section">
                        <img class="thumbnail" src="https://placehold.it/100x100">
                    </div>
                    <div class="media-object-section">
                        <h5>Nunc Eu Ullamcorper Orci</h5>
                        <p>Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque.</p>
                    </div>
                </div>
            </div>
            <div class="medium-4 cell">
                <div class="media-object">
                    <div class="media-object-section">
                        <img class="thumbnail" src="https://placehold.it/100x100">
                    </div>
                    <div class="media-object-section">
                        <h5>Nunc Eu Ullamcorper Orci</h5>
                        <p>Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque.</p>
                    </div>
                </div>
                <div class="media-object">
                    <div class="media-object-section">
                        <img class="thumbnail" src="https://placehold.it/100x100">
                    </div>
                    <div class="media-object-section">
                        <h5>Nunc Eu Ullamcorper Orci</h5>
                        <p>Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque.</p>
                    </div>
                </div>
                <div class="media-object">
                    <div class="media-object-section">
                        <img class="thumbnail" src="https://placehold.it/100x100">
                    </div>
                    <div class="media-object-section">
                        <h5>Nunc Eu Ullamcorper Orci</h5>
                        <p>Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque.</p>
                    </div>
                </div>
            </div>
            <div class="medium-4 cell">
                <div class="media-object">
                    <div class="media-object-section">
                        <img class="thumbnail" src="https://placehold.it/100x100">
                    </div>
                    <div class="media-object-section">
                        <h5>Nunc Eu Ullamcorper Orci</h5>
                        <p>Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque.</p>
                    </div>
                </div>
                <div class="media-object">
                    <div class="media-object-section">
                        <img class="thumbnail" src="https://placehold.it/100x100">
                    </div>
                    <div class="media-object-section">
                        <h5>Nunc Eu Ullamcorper Orci</h5>
                        <p>Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque.</p>
                    </div>
                </div>
                <div class="media-object">
                    <div class="media-object-section">
                        <img class="thumbnail" src="https://placehold.it/100x100">
                    </div>
                    <div class="media-object-section">
                        <h5>Nunc Eu Ullamcorper Orci</h5>
                        <p>Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque.</p>
                    </div>
                </div>
            </div>
        </div>
    </article>
    <!-- 푸터 부분 인클루드 -->
    <jsp:include page="./include/ft.jsp"></jsp:include>
</div>
</body>
</html>