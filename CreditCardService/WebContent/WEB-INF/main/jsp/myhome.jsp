<%@ page language="java" import="java.util.*, com.xinhua.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <div id="welcomeDiv">
    	Welcome <%=ProfileUtil.getProfile().getUserName() %> to login credit card system. The login time: <%=new java.util.Date().toString()%>
    </div>
    
    <div id="accountSummaryDiv">
    </div>

<script type="text/javascript">
$.ajax({
	  type: "GET",
	  url: "/CreditCardService/cardList.action",
	  dataType: "json"
	}).always(function() {
	    alert( "complete" );
	  });
</script>
