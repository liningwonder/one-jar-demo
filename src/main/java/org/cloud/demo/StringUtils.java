package org.cloud.demo;

public class StringUtils {

    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean startsWith(String s, String p) {
        if (null == s) {
            return false;
        }
        return s.startsWith(p);
    }

}
