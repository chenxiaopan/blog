package net.cxp.blog.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * md5加密工具类
 * 
 * @author cxp
 * @date 2017-1-07
 * 
 */
public class CryptographyUtil {

	public static String md5(String str, String salt) {
        //Md5Hash是Shiro中的一个方法
		return new Md5Hash(str, salt).toString();
	}

}






