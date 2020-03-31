/*
 * Copyright (c) 2020. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.common.tools;

import com.jcraft.jsch.SftpException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class SFTPUtilTest {
	//上传文件测试
	public static void main(String[] args) throws SftpException, IOException {
		SFTPUtil sftp = new SFTPUtil("用户名", "密码", "ip地址", 22);
		sftp.login();
		File file = new File("D:\\图片\\t0124dd095ceb042322.jpg");
		InputStream is = new FileInputStream(file);

		sftp.upload("基础路径", "文件路径", "test_sftp.jpg", is);
		sftp.logout();
	}
}