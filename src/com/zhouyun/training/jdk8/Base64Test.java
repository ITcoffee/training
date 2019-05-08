package com.zhouyun.training.jdk8;

import java.util.Base64;
import java.util.UUID;

/** 
 * Base64编码
 *
 * @author  周云
 * @version 2019年5月8日
 */
public class Base64Test {

	public static void main(String[] args) {
		
		try {
			// 使用基本编码
			String base64EncodedString = Base64.getEncoder().encodeToString("zhouyun?jdk8".getBytes("utf-8"));
			System.out.println("Base64 编码字符串 (基本) :" + base64EncodedString);
			
			// 解码
			byte[] base64DecodedBytes = Base64.getDecoder().decode(base64EncodedString);
			System.out.println("原始字符串：" + new String(base64DecodedBytes, "utf-8"));
			
			base64EncodedString = Base64.getUrlEncoder().encodeToString("http://zhouyun.com?jdk8".getBytes("utf-8"));
			System.out.println("Base64 编码字符串 (URL) :" + base64EncodedString);
			base64DecodedBytes = Base64.getUrlDecoder().decode(base64EncodedString);
			System.out.println("原始url：" + new String(base64DecodedBytes, "utf-8"));
			
			base64EncodedString = Base64.getMimeEncoder().encodeToString(UUID.randomUUID().toString().getBytes("utf-8"));
			System.out.println("Base64 编码字符串 (MIME):" + base64EncodedString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
