<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" >
    <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>
    <title>管理员登录</title>
</head>
<%--http://www.bz55.com/uploads/allimg/140818/138-140QQ35K9-50.jpg--%>
<body background="http://file.mumayi.com/forum/201305/23/164449hz47vl5bq4k94kq7.jpg">
<div class="container" style="margin: 0 auto;">
    <div class="col-md-8"></div>
    <div class="col-md-4" style="margin-top: 200px">

        <form action="../emp/login.do" method="post">
            <h4><a href="${pageContext.request.contextPath }/userLogin.jsp">用户登录</a>&nbsp;&nbsp;&nbsp;管理员登录</h4><br>
            <div class="form-group">
                <input type="text" class="form-control" name="empName" placeholder="手机号/会员名/邮箱">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="empPwd" placeholder="密码">
            </div>
            <button type="submit" class="btn btn-danger btn-block">登录</button>
            <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">忘记密码</a>&nbsp;&nbsp;&nbsp;<a href="#">免费注册</a>
        </form>
    </div>
</div>
</body>
</html>
