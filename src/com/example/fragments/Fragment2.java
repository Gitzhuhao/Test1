package com.example.fragments;

import com.example.base.BaseFragment;
import com.example.demo01.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment2 extends BaseFragment {
	ImageView imageView1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment2, container, false);
		imageView1 = (ImageView) view.findViewById(R.id.imageView1);
		initData();
		return view;
	}

	@Override
	protected void initData() {

		
		
	}

}
