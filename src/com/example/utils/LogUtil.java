package com.example.utils;

import android.util.Log;

public class LogUtil {

	// 日志管理：加入管理，可以统一开闭日志显示

	private LogUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static boolean isDebug = true;

	// 停止日志输出
	public static void stopLog() {
		isDebug = false;
	}

	public static void startLog() {
		isDebug = true;
	}

	// 使用时，一般obj都传this
	public static void d(Object obj, String msg) {
		if (isDebug) {
			Log.d(obj.getClass().getSimpleName(), msg);
		}
	}

}
