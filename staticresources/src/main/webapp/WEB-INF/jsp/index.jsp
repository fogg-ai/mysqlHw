<html lang="en">
<head>
    <title>Registration</title>
    <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet"/>
</head>
<body>
<form action="<%=request.getContextPath()%>/" method="post">
    <p>Registration</p>
    <div>
        <label for="login">Login</label>
        <input name="login" id="login"/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password"/>
    </div>
    <input type="submit" value="Sing Up"/>
</form>
<form action="<%=request.getContextPath()%>/user" method="post">
    <p>Entry</p>
    <div>
        <label for="loginE">Login</label>
        <input name="loginE" id="loginE"/>
    </div>
    <div>
        <label for="passwordE">Password</label>
        <input type="password" name="passwordE" id="passwordE"/>
    </div>
    <input type="submit" value="Sing in"/>
</form>
</body>
</html>
