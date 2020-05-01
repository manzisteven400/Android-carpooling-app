package com.pt.taxi.activities;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.adapters.HistoryAdapter;
import com.pt.taxi.adapters.PaymentHistoryAdapter;
import com.pt.taxi.widget.TextViewPixeden;

public class PaymentHistoryActivity extends BaseActivity {

	TextViewPixeden btnBack;
	PaymentHistoryAdapter paymentHistory;
	ListView lvPaymentHistory;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_payment_history);
		
		initUI();
		initUIInThis();
		setHeaderTitle(R.string.lbl_payment_history);
	}
	public void initUIInThis() {
		
		lvPaymentHistory = (ListView)findViewById(R.id.lsvHistory);
		paymentHistory = new PaymentHistoryAdapter(self);
	
		lvPaymentHistory.setAdapter(paymentHistory);
		
		lvPaymentHistory.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
			}
			
		});
		btnBack = (TextViewPixeden)findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		
	}
	
}
