package com.junerver.testo2oapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.junerver.testo2oapp.R;
import com.junerver.testo2oapp.operation.Operation;
import com.junerver.testo2oapp.utils.BaseActivity;
import com.junerver.testo2oapp.utils.L;
import com.junerver.testo2oapp.utils.SPUtils;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // 开启logcat输出，方便debug，发布时请关闭
        XGPushConfig. enableDebug(this, true) ;
        // 如果需要知道注册是否成功，请使用registerPush(getApplicationContext(), XGIOperateCallback)带callback版本
        // 如果需要绑定账号，请使用registerPush(getApplicationContext(),account)版本
        // 具体可参考详细的开发指南
        // 传递的参数为ApplicationContext
        Context context = getApplicationContext() ;
//        XGPushManager.registerPush(context);
        XGPushManager. registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                Log.d("TPush", "注册成功，设备token为：" + data);
            }

            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.d("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });
        //判断是否是第一次使用该软件，如果是跳转到登录页

        //一个延时跳转效果
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isFirstRun(getApplicationContext());
                WelcomeActivity.this.finish();
            }
        }, 1000);

    }


    public void isFirstRun(Context context) {
        boolean isFirstRun= (boolean) SPUtils.get(context, "isFirstRun", true);
        if (isFirstRun) {
            //第一次运行打开登录界面
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));

        }else {
            //不是第一次运行，找到SP文件中的用户名密码
            String user_name = (String) SPUtils.get(context, "LoginedUser", "");
            String user_pass = (String) SPUtils.get(context, "LoginedPass", "");
            //使用最后一次保存的用户名密码访问服务器验证，这里使用的这个接口是专门用于SP文件登录的
            String result = Operation.logined(user_name, user_pass);
            //测试通过，可以正确的读取出SP文件中保存的用户名与加密后的用户密码
            L.d("测试SP文件",user_name+user_pass);
            // TODO: 2015/12/3
            //判断服务器返回状态，如果通过则进入主页面
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            //如果不通过则停留在登录页面，并且toast提示！
        }
    }
}
