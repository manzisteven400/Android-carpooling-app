package com.pt.taxi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends FragmentActivity {
	public static String TAG;
	public static boolean DEBUG_MODE = false;
	protected BaseActivity self;

	protected ProgressDialog progressDialog;
	protected LinearLayout userStatusLayout;
	protected Context context;
	
	private TextView lblTitle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		self = this;
		TAG = self.getClass().getSimpleName();		
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.gc();
	}

	@Override
	public void onPause() {
		super.onPause();
	}
	
	protected void initUI() {
		lblTitle = (TextView)findViewById(R.id.lblTitle);
	}
	protected void setHeaderTitle(int idString) {
		lblTitle.setText(idString);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
	}

	/**
	 * Go to other activity
	 * 
	 * @param context
	 * @param cla
	 */

	public void gotoActivity(Class<?> cla) {
		Intent intent = new Intent(this, cla);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left2);
	}

	public void backActivity(Class<?> cla, Bundle b) {
		Intent intent = new Intent(this, cla);
		intent.putExtras(b);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left2);
	}

	public void backActivity(Class<?> cla) {
		Intent intent = new Intent(this, cla);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
	}

	public void gotoActivity(Class<?> cla, int flag) {
		Intent intent = new Intent(this, cla);
		intent.setFlags(flag);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left2);
	}

	/**
	 * goto view website
	 * 
	 * @param url
	 */
	public void gotoWeb(Uri uri) {
		Intent myIntent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(myIntent);
	}

	/**
	 * Go to other activity
	 * 
	 * @param context
	 * @param cla
	 */
	public void gotoActivityForResult(Context context, Class<?> cla,
			int requestCode) {
		Intent intent = new Intent(context, cla);
		startActivityForResult(intent, requestCode);
	}

	/**
	 * Goto activity with bundle
	 * 
	 * @param context
	 * @param cla
	 * @param bundle
	 */
	public void gotoActivity(Context context, Class<?> cla, Bundle bundle) {
		Intent intent = new Intent(context, cla);
		intent.putExtras(bundle);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.push_left_out);
	}

	/**
	 * Goto activity with bundle
	 * 
	 * @param context
	 * @param cla
	 * @param bundle
	 * @param requestCode
	 */
	public void gotoActivityForResult(Context context, Class<?> cla,
			Bundle bundle, int requestCode) {
		Intent intent = new Intent(context, cla);
		intent.putExtras(bundle);
		startActivityForResult(intent, requestCode);
	}

	/**
	 * Goto web page
	 * 
	 * @param url
	 */
	protected void gotoWebPage(String url) {
		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(i);
	}

	/**
	 * Goto phone call
	 * 
	 * @param telNumber
	 */
	protected void gotoPhoneCallPage(String telNumber) {
		Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(R.string.tel
				+ telNumber));
		startActivity(i);
	}

	/**
	 * Close activity
	 */
	public void closeActivity(View v) {
		finish();
	}

	// ********************* NOTIFICATION *******************

	// ======================= TOAST MANAGER =======================

	/**
	 * @param str
	 *            : alert message
	 * 
	 *            Show toast message
	 */
	public void showToastMessage(String str) {
		Toast.makeText(self, str, Toast.LENGTH_SHORT).show();
	}

	/**
	 * @param strId
	 *            : alert message
	 * 
	 *            Show toast message
	 */
	public void showToastMessage(int strId) {
		Toast.makeText(self, getString(strId), Toast.LENGTH_SHORT).show();
	}

	/**
	 * @param str
	 *            : alert message
	 * 
	 *            Show toast message
	 */
	public void showShortToastMessage(String str) {
		Toast.makeText(self, str, Toast.LENGTH_SHORT).show();
	}

	public void showShortToastMessage(int str) {
		Toast.makeText(self, str, Toast.LENGTH_SHORT).show();
	}

	/**
	 * @param str
	 *            : alert message
	 * 
	 *            Show toast message
	 */
	public void showToastMessage(String str, int time) {
		Toast.makeText(self, str, time).show();
	}

	/**
	 * @param str
	 *            : alert message
	 * 
	 *            Show toast message
	 */

	public void showToastMessage(int resId, int time) {
		Toast.makeText(self, resId, time).show();
	}

	/**
	 * Show comming soon toast message
	 */
	public void showComingSoonMessage() {
		showToastMessage("Coming soon!");
	}

	// ======================= PROGRESS DIALOG ======================

	/**
	 * Open progress dialog
	 * 
	 * @param text
	 */
	public void showProgressDialog() {
		try {
			if (progressDialog == null) {
				try {
					progressDialog = new ProgressDialog(self);
					progressDialog.show();
					progressDialog.setCancelable(false);
				} catch (Exception e) {
					progressDialog = new ProgressDialog(self.getParent());
					progressDialog.show();
					progressDialog.setCancelable(false);
					e.printStackTrace();
				}
			} else {
				if (!progressDialog.isShowing())
					progressDialog.show();
			}
		} catch (Exception e) {
			progressDialog = new ProgressDialog(self);
			progressDialog.show();
			progressDialog.setCancelable(false);
			e.printStackTrace();
		}
	}

	public void showProgressDialog(Context context) {
		try {
			if (progressDialog == null) {
				progressDialog = new ProgressDialog(context);
				progressDialog.show();
				progressDialog.setCancelable(false);

			} else {
				if (!progressDialog.isShowing())
					progressDialog.show();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void closeProgressDialog() {
		if (progressDialog != null) {
			progressDialog.dismiss();
			progressDialog.cancel();
			progressDialog = null;
		}

	}

}
