package com.junerver.testo2oapp.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.junerver.testo2oapp.R;
import com.junerver.testo2oapp.app.AppContext;
import com.junerver.testo2oapp.utils.ActivityCollector;

public class MainActivity extends TabActivity implements OnClickListener {

    private TabHost host;
    private final static String NEARBY_STRING = "NEARBY_STRING";//附近
    private final static String INDENT_STRING = "INDENT_STRING";//订单
    private final static String MINE_STRING = "MINE_STRING";//我的
    private ImageView img_nearby;
    private ImageView img_indent;
    private ImageView img_mine;
    private TextView text_nearby;
    private TextView text_indent;
    private TextView text_mine;
    private LinearLayout linearLayout_nearby;
    private LinearLayout linearLayout_indent;
    private LinearLayout linearLayout_mine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置屏幕显示尺寸
        getScreenDisplay();
        //初始化UI
        initView();
        host = getTabHost();
        host.setup();
        setNearbyTab();
        setIndentTab();
        setMineTab();
        host.setCurrentTabByTag(NEARBY_STRING);//设置页面默认为附近
        ActivityCollector. addActivity(this);
    }

    private void setNearbyTab() {
        host.addTab(host.newTabSpec(NEARBY_STRING).setIndicator(NEARBY_STRING).setContent(new Intent(MainActivity.this,NearbyActivity.class)));
    }

    private void setIndentTab() {
        host.addTab(host.newTabSpec(INDENT_STRING).setIndicator(INDENT_STRING).setContent(new Intent(MainActivity.this,IndentActivity.class)));
    }

    private void setMineTab() {
        host.addTab(host.newTabSpec(MINE_STRING).setIndicator(MINE_STRING).setContent(new Intent(MainActivity.this,MineActivity.class)));
    }

    private void initView() {

        img_nearby = (ImageView) findViewById(R.id.img_nearby);
        img_indent =(ImageView) findViewById(R.id.img_indent);
        img_mine = (ImageView)findViewById(R.id.img_mine);
        img_nearby.setOnClickListener(this);
        img_indent.setOnClickListener(this);
        img_mine.setOnClickListener(this);

        text_nearby = (TextView) findViewById(R.id.text_nearby);
        text_indent = (TextView) findViewById(R.id.text_indent);
        text_mine = (TextView) findViewById(R.id.text_mine);

        linearLayout_nearby = (LinearLayout) findViewById(R.id.linearlayout_nearby);
        linearLayout_indent = (LinearLayout) findViewById(R.id.linearlayout_indent);
        linearLayout_mine = (LinearLayout) findViewById(R.id.linearlayout_mine);
        linearLayout_nearby.setOnClickListener(this);
        linearLayout_indent.setOnClickListener(this);
        linearLayout_mine.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector. removeActivity(this);
    }

    private void getScreenDisplay(){
        Display display=this.getWindowManager().getDefaultDisplay();
        int screenWidth = display.getWidth();
        int screenHeight=display.getHeight();

        AppContext appContext=(AppContext) getApplicationContext();
        appContext.setScreenWidth(screenWidth);
        appContext.setScreenHeight(screenHeight);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            附近，点击后将被点击的资源设置成on 其他资源设置成off（还有其他的实现方式）
            case R.id.linearlayout_nearby:
            case R.id.img_nearby:
                host.setCurrentTabByTag(NEARBY_STRING);

                img_nearby.setBackgroundResource(R.drawable.ic_menu_poi_on);
                text_nearby.setTextColor(getResources().getColor(R.color.green));

                img_indent.setBackgroundResource(R.drawable.ic_menu_deal_off);
                text_indent.setTextColor(getResources().getColor(R.color.textgray));

                img_mine.setBackgroundResource(R.drawable.ic_menu_user_off);
                text_mine.setTextColor(getResources().getColor(R.color.textgray));

                break;
//            订单
            case R.id.linearlayout_indent:
            case R.id.img_indent:
                host.setCurrentTabByTag(INDENT_STRING);

                img_nearby.setBackgroundResource(R.drawable.ic_menu_poi_off);
                text_nearby.setTextColor(getResources().getColor(R.color.textgray));

                img_indent.setBackgroundResource(R.drawable.ic_menu_deal_on);
                text_indent.setTextColor(getResources().getColor(R.color.green));

                img_mine.setBackgroundResource(R.drawable.ic_menu_user_off);
                text_mine.setTextColor(getResources().getColor(R.color.textgray));

                break;
//            我的
            case R.id.linearlayout_mine:
            case R.id.img_mine:
                host.setCurrentTabByTag(MINE_STRING);

                img_nearby.setBackgroundResource(R.drawable.ic_menu_poi_off);
                text_nearby.setTextColor(getResources().getColor(R.color.textgray));

                img_indent.setBackgroundResource(R.drawable.ic_menu_deal_off);
                text_indent.setTextColor(getResources().getColor(R.color.textgray));

                img_mine.setBackgroundResource(R.drawable.ic_menu_user_on);
                text_mine.setTextColor(getResources().getColor(R.color.green));

                break;

            default:
                break;

        }

    }

}
