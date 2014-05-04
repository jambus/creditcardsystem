<%@ page language="java" import="java.util.*, com.xinhua.util.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
function doSubmit(){
	document.forms[0].submit();
}
</script>

<div id="privateUpdateDiv">
	<div id="privateUpdateTitle" class="cb">用户管理</div>
	<div class="cb">
		<s:form action="toPrivateUpdateConfirm">
		<div class="fl">
			<div>Name:${userinfo.firstName} ${userinfo.lastName}</div>
			<div>Address:
				<s:textfield name="userinfo.address"></s:textfield>
			</div>
			<div>Email:
				<s:textfield name="userinfo.mail"></s:textfield>
			</div>
			<div>Telephone:
				<s:textfield name="userinfo.tel"></s:textfield>
			</div>
		</div>
		
    	<div class="fr cb">
    		<a href="javascript:doSubmit()">Edit&gt;</a>
    	</div>
		
		</s:form>

	</div>
</div>