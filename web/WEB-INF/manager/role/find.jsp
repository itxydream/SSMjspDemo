<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>

</head>
<body>
<div style="height: 100%">
    <table id="dg" title="角色信息" class="easyui-datagrid"
           fitColumns="true" pagination="true" rownumbers="false"
           url="${pageContext.request.contextPath}/role/findRole.do" fit="true" toolbar="#tb"
           style="height: 100%">
        <thead>
        <tr>
            <th field="cb" checkbox="true" align="center"></th>
            <th field="id" width="50" align="center">编号</th>
            <th field="name" width="100" align="center">角色名</th>
        </tr>
        </thead>
    </table>
</div>
<%--按钮--%>
<div id="tb">
    <div>
        <a id="add" href="#" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openRoleModifyDialog()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteRole()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">删除</a>
        <a href="javascript:openRoleMenuDialog()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">权限分配</a>
    </div>
</div>
<%--添加时弹出的页面--%>
<div id="dlg" class="easyui-dialog" style="width:620px;height:=250px;padding:10px 20px"
     closed="true">
    <form method="post" action="${pageContext.request.contextPath}/role/addRole.do">
        <div class="form-group has-success has-feedback">
            <label class="control-label">角色名：</label>
            <input type="text" class="form-control" placeholder="请输入您要添加的角色名"
                   required="required" name="roleName">
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <input type="submit" value="保存" class="btn btn-success">
    </form>
</div>
<script type="text/javascript">
    <c:if test="${flag!=null}">
    <c:if test="${flag}">
    alert("添加成功！");
    </c:if>
    <c:if test="${!flag}">
    alert("添加失败！");
    </c:if>
    </c:if>
    $("#add").on("click", function () {
        $("#dlg").dialog("open").dialog("setTitle", "添加新角色");
        <%--location.href = "${pageContext.request.contextPath}/urlTrans.do?url=role/add.jsp";--%>
    });

</script>
</body>
</html>
