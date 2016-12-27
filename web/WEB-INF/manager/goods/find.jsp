<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>

</head>
<body>
<div style="height: 100%">
    <table id="dg" title="商品信息" class="easyui-datagrid"
           fitColumns="true" pagination="true" rownumbers="false"
           url="${pageContext.request.contextPath}/showAllGoods.do" fit="true" toolbar="#tb"
           style="height: 100%">
        <thead>
        <tr>
            <th field="id" width="50" align="center">商品编号</th>
            <th field="name" width="100" align="center">商品名称</th>
            <th field="price" width="100" align="center">商品价格</th>
            <th field="pic" width="100" align="center">商品详情</th>
            <th field="createtime" width="100" align="center">生产日期</th>
        </tr>
        </thead>
    </table>
</div>
<%--<button id="batchDeleteBtn" type="button" class="btn btn-success pull-left">删除</button>--%>
</body>
</html>
