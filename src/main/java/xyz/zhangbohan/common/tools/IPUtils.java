/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.common.tools;

import com.google.common.base.Strings;

import javax.servlet.http.HttpServletRequest;
/**
 * file encoding: utf-8
 * Function :
 * Create : 1/20/2020 4:25 PM
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
public class IPUtils {
	public static final String UNKNOWN_CODE = "unknown";

	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (Strings.isNullOrEmpty(ip) || ip.equalsIgnoreCase(UNKNOWN_CODE)) {
			ip = request.getHeader("proxy-clientvo-ip");
		} else {
			String[] split = ip.split(",");
			return split.length > 1 ? split[0] : ip;
		}
		if (Strings.isNullOrEmpty(ip) || ip.equalsIgnoreCase(UNKNOWN_CODE)) {
			ip = request.getHeader("wl-proxy-clientvo-ip");
		}
		if (Strings.isNullOrEmpty(ip) || ip.equalsIgnoreCase(UNKNOWN_CODE)) {
			ip = request.getHeader("http-client-ip");
		}
		if (Strings.isNullOrEmpty(ip) || ip.equalsIgnoreCase(UNKNOWN_CODE)) {
			ip = request.getHeader("http-x-forwarded-for-ip");
		}
		if (Strings.isNullOrEmpty(ip) || ip.equalsIgnoreCase(UNKNOWN_CODE)) {
			ip = request.getHeader("x-real-ip");
		}
		if (Strings.isNullOrEmpty(ip) || ip.equalsIgnoreCase(UNKNOWN_CODE)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
