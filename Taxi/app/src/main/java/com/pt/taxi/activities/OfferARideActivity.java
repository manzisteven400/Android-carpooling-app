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
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.widget.TextViewPixeden;
import com.pt.taxi.widget.TextViewRaleway;

public class OfferARideActivity extends BaseActivity implements OnClickListener {

	TextViewPixeden btnBack;
	TextViewRaleway lblTitle;
	private ImageView img_sub, img_sub1, img_add, img_add1;
	private TextView tv_number, tv_number1;
	private Spinner sp_bag, sp_time, sp_time2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offeraride);
		initUIOffer();
		setDataSpinner();
		initListener();
	}

	public void initUIOffer() {
		lblTitle = (TextViewRaleway) findViewById(R.id.lblTitle);

		lblTitle.setText("Offer A Ride");
		img_sub = (ImageView) findViewById(R.id.img_sub);
		img_sub1 = (ImageView) findViewById(R.id.img_sub1);
		img_add = (ImageView) findViewById(R.id.img_add);
		img_add1 = (ImageView) findViewById(R.id.img_add1);
		tv_number = (TextView) findViewById(R.id.tv_number);
		tv_number1 = (TextView) findViewById(R.id.tv_number1);
		btnBack = (TextViewPixeden) findViewById(R.id.btnMenu);
		sp_bag = (Spinner) findViewById(R.id.sp_bag);
		sp_time = (Spinner) findViewById(R.id.sp_Time);
		sp_time2 = (Spinner) findViewById(R.id.sp_Tour);
	}

	public void setDataSpinner() {
		List<String> list = new ArrayList<String>();
		list.add("Small");
		list.add("Medium");
		list.add("Big");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_bag.setAdapter(dataAdapter);

		List<String> list_time = new ArrayList<String>();
		list_time.add("Right on time");
		list_time.add("Now");
		ArrayAdapter<String> dataAdapter_time = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_time);
		dataAdapter_time
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_time.setAdapter(dataAdapter_time);

		List<String> list_tour = new ArrayList<String>();
		list_tour.add("15 minutes");
		list_tour.add("30 minutes");
		list_tour.add("45 minutes");
		ArrayAdapter<String> dataAdapter_tour = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_tour);
		dataAdapter_tour
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_time2.setAdapter(dataAdapter_tour);
	}

	public void initListener() {
		btnBack.setOnClickListener(this);
		img_sub1.setOnClickListener(this);
		img_sub.setOnClickListener(this);
		img_add.setOnClickListener(this);
		img_add1.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String number = tv_number.getText().toString();
		String number1 = tv_number1.getText().toString();
		switch (v.getId()) {
		case R.id.btnMenu:
			onBackPressed();
			finish();
			break;
		case R.id.img_sub:
			int dem = Integer.parseInt(number);
			if (dem > 0) {
				dem--;
				tv_number.setText(dem + "");
			}
			break;
		case R.id.img_add:
			int dem1 = Integer.parseInt(number);
			dem1++;
			tv_number.setText(dem1 + "");
			break;
		case R.id.img_sub1:
			int dem2 = Integer.parseInt(number1);
			if (dem2 > 0) {
				dem2--;
				tv_number1.setText(dem2 + "");
			}
			break;

		case R.id.img_add1:
			int dem3 = Integer.parseInt(number1);
			if (dem3 < 3) {
				dem3++;
				tv_number1.setText(dem3 + "");
			} else {
				Toast.makeText(this, "The number of seats allowed",
						Toast.LENGTH_SHORT).show();
			}

			break;

		default:
			break;
		}
	}
}
