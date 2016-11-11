package com.example.fragments;

import com.example.app.MyApp;
import com.example.base.BaseFragment;
import com.example.demo01.NewsActivity;
import com.example.demo01.R;
import com.example.utils.CommonUrls;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author admin1
 *
 */
public class Fragment1 extends BaseFragment implements OnClickListener {
	private ImageView iv_machinery;
	private ImageView iv_shopping;
	private ImageView iv_learing;
	private ImageView iv_photo;
	private ImageView iv_dry;
	private ImageView iv_output;
	private ImageView iv_insurance;
	private ImageView iv_law;
	private ImageView iv_money;
	private ImageView iv_input;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment1, container, false);
		iv_machinery = (ImageView) view.findViewById(R.id.iv_machinery);
		iv_shopping = (ImageView) view.findViewById(R.id.iv_shopping);
		iv_photo = (ImageView) view.findViewById(R.id.iv_photo);
		iv_learing = (ImageView) view.findViewById(R.id.iv_learing);
		iv_dry = (ImageView) view.findViewById(R.id.iv_dry);
		iv_output = (ImageView) view.findViewById(R.id.iv_output);
		iv_insurance = (ImageView) view.findViewById(R.id.iv_insurance);
		iv_law = (ImageView) view.findViewById(R.id.iv_law);
		iv_money = (ImageView) view.findViewById(R.id.iv_money);
		iv_input = (ImageView) view.findViewById(R.id.iv_input);
		initData();
		return view;
	}

	// 初始化数据
	@Override
	protected void initData() {
		iv_learing.setOnClickListener(this);
		iv_machinery.setOnClickListener(this);
		iv_shopping.setOnClickListener(this);
		iv_dry.setOnClickListener(this);
		iv_photo.setOnClickListener(this);
		iv_output.setOnClickListener(this);
		iv_insurance.setOnClickListener(this);
		iv_dry.setOnClickListener(this);
		iv_law.setOnClickListener(this);
		iv_input.setOnClickListener(this);
		iv_money.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_machinery:

			Toast.makeText(MyApp.getContext(), "---嘀嘀农机---", Toast.LENGTH_SHORT).show();

			break;

		case R.id.iv_shopping:

			Toast.makeText(MyApp.getContext(), "---农资商城---", Toast.LENGTH_SHORT).show();
			
			Intent intent=new Intent(getActivity(),NewsActivity.class);
			startActivity(intent);
			
			break;

		case R.id.iv_learing:

			Toast.makeText(MyApp.getContext(), "---学农技---", Toast.LENGTH_SHORT).show();
			String url = CommonUrls.getCommonUrls().getTestUrl();
			String docid = "C5GL25V100058783";
			// 交给activity,viewid,bundle
			Bundle bundle = new Bundle();
			bundle.putString("url", url);
			bundle.putString("docid", docid);
			int viewId = R.id.iv_learing;
			mListener.onFragmentInteraction(viewId, bundle);
			break;
		case R.id.iv_photo:

			Toast.makeText(MyApp.getContext(), "---视频---", Toast.LENGTH_SHORT).show();

			
			
			
			
			
			
			
			break;
		case R.id.iv_dry:

			Toast.makeText(MyApp.getContext(), "---粮食烘干---", Toast.LENGTH_SHORT).show();

			break;
		case R.id.iv_output:

			Toast.makeText(MyApp.getContext(), "---我要卖粮---", Toast.LENGTH_SHORT).show();

			break;
		case R.id.iv_insurance:

			Toast.makeText(MyApp.getContext(), "---保险服务---", Toast.LENGTH_SHORT).show();

			break;
		case R.id.iv_money:

			Toast.makeText(MyApp.getContext(), "---金融服务---", Toast.LENGTH_SHORT).show();

			break;
		case R.id.iv_input:

			Toast.makeText(MyApp.getContext(), "---我要买粮---", Toast.LENGTH_SHORT).show();

			break;
		case R.id.iv_law:

			Toast.makeText(MyApp.getContext(), "---纠纷板块---", Toast.LENGTH_SHORT).show();

			break;
		}

	}

}
