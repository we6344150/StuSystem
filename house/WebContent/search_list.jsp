<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function doSearch() {
		document.getElementById("searchForm").submit();
	}
</script>
<style type="">
.add br {
	display: none;
}
</style>
</head>
<body>
	<div id="navbar" class="wrap">
		<s:property value="#disList.district[0].name" />
		<dl class="search clearfix">
			<dt>
				<ul>
					<li class="bold">房屋信息</li>
					<li>标题：<s:property value="#disList[0].district.name" /> <s:textfield
							name="house.title" id="title" cssClass="text" /> <label
						class="ui-blue"> <input type="button"
							onclick="doSearch();" name="search" value="搜索房屋" />
					</label>
					</li>
				</ul>
			</dt>
			<dd>
				<ul>
					<li class="first">价格</li>
					<li><s:select
							list="#{'<=1000':'1000元及以下', '>1000,<2000':'1000元—2000元', '>=2000':'2000元及以上'}"
							listKey="key" listValue="value" headerKey="" headerValue="不限"
							name="price" id="price" value="price"></s:select></li>
				</ul>
			</dd>
			<dd>
				<ul>
					<li class="first">房型</li>
					<li>
						<div class="add">
							<s:select name="type" list="typeList" headerKey=""
								headerValue="不限" listKey="id" listValue="name" theme="xhtml" />
						</div>
					</li>
				</ul>
			</dd>
			<dd>
				<ul>
					<li class="first">房屋位置</li>
					<li><s:select name="district" list="disList" headerKey=""
								headerValue="不限" listKey="id" listValue="name" theme="xhtml" /></li>
				</ul>
			</dd>
			<dd>
				<ul>
					<li class="first">面积</li>
					<li><s:select
							list="#{'<=40':'40及以下', '>40,<80':'40-80', '>=80':'80及以上'}"
							listKey="key" listValue="value" headerKey="" headerValue="不限"
							name="floorage" value="floorage"></s:select></li>
				</ul>
			</dd>
		</dl>
	</div>