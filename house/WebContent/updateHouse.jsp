<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>青鸟租房 - 发布信息</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>


<jsp:include page="header.jsp" flush="true" />
<s:debug></s:debug>
     <table align="center">
	<tr>
		<td><h1>新房屋信息发布</h1></td>
	</tr>
	</table>
        <form action="${pageContext.request.contextPath}/updateHouse.action" method="post" enctype="multipart/form-data">
		<table class="field" align="center">
		<input type="hidden" name="house.id" value="${house.id}">
		<input type="hidden" name="filepath" value="${house.filepath}">
		<tr>
			<td class="field">标 题：</td>
			<td><input type="text" name="house.title"></td>
		</tr>
		<tr>
			<td class="field">户 型：</td>
			<td><select>
			<c:forEach items="${typeList}" var="type">
			<option value="${type.id}">${type.name}</option>
			</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td class="field">面 积：</td>
			<td><input type="text" name="house.floorage"></td>
		</tr>
		<tr>
			<td class="field">价 格：</td>
			<td><input type="text" name="house.price" ></td>
		</tr>
		<tr>
			<td class="field">房产证日期：</td>
			<td><input type="text" name="house.pubDate" onclick="WdatePicker()"></td>
		</tr>
		<tr>
			<td class="field">位 置：</td>
			<td>
			<select>
			<c:forEach items="${disList}" var="dis">
			<option value="${dis.id}">${dis.name}</option>
			</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td class="field">上传图片：</td>
			<td><input type="file" name="pic"></td>
		</tr>
		
		<tr>
			<td class="field">联系方式：</td>
			<td><input type="text" name="house.contact"></td>
		</tr>
		<tr>
			<td class="field">详细信息：</td>
			<td><textarea name="house.description" rows="2" cols="8"></textarea></td>
		</tr>
        </table>
        <table align="center">
		<tr>
			<td><input type="submit" value="修改完成" /></td>
		</tr>
		</table>
	</form>

<jsp:include page="footer.jsp" flush="true" />
</body>
</html>