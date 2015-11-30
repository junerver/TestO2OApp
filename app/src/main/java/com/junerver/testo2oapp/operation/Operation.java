package com.junerver.testo2oapp.operation;

import com.google.gson.Gson;
import com.junerver.testo2oapp.common.UrlConstant;
import com.junerver.testo2oapp.utils.HttpUtils;
import com.junerver.testo2oapp.utils.L;
import com.junerver.testo2oapp.utils.MD5Util;

/**
 * Created by junerver on 2015/11/30.
 */
public class Operation {
    public static String login(String user_name, String user_pass) {
        String result = null;
        //封装json
        Login_user login_user = new Login_user(user_name, user_pass);
        Gson gson = new Gson();
        String user_json = gson.toJson(login_user);
        L.d("登录",user_json);
        //将json数据发送到服务器，验证后服务器返回结果
        try {
            result = HttpUtils.doPost(UrlConstant.LOGINURL, user_json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    static class Login_user {
        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_pass() {
            return user_pass;
        }

        public void setUser_pass(String user_pass) {
            this.user_pass = user_pass;
        }

        String user_name;
        String user_pass;

        public Login_user(String user_name,String user_pass) {
            this.user_name = user_name;
            //使用MD5算法加密密码！
            this.user_pass = MD5Util.getMD5String(user_pass);
        }
    }
}
