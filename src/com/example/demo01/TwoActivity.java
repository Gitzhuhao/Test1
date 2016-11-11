package com.example.demo01;

import com.example.base.BaseActivity;
import com.example.base.BaseFragment.OnFragmentInteractionListener;
import com.example.fragments.Fragment1;
import com.example.fragments.Fragment2;
import com.example.fragments.Fragment3;
import com.example.fragments.Fragment4;
import com.example.fragments.Fragment5;
import com.viewpagerindicator.TabPageIndicator;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TwoActivity extends BaseActivity implements OnCheckedChangeListener, OnFragmentInteractionListener {
	private RadioGroup radiogroup;
	private Fragment1 fragment1;
	private Fragment2 fragment2;
	private Fragment3 fragment3;
	private Fragment4 fragment4;
	private Fragment5 fragment5;
	FragmentTransaction transaction;
	TabPageIndicator indicator;
	/**
	 * Tab标题
	 */
	private static final String[] TITLE = new String[] { "头条", "房产", "另一面", "女人", "财经", "数码", "情感", "科技" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		findView();
		inintData();
		setListener();

	}

	private void findView() {
		radiogroup = (RadioGroup) findViewById(R.id.radiogroup1);

	}

	private void inintData() {

		fragment1 = new Fragment1();
		fragment2 = new Fragment2();
		fragment3 = new Fragment3();
		fragment4 = new Fragment4();
		fragment5 = new Fragment5();
		addFragment(fragment1);

	}

	private void setListener() {
		radiogroup.setOnCheckedChangeListener(this);

	}

	private void addFragment(Fragment f) {
		getFragmentManager().beginTransaction().add(R.id.fragment1, f, f.getClass().getSimpleName()).commit();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int Id) {
		switch (Id) {
		case R.id.radioButton1:
			showFragment(fragment1);
			break;

		case R.id.radioButton2:
			showFragment(fragment2);
			break;

		case R.id.radioButton3:
			showFragment(fragment3);
			break;

		case R.id.radioButton4:
			showFragment(fragment4);
			break;

		case R.id.radioButton5:
			showFragment(fragment5);
			break;

		}

	}

	public void showFragment(Fragment f) {
		Fragment[] fs = { fragment1, fragment2, fragment3, fragment4, fragment5 };
		FragmentManager fm = getFragmentManager();
		if (f != fm.findFragmentByTag(f.getClass().getSimpleName())) {
			addFragment(f);
		}
		FragmentTransaction tr = fm.beginTransaction();
		for (Fragment tf : fs) {
			tr.hide(tf);
		}
		tr.show(f).commit();
	}

	@Override
	public void onFragmentInteraction(int viewId, Bundle bundle) {
		switch (viewId) {
		case R.id.iv_learing:
			// 跳转activity，传值过去
			jumpTo(WebActivity.class, bundle);
			break;
		}
	}

}
