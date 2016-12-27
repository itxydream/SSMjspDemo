<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>
<body class="container " style="width:50%;height:40%;margin: 50px auto;">
<form class="form-horizontal" action="${pageContext.request.contextPath}/deleteGoods.do" method="post">
    <div class="form-group">
        <label class="col-sm-2 control-label">商品编号</label>
        <div class="col-sm-10">
            <input type="text"  class="form-control" name="id" >
        </div>
    </div>
    <input type="submit" class="btn btn-success pull-right" value="确认删除">
</form>
</body>
</html>
