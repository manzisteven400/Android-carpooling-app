package com.pt.taxi.activities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.widget.TextViewPixeden;
import com.pt.taxi.widget.TextViewRaleway;

public class DetailTripActivity extends BaseActivity implements OnClickListener {

	TextViewPixeden btnBack;
	TextViewRaleway lblTitle;
	private ListView lv_questions;
	List<String> list_data = new ArrayList<String>();
	private LinearLayout ll_publish_question;
	private boolean check = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_findride);
		list_data.add("How are you?");
		list_data.add("How much?");
		list_data.add("How about?");

		initUIRoundTrip();

		initListener();
	}

	public void initUIRoundTrip() {
		lblTitle = (TextViewRaleway) findViewById(R.id.lblTitle);
		lblTitle.setText("Detail Find Ride");
		btnBack = (TextViewPixeden) findViewById(R.id.btnMenu);
		lv_questions = (ListView) findViewById(R.id.lv_questions);
		ll_publish_question = (LinearLayout) findViewById(R.id.ll_publish_questions);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list_data);
		lv_questions.setAdapter(adapter);
	}

	public void initListener() {
		btnBack.setOnClickListener(this);
		ll_publish_question.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnMenu:
			onBackPressed();
			finish();
			break;
		case R.id.ll_publish_questions:
			if (!check) {
				lv_questions.setVisibility(View.VISIBLE);
				check = true;
			}else{
				lv_questions.setVisibility(View.GONE);
				check = false;
			}
			// Animation animation = AnimationUtils.loadAnimation(context,
			// R.anim.toptobottom);
			// animation.setDuration(500);
			// lv_questions.startAnimation(animation);
			break;

		default:
			break;
		}
	}
}
