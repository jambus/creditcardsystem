<%@ page language="java" import="java.util.*, com.xinhua.util.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
function cardChange(){
	document.forms[0].submit();
}
</script>

<div id="cardDetailsDiv">
	<div id="detailsTitle" class="cb">账户详情</div>
	<div class="cb">
		<s:form>
		<div class="fl"><img alt="image not found" width="150px" height="100" src="images/cardlogo.jpg"></div>
		<div class="fl">
			<div>Select card:<s:select list="cardNumberDropDownMap" name="cardIndex" listKey="key" listValue="value" onchange="javascript:cardChange()"></s:select></div>
			<div>Current amount: ${cardDetails.currentAmount} Yuan</div>
			<div>Credit limit: ${cardDetails.creditLimit} Yuan</div>
			<div>Credit owe: ${cardAmountOwe} Yuan</div>
		</div>
		</s:form>
	</div>
	
	<div>
		<div id="txnTitle" class="cb">交易详情</div>
		<div id="txnTableHeader">
			<div>
				<div style="width:20%" class="fl">Transaction Date</div>
				<div style="width:35%" class="fl">Transaction Description</div>
				<div style="width:35%" class="fl">Merchant name</div>
				<div style="width:10%" class="fl">Transaction Amount</div>
			</div>
		</div>
		<div id="txnTableBody">
			<s:iterator value="transactionList" var="txn">
			<div>
				<div style="width:20%" class="fl"><s:property value="#txn.transactionDate"/></div>
				<div style="width:35%" class="fl"><s:property value="#txn.transactionDescription"/></div>
				<div style="width:35%" class="fl"><s:property value="#txn.merchantName"/></div>
				<div style="width:10%" class="fl"><s:property value="#txn.transactionAmount"/></div>
			</div>
			</s:iterator>
		</div>
	</div>
</div>