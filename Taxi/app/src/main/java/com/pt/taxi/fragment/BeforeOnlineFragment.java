package com.pt.taxi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;
import com.pt.taxi.activities.OnlineActivity;

public class BeforeOnlineFragment extends BaseFragment implements
		OnClickListener {

	RelativeLayout btn_one_seat, btn_two_seat, btn_three_seat;
	private TextView lblTitle;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_before_online,
				container, false);
		initUI(view);
		initControl();
		initMenuButton(view);
		return view;
	}

	public void initUI(View view) {
		lblTitle = (TextView) view.findViewById(R.id.lblTitle);
		lblTitle.setText(getResources().getString(R.string.lbl_online));
		btn_one_seat = (RelativeLayout) view.findViewById(R.id.btn_one_seat);
		btn_two_seat = (RelativeLayout) view.findViewById(R.id.btn_two_seat);
		btn_three_seat = (RelativeLayout) view
				.findViewById(R.id.btn_three_seat);
	}

	public void initControl() {
		btn_one_seat.setOnClickListener(this);
		btn_two_seat.setOnClickListener(this);
		btn_three_seat.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_one_seat:
			mainActivity.gotoActivity(OnlineActivity.class);
			break;
		case R.id.btn_two_seat:
			mainActivity.gotoActivity(OnlineActivity.class);
			break;
		case R.id.btn_three_seat:
			mainActivity.gotoActivity(OnlineActivity.class);
			break;
		}
	}

}
