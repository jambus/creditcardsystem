<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/struts-tags"  prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <head>
       	<title><tiles:insertAttribute name="title" /></title>
       
       	<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
       	<link rel="stylesheet" type="text/css" href="css/preloginStyle.css">
       	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    </head>
    <body>
       <table width="800px" height="400px" border="0" align="center">
      
           <tr>
              <td align="center" valign="top" width="800px" height="100px">
                  <tiles:insertAttribute name="header"/>
              </td>
           </tr>
           <tr>
              <td align="center" width="800px" height="200px"">
                  <tiles:insertAttribute name="body" />
              </td>
           </tr>
           <tr>
              <td height="20px">
                  <tiles:insertAttribute name="footer" />
              </td>
           </tr>
       </table>
    </body>
</html>