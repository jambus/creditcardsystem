<%@ page language="java" import="java.util.*, com.xinhua.util.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript" src="js/date.js"></script>
<script type="text/javascript">
function cardChange(){
	document.forms[0].submit();
}

function doSubmit(){
	document.forms[0].action = "toCardBlockRecap.action";
	document.forms[0].submit();
}
</script>

<div id="cardBlockDiv">
	<div id="cardBlockTitle" class="cb">卡片挂失</div>
	<div class="cb">
		<s:form>
		<div class="fl"><img alt="image not found" width="150px" height="100" src="images/cardlogo.jpg"></div>
		<div class="fl">
			<div>Select card:<s:select list="cardNumberDropDownMap" name="cardIndex" listKey="key" listValue="value" onchange="javascript:cardChange()"></s:select></div>
			<div>Card Status: ${cardBlockCode}</div>
			
			<div style="padding-top:10px">
				<span class="errorMsg"><s:fielderror name="cardBlock" fieldName="cardBlock"/></span>
			</div>
		</div>
		
		<s:if test='"L"!=cardDetails.cardBlockCode'>
    		<div class="fr cb">
    			<a href="javascript:doSubmit()">Block the card&gt;</a>
    		</div>
		</s:if>
		
		</s:form>

	</div>
</div>