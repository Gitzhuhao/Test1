package com.example.demo01;

import org.json.JSONObject;
import org.xutils.x;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;

import com.example.base.BaseActivity;
import com.example.entity.NewsBody;
import com.google.gson.Gson;

import android.os.Bundle;
import android.view.KeyEvent;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends BaseActivity {
	private WebView mWebview1;
	private NewsBody newsBody;

	// 字体颜色设为白色, “p”标签内的字体颜色 “*”定义了字体大小以及行高；
	public final static String CSS_STYLE1 = "<style>* {font-size:16px;line-height:20px;}p {color:#FFFFFF;}</style>";
	// 比较全的：
	// 上面全局样式：“*”定义了字体大小以及行高；“p”标签内的字体颜色；“a”标签内的字体颜色；“img”标签的图片最大宽度；“pre”为代码样式；
	public final static String CSS_STYLE = "<style>* {font-size:16px;line-height:20px;} p {color:#333;} a {color:#3E62A6;} img {max-width:310px;} pre {font-size:9pt;line-height:12pt;font-family:Courier New,Arial;border:1px solid #ddd;border-left:5px solid #6CE26C;background:#f6f6f6;padding:5px;}</style>";

	// 上面全局样式：“*”定义了字体大小以及行高；“p”标签内的字体颜色；“a”标签内的字体颜色；“img”标签的图片最大宽度；“pre”为代码样式；
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		mWebview1 = (WebView) findViewById(R.id.webview1);
		init();
	}

	private void init() {
		final String docid = getIntent().getStringExtra("docid");
		final String url = getIntent().getStringExtra("url");
		mWebview1.getSettings().setJavaScriptEnabled(true);
		mWebview1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		// WebView加载web资源
		mWebview1.loadUrl(url);
		// 覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
		mWebview1.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				// 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
				view.loadUrl(url);
				return true;
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				imgReset();
			}
		});
		x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
			@Override
			public void onSuccess(String result) {
				try {

					String body = new JSONObject(result).getString(docid);
					NewsBody newsBody = new Gson().fromJson(body, NewsBody.class);
					String before = "<p><img src=\"";
					String after = "\"/> </img></p>";
					// 重整字符串：
					// 1.添加标题；<p><h1> </h1></p>
					String title_b = "<p><h2>";
					String title_a = "</h2></p>";

					newsBody.body = title_b + newsBody.title + title_a + newsBody.body;

					// 添加作者：
					for (NewsBody.Img img : newsBody.img) {
						newsBody.body = newsBody.body.replace(img.ref, before + img.src + after);
					}
					mWebview1.loadDataWithBaseURL(null, newsBody.body, "text/html", "utf-8", null);

				} catch (Exception e) {
				}

			}

			@Override
			public void onError(Throwable ex, boolean isOnCallback) {

			}

			@Override
			public void onCancelled(CancelledException cex) {

			}

			@Override
			public void onFinished() {

			}
		});

	}

	private void imgReset() {
		mWebview1.loadUrl("javascript:(function(){" + "var objs = document.getElementsByTagName('img'); "
				+ "for(var i=0;i<objs.length;i++)  " + "{" + "var img = objs[i];   "
				+ "    img.style.maxWidth = '100%';   " + "}" + "})()");
	}

	// 如果希望浏览的网页后退而不是退出浏览器，需要WebView覆盖URL加载，让它自动生成历史访问记录，
	// 那样就可以通过前进或后退访问已访问过的站点。
	// 改写物理按键——返回的逻辑
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebview1.canGoBack()) {
			mWebview1.goBack(); // goBack()表示返回WebView的上一页面
			// 销毁activity页面
			finish();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

}
