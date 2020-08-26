<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.framework.util.ManageConstants"%>
<%
String basePath = (String)request.getServletContext().getAttribute(ManageConstants.BASE_PATH);
String staticPath = (String)request.getServletContext().getAttribute(ManageConstants.STATIC_PATH);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=staticPath%>bin/css/home-main.css">
<title>会话超时</title>
</head>
<body bgcolor="#e0e0e0" style=" font-family:'微软雅黑';padding-top:50px;">
<table width="400" border="0" align="center">
  <tr>
    <td rowspan="4" width="132" height="209"><img class="timeout-img"/></td>
    <td height="20"></td>

  </tr>
  <tr>
    <td style="padding-left:20px;color:#838383;font-size:40px;">对不起...<br/><span style="font-size:14px;">由于您长时间未操作，会话已过期。
.</span></td>
  </tr>
  <tr>
    <td style="padding-left:20px;color:#ff9003;font-size:30px;">请重新<a style="color:#3a94e2;">登录</a>！</td>
  </tr>
</table>

</body>
</html>