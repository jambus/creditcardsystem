<%@ page language="java" import="java.util.*, com.xinhua.util.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div id="cardDetailsDiv">
	<div id="detailsTitle" class="cb">账户详情</div>
	<div class="cb">
		<div class="fl"><img alt="image not found" width="150px" height="100" src="images/cardlogo.jpg"></div>
		<div class="fl">
			<div><b>${cardDetails.cardName} ${cardDetails.cardNumber}</b></div>
			<div>Current amount: ${cardDetails.currentAmount} Yuan</div>
			<div>Credit limit: ${cardDetails.creditLimit} Yuan</div>
			<div>Credit owe: ${cardAmountOwe} Yuan</div>
		</div>
	</div>
	
	<div>
		<div id="txnTitle" class="cb">交易详情</div>
	</div>
</div>