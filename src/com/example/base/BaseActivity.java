package com.example.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.utils.LogUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends Activity {
	// 中间层，不需要布局，只需要添加日志输出，显示生命周期日志，还可以扩展其他功能
	// 可以任意一个页面，关闭所有的Activity
	// 用一个静态的集合管理所有的Activity
	private static List<BaseActivity> activities = new ArrayList<BaseActivity>();

	/**
	 * 简要说明： onCreate(Bundle
	 * savedInstanceState)：创建activity时调用。设置在该方法中，还以Bundle中可以提出用于创建该 Activity
	 * 所需的信息。 onStart()：activity变为在屏幕上对用户可见时，即获得焦点时，会调用。
	 * onResume()：activity开始与用户交互时调用（无论是启动还是重新启动一个活动，该方法总是被调用的）。
	 * onPause()：activity被暂停或收回cpu和其他资源时调用，该方法用于保存活动状态的。。
	 * onStop()：activity被停止并转为不可见阶段及后续的生命周期事件时，即失去焦点时调用。
	 * onRestart()：重新启动activity时调用。该活动仍在栈中，而不是启动新的活动。
	 * onDestroy()：activity被完全从系统内存中移除时调用，该方法被调用可能是因为有人直接调用 finish()方法
	 * 或者系统决定停止该活动以释放资源。
	 * 
	 * 
	 */

	/** 声明一个方法，可以关闭集合中的所有Activity */
	public void finishAll() {
		Iterator<BaseActivity> iterator = activities.iterator();
		while (iterator.hasNext()) {
			iterator.next().finish();
		}

	}

	// // 提供一个简单初始化标题栏的方法,要先在布局中使用了此控件，而且id必须相同，才可以调用
	//
	// public void initSimpleTitleBar(String text) {
	// TitleBar titlebar1 = (TitleBar) findViewById(R.id.titlebar1);
	// titlebar1.init(R.drawable.btn_homeasup_default, text, -1,
	// new View.OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// switch (v.getId()) {
	// case R.id.iv_left:
	// finish();
	// // overridePendingTransition(R.anim.right_in,
	// // R.anim.left_out);
	// break;
	//
	// case R.id.iv_right:
	// finish();
	// overridePendingTransition(R.anim.left_in,
	// R.anim.right_out);
	//
	// break;
	// }
	//
	// }
	// });
	// }
	//
	// public void initSimpleTitleBar() {
	// TitleBar titleBar1 = (TitleBar) findViewById(R.id.titleBar1);
	// int textId = getIntent().getIntExtra("textId", R.string.main_filemgr);
	// String text = getResources().getString(textId);
	// titleBar1.init(R.drawable.btn_homeasup_default, text, -1,
	// new View.OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// finish();
	// // overridePendingTransition(R.anim.left_in,
	// // R.anim.right_out);
	// }
	// });
	// }
	//
	// public void initSimpleTitleBar2() {
	// TitleBar titleBar1 = (TitleBar) findViewById(R.id.titleBar1);
	// String text = getIntent().getStringExtra("text");
	// titleBar1.init(R.drawable.btn_homeasup_default, text, -1,
	// new View.OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// finish();
	// overridePendingTransition(R.anim.right_in,
	// R.anim.left_out);
	// }
	// });
	// }

	// 跳转，不传值
	public void jumpTo(Class<?> cls) {
		Intent intent = new Intent(this, cls);
		startActivity(intent);
	}

	// 跳转，带传值
	public void jumpTo(Class<?> cls, Bundle bundle) {
		Intent intent = new Intent(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	// 在Activity里都可以使用的快捷吐司方法
	public void showToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LogUtil.d(this, "onCreate");
		activities.add(this);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		LogUtil.d(this, "onStart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		LogUtil.d(this, "onResume");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		LogUtil.d(this, "onPause");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		LogUtil.d(this, "onStop");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		LogUtil.d(this, "onDestroy");
		activities.remove(this);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		LogUtil.d(this, "onRestart");
	}
}
