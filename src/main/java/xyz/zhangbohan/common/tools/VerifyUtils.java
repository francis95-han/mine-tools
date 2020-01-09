/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.common.tools;



import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.*;
/**
 * file encoding: utf-8
 * Function :
 * Create : 10/12/2019 10:14 AM
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
public class VerifyUtils {
	/**
	 * 天气签名生成算法-JAVA版本
	 * @param params 请求参数集，所有参数必须已转换为字符串类型
	 * @param secret 签名密钥（用户的认证key）
	 * @return 签名
	 * @throws IOException
	 */
	public static String getSignature(HashMap params, String secret) throws IOException {
		// 先将参数以其参数名的字典序升序进行排序
		Map sortedParams = new TreeMap(params);
		Set<Map.Entry> entrys = sortedParams.entrySet();

		// 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起

		StringBuilder baseString = new StringBuilder();
		for (Map.Entry param : entrys) {
			//sign参数 和 空值参数 不加入算法
			if(param.getValue()!=null &&
					!"".equals(param.getKey()) &&
					!"sign".equals(param.getKey()) &&
					!"key".equals(param.getKey()) &&
					!"".equals(param.getValue())) {
				baseString.append(param.getKey()).append("=").append(param.getValue()).append("&");
			}
		}
		if(baseString.length() > 0 ) {
			baseString.deleteCharAt(baseString.length() - 1).append(secret);
		}

		// 使用MD5对待签名串求签
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(baseString.toString().getBytes("UTF-8"));
			Base64.Encoder encoder = Base64.getEncoder();
			return new String(encoder.encode(bytes));
		} catch (GeneralSecurityException ex) {
			throw new IOException(ex);
		}
	}

}
