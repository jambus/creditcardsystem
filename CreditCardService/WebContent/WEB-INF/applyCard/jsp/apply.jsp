<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>

	<script type="text/javascript" src="js/date.js"></script>
	<script type="text/javascript" src="js/apply.js"></script>
	
	<h2 class="titleh2">申请信用卡 >>></h2> 

    <form action="apply.action" method="post" name="myForm" onsubmit="return checkform()">
    	<table id="applyTable">
    		<tr id="customTypeTr">
    			<td>用户类型：</td>
    			<td>
    			<select name="customType" id="customType" onChange="javascript:switchType()">
    				<option value="">请选择</option>
    				<option value="N">新银行用户</option>
    				<option value="E">现有用户</option>
    			</select>
    			<span id="nullcustomType" style="display:none;" class="errorMsg">用户类型不能为空</span>
    			<span class="errorMsg">
    				<s:fielderror name="customType" />
    			</span>
    			</td>
    		</tr>
    		<tr>
    			<td>姓名：</td>
    			<td>
    			<input name="userInfo.firstName" id="firstname" />
    			<input name="userInfo.lastName" id="lastname" />
    			<span id="nullfullname" style="display:none;" class="errorMsg">姓名不能为空</span></td>
    		</tr>
    		<tr id="idNumberTr">
    			<td>身份证：</td>
    			<td>
    			<input name="userInfo.idNumber" id="idNumber" />
    			<span id="nullidNubmer" style="display:none;" class="errorMsg">身份证不能为空</span></td>
    		</tr>
    		<tr>
    			<td>出生日期：</td>
    			<td><input name="userInfo.birthday" id="birthday" onfocus="HS_setDate(this)" />
    			<span id="nullbirth" style="display:none;" class="errorMsg">出生日期不能为空</span></td>
    		</tr>
    		<tr>
    			<td>工资：</td>
    			<td><input name="userInfo.salary" id="salary"/>
    			<span id="nullsalary" style="display:none;" class="errorMsg">工资不能为空</span></td>
    		</tr>
    		<tr>
    			<td>地址：</td>
    			<td><input name="userInfo.address" id="address"/>
    			<span id="nulladdress" style="display:none;" class="errorMsg">地址不能为空</span></td>
    		</tr>
    		<tr>
    			<td>电话：</td>
    			<td><input name="userInfo.tel" id="tell"/>
    			<span id="nulltel" style="display:none;" class="errorMsg">电话不能为空</span></td>
    		</tr>
    		<tr>
    			<td>邮箱：</td>
    			<td><input name="userInfo.mail" id="mail"/>
    			<span id="nullmail" style="display:none;" class="errorMsg">邮箱不能为空</span></td>
    		</tr>
    		<tr>
    			<td><input type="checkbox" id="agree"/></td>
				<td>我同意以下协议</td>
    			<span id="nullagree" style="display:none;" class="errorMsg">请同意协议</span>
    		</tr>
    		<tr id="submitTr" class="submitTr">
    			<td colspan="2"><input type="submit" value="申     请" /></td>
    		</tr>
    	</table>
    	
    </form>