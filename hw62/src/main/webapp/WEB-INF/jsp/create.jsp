<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <c:import url="include/header.jsp"/>
    <link href="static/css/formPost.css" rel="stylesheet"/>
</head>

<body>

<!-- Navigation -->
<c:import url="include/navigation.jsp"/>

<!-- Page Header -->
<header class="masthead" style="background-image: url('static/img/post-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="post-heading">
                    <h1>Man must explore, and this is exploration at its greatest</h1>
                    <h2 class="subheading">Problems look mighty small from 150 miles up</h2>
                    <span class="meta">Posted by
              <a href="#">Start Bootstrap</a>
              on August 24, 2019</span>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Post Content -->
<article>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="add">
                    <h2>Add </h2>
                    <form method="post" action="create">
                        <table>
                            <tr>
                                <td>
                                    <label for="titleAdd"> Title </label>
                                </td>
                                <td><input id="titleAdd" name="title"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="subtitleAdd"> Subtitle </label>
                                </td>
                                <td><input id="subtitleAdd" name="subtitle"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="autorAdd"> Author</label>
                                </td>
                                <td><input id="autorAdd" name="author"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="contAdd"> Content </label>
                                </td>
                                <td><textarea id="contAdd" name="content"></textarea></td>
                            </tr>
                        </table>
                        <button class="butPost" type="submit">Add</button>
                    </form>
                </div>
                <div class="replace">
                    <h2>Replace </h2>
                    <form method="post"  action="replace">
                        <table>
                            <tr>
                                <td>
                                    <label for="titleRep"> Title </label>
                                </td>
                                <td><input placeholder="Enter post title to replace" id="titleRep" name="title"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="titleNewRep"> New Title </label>
                                </td>
                                <td><input placeholder="New title" id="titleNewRep" name="titleNew"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="subtitleRep"> Subtitle </label>
                                </td>
                                <td><input id="subtitleRep" name="subtitle"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="autorRep"> Author</label>
                                </td>
                                <td><input id="autorRep" name="author"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="contRep"> Content </label>
                                </td>
                                <td><textarea id="contRep" name="content"></textarea></td>
                            </tr>
                        </table>
                        <button class="butPost" type="submit">Replace</button>
                    </form>
                </div>
                <div class="delete">
                    <form method="post" action="delete">
                        <h2>Delete </h2>
                        <table>
                            <tr>
                                <td>
                                    <label  for="titleDelete"> Title </label>
                                </td>
                                <td><input placeholder="Enter post title to delete" id="titleDelete" name="title"/></td>
                            </tr>
                        </table>
                        <button class="butPost" type="submit">Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</article>

<hr>

<!-- Footer -->
<c:import url="include/footer.jsp"/>
<!-- Bootstrap core JavaScript -->
<script src="static/vendor/jquery/jquery.min.js"></script>
<script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="static/js/clean-blog.min.js"></script>
<c:import url="include/logOut.jsp"/>
<c:import url="include/adminCount.jsp"/>
</body>

</html>
