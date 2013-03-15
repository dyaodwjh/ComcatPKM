<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>任务管理</title>
	
	<script>
		$(document).ready(function() {
			
			//聚焦第一个输入框
			$("#name").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
			
		});
		
		
	</script>
</head>

<body>
	<ul class="breadcrumb">
	  <li><a href="#">Home</a> <span class="divider">/</span></li>
	  <li><a href="#">API</a> <span class="divider">/</span></li>
	  <li class="active">AGENT</li>
	</ul>



	<form id="inputForm" action="${ctx}/api/agent/${action}" method="post" class="form-horizontal">
	   <c:if test="${action == 'update'}">
		<input type="hidden" name="id" value="${form.id}"/>
	   </c:if>	
		<fieldset>
			<legend><small>Agent API</small></legend>
			
			<div class="control-group">
				<label for="task_title" class="control-label">名称:</label>
				<div class="controls">
					<input type="text" id="name" name="name"  value="${form.name}" class="input-large required" minlength="3"/>
				</div>
			</div>	
			
			
			<div class="control-group">
				<label for="description" class="control-label">描述:</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-large" cols="30" rows="5">${form.description}</textarea>
				</div>
			</div>	
			
			<div class="control-group">
				<label for="description" class="control-label">用例:</label>
				<div class="controls">
					<textarea id="example" name="example" class="input-large" cols="20" rows="5">${form.example}</textarea>
				</div>
			</div>	
			
			<div class="control-group">
				<label for="description" class="control-label">状态:</label>
				<div class="controls">
					<input type="text"  id="status" name="status" class="input-large" value="${form.status}"/>
				</div>
			</div>	
			
			
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
			
		</fieldset>
	</form>
</body>
</html>


	
