package com.pt.taxi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.widget.TextViewPixeden;
import com.pt.taxi.widget.TextViewRaleway;

public class DetailTripHistoryActivity extends BaseActivity {

	TextViewPixeden btnBack;
	TextViewRaleway lbl_profile;
	TextView tv_cancel_trip;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_history);
		initUI();
		setHeaderTitle(R.string.lbl_trip_history);
		lbl_profile = (TextViewRaleway) findViewById(R.id.lbl_profile);
		tv_cancel_trip = (TextView) findViewById(R.id.tv_cancel_trip);
		tv_cancel_trip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		lbl_profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bd = new Bundle();
				bd.putString("profile", "profile");
				Intent intent = new Intent(DetailTripHistoryActivity.this,
						MainActivity.class);
				intent.putExtras(bd);
				startActivity(intent);
				finish();
			}
		});

		btnBack = (TextViewPixeden) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}
}
