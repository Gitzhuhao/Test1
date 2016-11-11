package com.example.fragments;

import com.example.base.BaseFragment;
import com.example.demo01.R;
import com.example.demo01.R.layout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment5 extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment5, container, false);

		return view;
	}

	@Override
	protected void initData() {

	}

}
