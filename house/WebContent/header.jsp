<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();

%>
<style type="text/css">
	.error{
	    color:red;
	}
	.pass{
	    color:blue;
	}
</style>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
//登录
function doLogin(type) {
 	var name =  $("#loginName").val();
	var pw = $("#loginPassword").val();
	var param={"name":name,"pw":pw};
	var url = "${pageContext.request.contextPath}/loginAjax.action"; 
	if (name != null && name!='' && pw != null && pw!='') {
		$.post(url,param,function(data){
			if(data && data == "error"){
				$("#login").addClass("error");
				$("#login").html("用户名或密码错误");
			}else{
				$("#login").addClass("pass");
				$("#login").html("登录成功");
				// $("#loginFrom").submit();
			}
		});
	     
	}else{
		alert("请输入用户名或密码！");
	} 
}
</script>
<s:debug></s:debug>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath}/images/logo.gif" /></div>
	
	<div >
		<div><span id="login"></span></div>
	</div>

	<div align="right">
	${sessionScope.msg}
		<form method="post" id="loginFrom" action="${pageContext.request.contextPath}/login.action">
			<div id="topLoginDiv" style="display: inline">
				用户名:&nbsp;<input type="text" id="loginName" name="user.username" size="15">
				&nbsp;密&nbsp;&nbsp;码:&nbsp;<input type="password" name="user.password" id="loginPassword" size="15">
				<label class="ui-green">
					<input type="button" name="loginButton" id="loginButton"  value="登录" onclick="doLogin();" />
				</label>
				<label class="ui-green">
					<input type='button' value='注册' onclick='document.location="${pageContext.request.contextPath}/register.jsp"'/>
				</label>
			</div>
			<div style="display: inline">
				<label class="ui-green">
					<input type="button" name="search" value="发布信息" onclick='document.location="${pageContext.request.contextPath}/addHouse.action"'/>
				</label>	
			</div>
		</form>
	</div>
</div>