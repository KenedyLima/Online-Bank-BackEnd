package com.digitalbank.entities;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class OperationUtil {
	
	private OperationUtil() {
		
	}
	
	public static boolean isKeyYearMonthPresent(HashMap<String, List<Operation>> operations, LocalDateTime date) {
		String key = getYearMonthKey(date);
		return operations.get(key) == null ? false : true;		
	}
	
	public static String getYearMonthKey(LocalDateTime date) {
		StringBuilder builder = new StringBuilder();
		builder.append(date.getYear()).append("-").append(date.getMonthValue());
		return builder.toString();
	}
	
}
