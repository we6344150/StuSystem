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
	<title>青鸟租房 - 用户注册</title>
	<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
	<style type="text/css">
	.error{
	    color:red;
	}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
	<script type="text/javascript">
	function checkName(){
		var username=$("#username").val();
		if(username.trim()==""){
			$("#usernameId").addClass("error");
			$("#usernameId").html("用户名不能为空");
		}else{
			var url="${pageContext.request.contextPath}/checkUserName.action";
			var param={"username":username};
			$.post(url,param,function(data){
				if(data && data == "no"){
					$("#usernameId").addClass("error");
					$("#usernameId").html("用户名已经存在");
				}else{
					$("#usernameId").removeClass("error");
					$("#usernameId").html("用户名可以进行注册");
				}
			});
		}
	}
	function checkForm(){
		checkName();
		//获取error数量
		if($(".error").size()>0){
			return false;
		}
		
	}
	
	</script>
</head>

<body>
	<s:include value="header.jsp"></s:include>
	<%-- ${sessionScope.msg}
	<div id="regLogin" class="wrap">
		<div class="dialog">
			<dl class="clearfix">
				<dt>新用户注册</dt>
				<dd class="past">填写个人信息</dd>
			</dl>
			<div class="box">
				<form action="${pageContext.request.contextPath}/register.action" id="formasdf" method="post">
					<div class="infos">
						<table>
							<tr>
								<td class="field">用 户 名：</td>
							    <td><input type="text" name="user.username"></td>
							</tr>	
							<tr>
								<td class="field">密　　码：</td>
								 <td><input type="password" name="user.password"></td>
							</tr>				
					<!-- 	 <tr>
							<td class="field">确认密码：</td>
							<td><input type="password" name="user.password"></td>
						</tr> -->	
						<tr>
							<td class="field">电　　话：</td>
							<td><input type="text" name="user.telephone"></td>
						</tr>
						<tr>
							<td class="field">用户姓名：</td>
							<td><input type="text" name="user.realname"></td>
						</tr>
						</table>
						<div ><input type="submit" value="立即注册" ></div>
					</div>
					
				</form>
			</div>
		</div>
	</div> --%>
 
	<div id="regLogin" class="wrap">
		<div class="dialog">
			<dl class="clearfix">
				<dt>新用户注册</dt>
				<dd class="past">填写个人信息</dd>
			</dl>
			<div class="box">
				<form action="${pageContext.request.contextPath}/register.action" onsubmit="return checkForm()" id="formasdf" method="post">
					<div class="infos">
						<table>
							<tr>
								<td class="field">用 户 名：</td>
							    <td><input type="text" id="username" name="user.username" onblur="checkName()"></td>
							    <td><span id="usernameId"></span></td>
							</tr>	
							<tr>
								<td class="field">密　　码：</td>
								 <td><input type="password" id="password" name="user.password"></td>
								 <td><span id="passwordId"></span></td>
							</tr>				
						<!--  <tr>
							<td class="field">确认密码：</td>
							<td><input type="password" id="passwordConfirm" name="user.password"></td>
						</tr> -->	
						<tr>
							<td class="field">电　　话：</td>
							<td><input type="text" id="telephone" name="user.telephone"></td>
						</tr>
						<tr>
							<td class="field">用户姓名：</td>
							<td><input type="text" id="realname" name="user.realname"></td>
						</tr>
						</table>
						<div ><input type="submit" value="立即注册" ></div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
	<s:include value="footer.jsp"></s:include>
</body>
</html>