<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cost.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form name="myForm" action="cost" method="post">
    	<table>
    		<tr>
    			<td>消费金额</td>
    			<td><input name="cost"/></td>
    		</tr>
    		<tr>
    			<td>备注</td>
    			<td><input name="note"/></td>
    		</tr>    	
    		<tr style="display:none;">
    			<td colspan="2">余额不足</td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="确认消费"/></td>
    			<td><input type="button" value="取消"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
