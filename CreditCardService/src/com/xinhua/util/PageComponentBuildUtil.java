package com.xinhua.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinhua.pojo.CardInfo;

public class PageComponentBuildUtil {
	
	public static Map<String,String> buildCardSelectDropdown(){
		Map<String,String> cardNumberDropDownMap = new HashMap<String,String>();
		List<CardInfo> list = ProfileUtil.getProfile().getCardList();
		if(list !=null){
			cardNumberDropDownMap.clear();
			for(int i=0;i<list.size();i++){
				cardNumberDropDownMap.put(""+i, list.get(i).getCardName() + " "+ list.get(i).getCardNumber());
			}
		}
		
		return cardNumberDropDownMap;
		
	}
}
