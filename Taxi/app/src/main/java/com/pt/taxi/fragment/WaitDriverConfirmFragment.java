package com.pt.taxi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;

public class WaitDriverConfirmFragment extends BaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(
				R.layout.layout_passenger_waiting_confirmation, container,
				false);

		return view;
	}

}
