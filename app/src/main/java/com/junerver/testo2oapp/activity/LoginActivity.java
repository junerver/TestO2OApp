package com.junerver.testo2oapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.junerver.testo2oapp.R;
import com.junerver.testo2oapp.utils.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
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

    @OnClick(R.id.framelayout_back)
    public void finishIt(View v) {
        finish();
    }

    @OnClick(R.id.text_register)
    public void openRegister(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
