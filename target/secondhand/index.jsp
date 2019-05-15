<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <h1>WHU供需平台</h1>

            <form class="form" action="${path}/user/checkLogin" method="post" id="myform">
                <input type="text" id="username" name="username" placeholder="Username"/>
                <input type="password" id="userpassword" name="userpassword" placeholder="Password"/>
                <button type="submit" id="login-button">Login</button>
            </form>
        </div>

        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>

<%--<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>--%>
<%--<script>--%>
<%--    $('#login-button').click(function (event) {--%>
<%--        event.preventDefault();--%>
<%--        $('form').fadeOut(500);--%>
<%--        $('.wrapper').addClass('form-success');--%>
<%--    });--%>
<%--</script>--%>

<%--<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">--%>
<%--    <h1>数据管理系统</h1>--%>
<%--</div>--%>
</body>
</html>