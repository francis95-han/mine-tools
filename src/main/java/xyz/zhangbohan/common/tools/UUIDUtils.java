/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.common.tools;

import lombok.Data;

import java.util.UUID;
/**
 * file encoding: utf-8
 * Function :
 * Create : 2020/4/15 9:30
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
public class UUIDUtils {

	public static String UUID32() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
	}

}
