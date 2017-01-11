package net.cxp.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 日期工具类
 * @author cxp
 * 
 */
public class DateUtil {

	/**
	 * 日期对象转字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (date != null) {
			result = sdf.format(date);
		}
		return result;
	}
	
	
	/**
	 * 字符串转日期对象
	 * @param str
	 * @param format
	 * @return
	 * @throws ParseException 
	 */
	public static Date  formatString(String str,String format) throws ParseException{
		
		if(StringUtil.isEmpty(str)){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		 return sdf.parse(str);
	}
	
	//得到当前日期字符串
	public static String getCurrentDateStr(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(date);		
	}
	
}
