package com.xinhua.util;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Calendar;

import com.xinhua.constant.Const;
import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.UserInfo;

public class GetCardInfo {
	private static SecureRandom random = new SecureRandom();
	
	public static String generateAccountNumber(){
		String number = "";
		 int a[] = new int[10];
	      for(int i=0;i<a.length;i++) {
	          a[i] = random.nextInt(10);
	          number += a[i];
	      }
		return number;
	}
	
	public static String generateCreditCardNumber(Const.IIN inn){
		String number = "";
		
		if(inn !=null){
			number = String.valueOf(inn.getValue());
		}
		
		 int a[] = new int[16-number.length()];
	      for(int i=0;i<a.length;i++) {
	    	  a[i] = random.nextInt(10);
	          number += a[i];
	      }
		return number;
	}
	
	public static BigDecimal getAmount(UserInfo userInfo){
		DecimalFormat df = new DecimalFormat("#.00");
		BigDecimal amount = new BigDecimal(df.format(1.4 * userInfo.getSalary()));
		System.out.println("amount = " + amount);
		return amount;
	}
	
	public static CardInfo initCreditCardInfo(UserInfo userInfo, String accountNumber){
		CardInfo cardInfo = new CardInfo();

		cardInfo.setCardNumber(generateCreditCardNumber(Const.IIN.UNIONPAY));
		cardInfo.setAccountNumber(accountNumber);
		
		double creditLimit = userInfo.getSalary() * 1.5;
		cardInfo.setAvailableAmount(BigDecimal.valueOf(creditLimit));
		cardInfo.setCreditLimit(BigDecimal.valueOf(creditLimit));
		cardInfo.setCurrentAmount(BigDecimal.valueOf(creditLimit));
		
		cardInfo.setCardActiveCode(Const.CARD_INACTIVE);
		cardInfo.setCardBlockCode(Const.CARDBLOCKCODE_INACTIVE);
		
		String embossName = userInfo.getFirstName() + " " + userInfo.getLastName();
		cardInfo.setCardEmbossName(embossName);
		
		Calendar today = Calendar.getInstance();
		today.add(Calendar.YEAR, 3);
		cardInfo.setCardExpireDate(today.getTime());
		
		cardInfo.setCardIndicator(Const.CARDIND_PRIMARY);
		
		if(creditLimit<=10000){
			cardInfo.setCardLogo(Const.CARDLOGO_NORMAL);
		}else if(creditLimit<100000){
			cardInfo.setCardLogo(Const.CARDLOGO_SILVER);
		}else{
			cardInfo.setCardLogo(Const.CARDLOGO_GOLD);
		}
		
		cardInfo.setProductType(String.valueOf(Const.IIN.UNIONPAY.getProductType()));

		return cardInfo;
	}
}
