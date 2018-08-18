<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>jb-aptech毕业设计项目</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	var msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>
<c:remove var="msg" scope="session" />
</head>
<body>

	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<TD class="page_title">客户开发计划</TD>
			<TD class="page_title_middle">&nbsp;</TD>
			<TD width=3><IMG height=32
				src="images/m_mpr.gif" width=3></TD>
		</tr>
	</table>


	<form action="" method="post">
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<td width=100% height=30 align=left
					background="images/m_table_top.jpg"
					colspan="6"><strong>&nbsp;执行计划</strong></td>
			</tr>

			<tr>
				<th>编号</th>
				<td><input type="hidden" name="chcId" value="${chance.chcId}">${chance.chcId}</td>
				<th>机会来源</th>
				<td>${chance.chcSource}</td>
			</tr>
			<tr>
				<th>客户名称</th>
				<td><input type="hidden" name="chc_cust_name"
					value="${chance.chcCustName}">${chance.chcCustName}</td>
				<th>成功机率（%）</th>
				<td>&nbsp;${chance.chcRate}</td>
			</tr>
			<tr>
				<th>概要</th>
				<td>${chance.chcTitle}</td>
				<th>联系地址</th>
				<td>${chance.chcAddr}</td>
			</tr>
			<tr>
				<th>联系人</th>
				<td>${chance.chcLinkman}</td>
				<th>联系人电话</th>
				<td>${chance.chcTel}</td>
			</tr>
			<tr>
				<th>机会描述</th>
				<td colspan="3">${chance.chcDesc}</td>
			</tr>
			<tr>
				<th>创建人</th>
				<td>${chance.chcCreateBy}</td>
				<th>指派给</th>
				<td><input type="hidden" name="chc_due_to"
					value="${chance.chcDueTo}">${chance.chcDueTo}</td>
			</tr>

			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="help.jsp"><input class="common_button" type="button"
						value="帮助"></a>&nbsp;&nbsp;&nbsp; <a
					href="plan/${chance.chcId}/deleteplan.action"><input
						class="common_button" size="70" type="button" value="终止开发"></a>&nbsp;&nbsp;&nbsp;
					<a href="plan/${chance.chcId}/updateplan.action"><input
						class="common_button" size="70" type="button" value="开发成功"></a>&nbsp;&nbsp;&nbsp;
					<a href="plan/1/developPlan.action"><input class="common_button"
						type="button" value="返回"></a>
				</td>
			</tr>
		</table>
	</form>
	<br />

	<form action="plan/saveplan.action" method="post">
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<th width=100% height=20 align=left
					background="images/m_table_top.jpg"><strong>&nbsp;制定计划</strong></th>
			</tr>
			<tr>
				<td><input type="hidden" name="plaChcId" value="${chance.chcId}"></td>
			</tr>
			<tr>
				<th align="left">计划内容</th>
			</tr>
			<tr>
						<td><textarea name="plaTodo" id="ttt" rows="6" cols="50">${plan.plaTodo }</textarea><span
							class="red_star">*</span></td>
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<input type="submit" class="common_button" value="保存"> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>