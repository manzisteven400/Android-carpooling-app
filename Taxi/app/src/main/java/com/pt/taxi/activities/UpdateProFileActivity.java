package com.pt.taxi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.adapters.GalleryPhotoAdapter;
import com.pt.taxi.fragment.ProfileFragment;

public class UpdateProFileActivity extends BaseActivity {
	ImageView imgPhoto;
//	private Gallery galleryPhoto;
//	private GalleryPhotoAdapter adapter;

	EditText txtUpdateNameDriver, txtUpdateCarPlate, txtUpdatePhone;
			
	TextView btnBack, btnSave;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_updateprofile);
		
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		init();
		initControl();
	}

	private void initControl() {
		btnBack.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sendProfileFragment(ProfileFragment.RESULT_CODE_SAVE);
			}
		});
//		galleryPhoto.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				imgPhoto.setImageResource(photo[position]);
//				galleryPhoto.setVisibility(View.GONE);
//				
//			}
//		});
//		imgPhoto.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				galleryPhoto.setVisibility(View.VISIBLE);
//			}
//		});

	}

	protected void sendProfileFragment(int resultcode) {
		Intent intent = getIntent();
		String nameDriver = txtUpdateNameDriver.getText().toString();
		String carPlate = txtUpdateCarPlate.getText().toString();
		String phone = txtUpdatePhone.getText().toString();
		intent.putExtra("name", nameDriver);
		intent.putExtra("car", carPlate);
		intent.putExtra("phone", phone);
		
//		intent.putExtra("photo");
		
		setResult(resultcode, intent);
		finish();
	}
//	private static final int photo[]={R.drawable.taxia,R.drawable.img_taxi};
	private void init() {
//		galleryPhoto=(Gallery) findViewById(R.id.galPhoto);
//		galleryPhoto.setSpacing(2);
		txtUpdateNameDriver = (EditText) findViewById(R.id.txtUpdateNameDrive);
		txtUpdateCarPlate = (EditText) findViewById(R.id.txtUpdateCarPlate);
		txtUpdatePhone = (EditText) findViewById(R.id.txtUpdatePhone);
		btnBack = (TextView) findViewById(R.id.btnBackUpdate);
		btnSave = (TextView) findViewById(R.id.btnSave);
		imgPhoto=(ImageView) findViewById(R.id.imgphoto);
		
		
		
		
//		adapter=new GalleryPhotoAdapter(this, photo);
//		galleryPhoto.setAdapter(adapter);
	}

}
