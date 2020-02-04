<%@ page import="java.util.List" isELIgnored="false" %>
<%@ page import="org.itstep.db.Post"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="include/header.jsp"/>
</head>

<body>

<!-- Navigation -->
<c:import url="include/navigation.jsp"/>
<!-- Page Header -->
<header class="masthead" style="background-image: url('static/img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="site-heading">
                    <h1>Clean Blog</h1>
                    <span class="subheading">A Blog Theme by Start Bootstrap</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-8 col-md-10 mx-auto">
            <c:forEach var="post" items='${requestScope.posts}'>
                <div class="post-preview">
                    <a href="post">
                        <h2 class="post-title">
                                <%--              Man must explore, and this is exploration at its greatest--%>
                                ${post.title}
                        </h2>
                        <c:if test="${!post.getSubTitle()}">
                            <h3 class="post-subtitle">
                                    <%--              Problems look mighty small from 150 miles up--%>
                                    ${post.subTitle}
                            </h3>
                        </c:if>
                    </a>
                    <p class="post-meta">Posted by
                        <a href="#">
                                ${post.author}
                        </a>
                           on ${post.published}
                    </p>
                </div>
                <hr>
            </c:forEach>

            <%--        <div class="post-preview">--%>
            <%--          <a href="post.jsp">--%>
            <%--            <h2 class="post-title">--%>
            <%--              I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.--%>
            <%--            </h2>--%>
            <%--          </a>--%>
            <%--          <p class="post-meta">Posted by--%>
            <%--            <a href="#">Start Bootstrap</a>--%>
            <%--            on September 18, 2019</p>--%>
            <%--        </div>--%>
            <%--        <hr>--%>
            <%--        <div class="post-preview">--%>
            <%--          <a href="post.jsp">--%>
            <%--            <h2 class="post-title">--%>
            <%--              Science has not yet mastered prophecy--%>
            <%--            </h2>--%>
            <%--            <h3 class="post-subtitle">--%>
            <%--              We predict too much for the next year and yet far too little for the next ten.--%>
            <%--            </h3>--%>
            <%--          </a>--%>
            <%--          <p class="post-meta">Posted by--%>
            <%--            <a href="#">Start Bootstrap</a>--%>
            <%--            on August 24, 2019</p>--%>
            <%--        </div>--%>
            <%--        <hr>--%>
            <%--        <div class="post-preview">--%>
            <%--          <a href="post.jsp">--%>
            <%--            <h2 class="post-title">--%>
            <%--              Failure is not an option--%>
            <%--            </h2>--%>
            <%--            <h3 class="post-subtitle">--%>
            <%--              Many say exploration is part of our destiny, but it’s actually our duty to future generations.--%>
            <%--            </h3>--%>
            <%--          </a>--%>
            <%--          <p class="post-meta">Posted by--%>
            <%--            <a href="#">Start Bootstrap</a>--%>
            <%--            on July 8, 2019</p>--%>
            <%--        </div>--%>
            <%--        <hr>--%>
            <!-- Pager -->
            <div class="clearfix">
                <a class="btn btn-primary float-right" href="#">Older Posts &rarr;</a>
            </div>
        </div>
    </div>
</div>
<hr>
<!-- Footer -->
<c:import url="include/footer.jsp"/>
<!-- Bootstrap core JavaScript -->
<script src="static/vendor/jquery/jquery.min.js"></script>
<script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="static/js/clean-blog.min.js"></script>
<c:import url="include/logOut.jsp"/>
</body>

</html>
