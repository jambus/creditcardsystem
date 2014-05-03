<%@ page language="java" import="java.util.*, com.xinhua.util.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">

function doSubmit(){
	document.forms[0].action = "toActiveCardConfirm.action";
	document.forms[0].submit();
}
</script>

<div id="activeCardDiv">
	<div id="activeCardTitle" class="cb">卡片激活</div>
	<div class="cb">
		<s:form>
		<div class="fl"><img alt="image not found" width="150px" height="100" src="images/cardlogo.jpg"></div>
		<div class="fl">
			<div>Card: ${cardDetails.cardName} ${cardDetails.cardNumber}</div>
			<div>Card Status: ${cardStatus}</div>
			
			<div style="padding-top:10px">
				卡片用户名:${cardEmbossName}
			</div>
			<div>
				卡片过期时间:${cardExpireDate}
			</div>
			<s:hidden name="cardIndex" value="%{cardIndex}"></s:hidden>
		</div>
		
		<s:if test="cardDetails.cardActiveCode='N'">
    		<div class="fr cb">
    			<a href="javascript:doSubmit()">Confirm&gt;</a>
    		</div>
		</s:if>
		
		</s:form>

	</div>
</div>