package com.junerver.testo2oapp.utils;

import com.junerver.testo2oapp.common.Constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by junerver on 2015/12/1.
 */
public class RegexUtils {
    //手机号码的正则验证
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern
                .compile(Constant.PHONE_NUMBER_REGEX);
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches() + "---");
        return m.matches();
    }
}
