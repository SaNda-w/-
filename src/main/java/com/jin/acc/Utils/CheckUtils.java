package com.jin.acc.Utils;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtils {
    public static boolean checkPhone(String phone){
        if(phone=="")return true;
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public static boolean checkEmail(String email){
        if(email=="")return true;
        Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
