<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>任务管理</title>
	
</head>

<body>
	<ul class="breadcrumb">
	  <li><a href="#">Home</a> <span class="divider">/</span></li>
	  <li><a href="#">API</a> <span class="divider">/</span></li>
	  <li class="active">AGENT</li>
	</ul>

		<input type="hidden" name="id" value="${form.id}"/>
		<fieldset>
			<div class="control-group">
				<label for="name" class="control-label">名称:</label>

				<div class="controls">
					<input type="text" width="400" id="name" name="name"  value="${form.name}" class="input-xxlarge required" minlength="3" readonly="true"/>
				</div>
			</div>
            <div class="control-group">
                <label for="description" class="control-label">类别:</label>
                <div class="controls">
                    <input type="text" width="400"  id="type" name="type" class="input-xxlarge" value="${form.type}" readonly="true"/>
                </div>
            </div>

            <div class="control-group">
                <label for="description" class="control-label">参数:</label>
                <div class="controls">
                    <input type="text"  width="400"  id="param" name="param" class="input-xxlarge" value="${form.param}"  readonly="true"/>
                </div>
            </div>

            <div class="control-group">
                <label for="description" class="control-label">返回值:</label>
                <div class="controls">
                    <input type="text" width="400"   id="result" name="result" class="input-xxlarge" value="${form.result}"  readonly="true"/>
                </div>
            </div>

            <div class="control-group">
                <label for="description" class="control-label">是否需要root:</label>
                    <div class="controls">
                        <select id="needRoot"  name="needRoot" disabled="true" >
                            <option value="true">需要root</option>
                            <option value="false">不需要root</option>
                        </select>
                    </div>
            </div>

            <div class="control-group">
                <label for="description" class="control-label">支持android版本:</label>
                <div class="controls">
                        <select id="supportAndroid"  name="supportAndroid" disabled="true">
                            <option value="ALL">ALL</option>
                            <option value="ANDROID2">ANDROID2</option>
                            <option value="ANDROID4">ANDROID4</option>
                        </select>
                </div>
            </div>

			<div class="control-group">
				<label for="description" class="control-label">描述:</label>
				<div class="controls">
					<textarea id="description" name="description" class="input-xxlarge" cols="60" rows="10" readonly="true">${form.description}</textarea>
				</div>
			</div>	
			
			<div class="control-group">
				<label for="description" class="control-label">用例:</label>
				<div class="controls">
					<textarea id="example" name="example" class="input-xxlarge" cols="60" rows="10" readonly="true">${form.example}</textarea>
				</div>
			</div>	
			
			<div class="control-group">
				<label for="description" class="control-label">状态:</label>
				<div class="controls">
                    <select id="status"  name="status" disabled="true"  >
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
                    <textarea id="exception" name="exception" class="input-xxlarge" cols="60" rows="10" readonly="true">${form.exception}</textarea>
                </div>
            </div>

            <div class="form-actions">
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
			
		</fieldset>
</body>
</html>


	
