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

public class SignUpActivity extends BaseActivity implements OnClickListener {
	private TextView tvDateOfBirth, lblTitle;
	private Button btnSubmit;
	private DatePicker dpResult;
	static final int DATE_DIALOG_ID = 999;
	private int year;
	private int month;
	private int day;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign);
		
		lblTitle = (TextView) findViewById(R.id.lblTitle);
		lblTitle.setText("Register");
		tvDateOfBirth = (TextView) findViewById(R.id.txtDateOfBirth);
		btnSubmit = (Button) findViewById(R.id.btn_Submit);
		setCurrentDateOnView();
		initListener();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.txtDateOfBirth:
			showDialog(DATE_DIALOG_ID);
			break;
		case R.id.btn_Submit:
			gotoActivity(SubmitCodeActivity.class);
			break;
		}
	}

	public void initListener() {
		tvDateOfBirth.setOnClickListener(this);
		btnSubmit.setOnClickListener(this);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set date picker as current date
			return new DatePickerDialog(this, datePickerListener, year, month,
					day);
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
		tvDateOfBirth.setText(new StringBuilder()
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
			tvDateOfBirth.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));

			// set selected date into datepicker also
			dpResult.init(year, month, day, null);

		}
	};
}
