package com.pt.taxi.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.utility.NetworkUtil;

public class ConfirmActivity extends BaseActivity {
	RelativeLayout btnLoginFacebook, btnLoginGoogle;
	private final int SPLASH_DISPLAY_LENGHT = 10000;
	TextView btnCancel;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm);
		initUI();
		setHeaderTitle(R.string.lbl_order_confirm);
		
		showToastMessage(R.string.lbl_please_wait_ten);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				gotoActivity(TripHistoryActivity.class);
				finish();
			}
		}, SPLASH_DISPLAY_LENGHT);
		
		btnCancel = (TextView)findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onBackPressed();
				
			}
		});

	}
}
