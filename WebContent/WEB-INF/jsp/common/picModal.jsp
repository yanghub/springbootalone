<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.framework.util.ManageConstants"%>
<%
String basePath = (String)request.getServletContext().getAttribute(ManageConstants.BASE_PATH);
String staticPath = (String)request.getServletContext().getAttribute(ManageConstants.STATIC_PATH);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>图片浏览</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		var pics = ${pics};
			for ( var i in pics) {
				if (pics[i].url != "" && pics[i].url != null) {
					var img = "<img alt='图片不正确' width='500px' height='350px' src='"+pics[i].url+"'>";
					$("#pic").append("<div class='widget-header'><span class='title'>"+pics[i].name+"</span></div><div class='widget-body' ><div class='widget-control'>"+img+"</div></div>");
				}else{
					$("#pic").append("<div class='widget-header'><span class='title'>"+pics[i].name+"</span></div><div class='widget-body' ><div class='widget-control'>无可查看图片</div></div>");
				}
			}
	});
</script>
</head>
<body>
	<div class="widget" id="pic"></div>
</body>
</html>