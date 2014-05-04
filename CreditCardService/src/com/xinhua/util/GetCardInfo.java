package com.xinhua.util;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinhua.constant.Const;
import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.Transaction;
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
	
	public static List<CardInfo> getCreditCardAdditionalData(List<CardInfo> cardList){
		
		if(cardList ==null || cardList.size() ==0){
			return cardList;
		}
		for(int index=0;index<cardList.size();index++){
			CardInfo card = cardList.get(index);
			
			int productType = Integer.valueOf(card.getProductType());
			String cardName = "Credit　Card";
			if(Const.IIN.MASTERCARD.getProductType() == productType){
				cardName = "Master Card";
			}else if(Const.IIN.VISA.getProductType() == productType){
				cardName = "Visa";
			}else if(Const.IIN.UNIONPAY.getProductType() == productType){
				cardName = "Union Pay";
			}
			
			String logo = card.getCardLogo();
			if(Const.CARDLOGO_NORMAL == logo){
				cardName += "";
			}else if(Const.CARDLOGO_SILVER == logo){
				cardName += "Silver";
			}else if(Const.CARDLOGO_GOLD == logo){
				cardName += "Gold";
			}
			
			card.setCardName(cardName);
			card.setCardIndex(index);
			
		}
		return cardList;
	}
	
	public static List<Transaction> generationTransactions(String cardNumber){
		int row = random.nextInt(10);
		List<Transaction> txnList = new ArrayList<Transaction>();
		
		String[] merchantNames = new String[]{"Apple Store","Sumsung store","百联集团","沃尔玛","携程","巴西烤肉","LV","希尔顿饭店"};
		String[] merchantCodes = new String[]{"100",			"200",			"300",	"400",	"500","600","700","800"};
		String[] txnDescriptions = new String[]{"Iphone","Note III","雪碧","方便面","泰国一日游","烤肉","LV包","酒店客房"};
		String[] txnCodes = new String[]{"001",			"002",		"003","004","005",	  "006","007","010"};
		for(int i=0;i<row;i++){
			Transaction txn = new Transaction();
			txn.setCardNumber(cardNumber);
			txn.setCycleFlag(random.nextInt(1) == 1? Const.TXN_CYCLE_FLAG_BILLED:Const.TXN_CYCLE_FLAG_UNBILLED);
			
			int merchantIndex = random.nextInt(merchantNames.length);
			txn.setMerchantName(merchantNames[merchantIndex]);
			txn.setMerchantCode(merchantCodes[merchantIndex]);
			double txnAmount = Double.valueOf(""+random.nextInt(10000000)).doubleValue()/100;
			txn.setTransactionAmount(BigDecimal.valueOf(txnAmount));
			txn.setTransactionCode(txnCodes[merchantIndex]);
			txn.setTransactionDate(new Date());
			txn.setTransactionDescription(txnDescriptions[merchantIndex]);
			txn.setTransactionReferenceNumber(generateTxnReferenceNumber());
			txnList.add(txn);
		}
		
		return txnList; 
	}
	
	private static String generateTxnReferenceNumber(){
		String number = "";
		 int a[] = new int[25];
	      for(int i=0;i<a.length;i++) {
	          a[i] = random.nextInt(10);
	          number += a[i];
	      }
		return number;
	}
}
