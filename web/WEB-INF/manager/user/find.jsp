<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/24
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
<title>菜单管理页面</title>
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

<table id="dg" title="用户管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="false"
       url="${pageContext.request.contextPath}/MenuListAction.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="name" width="100" align="center">用户名</th>
        <th field="pwd" width="100" align="center">密码</th>

    </tr>
    </thead>
</table>
<%--按钮--%>
<div id="tb">
    <div>
        <a id="add" href="#" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a id="updata" href="#" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>
        <a id="delete" href="#" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">删除</a>
        <a href="javascript:openRoleMenuDialog()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">权限分配</a>
    </div>
</div>
<%--添加时弹出的页面--%>
<div id="dlg" class="easyui-dialog" style="width:620px;height:250px;padding:10px 20px"
     closed="true">
    <form method="post" action="${pageContext.request.contextPath}/addUser.do">
        <div class="form-group has-success has-feedback">
            <label class="control-label">角色名：</label>
            <input type="text" class="form-control" placeholder="请输入您要添加的角色名"
                   required="required" name="name">
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <label class="control-label">密码：</label>
            <input type="text" class="form-control" placeholder="请输入您要添加的角色名"
                   required="required" name="pwd">
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <input type="submit" value="保存" class="btn btn-success">
    </form>
</div>
<!-- 下面的div用来显示添加和修改菜单 -->
<div id="dlg2" class="easyui-dialog" style="width:620px;height:250px;padding:10px 20px"
     closed="true">
    <form id="fmd" method="post" action="${pageContext.request.contextPath}/UpdateAction.do">
        <div class="form-group has-success has-feedback">
            <label class="control-label">角色名：</label>
            <input type="text" class="form-control" placeholder="请输入您要添加的角色名"
                   required="required" name="id">
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <label class="control-label">角色名：</label>
            <input type="text" class="form-control" placeholder="请输入您要添加的角色名"
                   required="required" name="name">
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <label class="control-label">密码：</label>
            <input type="text" class="form-control" placeholder="请输入您要添加的角色名"
                   required="required" name="pwd">
            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
        </div>
        <input type="submit" value="保存" class="btn btn-success">
    </form>
</div>

<script type="text/javascript">
    <c:if test="${flaa!=null}">
    <c:if test="${flaa}">
    alert("添加成功！");
    </c:if>
    <c:if test="${!flaa}">
    alert("添加失败！");
    </c:if>
    </c:if>
    <c:if test="${flag!=null}">
    <c:if test="${flag}">
    alert("修改成功！");
    </c:if>
    <c:if test="${!flag}">
    alert("修改失败！");
    </c:if>
    </c:if>
    <c:if test="${jieguo!=null}">
    <c:if test="${jieguo}">
    alert("删除成功！");
    </c:if>
    <c:if test="${!jieguo}">
    alert("删除失败！");
    </c:if>
    </c:if>
    $("#add").on("click", function () {
        $("#dlg").dialog("open").dialog("setTitle", "添加新角色");
        <%--location.href = "${pageContext.request.contextPath}/urlTrans.do?url=role/add.jsp";--%>
    });
    $("#updata").on("click", function () {
        var selectRows = $("#dg").datagrid('getSelections');

        //如果没有选择或者选择了多行
        if (selectRows.length != 1) {
            $.messager.alert("系统提示","请选择一条要编辑得数据");
            return;
        }

        var row = selectRows[0];
        //弹出编辑框,并设置标题
        $("#dlg2").dialog("open").dialog("setTitle","编辑角色信息");
        //将选中的单元格的数据填充到form表单中
        $("#fmd").form("load",row);
    });

    $("#delete").on("click", function () {
        var selectRows = $("#dg").datagrid('getSelections');
        //如果没有选择
        if (selectRows.length == 0) {
            $.messager.alert("系统提示","请选择一条要删除的数据");
            return;
        }


        var row = selectRows[0];
        $.messager.confirm("系统提示",
            "您确认要删除这条数据吗?",
            //result 表示的是用户的选择结果,确定是true,取消是false
            function(result){
                //如果用户点击了确定删除
                if (result) {
                    //post 提交删除请求到后台,删除数据
                    $.post("${pageContext.request.contextPath}/delterAction.do?id="+row.id)//提交的请求地址
                }
            });


    });




</script>

<!-- 下面这个div是用来对上面的div框补充 提交按钮和重置按钮的 -->
<div id="dlg-buttons"><!-- 注意这里的div id 和上面那个div的 buttons="#dlg-buttons"相对应-->
    <a href="javascript:addRole();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeRoleDialog();" class="easyui-linkbutton"
       iconCls="icon-cancel">关闭</a>
</div>

<!-- 下面这个div是用来对上面的div框补充 提交按钮和重置按钮的 -->
<div id="rm-dlg-buttons"><!-- 注意这里的div id 和上面那个div的 buttons="#dlg-buttons"相对应-->
    <a href="javascript:addRoleMenu();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeRoleMenuDialog();" class="easyui-linkbutton"
       iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>

