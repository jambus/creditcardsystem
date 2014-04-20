<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>

	<div style="position:relative; margin-top:-50px;">
    	<img src="images/login.jpg"/>
        <form id="myForm" method="post" action="login">
            <table id="tb" style="position:absolute; top:200px; left:320px;">
                <tr>
                    <td><font id="f1">用户名:</font></td>
                    <td><input id="username" name="user.userName" value=""/></td>
                </tr>
                <tr>
                    <td><font id="f1">密码:</font></td>
                    <td><input type="password" id="password" name="user.password" value=""/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="login" name="login" value="登  录"/></td>
                    <td><input type="reset" id="reset" name="reset" value="重  置" style="float:right;" /></td>
                </tr>
            </table>
        </form>
        <form id="myForm" method="post" action="toRegister">
        	<div style="position:absolute; top:320px; left:620px;">
            	<input type="submit" id="btn" value="立即注册..."/>
            </div>
        </form>
        <form id="myForm" method="post" action="toApply">
        	<div style="position:absolute; top:260px; left:620px;">
            	<input type="submit" id="btn" value="立即申请..."/>
            </div>
        </form>
    </div>
