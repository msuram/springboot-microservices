package com.example.demo.common.util;


public class AppEncDecode {

	public static String decode(String encodedValue) {
		String decodedValue;
		
		if ( encodedValue.isEmpty() || encodedValue.length() == 0) {
			return null;
		}
		decodedValue = "decoded";
		
		//do process
		return decodedValue;
	}
	
	
}
