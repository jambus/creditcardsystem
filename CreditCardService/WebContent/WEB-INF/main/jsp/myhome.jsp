<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <div id="welcomeDiv">
    	Welcome ${user.userName} to login credit card system. The login time: <%=new java.util.Date().toString()%>
    </div>
    
    <div id="accountSummaryDiv">
    </div>

