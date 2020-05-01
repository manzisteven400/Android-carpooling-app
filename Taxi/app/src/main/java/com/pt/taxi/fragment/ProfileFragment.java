package com.pt.taxi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;
import com.pt.taxi.activities.MainActivity;
import com.pt.taxi.activities.ReviewAcitivity;
import com.pt.taxi.activities.UpdateProFileActivity;
import com.pt.taxi.widget.TextViewRaleway;

public class ProfileFragment extends BaseFragment {
	public static final int REQUEST_CODE_INPUT = 1;
	public static final int RESULT_CODE_SAVE = 2;
	// TextView btnUpdate;
	// TextView lblNameDriver, lblCarplate, lblPhone, lblRate;
	// ImageView imgTaxt;
	TextViewRaleway lbl_reviews;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile, container,
				false);
		 initUI(view);
		// initControl();
		// lblNameDriver = (TextView) view.findViewById(R.id.txt_name_driver);
		// if (!MainActivity.profile.equals("")) {
		// lblNameDriver.setText(MainActivity.profile);
		// }

		initMenuButton(view);
		return view;
	}

	public void initUI(View view) {
		lbl_reviews = (TextViewRaleway) view.findViewById(R.id.lbl_reviews);
		lbl_reviews.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mainActivity.gotoActivity(ReviewAcitivity.class);
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == REQUEST_CODE_INPUT) {

			// String nameDriver = data.getStringExtra("name");
			// String carPlate = data.getStringExtra("car");
			// String phone = data.getStringExtra("phone");
			//
			// // int img=data.getIntExtra("photo");
			//
			// lblNameDriver.setText(nameDriver);
			// lblCarplate.setText(carPlate);
			// lblPhone.setText(phone);

			// imgTaxt.setImageResource(img);

		}
	}

}
