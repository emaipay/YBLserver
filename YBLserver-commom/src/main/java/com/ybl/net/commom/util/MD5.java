package com.ybl.net.commom.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 
 * @date 2016-12-13
 */
public final class MD5 {

	public static String SHA_1(String instr) {

		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA-1");

			md.update(instr.getBytes());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(System.err);

			return null;
		}

		byte[] result = md.digest();

		StringBuffer sb = new StringBuffer();

		for (byte b : result) {
			int i = b & 0xff;
			if (i <= 0xf) {
				sb.append(0);
			}
			sb.append(Integer.toHexString(i));
		}

		return sb.toString().toUpperCase();
	}

	public static String MD5(String instr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}

		char[] charArray = instr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	public static void main(String[] args) {
		System.out.println(MD5.MD5("654321"));
		//System.out.println(MD5.MD5("SDK-BBX-010-12054730774").toUpperCase());
	}
}
