package com.junerver.testo2oapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.junerver.testo2oapp.R;
import com.junerver.testo2oapp.utils.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.framelayout_back)
    FrameLayout framelayoutBack;
    @Bind(R.id.et_login_username)
    EditText etLoginUsername;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.linearlayout_login)
    LinearLayout linearlayoutLogin;

    @OnClick(R.id.framelayout_back)
    public void finishIt(View v) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

}
