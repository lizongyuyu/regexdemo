package regex;

import java.util.Arrays;

/**
 * ���ַ���
 * match(String regex):�Դ���ʼƥ��ͽ�������
 * split(String regex):��ָ���ַ�������regex���зָ� regexΪ�ָ���
 * @author Nick
 *
 */
public class RegexDemo {
	public static void main(String[] args) {
		/**
		 * ������ʽ
		 * �ֻ�����������֤
		 */
		String regex = "1[3578][0-9]{9}";
		String regex1 = "1[3578]\\d{9}";
		String phone = "15032177520";
		boolean end = phone.matches(regex);//�����ַ�����λ�ò��ܵߵ�
		System.out.println(end);
		/**
		 * ������֤
		 */
		String regex2 = "[1-9]\\d{7,10}@qq\\.com";
		String qqmail = "375705793@qq.com";
		boolean mail = qqmail.matches(regex2);
		System.out.println(mail);
		/**
		 * �ص㣺---------------------------------------------------------------------
		 * �����ж�:��2015-11-30;
		 * ���£�(0[13578])|(1[02])-((0[1-9])|([12][0-9])|(3[01]))
		 * С�£�(0[469]|11)-(0[1-9]|([12][0-9])|30)
		 * 2�£�(02-(0[1-9])|([12][0-9]))
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
		 * ���ݸ�����������ʽ��Ϊ�ָ��������ַ����ָ�ɶಿ�֣�������һ��String������
		 */
		String strs = "java,   php,  c++,end";
		//����,\\s*��Ϊ�ָ����ָ��ַ���
		//�����.��Ҫת��\.
		String [] arr = strs.split(",\\s*");
		System.out.println(Arrays.toString(arr));
		
		/**
		 * ---------------------------------------------------------------------------------
		 * ����Բ���ű�ʾ���飬���Խ�һϵ��������ʽ��ʾΪһ������
		 * ��ϰ:
		 * �����ֻ���+86 15032177573
		 * +86���п���
		 * +86�����ĺ���֮��ո����û�л��߶��
		 * �绰������ʮһλ
		 */
		String regex4 = "(\\+86)?\\s*1[3578]\\d{9}";//��Ҫ����ת���ַ�
		String phonew = "+861231543434";
		System.out.println(phonew.matches(regex4));
		
		/**
		 * -------------------------------------------------------------------------------
		 * ���ַ����е�������-�����滻��
		 * ������ʽ�滻����
		 * replaceAll(,)
		 */
		String reStr = "sfhkdsf13hskfhsdf4646-sfhk33";
		reStr = reStr.replaceAll("\\d+", "����");
		System.out.println(reStr);
		/**
		 * ��ϰ �����ַ�����
		 */
		String reStr2 = "�Բۣ��Բۣ����ǵ�";
		reStr2 = reStr2.replaceAll("(�Բ�)+","**");
		System.out.println(reStr2.toString());
		/**
		 * ������ʽ��������α�ʾ
		 * ����unique����
		 * ��Χ��[\u4e00-\u9af5]
		 * ����String regex = "[\u4e00-\u9af5]{2,4}";
		 * ��ʾ���ĳ���2-4��	
		 */
	}

}
