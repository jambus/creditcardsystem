<%@ page language="java" import="java.util.*, com.xinhua.util.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div id="welcomeDiv" class="welcomeClass">
	Welcome
	<%=ProfileUtil.getProfile().getUserName()%>
	to login credit card system. The login time:
	<%=new java.util.Date().toString()%>
</div>

<div id="accountSummaryDiv" class="accountSummaryClass"></div>

<script type="text/x-jsrender" id="summaryTmpl">
	<div>Account Summary:</div>
	{{if status=="ok"}}
	{{for cardList}}
	<a href="toShowDetails.action?cardIndex={{:cardIndex}}">
    <span>{{:cardName}} {{:cardNumber}} - </span>
	<span>Current amount: {{:currentAmount}}</span>
	</a>
	<br/>
	{{/for}}
	{{else}}
	<div>Sorry, get error to fetch the card information. Pls check with bank</div>
	{{/if}}
  </script>

<script type="text/javascript">
	$.ajax({
		type : "GET",
		url : "/CreditCardService/cardList.action",
		dataType : "json"
	}).always(function(data) {
		var obj = data;
		var temp = $.templates("#summaryTmpl");
		var renderData = temp.render(obj);
		$("#accountSummaryDiv").html(renderData);
	});
</script>
