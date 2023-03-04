package com.qian.annotationDemo.util;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/3/4 14:54
 * @Description: 脱敏工具类
 */
public class SensitiveUtil {

    /**
     * 隐藏手机号中间四位
     */
    public static String hidePhone(String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 只显示身份证的前后各四位
     * @param idNo
     * @return
     */
    public static String hideIdNo(String idNo) {
        return idNo.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1*****$2");
    }

    /**
     * 只显示姓
     * @param chineseName
     * @return
     */
    public static String hideName(String chineseName) {
        return desValue(chineseName,1,0,"*");
    }

    /**
     * 对字符串进行脱敏操作
     * @param origin          原始字符串
     * @param prefixNoMasLen 左侧需要保留几位明文字段
     * @param suffixNoMasLen 右侧需要保留几位明文字段
     * @param masStr         用于遮罩的字符串, 如'*'
     * @return 脱敏后结果
     */
    public static String desValue(String origin,int prefixNoMasLen,int suffixNoMasLen,String masStr) {
        if (origin == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0,n = origin.length();i < n; i++) {
            if (i < prefixNoMasLen) {
                sb.append(origin.charAt(i));
                continue;
            }
            if (i > (n - suffixNoMasLen - 1)) {
                sb.append(origin.charAt(i));
                continue;
            }
            sb.append(masStr);
        }
        return sb.toString();
    }
}
