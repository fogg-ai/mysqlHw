<%@ page import="java.util.List" %>
<%@ page import="org.itStep.db.Post" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@include file="include/head.jsp" %>
</head>

<body>

<!-- Navigation -->
<%@include file="include/navigator.jsp" %>


<% List<Post> posts = (List<Post>) request.getAttribute("posts"); %>
<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">Page Heading
                <small>Secondary Text</small>
            </h1>

            <!-- Blog Post -->
            <% for (Post post : posts){ %>
            <div class="card mb-4">
                <img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap">
                <div class="card-body">
                    <h2 class="card-title"><%= post.getTitle() %></h2>
                    <p class="card-text"><%=post.getContent() %></p>
                    <a href="#" class="btn btn-primary">Read More &rarr;</a>
                </div>
                <div class="card-footer text-muted">
                    <%=post.getPublished() %>
                    <a href="#">Start Bootstrap</a>
                </div>
            </div>
            <%}%>

            <!-- Pagination -->
            <ul class="pagination justify-content-center mb-4">
                <li class="page-item">
                    <a class="page-link" href="#">&larr; Older</a>
                </li>
                <li class="page-item disabled">
                    <a class="page-link" href="#">Newer &rarr;</a>
                </li>
            </ul>

        </div>

        <!-- Sidebar Widgets Column -->
        <%@include file="include/sidebar.jsp" %>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->
<%@include file="include/footer.jsp" %>

<!-- Bootstrap core JavaScript -->
<script src="static/vendor/jquery/jquery.min.js"></script>
<script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
