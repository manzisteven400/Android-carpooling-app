package com.pt.taxi.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;

public class OnlineActivity extends BaseActivity {
	RelativeLayout btnLoginFacebook, btnLoginGoogle;
	private final int SPLASH_DISPLAY_LENGHT = 10000;
	private Handler myHandler;
	private Runnable myRunnable = new Runnable() {
		@Override
		public void run() {
			// Do Something
			gotoActivity(RequestPassengerActivity.class);
			finish();
		}
	};

	@Override
	protected void onStart() {
		super.onStart();
		myHandler = new Handler();
		myHandler.postDelayed(myRunnable, SPLASH_DISPLAY_LENGHT);
	}

	@Override
	protected void onStop() {
		super.onStop();
		myHandler.removeCallbacks(myRunnable);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_online);
		((Button) findViewById(R.id.btnOffline))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						onBackPressed();
					}
				});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		showQuitDialog();
	}

	private void showQuitDialog() {
		new AlertDialog.Builder(this)
				.setTitle(R.string.app_name)
				.setMessage(R.string.msg_offline)
				.setPositiveButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								finish();
								overridePendingTransition(
										R.anim.slide_in_right,
										R.anim.slide_out_right);
							}
						}).setNegativeButton(android.R.string.cancel, null)
				.create().show();
	}
}
