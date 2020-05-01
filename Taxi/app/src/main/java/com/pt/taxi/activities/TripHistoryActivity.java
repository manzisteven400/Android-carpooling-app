package com.pt.taxi.activities;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TripHistoryActivity extends BaseActivity {

	TextView btnEnd, btnStart;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_trip);

		initUI();
		setHeaderTitle(R.string.lbl_title_start_trip);

		btnEnd = (TextView) findViewById(R.id.btnEndTrip);
		btnStart = (TextView)findViewById(R.id.btnStartTrip);
		
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				btnEnd.setVisibility(v.VISIBLE);
				btnStart.setVisibility(v.GONE);
			}
		});
		btnEnd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				gotoActivity(HelpActivity.class);
				finish();
			}
		});
	}
}
