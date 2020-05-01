package com.pt.taxi.activities;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.adapters.RequestPassengerAdapter;

public class RequestPassengerActivity extends BaseActivity {
	TextView btnBack;
	ListView lvRequestPassenger;
	RequestPassengerAdapter adapter;
	ArrayList<String> array;	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_request_passenger);
		init();
		lvRequestPassenger = (ListView) findViewById(R.id.lvRequestPassenger);
		array = new ArrayList<String>();
		array.add("Request Link I");
		array.add("Request Link II");
		array.add("Request Link III");
		adapter = new RequestPassengerAdapter(this, array);
		lvRequestPassenger.setAdapter(adapter);
		lvRequestPassenger.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				gotoActivity(ShowPassengerActivity.class);
				finish();
			}
		});
	}

	private void init() {
		btnBack = (TextView) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});

	}

}
