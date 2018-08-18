<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- <%@taglib prefix="s" uri="/struts-tags" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="js/changetrcolor.js"
	type="text/javascript"></script>
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
	<form
		action="plan/1/findByCon.action"
		method="post">
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<th>客户名称</th>
				<td><input type="text" name="chcCustName" /></td>
				<th>概要</th>
				<td><input type="text" name="chcTitle" /></td>
				<th>联系人</th>
				<td><input type="text" name="chcLinkman" size="20" /></td>
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="showhelp.action"><input
						class="common_button" type="button" value="帮助"></a>&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp; <input class="common_button" type="submit" value="查询">
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
	<tr>
		<TD class="page_title">检索结果</TD>
		<TD class="page_title_middle">&nbsp;</TD>
		<TD width=3><IMG height=32
			src="images/m_mpr.gif" width=3></TD>
	</tr>
	</table>

	<table id="data_list_table" class="data_list_table" cellSpacing=1
		cellPadding=1>
		<tr>
			<th id="firstth">编号</th>
			<th>客户名称</th>
			<th>概要</th>
			<th>联系人</th>
			<th>联系人电话</th>
			<th>状态</th>
			<th>操作</th>
		</tr>

		<c:forEach items="${sessionScope.pageInfo.list}" var="chances">
			<c:choose>
				<c:when test="${chances.chcStatus=='develop'}">
							<tr>
								<td class="list_data_number">${chances.chcId}</td>
								<td class="list_data_text">${chances.chcCustName }</td>
								<td class="list_data_ltext">${chances.chcDesc }</td>
								<td class="list_data_text">${chances.chcLinkman }</td>
								<td class="list_data_text">${chances.chcTel }</td>
								<td class="list_data_text">${chances.chcStatus }</td>

								<td class="list_data_op"><a
									href="plan/${chances.chcId}/doplan.action"><img
										title="制定计划"
										src="images/bt_plan.gif"
										class="op_button" /></a> 
								<a
							        href="sal/findOnePlan?chc_id=${chances.chcId}"><img
								onClick="to('pages/~sale/dev_detail.jsp');"
								title="查看"
								src="images/bt_detail.gif"
								class="op_button" /></a>
								</td>
							</tr>
						</c:when>
				<c:otherwise>
					<tr>
						<td class="list_data_number">${chances.chcId}</td>
						<td class="list_data_text">${chances.chcCustName }</td>
						<td class="list_data_ltext">${chances.chcDesc }</td>
						<td class="list_data_text">${chances.chcLinkman }</td>
						<td class="list_data_text">${chances.chcTel }</td>
						<td class="list_data_text">${chances.chcStatus }</td>

						<td class="list_data_op"><a
							href="sal/findOnePlan?chc_id=${chances.chcId}"><img
								onClick="to('pages/~sale/dev_detail.jsp');"
								title="查看"
								src="images/bt_detail.gif"
								class="op_button" /></a></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>

	<tr>
			<th colspan="7" class="pager">
				<div class="pager">
					每页 5 条 第${sessionScope.pageInfo.pageNum}页 <a
						href="plan/1/developPlan">首页</a>
					<c:choose>
						<c:when test="${sessionScope.pageInfo.hasPreviousPage}">
							<a href="plan/${sessionScope.pageInfo.prePage}/developPlan.action">上一页</a>
						</c:when>
						<c:otherwise>
							<font color="#ABA8AB">上一页</font>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${sessionScope.pageInfo.hasNextPage}">
							<a href="plan/${sessionScope.pageInfo.nextPage}/developPlan.action">下一页</a>
						</c:when>

						<c:otherwise>
							<font color="#ABA8AB">下一页</font>
						</c:otherwise>

					</c:choose>
					<a href="plan/${sessionScope.pageInfo.lastPage}/developPlan.action">尾页</a>
				</div>
			</th>
		</tr>
	</table>

</body>
</html>