package com.testsmirk.utils;

/**
 * Created by Smirk on 2017/3/12.
 */
public class TextUtil {
    public static boolean isEmpty(String text) {
        if (text == null || text.length() == 0)
            return true;
        else
            return false;
    }
}
