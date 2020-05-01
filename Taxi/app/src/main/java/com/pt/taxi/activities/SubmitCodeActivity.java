package com.pt.taxi.activities;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;

public class SubmitCodeActivity extends BaseActivity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_code);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}
}
