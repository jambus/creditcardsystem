<%@ page language="java" import="java.util.*, com.xinhua.util.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div id="cardBlockDiv">
	<div id="cardBlockTitle" class="cb">卡片挂失</div>
	<div class="cb">
		<s:form>
		<div class="fl"><img alt="image not found" width="150px" height="100" src="images/cardlogo.jpg"></div>
		<div class="fl">
			<div>Card: ${cardDetails.cardName} ${cardDetails.cardNumber}</div>
			<div>Card Status: ${cardBlockCode}</div>
			
		</div>
		
   		<div class="fr cb">
   			<a href="#">Back to home&gt;</a>
   		</div>
		
		</s:form>

	</div>
</div>