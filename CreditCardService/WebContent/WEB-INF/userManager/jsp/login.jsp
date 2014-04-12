<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>


  	<div style="position:relative; margin-left:180px; margin-top:50px;">
    	<img src="images/login.jpg"/>
        <form id="myForm" method="post" action="login">
            <table id="tb" style="position:absolute; top:180px; left:320px;">
                <tr>
                    <td><font id="f1">username:</font></td>
                    <td><input id="username" name="user.userName" value=""/></td>
                </tr>
                <tr>
                    <td><font id="f1">password:</font></td>
                    <td><input type="password" id="password" name="user.password" value=""/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="login" name="login" value="LOGIN"/></td>
                    <td><input type="reset" id="reset" name="reset" value="RESET" style="float:right;" /></td>
                </tr>
            </table>
        </form>
        <form id="myForm" method="post" action="toRegister">
        	<div style="position:absolute; top:320px; left:600px;">
            	<input type="submit" id="register" value="REGISTER NOW..."/>
            </div>
        </form>
    </div>