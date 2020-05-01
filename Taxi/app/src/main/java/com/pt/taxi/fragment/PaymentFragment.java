package com.pt.taxi.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;
import com.pt.taxi.activities.PaymentActivity;
import com.pt.taxi.activities.PaymentHistoryActivity;
import com.pt.taxi.activities.PaymentTransferActivity;
import com.pt.taxi.activities.PayoutActivity;

public class PaymentFragment extends BaseFragment implements OnClickListener {
	Button btnPayment, btnPayout, btnTransfers, btnHistory;
	TextView lblTotalPoint;
	int Total = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_payment, container,
				false);
		initUI(view);
		initControl();
		initMenuButton(view);
		return view;
	}

	public void initUI(View view) {
		btnHistory = (Button) view.findViewById(R.id.btnHistory);
		btnPayment = (Button) view.findViewById(R.id.btnPayment);
		btnPayout = (Button) view.findViewById(R.id.btnPayout);
		btnTransfers = (Button) view.findViewById(R.id.btnTrasfers);
		lblTotalPoint = (TextView) view.findViewById(R.id.txtTotalPoint);
	}

	public void initControl() {
		btnHistory.setOnClickListener(this);
		btnPayment.setOnClickListener(this);
		btnPayout.setOnClickListener(this);
		btnTransfers.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnPayment:

			showDialogPayment();
			break;
		case R.id.btnPayout:
			showDialogPayout();
			break;
		case R.id.btnTrasfers:
			showTrasfers();
			break;
		case R.id.btnHistory:
			showHistory();
			break;

		}
	}

	private void showTrasfers() {
		startActivity(PaymentTransferActivity.class);
	}

	private void showHistory() {
		startActivity(PaymentHistoryActivity.class);
	}

	private void showDialogPayout() {
		startActivity(PayoutActivity.class);

	}

	private void showDialogPayment() {
		startActivity(PaymentActivity.class);
	}
}
