package com.pt.taxi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.widget.TextViewPixeden;
import com.pt.taxi.widget.TextViewRaleway;

public class PaymentTransferActivity extends BaseActivity {

	TextViewPixeden btnBack;
	TextView btnContinue, lblError;
	TextViewRaleway lblBalance;
	private EditText lblPoint;
	Double a, b;
	Double c = 0.0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payment_transfers);
		
		initUI();
		initUIInThis();
		setHeaderTitle(R.string.lbl_transfers);
	}
	
	public void initUIInThis() {
		
		lblBalance = (TextViewRaleway)findViewById(R.id.lbl_Balance);
		lblPoint = (EditText)findViewById(R.id.lbl_Point);
		lblError = (TextView)findViewById(R.id.lbl_Error);
		
		btnBack = (TextViewPixeden)findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		
		btnContinue = (TextView)findViewById(R.id.btnContinue);
		btnContinue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (lblPoint.length() == 0){
					lblPoint.requestFocus();
					lblPoint.selectAll();
                    Toast.makeText(PaymentTransferActivity.this, "Point not null", Toast.LENGTH_SHORT).show();
                    return;
                }
				
				String balance = lblBalance.getText().toString();
				String point = lblPoint.getText().toString().trim();
				
				a = Double.parseDouble(balance);
				b = Double.parseDouble(point);
				c = a - b/10;
				
				if(c >=0){
//					Bundle bundle = new Bundle();
//					bundle.putDouble("c", c);
//					i.putExtra("bundle", bundle);
					gotoActivity(DetailTransferActivity.class);
					
					lblError.setVisibility(v.GONE);
					
				}else{
					lblError.setVisibility(v.VISIBLE);
					lblError.setText("You enter too many points");
				}
			}
		});
		
	}

}
