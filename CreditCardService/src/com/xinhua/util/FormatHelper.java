package com.xinhua.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FormatHelper {
	public static String getBirthday(Timestamp t){
		return new SimpleDateFormat("MM/dd/yyyy").format(t);
	}
}
