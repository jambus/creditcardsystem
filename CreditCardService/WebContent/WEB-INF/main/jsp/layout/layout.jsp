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
    	<base href="<%=basePath%>">
       	<title><tiles:insertAttribute name="title" /></title>
    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
       
       <link rel="stylesheet" type="text/css" href="css/style.css">
       <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
       <script type="text/javascript" src="js/mustache.js"></script>
    </head>
    <body>
       <table width="800px" height="400px" border="0" align="center">
      
           <tr>
              <td class="post-layoutHeader" align="center" valign="top" width="800px" height="50px">
                  <tiles:insertAttribute name="header"/>
              </td>
           </tr>
           <tr>
              <td class="post-layoutMenu" align="left" width="800px" height="60px">
                  <tiles:insertAttribute name="menu" />
              </td>
           </tr>
           <tr>
              <td class="post-layoutBody">
                  <tiles:insertAttribute name="body" />
              </td>
           </tr>
           <tr>
              <td class="post-layoutFooter" height="40px">
                  <tiles:insertAttribute name="footer" />
              </td>
           </tr>
       </table>
    </body>
</html>