/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.common.tools;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
/**
 * file encoding: utf-8
 * Function :
 * Create : 2019/11/6 9:19
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@Slf4j
public class TimeUtils {


	public static Date transToDate(LocalDateTime localDateTime) {

		Date from = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(8)));
		log.info("时间转化 -- {}转化为{}",localDateTime,String.valueOf(from));
		return from;
	}

}
