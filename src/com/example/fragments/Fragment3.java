package com.example.fragments;

import com.example.base.BaseFragment;
import com.example.demo01.R;
import com.example.demo01.R.layout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment3 extends BaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment3, container, false);
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub

	}

}
