package com.xinhua.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.xinhua.pojo.UserInfo;

public class GetCardInfo {
	
	public static String getAccountNumber(){
		String number = "";
		 int a[] = new int[10];
	      for(int i=0;i<a.length;i++) {
	          a[i] = (int)(10*(Math.random()));
	          number = number + a[i];
	      }
		return number;
	}
	
	public static BigDecimal getAmount(UserInfo userInfo){
		DecimalFormat df = new DecimalFormat("#.00");
		BigDecimal amount = new BigDecimal(df.format(1.4 * userInfo.getSalary()));
		System.out.println("amount = " + amount);
		return amount;
	}
}
