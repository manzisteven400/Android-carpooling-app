package com.pt.taxi.activities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.gcm.GcmManager;
import com.pt.taxi.R;
import com.pt.taxi.utility.NetworkUtil;

public class SplashActivity extends BaseActivity {

	private final int SPLASH_DISPLAY_LENGHT = 1000;
	private GcmManager gcm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		// getData();
		NetworkUtil.enableStrictMode();
		getAppKeyHash();
	}

	@Override
	public void onResume() {
		super.onResume();
		if (NetworkUtil.checkNetworkAvailable(this)) {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					gotoActivity(LoginActivity.class);
					finish();
				}
			}, SPLASH_DISPLAY_LENGHT);
		} else {
			showDialogEnableNetwork();
		}
	}

	private void showDialogEnableNetwork() {
		new AlertDialog.Builder(this)
				.setTitle(R.string.app_name)
				.setMessage(R.string.msg_check_net_work)
				.setPositiveButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								arg0.dismiss();
								Intent intent = new Intent(
										Settings.ACTION_WIRELESS_SETTINGS);
								startActivity(intent);
							}
						})
				.setNegativeButton(android.R.string.cancel,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								onBackPressed();
							}
						}).create().show();
	}

	private void getAppKeyHash() {
		try {
			PackageInfo info = getPackageManager().getPackageInfo(
					"com.pt.taxi", PackageManager.GET_SIGNATURES);
			for (Signature signature : info.signatures) {
				MessageDigest md;

				md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());
				String something = new String(Base64.encode(md.digest(), 0));
				Log.d("Hash key", "HASH KEY : " + something);
			}
		} catch (NameNotFoundException e1) {
			// TODO Auto-generated catch block
		}

		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
		} catch (Exception e) {
		}

	}
}
