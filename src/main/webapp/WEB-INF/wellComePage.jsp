<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-10-26
  Time: 오후 7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="includes/header.jsp" %>
    <title>Wellcome Page</title>
</head>

<body>

<!doctype html>
<html lang="en">
<head>
    <%@include file="includes/header.jsp"%>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/carousel/">
    <!-- Custom styles for this template -->

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <link href="/resources/css/carousel.css" rel="stylesheet">
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<main role="main">
    <!-- carousel zone -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
<%--                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg>--%>
                <img src="/resources/images/ivyleague_cut.jpg" max-width="200">
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h1>아이비 리그 컷</h1>
                        <p style="color:black">당신은 유아인이 아닙니다. 이 머리를 고민하고 있다면 포기하세요</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">그냥 버튼</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="/resources/images/wolf_cut.jpg" width="400" height="100%">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>울프 컷</h1>
                        <p>연예인이 하니까 잘어울리는거지 당신이 하면 양아치 머리입니다. 무난하게 투블럭이나 하십쇼</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">그냥 버튼</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img src="/resources/images/shadow_pama.jpg" width="50%" height="100%">
                <div class="container">
                    <div class="carousel-caption text-right">
                        <h1>쉐도우 펌</h1>
                        <p>너가 하면 개털머리됨.</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">그냥 버튼</a></p>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <!-- carousel zone end. -->

    <!-- card zone -->

    </div>
    <div class="row row-cols-1 row-cols-md-3">
        <c:if test="${not empty shops}">
            <c:forEach var="shop" items="${shops}">
                <div class="col mb-4">
                    <div class="card">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${shop.storeName}</h5>
                            <p class="card-text"> 지역 : ${shop.local}</p>
                            <p class="card-text">어떤 미용실인지 대충 설명</p>
                            <a class="btn btn-secondary" href="/beautyShopDetailPage?id=${shop.DB_Id}" role="button">보러가기</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <c:if test="${empty shops}">
    <blockquote class="blockquote text-center">
        <p class="mb-0">등록된 미용실이 없습니다...</p>
        <footer class="blockquote-footer">관리자</footer>
    </blockquote>
    </c:if>

    <!-- card zone end -->

    <!-- 디자인 이뻐서 일단 킵해놓음 start -->
    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <%--    <div class="container marketing">--%>

    <%--        <!-- Three columns of text below the carousel -->--%>
    <%--        <div class="row">--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>--%>
    <%--                <h2>Heading</h2>--%>
    <%--                <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>--%>
    <%--                <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>--%>
    <%--            </div><!-- /.col-lg-4 -->--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>--%>
    <%--                <h2>Heading</h2>--%>
    <%--                <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>--%>
    <%--                <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>--%>
    <%--            </div><!-- /.col-lg-4 -->--%>
    <%--            <div class="col-lg-4">--%>
    <%--                <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 140x140"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>--%>
    <%--                <h2>Heading</h2>--%>
    <%--                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>--%>
    <%--                <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>--%>
    <%--            </div><!-- /.col-lg-4 -->--%>
    <%--        </div><!-- /.row -->--%>

<%--        <!-- START THE FEATURETTES -->--%>

<%--        <hr class="featurette-divider">--%>

<%--        <div class="row featurette">--%>
<%--            <div class="col-md-7">--%>
<%--                <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It’ll blow your mind.</span></h2>--%>
<%--                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>--%>
<%--            </div>--%>
<%--            <div class="col-md-5">--%>
<%--                <svg class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 500x500"><title>Placeholder</title><rect width="100%" height="100%" fill="#eee"/><text x="50%" y="50%" fill="#aaa" dy=".3em">500x500</text></svg>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <hr class="featurette-divider">--%>

<%--        <div class="row featurette">--%>
<%--            <div class="col-md-7 order-md-2">--%>
<%--                <h2 class="featurette-heading">Oh yeah, it’s that good. <span class="text-muted">See for yourself.</span></h2>--%>
<%--                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>--%>
<%--            </div>--%>
<%--            <div class="col-md-5 order-md-1">--%>
<%--                <svg class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 500x500"><title>Placeholder</title><rect width="100%" height="100%" fill="#eee"/><text x="50%" y="50%" fill="#aaa" dy=".3em">500x500</text></svg>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <hr class="featurette-divider">--%>

<%--        <div class="row featurette">--%>
<%--            <div class="col-md-7">--%>
<%--                <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>--%>
<%--                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>--%>
<%--            </div>--%>
<%--            <div class="col-md-5">--%>
<%--                <svg class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 500x500"><title>Placeholder</title><rect width="100%" height="100%" fill="#eee"/><text x="50%" y="50%" fill="#aaa" dy=".3em">500x500</text></svg>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <hr class="featurette-divider">--%>

<%--        <!-- /END THE FEATURETTES -->--%>
<%--    </div><!-- /.container -->--%>
    <!-- 디자인 이뻐서 일단 킵해놓음 end -->
</main>
<%@ include file="includes/footer.jsp"%>
</body>
</html>
