package com.junerver.testo2oapp.activity;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.junerver.testo2oapp.R;
import com.junerver.testo2oapp.utils.BaseActivity;

public class NewIndentActivity extends BaseActivity  implements View.OnClickListener {
    private ImageView img_back;
    private FrameLayout framelayout_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_indent);

        initView();

    }

    private void initView() {
        img_back = (ImageView) findViewById(R.id.img_back);
        framelayout_back = (FrameLayout) findViewById(R.id.framelayout_back);
        img_back.setOnClickListener(this);
        framelayout_back.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.framelayout_back:
            case R.id.img_back:
                finish();
                break;
            default:
                break;
        }

    }
}
