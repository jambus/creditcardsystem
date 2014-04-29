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

<script type="text/x-mustache" id="summaryTmpl">
	<a href="toShowDetails.action?cardIndex={{index}}">
    <span>{{cardName}} {{cardNumber}} - </span>
	<span>Current amount: {{currentAmount}}</span>
	</a>
	<br/>
  </script>

<script type="text/x-mustache" id="summaryTmplError">
    <div>Sorry, get error to fetch the card information. Pls check with bank</div>
  </script>

<script type="text/javascript">
	$.ajax({
		type : "GET",
		url : "/CreditCardService/cardList.action",
		dataType : "json"
	}).always(function(data) {
		var obj = data;
		if (obj.status && obj.status == "ok" && obj.cardList) {
			var temp = $("#summaryTmpl").html();
			var renderData = "<div>Account Summary:</div>";
			$(obj.cardList).each(function(index) {
				this.index = index;
				renderData += Mustache.render(temp, this);
			})
			$("#accountSummaryDiv").html(renderData);
		} else {
			var temp = $("#summaryTmplError").html();
			var renderData = Mustache.render(temp, {});
			$("#accountSummaryDiv").html(renderData);
		}
	});
</script>
