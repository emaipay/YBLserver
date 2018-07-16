package com.ybl.net.commom.util;

public class GenerateCnUtil {
    private static final char[] codeArr = {'1','2','3','4','5','6','7','8','9'};
    
    private static final char[] letter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
	public static long generateCn() {
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			
			b.append(String.valueOf(codeArr[(int)(codeArr.length*Math.random())]));
		}
		return Long.valueOf(b.toString());
	}
	
	/**
	 * 生成机器类型编号
	 */
	public static String generateNumber(){
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			
			b.append(String.valueOf(codeArr[(int)(codeArr.length*Math.random())]));
		}
		return b.toString();
	}
	
	/**
	 * 生成商户密钥
	 */
	public static String generateKey(){
		char[] code = new char[61];
		System.arraycopy(codeArr, 0, code, 0, 9);
		System.arraycopy(letter, 0, code, 9, 52);
		
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < 32; i++) {
			
			b.append(String.valueOf(code[(int)(code.length*Math.random())]));
		}
		return b.toString();
	}
	
	public static void main(String[] args) {
		String key = generateKey();
		System.out.println(key);
	}
}