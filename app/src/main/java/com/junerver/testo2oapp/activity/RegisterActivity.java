package com.junerver.testo2oapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.junerver.testo2oapp.R;
import com.junerver.testo2oapp.common.UrlConstant;
import com.junerver.testo2oapp.utils.BaseActivity;
import com.junerver.testo2oapp.utils.L;
import com.junerver.testo2oapp.utils.RegexUtils;
import com.junerver.testo2oapp.utils.T;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    private String phonenumber;

    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.framelayout_back)
    FrameLayout framelayoutBack;
    @Bind(R.id.et_register_phone_number)
    EditText etRegisterPhoneNumber;
    @Bind(R.id.btn_register_get_vericode)
    Button btnRegisterGetVericode;
    @Bind(R.id.text_get_user_agreement)
    TextView textGetUserAgreement;
    @Bind(R.id.framelayout_cancel_input)
    FrameLayout framelayoutCancelInput;


    //结束当前页
    @OnClick({R.id.img_back, R.id.framelayout_back})
    public void finishIt(View v) {
        finish();
    }
    //清空EditText的内容
    @OnClick(R.id.framelayout_cancel_input)
    public void cancalInput(View v) {
        etRegisterPhoneNumber.setText("");
        framelayoutCancelInput.setVisibility(View.INVISIBLE);
    }
    //设置用户协议的点击事件
    @OnClick(R.id.text_get_user_agreement)
    public void getUserAgreement(View v) {
        //TODO
        //新建一个WebView打开一个网页
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(UrlConstant.USER_AGREEMENT));
        startActivity(i);
    }

    //获取验证码的事件
    @OnClick(R.id.btn_register_get_vericode)
    public void getVeriCode(View view) {
        L.d("注册","注册按钮被点击了");
        //获取输入的字符串
        String phonenumber = etRegisterPhoneNumber.getText().toString().trim();
        //将字符串进行正则验证
        if (!RegexUtils.isMobileNO(phonenumber)) {
            //验证不通过时toast提示
            L.d("注册", phonenumber+"不是电话号码");
            Toast.makeText(this, "请输入正确的手机号码~", Toast.LENGTH_LONG).show();
            return;
        } else {
            L.d("注册", "是电话号码");
        }
        //// TODO: 2015/12/3  
        //到数据库检查是否存在
            //不通过时toast提示
        //调用短信验证码SDK
        //跳转到下一页
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        //设置按钮不可用
        judgeButtonState();


        //为EdutText增加内容变化监听器
        etRegisterPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                judgeButtonState();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                framelayoutCancelInput.setVisibility(View.VISIBLE);
                judgeButtonState();
            }

            @Override
            public void afterTextChanged(Editable s) {
                judgeButtonState();
            }
        });

    }



    private void judgeButtonState() {
        //尝试使用过xml中的布局属性置clicable与enable属性，发现无法满足需求，后改变使用方式
        phonenumber = etRegisterPhoneNumber.getText().toString().trim();
        if (phonenumber.length() == 11) {
            //按钮状态可用
            btnRegisterGetVericode.setClickable(true);
            btnRegisterGetVericode.setBackgroundColor(getResources().getColor(R.color.green));
        } else {
            //设置按钮状态为不可点击
            btnRegisterGetVericode.setClickable(false);
//        btnRegisterGetVericode.setTextColor(getResources().getColor(R.color.white));
            btnRegisterGetVericode.setBackgroundColor(getResources().getColor(R.color.gray));
        }
    }

}
