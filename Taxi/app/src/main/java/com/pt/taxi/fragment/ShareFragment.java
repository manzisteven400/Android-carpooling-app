package com.pt.taxi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;

public class ShareFragment extends BaseFragment implements OnClickListener {
	RelativeLayout btnShareFacebook, btnShareGmail;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_share, container, false);

		initUI(view);
		initControl();
		initMenuButton(view);
		
		return view;
	}

	public void initUI(View view) {
		btnShareFacebook = (RelativeLayout) view
				.findViewById(R.id.btnShareFacebook);
		btnShareGmail = (RelativeLayout) view.findViewById(R.id.btnShareGmail);
	}

	public void initControl() {
		btnShareFacebook.setOnClickListener(this);
		btnShareGmail.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnShareFacebook:
			Toast.makeText(getActivity(), "Share Facebook + 50 point", Toast.LENGTH_LONG)
					.show();
			break;

		case R.id.btnShareGmail:
			Toast.makeText(getActivity(), "Share Google + 50 point", Toast.LENGTH_LONG)
					.show();
			break;
		}
	}

}
