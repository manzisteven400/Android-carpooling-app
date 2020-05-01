package com.pt.taxi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.widget.TextViewPixeden;
import com.pt.taxi.widget.TextViewRaleway;

public class DetailTransferActivity extends BaseActivity {

	TextViewPixeden btnback;
	TextViewRaleway lblBalance;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_transfers);
		
		lblBalance = (TextViewRaleway)findViewById(R.id.lbl_Balance);
		
		//hide keyboard with edittext
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		
//		Intent i = getIntent();
//		Bundle bundle = i.getBundleExtra("bundle");
//		Double c = bundle.getDouble("c");
//		lblBalance.setText(String.valueOf(c));
		
		btnback = (TextViewPixeden)findViewById(R.id.btnBack);
		btnback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
	}
}
