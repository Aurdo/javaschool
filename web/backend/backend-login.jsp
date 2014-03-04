<%@ page import="java.util.ArrayList" %>
<%@ page import="domain_objects.User" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/backend-style.css"/>
</head>
<body>
<div id="backend-login">
    <form action="" method="post">
        <div class="inputs">
            <input name="username" autocomplete="off" placeholder="Username">
            <input name="password" type="password" placeholder="Password">
        </div>
        <div class="post-button">
            <button type="submit">Login</button>
        </div>

        <%=request.getAttribute("error") != null ? request.getAttribute("error") : ""%>
    </form>

</div>
</body>
</html>