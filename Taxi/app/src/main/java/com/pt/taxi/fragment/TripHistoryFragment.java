package com.pt.taxi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;

public class TripHistoryFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_start_trip, container,
				false);
		initUI(view);
		initMenuButton(view);
		setHeaderTitle(R.string.lbl_title_start_trip);
		return view;
	}

}
