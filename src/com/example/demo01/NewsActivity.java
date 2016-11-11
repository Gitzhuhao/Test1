package com.example.demo01;

import com.example.adapter.TabPageIndicatorAdapter;
import com.viewpagerindicator.TabPageIndicator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.Toast;

public class NewsActivity extends FragmentActivity implements OnPageChangeListener {
	/**
	 * Tab标题
	 */
	public static final String[] TITLE = new String[] { "行业新闻", "涉农政策", "平台快讯" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		// 实例化ViewPager， 然后给ViewPager设置Adapter
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);

		// 实例化TabPageIndicator，然后与ViewPager绑在一起（核心步骤）
		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);

		// 如果要设置监听ViewPager中包含的Fragment的改变(滑动切换页面)，使用OnPageChangeListener为它指定一个监听器，那么不能像之前那样直接设置在ViewPager上了，而要设置在Indicator上，
		indicator.setOnPageChangeListener(this);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		Toast.makeText(getApplicationContext(), TITLE[arg0], Toast.LENGTH_SHORT).show();
	}

}
