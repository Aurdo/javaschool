<%@ page import="domain_objects.Category" %>

<%--
  Created by IntelliJ IDEA.
  AuthUser: Shichirin
  Date: 03.02.14
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <style>
        body {
            width: 950px;
            margin: 0 auto;
        }

        #header-backend {
            border: 2px solid;
            height: 25px;
            margin: 0 auto;
        }

        #menu {
            width: 240px;
            border: 2px solid;
            float: left;
        }

        #menu ul {
            list-style: none;
            padding: 0px;
        }

        #menu ul li a {
            padding-left: 5px;
            color: black;
            text-decoration: none;
        }

        #menu ul li:hover {
            background-color: #808080;
            color: #ffffff
        }

        .inner-content {
            float: left;
            margin: 15px 0px 8px 20px
        }
    </style>

</head>
<body>
<div id="header-backend"></div>
<div id="content">
    <div id="menu">
        <ul>
            <li><a href="/backend/category">Categories</a></li>
        </ul>
    </div>
    <div class="inner-content">
        <%
            Category category = (Category) request.getAttribute("cat");
        %>
        <form method="post" action="/backend/category/edit/<%=category.getId()%>">
            <p style="width: 50px;"><label>Name</label>
                <input name="name" value="<%=category.getName()%>"></p>

            <p style="width: 50px;"><label>Description</label>
                <input name="description" value="<%=category.getDescription()%>"></p>

            <p>
                <button>Save</button>
            </p>
        </form>
    </div>
</div>
<div id="footer"></div>
</body>
</html>