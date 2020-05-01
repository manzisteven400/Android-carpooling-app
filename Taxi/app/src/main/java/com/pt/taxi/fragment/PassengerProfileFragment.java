package com.pt.taxi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;
import com.pt.taxi.activities.SignUpActivity;

public class PassengerProfileFragment extends BaseFragment {
	private Button btn_editprofile;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_passenger_profile,
				container, false);
		btn_editprofile = (Button) view.findViewById(R.id.btn_Submit);
		btn_editprofile.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mainActivity.gotoActivity(SignUpActivity.class);
			}
		});
		// RatingBar ratingBar = (RatingBar)view.findViewById(R.id.ratingBar);
		// LayerDrawable stars = (LayerDrawable)
		// ratingBar.getProgressDrawable();
		// stars.getDrawable(2).setColorFilter(Color.YELLOW, Mode.SRC_ATOP);

		initUI(view);
		initMenuButton(view);
		setHeaderTitle(R.string.lbl_pass_profile);
		return view;
	}

}
