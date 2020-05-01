package com.pt.taxi.activities;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.widget.TextViewPixeden;
import com.pt.taxi.widget.TextViewRaleway;

public class RoundTripActivity extends BaseActivity implements OnClickListener {

	TextViewPixeden btnBack;
	TextViewRaleway lblTitle;
	TextView lbl_time1, lbl_time2;
	private DatePicker dpResult;
	static final int DATE_DIALOG_ID = 999;
	static final int DATE_DIALOG_ID_1 = 996;
	private TimePicker timePicker1;

	private int hour;
	private int minute;

	static final int TIME_DIALOG_ID = 998;
	static final int TIME_DIALOG_ID_1 = 997;

	private int year;
	private int month;
	private int day;
	private Button btn_nextStep;
	private TextViewRaleway tv_date_start, tv_date_end;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_roundtrip);
		initUIRoundTrip();
		setCurrentDateOnView();
		setCurrentTimeOnView();
		initListener();
	}

	public void initUIRoundTrip() {
		lblTitle = (TextViewRaleway) findViewById(R.id.lblTitle);
		lblTitle.setText(R.string.lbl_roundtrip);
		btnBack = (TextViewPixeden) findViewById(R.id.btnMenu);
		lbl_time1 = (TextView) findViewById(R.id.txt_time);
		lbl_time2 = (TextView) findViewById(R.id.txt_time1);
		btn_nextStep = (Button) findViewById(R.id.btn_nextStep);
		tv_date_start = (TextViewRaleway) findViewById(R.id.tv_date_start);
		tv_date_end = (TextViewRaleway) findViewById(R.id.tv_date_end);
	}

	public void initListener() {
		btnBack.setOnClickListener(this);
		lbl_time1.setOnClickListener(this);
		lbl_time2.setOnClickListener(this);
		tv_date_start.setOnClickListener(this);
		tv_date_end.setOnClickListener(this);
		btn_nextStep.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnMenu:
			onBackPressed();
			finish();
			break;
		case R.id.tv_date_start:
			showDialog(DATE_DIALOG_ID);
			break;
		case R.id.tv_date_end:
			showDialog(DATE_DIALOG_ID_1);
			break;
		case R.id.btn_nextStep:
			gotoActivity(OfferARideActivity.class);
			break;
		case R.id.txt_time:
			showDialog(TIME_DIALOG_ID);
			break;
		case R.id.txt_time1:
			showDialog(TIME_DIALOG_ID_1);
			break;

		default:
			break;
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set date picker as current date
			return new DatePickerDialog(this, datePickerListener, year, month,
					day);
		case DATE_DIALOG_ID_1:
			// set date picker as current date
			return new DatePickerDialog(this, datePickerListener1, year, month,
					day);

		case TIME_DIALOG_ID:
			// set time picker as current time
			return new TimePickerDialog(this, timePickerListener, hour, minute,
					false);
		case TIME_DIALOG_ID_1:
			// set time picker as current time
			return new TimePickerDialog(this, timePickerListener1, hour,
					minute, false);
		}

		return null;
	}

	public void setCurrentDateOnView() {
		dpResult = new DatePicker(this);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		tv_date_start.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" "));
		tv_date_end.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" "));

		// set current date into datepicker
		dpResult.init(year, month, day, null);

	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			// set selected date into textview
			tv_date_start.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));

			// set selected date into datepicker also
			dpResult.init(year, month, day, null);

		}
	};
	private DatePickerDialog.OnDateSetListener datePickerListener1 = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			// set selected date into textview
			tv_date_end.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));

			// set selected date into datepicker also
			dpResult.init(year, month, day, null);

		}
	};

	// display current time
	public void setCurrentTimeOnView() {

		timePicker1 = new TimePicker(this);

		final Calendar c = Calendar.getInstance();
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);

		// set current time into textview
		lbl_time1.setText(new StringBuilder().append(pad(hour)).append(":")
				.append(pad(minute)));
		lbl_time2.setText(new StringBuilder().append(pad(hour)).append(":")
				.append(pad(minute)));


		// set current time into timepicker
		timePicker1.setCurrentHour(hour);
		timePicker1.setCurrentMinute(minute);

	}

	private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int selectedHour,
				int selectedMinute) {
			hour = selectedHour;
			minute = selectedMinute;

			// set current time into textview
			lbl_time1.setText(new StringBuilder().append(pad(hour)).append(":")
					.append(pad(minute)));

			// set current time into timepicker
			timePicker1.setCurrentHour(hour);
			timePicker1.setCurrentMinute(minute);

		}
	};
	private TimePickerDialog.OnTimeSetListener timePickerListener1 = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int selectedHour,
				int selectedMinute) {
			hour = selectedHour;
			minute = selectedMinute;

			// set current time into textview
			lbl_time2.setText(new StringBuilder().append(pad(hour)).append(":")
					.append(pad(minute)));

			// set current time into timepicker
			timePicker1.setCurrentHour(hour);
			timePicker1.setCurrentMinute(minute);

		}
	};

	private static String pad(int c) {
		if (c >= 10)
			return String.valueOf(c);
		else
			return "0" + String.valueOf(c);
	}
}
