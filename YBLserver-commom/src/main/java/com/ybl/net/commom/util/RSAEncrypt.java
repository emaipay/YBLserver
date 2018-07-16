package com.ybl.net.commom.util;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * RSA对称加密工具
 * @author 
 * @data 2017年3月29日
 */
public class RSAEncrypt {
	
	private static final Logger logger = LoggerFactory.getLogger(RSAEncrypt.class);
	
	private final static long E = 77777;
	
	/**
	 * 加密方法
	 * @param  p公钥
	 * 		   q私钥
	 * 		   s待加密字段
	 * @return 加密后的字符串，数字以:分割开，eg-> 111:222:333:444
	 */
	public static String encode(long p, long q, String s){
		try{
			long n=p*q;
			int len = s.toCharArray().length;
			char[] arr = Arrays.copyOf(s.toCharArray(), len);
			StringBuffer sb = new StringBuffer("");
			
			for(int i = 0; i < len && arr[i] != 0; i++)
			{
				int r = (int)rsa(arr[i], E, n);
				sb.append(r + ":");
			}
			sb.deleteCharAt(sb.length()-1);
			return sb.toString();
		}catch(Exception e){
			logger.error("加密出现异常，公钥P-{}, 私钥-{}, 加密串-{}", p, q, s);
			return "-1";
		}
	}
	
	/**
	 * 解密
	 * @param  p公钥
	 * 		   q私钥
	 * 		   s待解密字段以:分割开，eg-> 111:222:333:444
	 * @return 解密后的明文字符串
	 */
	public static String decode(long p, long q, String s){
		try{
			long d = 1, t = (p-1)*(q-1), n = p*q;
			String[] arr = s.split(":");
			
			while(((E * d) % t) != 1)
			{ 
				d++; 
			}
			
			int len = arr.length;
			StringBuffer sb = new StringBuffer("");
			for(int i=0; i<len && Integer.valueOf(arr[i]) != 0; i++)
			{
				char c = (char)rsa(Long.valueOf(arr[i]), d, n);
				sb.append(c);
			}
			return sb.toString();
		}catch(Exception e) {
			logger.error("解密出现异常，公钥P-{}, 私钥-{}, 解密串-{}", p, q, s);
			return "-1";
		}
	}

	/**
	 * 加解密算法
	 */
	public static long rsa(long a, long b, long c) {
		long r = 1;
		b = b + 1;
		while(b != 1)
		{
			r = r * a;
			r = r % c;
			b--;
		}
		return r;
	}
	
	public static void main(String[] args) {
		/*String s = "{\"name\":\"meitelesi123\"}";
		String s1 = encode(53, 79, s);
		System.out.println(s1);
		String s2 = decode(53, 79, s1);
		System.out.println(s2);*/
		System.out.println(Long.valueOf("0"));
	}
}
