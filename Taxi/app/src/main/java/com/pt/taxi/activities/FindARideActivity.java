package com.pt.taxi.activities;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.adapters.TripApdater;
import com.pt.taxi.widget.TextViewPixeden;
import com.pt.taxi.widget.TextViewRaleway;

public class FindARideActivity extends BaseActivity implements OnClickListener {

	TextViewPixeden btnBack;
	TextViewRaleway lblTitle;
	private ListView lv_trip, lv_trip_tm;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_findaride);
		initUIRoundTrip();

		initListener();
	}

	public void initUIRoundTrip() {
		lblTitle = (TextViewRaleway) findViewById(R.id.lblTitle);
		lblTitle.setText("Find A Ride");
		btnBack = (TextViewPixeden) findViewById(R.id.btnMenu);
		lv_trip = (ListView) findViewById(R.id.lv_trip);
		
		lv_trip.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				gotoActivity(DetailTripActivity.class);

			}
		});
		TripApdater adapter = new TripApdater(this);
		lv_trip.setAdapter(adapter);
		lv_trip_tm = (ListView) findViewById(R.id.lv_trip_tomorrow);
		TripApdater adapter_tm = new TripApdater(this);
		lv_trip_tm.setAdapter(adapter_tm);
	}

	public void initListener() {
		btnBack.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnMenu:
			onBackPressed();
			finish();
			break;


		default:
			break;
		}
	}
}
