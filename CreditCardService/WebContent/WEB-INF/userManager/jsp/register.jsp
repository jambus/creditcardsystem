<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>

	<script type="text/javascript" src="js/date.js"></script>
	<script type="text/javascript" src="js/register.js"></script>

	<h2 class="titleh2">注册用户 >>></h2>
    <form action="register.action" method="post" name="myForm" onsubmit="return checkform()">
    	<table id="applyTable">
    		<tr>
    			<td>用户名：</td>
    			<td><input name="user.userName" id="userName"/>
    			<span id="nullname" style="display:none;" class="errorMsg">
    				用户名不能为空
    			</span>
    			<span class="errorMsg">
    				<s:fielderror name="user.userName" />
    			</span>
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" id="password" name="user.password"/>
    			<span id="nullpwd" class="errorMsg" style="display:none;">密码不能为空</span></td>
    		</tr>
    		<tr>
    			<td>确认密码：</td>
    			<td><input type="password" id="password0" name="password0"/>
    			<span id="errorpwd" style="display:none;" class="errorMsg">两次输入密码不一致</span></td>
    		</tr>
    		<tr>
    			<td>姓名：</td>
    			<td>
    			<input name="userInfo.firstName" id="firstname" />
    			<input name="userInfo.lastName" id="lastname" />
    			<span id="nullfullname" style="display:none;" class="errorMsg">姓名不能为空</span></td>
    		</tr>
    		<tr>
    			<td>出生日期：</td>
    			<td><input name="userInfo.birthday" id="birthday" onfocus="HS_setDate(this)" />
    			<span id="nullbirth" style="display:none;" class="errorMsg">出生日期不能为空</span></td>
    		</tr>
    		<tr>
    			<td>账户号：</td>
    			<td><input id="accountNumber" name="accountNumber"/>
    			<span id="nullaccountNumber" style="display:none;" class="errorMsg">账户号不能为空</span></td>
    		</tr>
    		<tr>
    			<td>身份证：</td>
    			<td><input name="userInfo.idNumber" id="idNumber"/>
    			<span id="nullidNumber" style="display:none;" class="errorMsg">身份证不能为空</span></td>
    		</tr>
    		<tr>
    			<td>电话：</td>
    			<td><input name="userInfo.tel" id="tell"/>
    			<span id="nulltel" style="display:none;" class="errorMsg">电话不能为空</span></td>
    		</tr>
    		<tr>
    			<td><input type="checkbox" id="agree"/></td>
				<td>我同意以下协议</td>
    			<span id="nullagree" style="display:none;" class="errorMsg">请同意协议</span>
    		</tr>
    		<tr class="submitTr">
    			<td colspan="2"><input type="submit" value="注     册" /></td>
    		</tr>
    	</table>
    	
    </form>