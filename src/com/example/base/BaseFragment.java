package com.example.base;

import com.example.app.MyApp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment {
	protected View rootView;

	public BaseFragment() {
	}

	public BaseFragment(View rootView) {
		this.rootView = rootView;
	}

	protected OnFragmentInteractionListener mListener;

	public interface OnFragmentInteractionListener {
		void onFragmentInteraction(int viewId, Bundle bundle);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		if (rootView == null) {

			Toast.makeText(MyApp.getContext(), "rootView == null", Toast.LENGTH_SHORT).show();
		}

		return rootView;
	}

	// 初始化界面
	protected abstract void initData();

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.i("i", " Fragment 执行onActivityCreated");

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("i", " Fragment 执行onStart");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("i", " Fragment 执行onPause");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("i", " Fragment 执行onResume");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("i", " Fragment 执行onStop");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("i", " Fragment 执行onDestroy");
		if (rootView != null) {
			ViewGroup parent = (ViewGroup) rootView.getParent();
			// Toast.makeText(BaseFragment.this.getContext(), "移除rootView",
			// Toast.LENGTH_SHORT).show();
			parent.removeView(rootView);
		}
	}

	public void onButtonPressed(int viewId, Bundle bundle) {
		if (mListener != null) {
			mListener.onFragmentInteraction(viewId, bundle);
		}
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		if (activity instanceof OnFragmentInteractionListener) {
			mListener = (OnFragmentInteractionListener) activity;
		}
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.i("i", " Fragment 执行onDetach");
		mListener = null;
	}

}
