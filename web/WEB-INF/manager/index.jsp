<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>

</head>

<body style="margin: 0 auto;">
<div id="cc" class="easyui-layout" style="width:90%;height:100%;margin: 0 auto;">
    <div data-options="region:'north'" style="height:100px;">
        <table style="padding: 5px" width="100%">
            <tr>
                <td width="50%">
                    <h3>后台管理系统</h3>
                </td>
                <td valign="bottom" align="right" width="50%">
                    ${emp.name}
                    <button id="btn">注销</button>
                </td>
            </tr>
        </table>
        <br>
    </div>
    <div data-options="region:'south'" style="height:100px;">
        south
    </div>
    <div data-options="region:'west',title:'菜单',split:true" style="width:250px;">
        <ul id="tt"></ul>
    </div>
    <div data-options="region:'center',title:'功能区'" style="padding:5px;background:#eee;">
        <div id="tabs" class="easyui-tabs" fit="true">
            <div title="主页面" style="padding:20px;">
                默认广告页面
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#tt').tree({
            url: 'json.do?empId=${emp.id}',
            onClick: function (node) {
                openTab(node);
            }
        });
        function openTab(node) {
            if ($("#tabs").tabs("exists", node.text)) {
                $("#tabs").tabs("select", node.text);
            } else {
                var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src=${pageContext.request.contextPath}/urlzhuagnhuagn.do?url=" + node.attributes.url + "></iframe>"
                $("#tabs").tabs("add", {
                    title: node.text,
                    closable: true,
                    content: content
                });
            }
        }
        $("#btn").on("click",function () {
            $.messager.confirm("系统提示","您确定要退出系统吗",function(r){
                if(r){
                    window.location.href="${pageContext.request.contextPath}/action/user/LogoutAction.do";
                }
            });
        })
    });
   
</script>
</body>
</html>