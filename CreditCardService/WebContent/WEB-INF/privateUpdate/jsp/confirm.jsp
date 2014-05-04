<%@ page language="java" import="java.util.*, com.xinhua.util.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div id="privateUpdateDiv">
	<div id="privateUpdateTitle" class="cb">用户管理</div>
	<div class="cb">
		<div class="fl">
			<div>Name:${userinfo.firstName} ${userinfo.lastName}</div>
			<div>Address:${userinfo.address}</div>
			<div>Email:${userinfo.mail}</div>
			<div>Telephone:${userinfo.tel}</div>
		</div>
		
    	<div class="fr cb">
    		<a href="#">Back to home&gt;</a>
    	</div>

	</div>
</div>