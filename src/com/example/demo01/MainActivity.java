package com.example.demo01;

import java.util.Timer;
import java.util.TimerTask;

import com.example.base.BaseActivity;
import com.example.demo01.R;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {
	ImageView imageView;
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
		imageView.startAnimation(animation);

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				jumpTo(TwoActivity.class);
				finish();
				overridePendingTransition(R.anim.right_in, R.anim.left_out);
			}

		};
		timer.schedule(task, 5000);

	}

	private void findView() {
		imageView = (ImageView) findViewById(R.id.imageView1);

	}

}
