<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>]添加角色</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js">
	
</script>

</head>
<script type="text/javascript">
	function check() {
		var aaa = document.getElementById("roleId").value;
		var bbb = document.getElementById("txt").value;
		if (aaa == "" || bbb == "") {
			alert("角色编号和姓名不能为空");
			return false;
		}
		return true;
	}
	var msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>
<c:remove var="msg" scope="session"/>
<body>

	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<TD class="page_title">系统设置</TD>
			<TD class="page_title_middle">&nbsp;</TD>
			<TD width=3><IMG height=32
				src="images/m_mpr.gif" width=3></TD>
		</tr>
	</table>

	<form action="role/addRole.action" method="post" onsubmit="return check()">
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<td width=100% height=30 align=left
					background="images/m_table_top.jpg"
					colspan="6"><strong>&nbsp;新建角色</strong></td>
			</tr>
			<tr>
				<th>角色编号</th>
				<td><input type="text" name="roleId" id="roleId" /><span
					class="red_star">*</span></td>

				<th>角色名称</th>
				<td><input type="text" name="roleName" size="20" id="txt" /><span
					class="red_star">*</span></td>
			</tr>
			<tr>
				<th>描述</th>
				<td><input type="text" name="roleDesc" /></td>
				<th>角色状态</th>
				<td><input type="number" name="roleFlag" value="1" max="4"/><span
					class="red_star">*</span>
					<br />
					1 为管理员，2位高管，3为主管,4为经理
					</td>
			</tr>
			<tr>
				<th>创建人</th>
				<td><input value="${sessionScope.user.usrName}" readonly /><span
					class="red_star">*</span></td>
				<th></th>
				<td></td>
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="showhelp.action"><input class="common_button" type="button"
						value="帮助"></a> &nbsp;&nbsp;&nbsp; <a href="showRolemanage.action"><input
						class="common_button" type="button" value="返回"></a>
					&nbsp;&nbsp; <input type="submit" value="保存">
				</td>
			</tr>
		</table>
	</form>
	<br />
</body>
</html>