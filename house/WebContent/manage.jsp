<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>青鸟租房 - 用户管理</title>
	<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
</head>
<body>
   <jsp:include   page="header.jsp" flush="true"/>
   <jsp:include   page="search_list.jsp" flush="true"/>
   <jsp:include   page="house_list.jsp" flush="true"/>
   <jsp:include   page="footer.jsp" flush="true"/>
</body>
</html>