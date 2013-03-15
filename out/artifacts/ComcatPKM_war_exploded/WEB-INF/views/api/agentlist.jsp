<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>Agent-API列表</title>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#alert").alert()
	});
	</script>
</head>

<body>

	<!-- 导航栏 -->
	<ul class="breadcrumb">
	  <li><a href="#">Home</a> <span class="divider">/</span></li>
	  <li><a href="#">API</a> <span class="divider">/</span></li>
	  <li class="active">AGENT</li>
	</ul>

     <!-- 信息框 -->
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>

	<!-- 删除确认框 -->
	<div id="deleteModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">删除确认</h3>
		</div>
		<div class="modal-body">
			<p>请问是否删除该记录?</p>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<a id="confirmDelete" class="btn btn-info" href="${ctx}/api/agent/delete/${api.id}">删除</a>
		</div>
	</div>
	

	<div align="right">
		<table id="contentTable" class="table table-striped table-bordered table-condensed">
			<thead><tr><th>名称</th><th>状态</th><th>管理</th></tr></thead>
			<tbody>
			<c:forEach items="${page.content}" var="api">
				<tr>
					<td><a href="${ctx}/api/agent/view/${api.id}">${api.name}</a></td>
					<td>${api.status}</td>
					<td width="100px">
					        <div class="btn-group">
					           <a class="btn btn-mini btn-info" href="${ctx}/api/agent/update/${api.id}">编辑</a>
					           <a  href="javascript:$('#confirmDelete').attr('href','${ctx}/api/agent/delete/${api.id}');$('#deleteModal').modal()" class="btn btn-mini btn-danger">删除</a>
					        </div>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<tags:pagination page="${page}" paginationSize="20"/>
	<div class="form-actions">
		<div><a class="btn btn-primary" href="${ctx}/api/agent/create">添加API</a></div>
	</div>	
	</div>
	
</body>
</html>
