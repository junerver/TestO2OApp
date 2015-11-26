package com.junerver.testo2oapp.utils;


import android.os.Bundle ;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;



/**
 * Created by Administrator on 2015/7/22.
 */
public class BaseActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        ActivityCollector. addActivity( this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy() ;
        ActivityCollector. removeActivity( this);
    }
}
