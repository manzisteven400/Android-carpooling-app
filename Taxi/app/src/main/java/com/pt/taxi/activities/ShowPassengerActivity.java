package com.pt.taxi.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;

public class ShowPassengerActivity extends BaseActivity implements
		OnClickListener {
	RelativeLayout btnLoginFacebook, btnLoginGoogle;
	TextView btnMenu;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_passenger);
		initUI();
		
		setHeaderTitle(R.string.lbl_order_confirm);
		
		btnMenu=(TextView) findViewById(R.id.btnMenu);
		btnMenu.setVisibility(View.GONE);
		
		((TextView) findViewById(R.id.btnArrived))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						gotoActivity(StartTripForDriverActivity.class);
						finish();
					}
				});

		((TextView) findViewById(R.id.btnCancelTrip))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						onBackPressed();
					}
				});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
