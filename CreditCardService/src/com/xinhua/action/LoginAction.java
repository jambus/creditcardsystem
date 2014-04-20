package com.xinhua.action;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.dao.UserDao;
import com.xinhua.dao.impl.UserDaoImpl;
import com.xinhua.pojo.SysProfile;
import com.xinhua.pojo.User;
import com.xinhua.util.EncryptUtil;
import com.xinhua.util.ProfileUtil;

public class LoginAction extends ActionSupport{
	
	private static Log log = LogFactory.getLog(LoginAction.class);
	private User user;
	private UserDao userDao = new UserDaoImpl();
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String execute(){
		String forward = null;
		
		log.info("Start Login");
		try{
			if(ProfileUtil.isCustomerLogin()){
		    	forward = "home";
		    	return forward;
		    }
			
			String inputUserName = user.getUserName();
			String inputPassword = EncryptUtil.getEncryptedBySha1(user.getPassword());
			if(userDao.getUserByName(inputUserName) == null){
				this.addFieldError("user.userName", "用户名不存在，请重新输入！");
				forward = "login";
			}else{
				User user = userDao.getUserByName(inputUserName);
				
				if(Const.USERSTATUS_ACTIVE.equals(user.getStatus()) && inputPassword.equals(user.getPassword())){
					forward = "home";
					ProfileUtil.getProfile().setCustomerType(Const.CUSTOMERTYPE_CUSTOMER);
					ProfileUtil.getProfile().setUserName(user.getUserName());
					ProfileUtil.getProfile().setCustomerNumber(user.getCustomerNumber());
				}else if(Const.USERSTATUS_LOCK.equals(user.getStatus())){
					this.addFieldError("user.userName", "用户名或密码不正确！请联系银行工作人员获取更多的支持。");
					forward = "login";
				}else{
					this.addFieldError("user.userName", "用户名或密码不正确！");
					forward = "login";
					
					user.setFailloginCount(user.getFailloginCount()+1);
					if(user.getFailloginCount()>=3){
						user.setStatus(Const.USERSTATUS_LOCK);
					}
					userDao.modifyUser(user);
				}	
			}
		}catch(Exception e){
			log.error("Error during login:"+ e.getMessage());
			this.addFieldError("user.userName", "未知错误！请联系银行工作人员获取更多的支持。");
			forward = "login";
		}
		return forward;
	}

	@Override
	public void validate() {
		if("".equals(user.getUserName())){
			this.addFieldError("user.userName", "用户名不能为空！");
		}
		if("".equals(user.getPassword())){
			this.addFieldError("user.password", "密码不能为空！");
		}
	}
	
	
}
