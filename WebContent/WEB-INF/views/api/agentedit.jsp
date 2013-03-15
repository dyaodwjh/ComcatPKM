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

            $("#needRoot").val("${form.needRoot}");
            $("#supportAndroid").val("${form.supportAndroid}");
            $("#status").val("${form.status}");

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
			<div class="control-group">
				<label for="name" class="control-label">名称:</label>

				<div class="controls">
					<input type="text" id="name" name="name"  value="${form.name}" class="input-xxlarge required" minlength="3" width="500" />
				</div>
			</div>

            <div class="control-group">
                <label for="description" class="control-label">参数:</label>
                <div class="controls">
                    <input type="text"  id="param" name="param" class="input-xxlarge" value="${form.param}" width="400"/>
                </div>
            </div>

            <div class="control-group">
                <label for="description" class="control-label">返回值:</label>
                <div class="controls">
                    <input type="text"  id="result" name="result" class="input-xxlarge" value="${form.result}" width="400"/>
                </div>
            </div>


            <div class="control-group">
                <label for="description" class="control-label">类别:</label>
                <div class="controls">
                    <input type="text"  id="type" name="type" class="input-xxlarge" value="${form.type}" width="400"/>
                </div>
            </div>

            <div class="control-group">
                <label for="description" class="control-label">是否需要root:</label>
                    <div class="controls">
                        <select id="needRoot"  name="needRoot" >
                            <option value="true">需要root</option>
                            <option value="false">不需要root</option>
                        </select>
                    </div>
            </div>

            <div class="control-group">
                <label for="description" class="control-label">支持android版本:</label>
                <div class="controls">
                        <select id="supportAndroid"  name="supportAndroid" >
                            <option value="ALL">ALL</option>
                            <option value="ANDROID2">ANDROID2</option>
                            <option value="ANDROID4">ANDROID4</option>
                        </select>
                </div>
            </div>

			<div class="control-group">
				<label for="description" class="control-label">描述:</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-xxlarge" cols="60" rows="10">${form.description}</textarea>
				</div>
			</div>	
			
			<div class="control-group">
				<label for="description" class="control-label">用例:</label>
				<div class="controls">
					<textarea id="example" name="example" class="input-xxlarge" cols="60" rows="10">${form.example}</textarea>
				</div>
			</div>	
			
			<div class="control-group">
				<label for="description" class="control-label">状态:</label>
				<div class="controls">
                    <select id="status"  name="status" >
                        <option value="未测试">未测试</option>
                        <option value="测试中">测试中</option>
                        <option value="正常">正常</option>
                        <option value="异常">异常</option>
                        <option value="废弃">废弃</option>
                    </select>
				</div>
			</div>

            <div class="control-group">
                <label for="description" class="control-label">异常原因:</label>
                <div class="controls">
                    <textarea id="exception" name="exception" class="input-xxlarge" cols="60" rows="10">${form.exception}</textarea>
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


	
