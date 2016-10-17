package com.ett.csz.huacheng.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理类
 * Created by csz on 2016/10/8.
 */

public class StringUtil {
    /**
     * 过滤字符串中的空格回车
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 判断是否为空
     * @param str
     * @return
     */
    public static String getNotNull(String str) {
        return "null".equals(str.trim()) ? "" : str;
    }

    /**
     * 截取字符串长度
     * @param str
     * @param length
     * @return
     */
    public static String cutBigString(String str, int length) {
        return str.length() > length ? str.substring(0, length) + "..." : str;
    }
}
