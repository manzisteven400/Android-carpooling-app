package com.pt.taxi.activities;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.widget.TextViewPixeden;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RatingBar;
import android.widget.TextView;

public class HelpActivity extends BaseActivity{
	
	TextView btnSend;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_passenger_trip);
		
		initUI();
		setHeaderTitle(R.string.lbl_title_your_trip);
		
		RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);
		LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
		stars.getDrawable(2).setColorFilter(Color.YELLOW, Mode.SRC_ATOP);
		btnSend = (TextView)findViewById(R.id.btnSend);
		
		btnSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		
	}

}
