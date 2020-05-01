package com.pt.taxi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;

public class RegisterFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_register, container,
				false);
		initUI(view);
		initMenuButton(view);
		setHeaderTitle(getResources()
				.getString(R.string.lbl_register_as_driver));
		return view;
	}

}
