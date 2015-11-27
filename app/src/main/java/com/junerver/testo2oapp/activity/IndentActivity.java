package com.junerver.testo2oapp.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.junerver.testo2oapp.R;
import com.junerver.testo2oapp.common.SlidingTabLayout;
import com.junerver.testo2oapp.utils.BaseActivity;

import java.util.ArrayList;

//如果需要使用slidingtab必须继承自ActionBarActivity，Basectivity已经更新为继承自ActionBarActivity
public class IndentActivity extends BaseActivity {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    //    private Toolbar toolbar;
    private ArrayList<Fragment> listFrament;
    private RemindAdapter myadapter;
    private AllIndentFragment allIndentFragment;
    private UnEvaluationFragment unEvaluationFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent);

        //找到设置的viewpager，与slidingTablayout
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        //添加fragment碎片到一个ArrayList中去
        listFrament = new ArrayList<>();
        allIndentFragment = new AllIndentFragment();
        unEvaluationFragment = new UnEvaluationFragment();
        listFrament.add(allIndentFragment);
        listFrament.add(unEvaluationFragment);
        //设置配适器
        myadapter = new RemindAdapter(getSupportFragmentManager(), this);
        //将配适器添加到ViewPager中
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(myadapter);

        // 定义 SlidingTabLayout，设置选中颜色、背景颜色
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.greyblue));
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.white));
        //设置自定义的布局（一个LinearLayou与一个TextView）
        mSlidingTabLayout.setCustomTabView(R.layout.view_tab, R.id.tabText);
        mSlidingTabLayout.setViewPager(mViewPager); // 加载ViewPager
    }


    public class RemindAdapter extends FragmentStatePagerAdapter {

        private String[] titles;
        private Context ctx;

        public RemindAdapter(FragmentManager fm, Context ctx) {
            super(fm);
            this.ctx = ctx;
            //设置碎片tab的title，来自一个xml文件
            titles = ctx.getResources().getStringArray(R.array.remind_type);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {//全部订单
                return allIndentFragment;
            } else {//未评价订单
                return unEvaluationFragment;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }
}

