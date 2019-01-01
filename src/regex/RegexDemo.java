package regex;

import java.util.Arrays;

/**
 * 两种方法
 * match(String regex):自带开始匹配和结束功能
 * split(String regex):对指定字符串按照regex进行分割 regex为分隔符
 * @author Nick
 *
 */
public class RegexDemo {
	public static void main(String[] args) {
		/**
		 * 正则表达式
		 * 手机号码正则验证
		 */
		String regex = "1[3578][0-9]{9}";
		String regex1 = "1[3578]\\d{9}";
		String phone = "15032177520";
		boolean end = phone.matches(regex);//两个字符串的位置不能颠倒
		System.out.println(end);
		/**
		 * 邮箱验证
		 */
		String regex2 = "[1-9]\\d{7,10}@qq\\.com";
		String qqmail = "375705793@qq.com";
		boolean mail = qqmail.matches(regex2);
		System.out.println(mail);
		/**
		 * 重点：---------------------------------------------------------------------
		 * 日期判断:例2015-11-30;
		 * 大月：(0[13578])|(1[02])-((0[1-9])|([12][0-9])|(3[01]))
		 * 小月：(0[469]|11)-(0[1-9]|([12][0-9])|30)
		 * 2月：(02-(0[1-9])|([12][0-9]))
		 */
		String regex3 = "\\d{4}-("
				+ "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])|"
				+ "(0[469]|11)-(0[1-9]|[12][0-9]|30)|"
				+ "02-(0[1-9]|[12][0-9])"
				+ ")";
		
		/**
		 * "\\d{4}-("
				+ "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])|"
				+ "(0[469]|11)-(0[1-9]|[12][0-9]|30)|"
				+ "02-(0[1-9]|[12][0-9])"
				+ ")";
		 */
		String date = "2018-03-30";
		boolean n = date.matches(regex3);
		System.out.println(n);
		/**
		 * --------------------------------------------------------------------------
		 * split(String regex) -String[]\
		 * 根据给定的正则表达式作为分隔符，将字符串分割成多部分，保存在一个String数组中
		 */
		String strs = "java,   php,  c++,end";
		//根据,\\s*作为分隔符分割字符串
		//如果用.需要转义\.
		String [] arr = strs.split(",\\s*");
		System.out.println(Arrays.toString(arr));
		
		/**
		 * ---------------------------------------------------------------------------------
		 * （）圆括号表示分组，可以将一系列正则表达式表示为一个整体
		 * 练习:
		 * 检索手机号+86 15032177573
		 * +86可有可无
		 * +86与后面的号码之间空格可以没有或者多个
		 * 电话号码有十一位
		 */
		String regex4 = "(\\+86)?\\s*1[3578]\\d{9}";//不要忘了转义字符
		String phonew = "+861231543434";
		System.out.println(phonew.matches(regex4));
		
		/**
		 * -------------------------------------------------------------------------------
		 * 把字符串中的数字用-数字替换掉
		 * 正则表达式替换内容
		 * replaceAll(,)
		 */
		String reStr = "sfhkdsf13hskfhsdf4646-sfhk33";
		reStr = reStr.replaceAll("\\d+", "数字");
		System.out.println(reStr);
		/**
		 * 练习 敏感字符过滤
		 */
		String reStr2 = "卧槽，卧槽，真是的";
		reStr2 = reStr2.replaceAll("(卧槽)+","**");
		System.out.println(reStr2.toString());
		/**
		 * 正则表达式中中文如何表示
		 * 利用unique编码
		 * 范围：[\u4e00-\u9af5]
		 * 例：String regex = "[\u4e00-\u9af5]{2,4}";
		 * 表示中文出现2-4次	
		 */
	}

}
