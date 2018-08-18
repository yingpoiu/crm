<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新建联系人</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script src="script/common.js"></script>
	<script src="script/jquery-1.4.1.js"></script>
  	<script src="js/linkman_add.js"></script>
  	
  </head>
  
  <body>
<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 联系人 &gt; 新建联系人</div>
<form action="cust/${sessionScope.customer.custNo}/saveNewLinkman.action" method="post" onsubmit="return linkman_addcheck()">

<div class="button_bar">
	<a href="showhelp.action"><input class="common_button"  type="button" value="帮助"></a>
	<input type="submit" value="保存/返回" /> 
</div>
<table class="query_form_table">
	<tr>
		<th>姓名</th>
			<td><input type="text" name="lkmName" id="lkm_nameinp"/><span class="red_star" id="lkm_nameinpspan">*</span></td>
		<th>性别</th>
		<td>
			<input type="radio" name="lkmSex" checked="checked" value="男" />男
			<input type="radio" name="lkmSex" value="女"/>女
		</td>
	</tr>
	<tr>
		<th>职位</th>
		<td><input type="text" name="lkmPostion" id="lkm_postion"/><span class="red_star" id="lkm_postionspan">*</span></td>
		<th>办公电话</th>
		<td><input type="text" name="lkmTel" id="lkm_tel"/><span class="red_star" id="lkm_telspan">*</span></td>
	</tr>	
	<tr>
		<th>手机</th>
		<td><input type="text" name="lkmMobile" size="20" /></td>
		<th>备注</th>
		<td><input type="text" name="lkmMemo" size="20" /></td>
	</tr>
</table>
</form>
  </body>
</html>
