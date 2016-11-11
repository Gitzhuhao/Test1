package com.example.adapter;

import com.example.fragments.ItemFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPageIndicatorAdapter extends FragmentPagerAdapter {
	/**
	 * 定义ViewPager的适配器
	 */
	public static final String[] TITLE = new String[] { "行业新闻", "涉农政策", "平台快讯" };
	public TabPageIndicatorAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int position) {
		// 新建一个Fragment来展示ViewPager item的内容，并传递参数
		Fragment fragment = new ItemFragment();
		Bundle args = new Bundle();
		args.putString("arg", TITLE[position]);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public CharSequence getPageTitle(int position) {

		return TITLE[position % TITLE.length];
	}

	@Override
	public int getCount() {
		return TITLE.length;
	}

}
