<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>Comcat-<sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link href="${ctx}/static/bootstrap/2.1.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-validation/1.9.0/validate.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/quickstart.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.9.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.9.0/messages_bs_cn.js" type="text/javascript"></script>

<script src="${ctx}/static/bootstrap/2.1.0/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery/1.7.2/bootstrap-button.js" type="text/javascript"></script>
<sitemesh:head/>

<script type="text/javascript">

 
  
  $(document).ready(function() {
	  var target = "${sessionScope.current}";
	  $(".active").removeClass("active");
	  $("#"+target).addClass("active");
	});
</script>

</head>

<body>
       
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		
		 <table style="width: 100%">
		   <tr>
              <shiro:user>
                  <td width="120px"  valign="top" style="padding-right: 10px">
                    <ul  class="nav nav-list well">
                      <li  id="0"  ><a href="${ctx}/index.do">home</a></li>
                       <li class="divider"></li>

                      <li class="nav-header">API列表</li>
                        <!--<li  id="11"  style="padding-left: 10px"><a href="#">功能模块</a></li>-->
                        <!--<li  id="12"  style="padding-left: 10px"><a href="#">IDE</a></li>-->
                      <li  id="13"  style="padding-left: 10px"><a href="${ctx}/api/agent/list?current=13">AGENT</a></li>
                    </ul>
                  </td>
              </shiro:user>
               <td>
		      <div id="content" class="span12">
		         <sitemesh:body/>
		      </div>   
		      </td>
		   </tr>
		 </table>
			
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
	
</body>
</html>