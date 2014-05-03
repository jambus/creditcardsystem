package com.xinhua.constant;

public class Const {
	public final static String USERSTATUS_ACTIVE = "A";
	public final static String USERSTATUS_LOCK = "L";

	public final static String SYSPROFILE = "SystemProfile";
	public final static String CUSTOMERTYPE_VISIT = "VISIT";
	public final static String CUSTOMERTYPE_CUSTOMER = "CUSTOMER";

	public final static String CUSTOMERTYPE_EXISTING = "E";
	public final static String CUSTOMERTYPE_NEW = "N";
	
	public final static String CARD_INACTIVE = "N";
	public final static String CARD_ACTIVE = "Y";
	
	public final static String TXN_CYCLE_FLAG_UNBILLED = "U";
	public final static String TXN_CYCLE_FLAG_BILLED = "B";
	
	public final static String CARDBLOCKCODE_NORMAL = " ";
	public final static String CARDBLOCKCODE_LOST = "L";
	public final static String CARDBLOCKCODE_INACTIVE = "N";
	
	public final static String CARDIND_PRIMARY = "P";
	public final static String CARDIND_SUPPLEMENTARY = "S";
	
	public final static String CARDLOGO_NORMAL = "100";
	public final static String CARDLOGO_SILVER = "200";
	public final static String CARDLOGO_GOLD = "300";
	
	public static enum IIN {
		VISA(4,70), MASTERCARD(5,71), UNIONPAY(62,72);

		IIN(int value,int productType) {
			this.value = value;
			this.productType = productType;
		}
		private final int value;
		private final int productType;

		public int getValue() {
			return value;
		}
		
		public int getProductType(){
			return productType;
		}
	}
}
