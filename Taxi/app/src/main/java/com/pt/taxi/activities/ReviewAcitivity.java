package com.pt.taxi.activities;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.adapters.CommentAdapter;
import com.pt.taxi.widget.TextViewPixeden;
import com.pt.taxi.widget.TextViewRaleway;

public class ReviewAcitivity extends BaseActivity implements OnClickListener {

	TextViewPixeden btnBack;
	TextViewRaleway lblTitle;
	private ListView lv_comment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_review);
		initUIRoundTrip();

		initListener();
	}

	public void initUIRoundTrip() {
		lblTitle = (TextViewRaleway) findViewById(R.id.lblTitle);
		lblTitle.setText("Passenger Reviews");
		btnBack = (TextViewPixeden) findViewById(R.id.btnMenu);
		lv_comment = (ListView) findViewById(R.id.lv_comment);
		CommentAdapter adapter = new CommentAdapter(self);
		lv_comment.setAdapter(adapter);
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
