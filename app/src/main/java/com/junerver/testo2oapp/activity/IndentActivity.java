package com.junerver.testo2oapp.activity;

//import android.app.Fragment;
import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.junerver.testo2oapp.R;
import com.junerver.testo2oapp.common.SlidingTabLayout;

import com.junerver.testo2oapp.utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;
//如果需要使用slidingtab必须继承自ActionBarActivity
public class IndentActivity extends BaseActivity {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private Toolbar toolbar;
    private ArrayList<View> listFrament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent);
//        找到设置的viewpager，与slidingTablayout
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRemindAdapter = new RemindAdapter(getSupportFragmentManager(), this);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(mRemindAdapter);

        // 定义 SlidingTabLayout
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.primary));
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.white));
        mSlidingTabLayout.setCustomTabView(R.layout.view_tab, R.id.tv_text);
        mSlidingTabLayout.setViewPager(mViewPager); // 加载ViewPager


//        listFrament = new ArrayList<Fragment>();
//        listFrament.add(new AllIndentFragment());
//        listFrament.add(new UnEvaluationFragment());

//        listFrament = new ArrayList<View>();
//        LayoutInflater lf = getLayoutInflater().from(this);
//        View view1 = lf.inflate(R.layout.fragment_all_indent, null);
//        View view2=lf.inflate(R.layout.fragment_un_evaluation, null);
//        listFrament.add(view1);
//        listFrament.add(view2);
//        PagerAdapter adapter = new MyViewPagerAdapter(listFrament);
//        pager.setAdapter(adapter);
//        tab.setViewPager(pager);

//
//        MyAdapte adapter = new MyAdapte();
//        pager.setAdapter(adapter);
//
//        tab.setCustomTabView(R.layout.custom_tab,0);
//        tab.setViewPager(pager);
//
//
//        tab.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
//            @Override
//            public int getIndicatorColor(int position) {
//                return colors[position];
//            }
//
//            @Override
//            public int getDividerColor(int position) {
//                return 0x00FFFFFF;
//            }
//        });

    }

    public class MyViewPagerAdapter extends PagerAdapter{
        private List<View> mListViews;

        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) 	{
            container.removeView(mListViews.get(position));//删除页卡
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {	//这个方法用来实例化页卡
            container.addView(mListViews.get(position), 0);//添加页卡
            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return  mListViews.size();//返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;//官方提示这样写
        }
    }


//    class MyPagerAdapter extends FragmentPagerAdapter {
//
//        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public int getCount() {
//            return listFrament.size();
//        }
//
//        @Override
//        public android.support.v4.app.Fragment getItem(int position) {
//            return listFrament.get(position);
//        }
//
//    }

//    int[] colors = {0xFF123456, 0xFF654321, 0xFF336699};
//    class MyAdapte extends PagerAdapter {
//        String[] titles = {"AA", "BB", "CC"};
//
//        ArrayList<LinearLayout> layouts = new ArrayList<LinearLayout>();
//
//        MyAdapte() {
//
//            for (int i = 0; i < 3; i++) {
//                LinearLayout l = new LinearLayout(IndentActivity.this);
//                l.setBackgroundColor(colors[i]);
//                l.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//                layouts.add(l);
//            }
//
//        }
//
//        @Override
//        public int getCount() {
//            return layouts.size();
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object o) {
//            return view == o;
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            LinearLayout l = layouts.get(position);
//            container.addView(l);
//            return l;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView(layouts.get(position));
//        }
//
//
//        int[] imageResId = {
//                R.drawable.ic_launcher,
//                R.drawable.ic_launcher,
//                R.drawable.ic_launcher
//        };
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            Drawable image = getResources().getDrawable(imageResId[position]);
//            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//            SpannableString sb = new SpannableString(" ");
//            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            return sb;
//            //return titles[position];
//        }
//    }

}
