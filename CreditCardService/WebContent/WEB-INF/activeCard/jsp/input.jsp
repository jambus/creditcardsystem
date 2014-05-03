<%@ page language="java" import="java.util.*, com.xinhua.util.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript" src="js/date.js"></script>
<script type="text/javascript">
function cardChange(){
	document.forms[0].submit();
}

function doSubmit(){
	document.forms[0].action = "toActiveCardRecap.action";
	document.forms[0].submit();
}
</script>

<div id="activeCardDiv">
	<div id="activeCardTitle" class="cb">卡片激活</div>
	<div class="cb">
		<s:form>
		<div class="fl"><img alt="image not found" width="150px" height="100" src="images/cardlogo.jpg"></div>
		<div class="fl">
			<div>Select card:<s:select list="cardNumberDropDownMap" name="cardIndex" listKey="key" listValue="value" onchange="javascript:cardChange()"></s:select></div>
			<div>Card Status: ${cardStatus}</div>
			
			<s:if test='"N"==cardDetails.cardActiveCode'>
				<div style="padding-top:10px">
				卡片用户名:<input name="cardEmbossName" id="cardEmbossName"/>
				<span class="errorMsg"><s:fielderror name="cardEmbossName" fieldName="cardEmbossName"/></span>
				</div>
				<div>
				卡片过期时间:<input name="cardExpireDate" id="cardExpireDate" onfocus="HS_setDate(this)"/>
				<span class="errorMsg"><s:fielderror name="cardExpireDate" fieldName="cardExpireDate"/></span>
				</div>
			</s:if>
		</div>
		
		<s:if test='"N"==cardDetails.cardActiveCode'>
    		<div class="fr cb">
    			<a href="javascript:doSubmit()">Active the card&gt;</a>
    		</div>
		</s:if>
		
		</s:form>

	</div>
</div>