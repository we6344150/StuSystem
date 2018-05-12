<%@ page language="java" contentType="text/html;charout=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
//out.print(path);
request.setAttribute("path", path);
%>
<div class="main wrap">
	<div id="houseArea">
		<table class="house-list">
		
		<c:if test="null == ${page} || null == ${page.list}">
	   		<tr>
	    		<td colspan="11"><center>无租房信息</center></td>
	    	</tr>
	   	</c:if>
	    
		<c:forEach items="${page.list}" var="house" varStatus="status">
			<tr <c:if test="${(status.index+1)%2==0}"> class="odd"</c:if>>
				<td class="house-thumb">
					<span>
						<a href="house!show.action?house.id=${house.id}">
						
							<c:if test='house.picture!=null && house.picture!=""'>
								<img src='<%=path%><c:out value="house."/>' width="90" height="60" />
							</c:if>
								<img src="images/thumb_house.gif" />
							
						</a>
					</span>
				</td>
				<td>
					<dl>
						<dt>
							<a href="house!show.action?house.id=${house.id}">
								<c:out value="${house.title}"/>
							</a>
						</dt>
						<dd>
							<c:if test="house.street != null">
								<c:out value="${house.street.district.name}"/>区
								<c:out value="${house.street.name}"/>,
							</c:if>
							<c:out value="${house.floorage}"/>平米<br />
							联系方式：<c:out value="${house.contact}"/>
						</dd>
					</dl>
				</td>
					<td class="house-type">
						<a href="${pageContext.request.contextPath}/initUpdate.action?house.id='${house.id}'" >修改</a>
					</td>
					<td>
							<a href="${pageContext.request.contextPath}/delete.action?house.id='${house.id}'" onclick="return window.confirm('确认删除吗')">删除</a>
					</td>
			</tr>
	    </c:forEach>
	    
		</table>
	</div>
	<jsp:include   page="page.jsp" flush="true"/>
	
</div>