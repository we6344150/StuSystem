<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>青鸟租房 - 操作成功</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
</head>
<body>
<s:include value="header.jsp"></s:include>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<div class="box">
			<div class="msg">
				<p>恭喜：操作成功！<a href="javascript:window.location.href='doSearch.action'">返回首页</a><br /></p>
			</div>
		</div>
	</div>
</div>
<s:include value="footer.jsp"></s:include>
</body>
</html>

