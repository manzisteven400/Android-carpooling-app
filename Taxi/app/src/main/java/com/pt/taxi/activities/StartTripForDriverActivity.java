package com.pt.taxi.activities;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class StartTripForDriverActivity extends BaseActivity {

	TextView btnEnd, btnStart;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_for_driver_trip);

		initUI();
		setHeaderTitle(R.string.lbl_title_start_trip);
		btnStart=(TextView) findViewById(R.id.btnStartTrip);
		
		
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				btnStart.setVisibility(View.GONE);
				btnEnd.setVisibility(View.VISIBLE);
			}
		});

		btnEnd = (TextView) findViewById(R.id.btnEndTrip);
		btnEnd.setVisibility(View.GONE);
		btnEnd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoActivity(RatingPassengerActivity.class);
				finish();
			}
		});
	}
}
