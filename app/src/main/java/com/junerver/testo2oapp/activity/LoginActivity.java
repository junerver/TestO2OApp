package com.junerver.testo2oapp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.junerver.testo2oapp.R;
import com.junerver.testo2oapp.operation.Operation;
import com.junerver.testo2oapp.utils.BaseActivity;
import com.junerver.testo2oapp.utils.MD5Util;
import com.junerver.testo2oapp.utils.SPUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    private String user_name;
    private String user_pass;
    //    进度对话框
    private ProgressDialog progressDialog;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String string=(String) msg.obj;
            progressDialog.dismiss();
            Toast.makeText(LoginActivity.this, string,Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
        }
    };


    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.framelayout_back)
    FrameLayout framelayoutBack;
    @Bind(R.id.et_login_username)
    EditText etLoginUsername;
    @Bind(R.id.et_login_password)
    EditText etLoginPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.linearlayout_login)
    LinearLayout linearlayoutLogin;
    @Bind(R.id.text_quicklogin)
    TextView textQuicklogin;
    @Bind(R.id.text_register)
    TextView textRegister;
    //结束
    @OnClick(R.id.framelayout_back)
    public void finishIt(View v) {
        finish();
    }
    //注册
    @OnClick(R.id.text_register)
    public void openRegister(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
    //登录
    @OnClick(R.id.btn_login)
    public void login() {
        user_name = etLoginUsername.getText().toString().trim();
        if (user_name == null || "".equals(user_name)) {
            etLoginUsername.requestFocus();
            etLoginUsername.setError("对不起，用户名不能为空");
            return;
        } else {
            user_name = etLoginUsername.getText().toString().trim();
        }
        user_pass=etLoginPassword.getText().toString().trim();
        if (user_pass == null || "".equals(user_pass)) {
            etLoginPassword.requestFocus();
            etLoginPassword.setError("对不起，用密码不能为空");
            return;
        } else {
            user_pass=etLoginPassword.getText().toString().trim();
        }
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = Operation.login(user_name, user_pass);
                //登录不成功
                if (result == null || "".equals(result)) {
                    result = "服务器好像出错了~";
                }
                //TODO: 2015/12/3
                //此处只有在登录验证成功后才保存用户名密码
                //成功后将用户名登陆密码保存到SP文件中,密码使用MD5加密
                SPUtils.put(getApplicationContext(), "LoginedUser", user_name);
                SPUtils.put(getApplicationContext(),"LoginedPass", MD5Util.getMD5String(user_pass));
                SPUtils.put(getApplicationContext(),"isFirstRun",false);

                //// TODO: 2015/12/3
                // 通过handler更新UI，toast提示、跳转到mainactivity
                Message message = new Message();
                message.obj = result;
                handler.sendMessage(message);
            }
        }).start();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("登录中");
        progressDialog.setMessage("登录中，马上就好");

    }


   }
