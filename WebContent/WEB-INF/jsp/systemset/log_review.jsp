<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>log_review</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="js/changetrcolor.js" type="text/javascript"></script>
<script type="text/javascript">
	var msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>
<c:remove var="msg" scope="session" />
</head>
<body>
	<br />
	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<td class="page_title">检索结果</td>
			<td class="page_title_middle">&nbsp;</td>
			<td width=3><IMG height=32 src="images/m_mpr.gif" width=3></td>
		</tr>
	</table>
	<table id="data_list_table" class="data_list_table" cellSpacing=1
		cellPadding=1 style="text-align: center;">
		<tr>

			<th id="firstth">时间</th>
			<th>操作员</th>
			<th colspan="3">事件</th>
		</tr>

		<c:forEach items="${sessionScope.pageInfo.list }" var="logs">
			<tr>
				<td><fmt:formatDate value="${logs.logDate}"
						pattern="yyyy年MM月dd日:HH时mm分ss秒" dateStyle="long" type="date" />
				<td>${logs.logOp }</td>
				<td colspan="3">${logs.logEvent }</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="3"><a href="log/${sessionScope.pageInfo.firstPage}/selectAllLog.action">首页</a> <c:choose>
					<c:when test="${sessionScope.pageInfo.hasPreviousPage}">
						<a href="log/${sessionScope.pageInfo.prePage}/selectAllLog.action">上一页</a>
					</c:when>
					<c:otherwise>
						<font color="#ABA8AB">上一页</font>
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when test="${sessionScope.pageInfo.hasNextPage}">
						<a href="log/${sessionScope.pageInfo.nextPage}/selectAllLog.action">下一页</a>
					</c:when>

					<c:otherwise>
						<font color="#ABA8AB">下一页</font>
					</c:otherwise>

				</c:choose> <a href="log/${sessionScope.pageInfo.lastPage}/selectAllLog.action">尾页</a></td>
		</tr>

		<tr>
			<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
				<a href="help.jsp"><input class="common_button" type="button"
					value="帮助"></a>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
			</td>
		</tr>

	</table>
</body>
<script src="js/changetrcolor.js" type="text/javascript"></script>
</html>
