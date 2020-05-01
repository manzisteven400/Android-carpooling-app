package com.pt.taxi.activities;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;

public class LoginActivity extends BaseActivity {
	RelativeLayout btnLoginFacebook, btnLoginGoogle;
	Button btn_register, btn_Login;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_login);
		btnLoginFacebook = (RelativeLayout) findViewById(R.id.btnLoginFacebook);
		btnLoginGoogle = (RelativeLayout) findViewById(R.id.btnLoginGoogle);
		btn_register = (Button) findViewById(R.id.btn_register);
		btn_Login = (Button) findViewById(R.id.btn_login);
		btn_Login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoActivity(MainActivity.class);
			}
		});
		btn_register.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoActivity(SignUpActivity.class);
			}
		});
		btnLoginFacebook.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				gotoActivity(MainActivity.class);
				finish();
			}
		});
		btnLoginGoogle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				gotoActivity(MainActivity.class);
				finish();
			}
		});

		LocalBroadcastManager.getInstance(this).registerReceiver(
				mMessageReceiver, new IntentFilter("custom-event-name"));
	}

	private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String message = intent.getStringExtra("message");
			Log.d("receiver", "Got message: " + message);
			showToastMessage(message);
		}
	};

	@Override
	protected void onDestroy() {
		// Unregister since the activity is about to be closed.
		LocalBroadcastManager.getInstance(this).unregisterReceiver(
				mMessageReceiver);
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		showQuitDialog();
	}

	private void showQuitDialog() {
		new AlertDialog.Builder(this)
				.setTitle(R.string.app_name)
				.setMessage(R.string.msg_quit_app)
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
