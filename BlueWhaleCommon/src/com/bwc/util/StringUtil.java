package com.bwc.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * String������.
 * 
 * @author Bill Tang
 * @date 2014��06��24��
 */
public class StringUtil {

	private static final int INDEX_NOT_FOUND = -1;
	private static final String EMPTY = "";
	/**
	 * <p>
	 * The maximum size to which the padding constant(s) can expand.
	 * </p>
	 */
	private static final int PAD_LIMIT = 8192;

	/**
	 * ���ܣ�����ǵķ���ת����ȫ�Ƿ���.(��Ӣ���ַ�ת�����ַ�)
	 * 
	 * @author ������
	 * @param str
	 *            Դ�ַ���
	 * @return String
	 * @date 2014��06��24��
	 */
	public static String changeToFull(String str) {
		String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";
		String[] decode = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"'", "\"", "��", "��", "��", "��", "��", "��" };
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int pos = source.indexOf(str.charAt(i));
			if (pos != -1) {
				result += decode[pos];
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	/**
	 * ���ܣ�cs�����Ƿ�һ�����������ַ�����searchChars�е��ַ���
	 * 
	 * @author ������
	 * @param cs
	 *            �ַ���
	 * @param searchChars
	 *            �ַ�����
	 * @return boolean ������������true�����򷵻�false��
	 * @date 2014��06��24��
	 */
	public static boolean containsNone(CharSequence cs, char... searchChars) {
		if (cs == null || searchChars == null) {
			return true;
		}
		int csLen = cs.length();
		int csLast = csLen - 1;
		int searchLen = searchChars.length;
		int searchLast = searchLen - 1;
		for (int i = 0; i < csLen; i++) {
			char ch = cs.charAt(i);
			for (int j = 0; j < searchLen; j++) {
				if (searchChars[j] == ch) {
					if (Character.isHighSurrogate(ch)) {
						if (j == searchLast) {
							// missing low surrogate, fine, like
							// String.indexOf(String)
							return false;
						}
						if (i < csLast
								&& searchChars[j + 1] == cs.charAt(i + 1)) {
							return false;
						}
					} else {
						// ch is in the Basic Multilingual Plane
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * <p>
	 * ����ΪUnicode����ʽ '\u0020'.
	 * </p>
	 * 
	 * @author ������
	 * 
	 *         <pre>
	 *   CharUtils.unicodeEscaped(' ') = "\u0020"
	 *   CharUtils.unicodeEscaped('A') = "\u0041"
	 * </pre>
	 * 
	 * @param ch
	 *            Դ�ַ���
	 * @return ת�����ַ���
	 * @date 2014��06��24��
	 */
	public static String unicodeEscaped(char ch) {
		if (ch < 0x10) {
			return "\\u000" + Integer.toHexString(ch);
		} else if (ch < 0x100) {
			return "\\u00" + Integer.toHexString(ch);
		} else if (ch < 0x1000) {
			return "\\u0" + Integer.toHexString(ch);
		}
		return "\\u" + Integer.toHexString(ch);
	}

	/**
	 * <p>
	 * ����tostring����������������null�����ؿ��ַ�����
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.toString(null)         = ""
	 * ObjectUtils.toString("")           = ""
	 * ObjectUtils.toString("bat")        = "bat"
	 * ObjectUtils.toString(Boolean.TRUE) = "true"
	 * </pre>
	 *
	 * @param obj
	 *            Դ
	 * @return String
	 */
	public static String toString(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	/**
	 * <p>
	 * ����tostring����������������null������ָ����Ĭ��ֵ��
	 * </p>
	 *
	 * <pre>
	 * ObjectUtils.toString(null, null)           = null
	 * ObjectUtils.toString(null, "null")         = "null"
	 * ObjectUtils.toString("", "null")           = ""
	 * ObjectUtils.toString("bat", "null")        = "bat"
	 * ObjectUtils.toString(Boolean.TRUE, "null") = "true"
	 * </pre>
	 *
	 * @param obj
	 *            Դ
	 * @param nullStr
	 *            ���objΪnullʱ�������ָ��ֵ
	 * @return String
	 */
	public static String toString(Object obj, String nullStr) {
		return obj == null ? nullStr : obj.toString();
	}

	/**
	 * <p>
	 * ֻ��Դ�ַ������Ƴ�ָ����ͷ���ַ���.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.removeStart(null, *)      = null
	 * StringUtil.removeStart("", *)        = ""
	 * StringUtil.removeStart(*, null)      = *
	 * StringUtil.removeStart("www.domain.com", "www.")   = "domain.com"
	 * StringUtil.removeStart("domain.com", "www.")       = "domain.com"
	 * StringUtil.removeStart("www.domain.com", "domain") = "www.domain.com"
	 * StringUtil.removeStart("abc", "")    = "abc"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param remove
	 *            ��Ҫ���Ƴ������ַ���
	 * @return String
	 */
	public static String removeStart(String str, String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (str.startsWith(remove)) {
			return str.substring(remove.length());
		}
		return str;
	}

	/**
	 * <p>
	 * ֻ��Դ�ַ������Ƴ�ָ����β�����ַ���.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.removeEnd(null, *)      = null
	 * StringUtil.removeEnd("", *)        = ""
	 * StringUtil.removeEnd(*, null)      = *
	 * StringUtil.removeEnd("www.domain.com", ".com.")  = "www.domain.com"
	 * StringUtil.removeEnd("www.domain.com", ".com")   = "www.domain"
	 * StringUtil.removeEnd("www.domain.com", "domain") = "www.domain.com"
	 * StringUtil.removeEnd("abc", "")    = "abc"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param remove
	 *            ��Ҫ���Ƴ������ַ���
	 * @return String
	 */
	public static String removeEnd(String str, String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (str.endsWith(remove)) {
			return str.substring(0, str.length() - remove.length());
		}
		return str;
	}

	/**
	 * <p>
	 * ��һ���ַ����ظ�N��
	 * </p>
	 *
	 * <pre>
	 * StringUtil.repeat(null, 2) = null
	 * StringUtil.repeat("", 0)   = ""
	 * StringUtil.repeat("", 2)   = ""
	 * StringUtil.repeat("a", 3)  = "aaa"
	 * StringUtil.repeat("ab", 2) = "abab"
	 * StringUtil.repeat("a", -2) = ""
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param repeat
	 *            �ظ��Ĵ���
	 * @return String
	 */
	public static String repeat(String str, int repeat) {
		// Performance tuned for 2.0 (JDK1.4)

		if (str == null) {
			return null;
		}
		if (repeat <= 0) {
			return EMPTY;
		}
		int inputLength = str.length();
		if (repeat == 1 || inputLength == 0) {
			return str;
		}
		if (inputLength == 1 && repeat <= PAD_LIMIT) {
			return repeat(str.charAt(0), repeat);
		}

		int outputLength = inputLength * repeat;
		switch (inputLength) {
		case 1:
			return repeat(str.charAt(0), repeat);
		case 2:
			char ch0 = str.charAt(0);
			char ch1 = str.charAt(1);
			char[] output2 = new char[outputLength];
			for (int i = repeat * 2 - 2; i >= 0; i--, i--) {
				output2[i] = ch0;
				output2[i + 1] = ch1;
			}
			return new String(output2);
		default:
			StringBuilder buf = new StringBuilder(outputLength);
			for (int i = 0; i < repeat; i++) {
				buf.append(str);
			}
			return buf.toString();
		}
	}

	/**
	 * <p>
	 * ��һ���ַ����ظ�N�Σ������м����ָ���ķָ���
	 * </p>
	 *
	 * <pre>
	 * StringUtil.repeat(null, null, 2) = null
	 * StringUtil.repeat(null, "x", 2)  = null
	 * StringUtil.repeat("", null, 0)   = ""
	 * StringUtil.repeat("", "", 2)     = ""
	 * StringUtil.repeat("", "x", 3)    = "xxx"
	 * StringUtil.repeat("?", ", ", 3)  = "?, ?, ?"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param separator
	 *            �ָ���
	 * @param repeat
	 *            �ظ�����
	 * @return String
	 */
	public static String repeat(String str, String separator, int repeat) {
		if (str == null || separator == null) {
			return repeat(str, repeat);
		} else {
			// given that repeat(String, int) is quite optimized, better to rely
			// on it than try and splice this into it
			String result = repeat(str + separator, repeat);
			return removeEnd(result, separator);
		}
	}

	/**
	 * <p>
	 * ��ĳ���ַ��ظ�N��.
	 * </p>
	 *
	 * @param ch
	 *            ĳ���ַ�
	 * @param repeat
	 *            �ظ�����
	 * @return String
	 */
	public static String repeat(char ch, int repeat) {
		char[] buf = new char[repeat];
		for (int i = repeat - 1; i >= 0; i--) {
			buf[i] = ch;
		}
		return new String(buf);
	}

	/**
	 * <p>
	 * �ַ������ȴﲻ��ָ������ʱ�����ַ����ұ߲�ָ�����ַ�.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.rightPad(null, *, *)     = null
	 * StringUtil.rightPad("", 3, 'z')     = "zzz"
	 * StringUtil.rightPad("bat", 3, 'z')  = "bat"
	 * StringUtil.rightPad("bat", 5, 'z')  = "batzz"
	 * StringUtil.rightPad("bat", 1, 'z')  = "bat"
	 * StringUtil.rightPad("bat", -1, 'z') = "bat"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param size
	 *            ָ���ĳ���
	 * @param padChar
	 *            ���в�����ַ�
	 * @return String
	 */
	public static String rightPad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		}
		int pads = size - str.length();
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (pads > PAD_LIMIT) {
			return rightPad(str, size, String.valueOf(padChar));
		}
		return str.concat(repeat(padChar, pads));
	}

	/**
	 * <p>
	 * �����ַ������ȣ�����߲���ָ���ַ�
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.rightPad(null, *, *)      = null
	 * StringUtil.rightPad("", 3, "z")      = "zzz"
	 * StringUtil.rightPad("bat", 3, "yz")  = "bat"
	 * StringUtil.rightPad("bat", 5, "yz")  = "batyz"
	 * StringUtil.rightPad("bat", 8, "yz")  = "batyzyzy"
	 * StringUtil.rightPad("bat", 1, "yz")  = "bat"
	 * StringUtil.rightPad("bat", -1, "yz") = "bat"
	 * StringUtil.rightPad("bat", 5, null)  = "bat  "
	 * StringUtil.rightPad("bat", 5, "")    = "bat  "
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param size
	 *            �����ĳ���
	 * @param padStr
	 *            ���ұ߲�����ַ���
	 * @return String
	 */
	public static String rightPad(String str, int size, String padStr) {
		if (str == null) {
			return null;
		}
		if (isEmpty(padStr)) {
			padStr = " ";
		}
		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (padLen == 1 && pads <= PAD_LIMIT) {
			return rightPad(str, size, padStr.charAt(0));
		}

		if (pads == padLen) {
			return str.concat(padStr);
		} else if (pads < padLen) {
			return str.concat(padStr.substring(0, pads));
		} else {
			char[] padding = new char[pads];
			char[] padChars = padStr.toCharArray();
			for (int i = 0; i < pads; i++) {
				padding[i] = padChars[i % padLen];
			}
			return str.concat(new String(padding));
		}
	}

	/**
	 * <p>
	 * �����ַ������ȣ�����߲���ո�
	 * </p>
	 *
	 * <pre>
	 * StringUtil.leftPad(null, *)   = null
	 * StringUtil.leftPad("", 3)     = "   "
	 * StringUtil.leftPad("bat", 3)  = "bat"
	 * StringUtil.leftPad("bat", 5)  = "  bat"
	 * StringUtil.leftPad("bat", 1)  = "bat"
	 * StringUtil.leftPad("bat", -1) = "bat"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param size
	 *            �����ĳ���
	 * @return String
	 */
	public static String leftPad(String str, int size) {
		return leftPad(str, size, ' ');
	}

	/**
	 * <p>
	 * �����ַ������ȣ�����߲���ָ�����ַ�
	 * </p>
	 *
	 * <pre>
	 * StringUtil.leftPad(null, *, *)     = null
	 * StringUtil.leftPad("", 3, 'z')     = "zzz"
	 * StringUtil.leftPad("bat", 3, 'z')  = "bat"
	 * StringUtil.leftPad("bat", 5, 'z')  = "zzbat"
	 * StringUtil.leftPad("bat", 1, 'z')  = "bat"
	 * StringUtil.leftPad("bat", -1, 'z') = "bat"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param size
	 *            �����ĳ���
	 * @param padStr
	 *            ������ַ�
	 * @return String
	 */
	public static String leftPad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		}
		int pads = size - str.length();
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (pads > PAD_LIMIT) {
			return leftPad(str, size, String.valueOf(padChar));
		}
		return repeat(padChar, pads).concat(str);
	}

	/**
	 * <p>
	 * �����ַ������ȣ�����߲���ָ�����ַ�
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.leftPad(null, *, *)      = null
	 * StringUtil.leftPad("", 3, "z")      = "zzz"
	 * StringUtil.leftPad("bat", 3, "yz")  = "bat"
	 * StringUtil.leftPad("bat", 5, "yz")  = "yzbat"
	 * StringUtil.leftPad("bat", 8, "yz")  = "yzyzybat"
	 * StringUtil.leftPad("bat", 1, "yz")  = "bat"
	 * StringUtil.leftPad("bat", -1, "yz") = "bat"
	 * StringUtil.leftPad("bat", 5, null)  = "  bat"
	 * StringUtil.leftPad("bat", 5, "")    = "  bat"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param size
	 *            �����ĳ���
	 * @param padStr
	 *            ������ַ���
	 * @return String
	 */
	public static String leftPad(String str, int size, String padStr) {
		if (str == null) {
			return null;
		}
		if (isEmpty(padStr)) {
			padStr = " ";
		}
		int padLen = padStr.length();
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0) {
			return str; // returns original String when possible
		}
		if (padLen == 1 && pads <= PAD_LIMIT) {
			return leftPad(str, size, padStr.charAt(0));
		}

		if (pads == padLen) {
			return padStr.concat(str);
		} else if (pads < padLen) {
			return padStr.substring(0, pads).concat(str);
		} else {
			char[] padding = new char[pads];
			char[] padChars = padStr.toCharArray();
			for (int i = 0; i < pads; i++) {
				padding[i] = padChars[i % padLen];
			}
			return new String(padding).concat(str);
		}
	}

	/**
	 * <p>
	 * �����ַ������Ȳ������ڵ��ַ������У������󲿷��ÿո���䡣
	 * <p>
	 * 
	 * <pre>
	 * StringUtil.center(null, *)   = null
	 * StringUtil.center("", 4)     = "    "
	 * StringUtil.center("ab", -1)  = "ab"
	 * StringUtil.center("ab", 4)   = " ab "
	 * StringUtil.center("abcd", 2) = "abcd"
	 * StringUtil.center("a", 4)    = " a  "
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param size
	 *            �����ĳ���
	 * @return String
	 */
	public static String center(String str, int size) {
		return center(str, size, ' ');
	}

	/**
	 * <p>
	 * ���ַ��������޸�Ϊָ�����ȣ������о�����ʾ��
	 * </p>
	 *
	 * <pre>
	 * StringUtil.center(null, *, *)     = null
	 * StringUtil.center("", 4, ' ')     = "    "
	 * StringUtil.center("ab", -1, ' ')  = "ab"
	 * StringUtil.center("ab", 4, ' ')   = " ab"
	 * StringUtil.center("abcd", 2, ' ') = "abcd"
	 * StringUtil.center("a", 4, ' ')    = " a  "
	 * StringUtil.center("a", 4, 'y')    = "yayy"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param size
	 *            ָ���ĳ���
	 * @param padStr
	 *            ���Ȳ���ʱ������ַ���
	 * @return String
	 * @throws IllegalArgumentException
	 *             ����������ַ���Ϊ null���� empty
	 */
	public static String center(String str, int size, char padChar) {
		if (str == null || size <= 0) {
			return str;
		}
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0) {
			return str;
		}
		str = leftPad(str, strLen + pads / 2, padChar);
		str = rightPad(str, size, padChar);
		return str;
	}

	/**
	 * <p>
	 * ���ַ��������޸�Ϊָ�����ȣ������о�����ʾ��
	 * </p>
	 *
	 * <pre>
	 * StringUtil.center(null, *, *)     = null
	 * StringUtil.center("", 4, " ")     = "    "
	 * StringUtil.center("ab", -1, " ")  = "ab"
	 * StringUtil.center("ab", 4, " ")   = " ab"
	 * StringUtil.center("abcd", 2, " ") = "abcd"
	 * StringUtil.center("a", 4, " ")    = " a  "
	 * StringUtil.center("a", 4, "yz")   = "yayz"
	 * StringUtil.center("abc", 7, null) = "  abc  "
	 * StringUtil.center("abc", 7, "")   = "  abc  "
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param size
	 *            ָ���ĳ���
	 * @param padStr
	 *            ���Ȳ���ʱ������ַ���
	 * @return String
	 * @throws IllegalArgumentException
	 *             ����������ַ���Ϊ null���� empty
	 */
	public static String center(String str, int size, String padStr) {
		if (str == null || size <= 0) {
			return str;
		}
		if (isEmpty(padStr)) {
			padStr = " ";
		}
		int strLen = str.length();
		int pads = size - strLen;
		if (pads <= 0) {
			return str;
		}
		str = leftPad(str, strLen + pads / 2, padStr);
		str = rightPad(str, size, padStr);
		return str;
	}

	/**
	 * <p>
	 * ����ַ����Ƿ�ȫ��ΪСд.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.isAllLowerCase(null)   = false
	 * StringUtil.isAllLowerCase("")     = false
	 * StringUtil.isAllLowerCase("  ")   = false
	 * StringUtil.isAllLowerCase("abc")  = true
	 * StringUtil.isAllLowerCase("abC") = false
	 * </pre>
	 *
	 * @param cs
	 *            Դ�ַ���
	 * @return String
	 */
	public static boolean isAllLowerCase(String cs) {
		if (cs == null || isEmpty(cs)) {
			return false;
		}
		int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isLowerCase(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * ����Ƿ��Ǵ�д.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.isAllUpperCase(null)   = false
	 * StringUtil.isAllUpperCase("")     = false
	 * StringUtil.isAllUpperCase("  ")   = false
	 * StringUtil.isAllUpperCase("ABC")  = true
	 * StringUtil.isAllUpperCase("aBC") = false
	 * </pre>
	 *
	 * @param cs
	 *            Դ�ַ���
	 * @return String
	 */
	public static boolean isAllUpperCase(String cs) {
		if (cs == null || StringUtil.isEmpty(cs)) {
			return false;
		}
		int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isUpperCase(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * ��ת�ַ���.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.reverse(null)  = null
	 * StringUtil.reverse("")    = ""
	 * StringUtil.reverse("bat") = "tab"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @return String
	 */
	public static String reverse(String str) {
		if (str == null) {
			return null;
		}
		return new StringBuilder(str).reverse().toString();
	}

	/**
	 * <p>
	 * �ַ����ﲻ��һ������ʱ���ұ߲��հ�.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.rightPad(null, *)   = null
	 * StringUtil.rightPad("", 3)     = "   "
	 * StringUtil.rightPad("bat", 3)  = "bat"
	 * StringUtil.rightPad("bat", 5)  = "bat  "
	 * StringUtil.rightPad("bat", 1)  = "bat"
	 * StringUtil.rightPad("bat", -1) = "bat"
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param size
	 *            ָ���ĳ���
	 * @return String
	 */
	public static String rightPad(String str, int size) {
		return rightPad(str, size, ' ');
	}

	/**
	 * ���ұ߽�ȡ�ַ���.</p>
	 * 
	 * <pre>
	 * StringUtil.right(null, *)    = null
	 * StringUtil.right(*, -ve)     = ""
	 * StringUtil.right("", *)      = ""
	 * StringUtil.right("abc", 0)   = ""
	 * StringUtil.right("abc", 2)   = "bc"
	 * StringUtil.right("abc", 4)   = "abc"
	 * </pre>
	 * 
	 * @param str
	 *            Դ�ַ���
	 * @param len
	 *            ����
	 * @return String
	 */
	public static String right(String str, int len) {
		if (str == null) {
			return null;
		}
		if (len < 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(str.length() - len);
	}

	/**
	 * <p>
	 * ��ȡһ���ַ�����ǰ����.
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.left(null, *)    = null
	 * StringUtil.left(*, -ve)     = ""
	 * StringUtil.left("", *)      = ""
	 * StringUtil.left("abc", 0)   = ""
	 * StringUtil.left("abc", 2)   = "ab"
	 * StringUtil.left("abc", 4)   = "abc"
	 * </pre>
	 * 
	 * @param str
	 *            Դ�ַ���
	 * @param len
	 *            ��ȡ�ĳ���
	 * @return the String
	 */
	public static String left(String str, int len) {
		if (str == null) {
			return null;
		}
		if (len < 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(0, len);
	}

	/**
	 * <p>
	 * �õ�tag�ַ����м�����ַ�����ֻ���ص�һ��ƥ���
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.substringBetween(null, *)            = null
	 * StringUtil.substringBetween("", "")             = ""
	 * StringUtil.substringBetween("", "tag")          = null
	 * StringUtil.substringBetween("tagabctag", null)  = null
	 * StringUtil.substringBetween("tagabctag", "")    = ""
	 * StringUtil.substringBetween("tagabctag", "tag") = "abc"
	 * </pre>
	 * 
	 * @param str
	 *            Դ�ַ�����
	 * @param tag
	 *            ��ʶ�ַ�����
	 * @return String ���ַ���, ���û�з���Ҫ��ģ�����{@code null}��
	 */
	public static String substringBetween(String str, String tag) {
		return substringBetween(str, tag, tag);
	}

	/**
	 * <p>
	 * �õ������ַ����м�����ַ�����ֻ���ص�һ��ƥ���
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.substringBetween("wx[b]yz", "[", "]") = "b"
	 * StringUtil.substringBetween(null, *, *)          = null
	 * StringUtil.substringBetween(*, null, *)          = null
	 * StringUtil.substringBetween(*, *, null)          = null
	 * StringUtil.substringBetween("", "", "")          = ""
	 * StringUtil.substringBetween("", "", "]")         = null
	 * StringUtil.substringBetween("", "[", "]")        = null
	 * StringUtil.substringBetween("yabcz", "", "")     = ""
	 * StringUtil.substringBetween("yabcz", "y", "z")   = "abc"
	 * StringUtil.substringBetween("yabczyabcz", "y", "z")   = "abc"
	 * </pre>
	 * 
	 * @param str
	 *            Դ�ַ���
	 * @param open
	 *            ���ַ�����
	 * @param close
	 *            ĩ�ַ�����
	 * @return String ���ַ���, ���û�з���Ҫ��ģ�����{@code null}��
	 */
	public static String substringBetween(String str, String open, String close) {
		if (str == null || open == null || close == null) {
			return null;
		}
		int start = str.indexOf(open);
		if (start != INDEX_NOT_FOUND) {
			int end = str.indexOf(close, start + open.length());
			if (end != INDEX_NOT_FOUND) {
				return str.substring(start + open.length(), end);
			}
		}
		return null;
	}

	/**
	 * <p>
	 * �õ������ַ����м�����ַ���������ƥ�������Ϊ���鲢���ء�
	 * </p>
	 * 
	 * <pre>
	 * StringUtil.substringsBetween("[a][b][c]", "[", "]") = ["a","b","c"]
	 * StringUtil.substringsBetween(null, *, *)            = null
	 * StringUtil.substringsBetween(*, null, *)            = null
	 * StringUtil.substringsBetween(*, *, null)            = null
	 * StringUtil.substringsBetween("", "[", "]")          = []
	 * </pre>
	 *
	 * @param str
	 *            Դ�ַ���
	 * @param open
	 *            ���ַ�����
	 * @param close
	 *            ĩ�ַ�����
	 * @return String ���ַ�������, ���û�з���Ҫ��ģ�����{@code null}��
	 */
	public static String[] substringsBetween(String str, String open,
			String close) {
		if (str == null || isEmpty(open) || isEmpty(close)) {
			return null;
		}
		int strLen = str.length();
		if (strLen == 0) {
			return new String[0];
		}
		int closeLen = close.length();
		int openLen = open.length();
		List<String> list = new ArrayList<String>();
		int pos = 0;
		while (pos < strLen - closeLen) {
			int start = str.indexOf(open, pos);
			if (start < 0) {
				break;
			}
			start += openLen;
			int end = str.indexOf(close, start);
			if (end < 0) {
				break;
			}
			list.add(str.substring(start, end));
			pos = end + closeLen;
		}
		if (list.isEmpty()) {
			return null;
		}
		return list.toArray(new String[list.size()]);
	}

	/**
	 * ���ܣ��л��ַ����е�������ĸ��Сд��<br/>
	 * 
	 * <pre>
	 * StringUtil.swapCase(null)                 = null
	 * StringUtil.swapCase("")                   = ""
	 * StringUtil.swapCase("The dog has a BONE") = "tHE DOG HAS A bone"
	 * </pre>
	 * 
	 *
	 * @param str
	 *            Դ�ַ���
	 * @return String
	 */
	public static String swapCase(String str) {
		if (StringUtil.isEmpty(str)) {
			return str;
		}
		char[] buffer = str.toCharArray();

		boolean whitespace = true;

		for (int i = 0; i < buffer.length; i++) {
			char ch = buffer[i];
			if (Character.isUpperCase(ch)) {
				buffer[i] = Character.toLowerCase(ch);
				whitespace = false;
			} else if (Character.isTitleCase(ch)) {
				buffer[i] = Character.toLowerCase(ch);
				whitespace = false;
			} else if (Character.isLowerCase(ch)) {
				if (whitespace) {
					buffer[i] = Character.toTitleCase(ch);
					whitespace = false;
				} else {
					buffer[i] = Character.toUpperCase(ch);
				}
			} else {
				whitespace = Character.isWhitespace(ch);
			}
		}
		return new String(buffer);
	}

	/**
	 * ���ܣ���ȡ�����һ����־λ֮����ַ���.<br/>
	 * ���sourceStrΪempty����exprΪnull��ֱ�ӷ���Դ�ַ�����<br/>
	 * ���expr����Ϊ0��ֱ�ӷ���sourceStr��<br/>
	 * ���expr��sourceStr�в����ڣ�ֱ�ӷ���sourceStr��<br/>
	 * 
	 * @author ������
	 * @date 2014��06��24��
	 * @param sourceStr
	 *            ����ȡ���ַ���
	 * @param expr
	 *            �ָ���
	 * @return String
	 */
	public static String substringAfterLast(String sourceStr, String expr) {
		if (isEmpty(sourceStr) || expr == null) {
			return sourceStr;
		}
		if (expr.length() == 0) {
			return sourceStr;
		}

		int pos = sourceStr.lastIndexOf(expr);
		if (pos == -1) {
			return sourceStr;
		}
		return sourceStr.substring(pos + expr.length());
	}

	/**
	 * ���ܣ���ȡ�����һ����־λ֮ǰ���ַ���.<br/>
	 * ���sourceStrΪempty����exprΪnull��ֱ�ӷ���Դ�ַ�����<br/>
	 * ���expr����Ϊ0��ֱ�ӷ���sourceStr��<br/>
	 * ���expr��sourceStr�в����ڣ�ֱ�ӷ���sourceStr��<br/>
	 * 
	 * @author ������
	 * @date 2014��06��24��
	 * @param sourceStr
	 *            ����ȡ���ַ���
	 * @param expr
	 *            �ָ���
	 * @return String
	 */
	public static String substringBeforeLast(String sourceStr, String expr) {
		if (isEmpty(sourceStr) || expr == null) {
			return sourceStr;
		}
		if (expr.length() == 0) {
			return sourceStr;
		}
		int pos = sourceStr.lastIndexOf(expr);
		if (pos == -1) {
			return sourceStr;
		}
		return sourceStr.substring(0, pos);
	}

	/**
	 * ���ܣ���ȡ����һ����־λ֮����ַ���.<br/>
	 * ���sourceStrΪempty����exprΪnull��ֱ�ӷ���Դ�ַ�����<br/>
	 * ���expr����Ϊ0��ֱ�ӷ���sourceStr��<br/>
	 * ���expr��sourceStr�в����ڣ�ֱ�ӷ���sourceStr��<br/>
	 * 
	 * @author ������
	 * @date 2014��06��24��
	 * @param sourceStr
	 *            ����ȡ���ַ���
	 * @param expr
	 *            �ָ���
	 * @return String
	 */
	public static String substringAfter(String sourceStr, String expr) {
		if (isEmpty(sourceStr) || expr == null) {
			return sourceStr;
		}
		if (expr.length() == 0) {
			return sourceStr;
		}

		int pos = sourceStr.indexOf(expr);
		if (pos == -1) {
			return sourceStr;
		}
		return sourceStr.substring(pos + expr.length());
	}

	/**
	 * ���ܣ���ȡ����һ����־λ֮ǰ���ַ���.<br/>
	 * ���sourceStrΪempty����exprΪnull��ֱ�ӷ���Դ�ַ�����<br/>
	 * ���expr����Ϊ0��ֱ�ӷ���sourceStr��<br/>
	 * ���expr��sourceStr�в����ڣ�ֱ�ӷ���sourceStr��<br/>
	 * ���expr��sourceStr�д��ڲ�ֹһ�����Ե�һ��λ��Ϊ׼��
	 * 
	 * @author ������
	 * @date 2014��06��24��
	 * @param sourceStr
	 *            ����ȡ���ַ���
	 * @param expr
	 *            �ָ���
	 * @return String
	 */
	public static String substringBefore(String sourceStr, String expr) {
		if (isEmpty(sourceStr) || expr == null) {
			return sourceStr;
		}
		if (expr.length() == 0) {
			return sourceStr;
		}
		int pos = sourceStr.indexOf(expr);
		if (pos == -1) {
			return sourceStr;
		}
		return sourceStr.substring(0, pos);
	}

	/**
	 * ���ܣ��������ַ����ǲ��ǿ��ַ�����<br/>
	 * �������ַ���Ϊnull����trim��Ϊ���ַ����򷵻�true�����򷵻�false��
	 * 
	 * @author ������
	 * @date 2014��06��24��
	 * @param chkStr
	 *            �������ַ���
	 * @return boolean
	 */
	public static boolean isEmpty(String chkStr) {
		if (chkStr == null) {
			return true;
		} else {
			return "".equals(chkStr.trim()) ? true : false;
		}
	}

	/**
	 * ����ַ���û�г������ʾ���ȷ���ԭ�ַ���������ӿ�ͷ��ȡָ�����Ȳ���...���ء�
	 * 
	 * @param str
	 *            ԭ�ַ���
	 * @param length
	 *            �ַ������ʾ�ĳ���
	 * @return ת������ַ���
	 */
	public static String trimString(String str, int length) {
		if (str == null) {
			return "";
		} else if (str.length() > length) {
			return str.substring(0, length - 3) + "...";
		} else {
			return str;
		}
	}

}