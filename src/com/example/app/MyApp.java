package com.example.app;

import org.xutils.x;
import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Administrator on 2016/8/31 0031.
 */
public class MyApp extends Application {
	private static MyApp app;
	public static Handler handler;

	@Override
	public void onCreate() {
		super.onCreate();
		app = this;
		handler = new Handler();
		x.Ext.init(this);

	}

	public static MyApp getApp() {
		return app;
	}

	public static Context getContext() {
		return MyApp.getApp();
	}
}
