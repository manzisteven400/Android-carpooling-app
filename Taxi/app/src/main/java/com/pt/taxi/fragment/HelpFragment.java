package com.pt.taxi.fragment;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;

public class HelpFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_help, container,false);
		
//		RatingBar ratingBar = (RatingBar)view.findViewById(R.id.ratingBar);
//		LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
//		stars.getDrawable(2).setColorFilter(Color.YELLOW, Mode.SRC_ATOP);

		initUI(view);
		initMenuButton(view);
		setHeaderTitle(R.string.lbl_help);
		return view;
	}

}
