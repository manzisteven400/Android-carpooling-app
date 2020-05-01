package com.pt.taxi.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pt.taxi.BaseActivity;
import com.pt.taxi.R;
import com.pt.taxi.fragment.PassengerPage1Fragment;
import com.pt.taxi.slidingmenu.SlidingMenu;
import com.pt.taxi.widget.TextViewFontAwesome;
import com.pt.taxi.widget.TextViewRaleway;

public class MainActivity extends BaseActivity {

	// --------------------------------------------
	// --- Menu layout
	// --------------------------------------------
	private ImageView imgAvartar;
	private TextViewRaleway txtPoint;
	private TextViewRaleway txtUserName;
	private LinearLayout btnHome;
	private TextViewFontAwesome icHome;
	private TextViewRaleway lblHome;
	private LinearLayout btnProfile;
	private TextViewFontAwesome icProfile;
	private TextViewRaleway lblProfile;
	private LinearLayout btnPayment;
	private TextViewFontAwesome icPayment;
	private TextViewRaleway lblPayment;
	private LinearLayout btnShare;
	private TextViewFontAwesome icShare;
	private TextViewRaleway lblShare;
	private LinearLayout btnHelp;
	private TextViewFontAwesome icHelp;
	private TextViewRaleway lblHelp;
	private LinearLayout btnTripHistory;
	private TextViewFontAwesome icTripHistory;
	private TextViewRaleway lblTripHistory;
	private LinearLayout btnOnline;
	private TextViewFontAwesome icOnline;
	private TextViewRaleway lblOnline;
	private LinearLayout btnRegisterDriver;
	private TextViewFontAwesome icRegisterDriver;
	private TextViewRaleway lblRegisterDriver;
	private LinearLayout btnLanguage;
	private TextViewFontAwesome icLanguage;
	private TextViewRaleway lblLanguage;
	private LinearLayout btn_rate;
	private TextViewFontAwesome icRate;
	private TextViewRaleway lblRate;
	private LinearLayout btn_Pass_Profile;
	private TextViewFontAwesome ic_Pass_Profile;
	private TextViewRaleway lbl_Pass_Profile;

	// --------------------------------------------
	// --- For fragment
	// --------------------------------------------
	// public static final int PROFILE = 0;
	// public static final int PAYMENT = 1;
	// public static final int SHARE = 2;
	// public static final int HELP = 3;
	// public static final int TRIP_HISTORY = 4;
	// public static final int ONLINE = 5;
	// public static final int REGISTER_AS_DRIVER = 6;
	// public static final int LANGUAGE = 7;
	public static final int PROFILE = 0;
	public static final int TRIP_HISTORY = 1;
	public static final int PASSENGER_PAGE1 = 2;
	public static final int HELP = 3;
	public static final int REGISTER_AS_DRIVER = 4;
	public static final int WAIT_DRIVER_CONFIRM = 5;
	public static final int ONLINE = 6;

	public static final int PAYMENT = 7;
	public static final int SHARE = 8;

	public static final int TOTAL_FRAGMENT = 11;
	public static final int RATE = 9;
	public static final int PASSENGER_PROFILE = 10;

	private int currentFragment = PROFILE;
	private Fragment fragments[];
	private FragmentManager fm;
	public SlidingMenu menu;
	private boolean showManager = false;
	public static String profile = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bundle bd = getIntent().getExtras();
		if (bd != null) {
			profile = bd.getString("profile");
			if (profile != null) {
				initMenu();
				initFragmentProfile();
				initMenuControl();
			}
		} else {
			initMenu();
			initFragment();
			initMenuControl();
		}
	}

	// --------------------------------------------
	// --- Menu Manager
	// --------------------------------------------

	private void initMenu() {
		// Get header menu
		menu = new SlidingMenu(this);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.5f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		menu.setMenu(R.layout.layout_menu);

		// Get content menu
		imgAvartar = (ImageView) findViewById(R.id.img_avartar);
		txtPoint = (TextViewRaleway) findViewById(R.id.txt_point);
		txtUserName = (TextViewRaleway) findViewById(R.id.txt_user_name);
		btnHome = (LinearLayout) findViewById(R.id.btn_home);
		icHome = (TextViewFontAwesome) findViewById(R.id.ic_home);
		lblHome = (TextViewRaleway) findViewById(R.id.lbl_home);
		btnProfile = (LinearLayout) findViewById(R.id.btn_profile);
		icProfile = (TextViewFontAwesome) findViewById(R.id.ic_profile);
		lblProfile = (TextViewRaleway) findViewById(R.id.lbl_profile);
		btnPayment = (LinearLayout) findViewById(R.id.btn_payment);
		icPayment = (TextViewFontAwesome) findViewById(R.id.ic_payment);
		lblPayment = (TextViewRaleway) findViewById(R.id.lbl_payment);
		btnShare = (LinearLayout) findViewById(R.id.btn_share);
		icShare = (TextViewFontAwesome) findViewById(R.id.ic_share);
		lblShare = (TextViewRaleway) findViewById(R.id.lbl_share);
		btnHelp = (LinearLayout) findViewById(R.id.btn_help);
		icHelp = (TextViewFontAwesome) findViewById(R.id.ic_help);
		lblHelp = (TextViewRaleway) findViewById(R.id.lbl_help);
		btnTripHistory = (LinearLayout) findViewById(R.id.btn_trip_history);
		icTripHistory = (TextViewFontAwesome) findViewById(R.id.ic_trip_history);
		lblTripHistory = (TextViewRaleway) findViewById(R.id.lbl_trip_history);
		btnOnline = (LinearLayout) findViewById(R.id.btn_online);
		icOnline = (TextViewFontAwesome) findViewById(R.id.ic_online);
		lblOnline = (TextViewRaleway) findViewById(R.id.lbl_online);
		btnRegisterDriver = (LinearLayout) findViewById(R.id.btn_register_driver);
		icRegisterDriver = (TextViewFontAwesome) findViewById(R.id.ic_register_driver);
		lblRegisterDriver = (TextViewRaleway) findViewById(R.id.lbl_register_driver);
		btnLanguage = (LinearLayout) findViewById(R.id.btn_language);
		icLanguage = (TextViewFontAwesome) findViewById(R.id.ic_language);
		lblLanguage = (TextViewRaleway) findViewById(R.id.lbl_language);
		btn_rate = (LinearLayout) findViewById(R.id.btn_rate);
		icRate = (TextViewFontAwesome) findViewById(R.id.ic_rate);
		lblRate = (TextViewRaleway) findViewById(R.id.lbl_rate);
		btn_Pass_Profile = (LinearLayout) findViewById(R.id.btn_pass_profile);
		ic_Pass_Profile = (TextViewFontAwesome) findViewById(R.id.ic_pass_profile);
		lbl_Pass_Profile = (TextViewRaleway) findViewById(R.id.lbl_pass_profile);
	}

	public void showMenu() {
		menu.showMenu();
	}

	private void initMenuControl() {
		btnProfile.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment(PROFILE);
				menu.showContent(true);
			}
		});

		btnTripHistory.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment(TRIP_HISTORY);
				menu.showContent(true);
			}
		});

		btnLanguage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// showFragment(LANGUAGE);
				// menu.showContent(true);
			}
		});

		btnHelp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment(HELP);
				menu.showContent(true);
			}
		});

		btnRegisterDriver.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment(REGISTER_AS_DRIVER);
				menu.showContent(true);
			}
		});

		btnHome.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment(PASSENGER_PAGE1);
				menu.showContent(true);
			}
		});

		btnOnline.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragmentOffer();
				menu.showContent(true);
			}
		});

		btnPayment.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment(PAYMENT);
				menu.showContent(true);
			}
		});
		btnShare.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment(SHARE);
				menu.showContent(true);
			}
		});
		btn_rate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment(RATE);
				menu.showContent(true);
			}
		});
		btn_Pass_Profile.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment(PASSENGER_PROFILE);
				menu.showContent(true);
			}
		});

	}

	private void updateMenuUI() {
		if (currentFragment == PROFILE) {
			btnProfile.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			icProfile.setTextColor(getResources().getColor(R.color.white));
			lblProfile.setTextColor(getResources().getColor(R.color.white));
		} else {
			btnProfile.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			icProfile.setTextColor(getResources().getColor(R.color.white));
			lblProfile.setTextColor(getResources().getColor(R.color.white));
		}

		if (currentFragment == TRIP_HISTORY) {
			btnTripHistory.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			icTripHistory.setTextColor(getResources().getColor(R.color.white));
			lblTripHistory.setTextColor(getResources().getColor(R.color.white));
		} else {
			btnTripHistory.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			icTripHistory.setTextColor(getResources().getColor(R.color.white));
			lblTripHistory.setTextColor(getResources().getColor(R.color.white));
		}

		if (currentFragment == HELP) {
			btnHelp.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			icHelp.setTextColor(getResources().getColor(R.color.white));
			lblHelp.setTextColor(getResources().getColor(R.color.white));
		} else {
			btnHelp.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			icHelp.setTextColor(getResources().getColor(R.color.white));
			lblHelp.setTextColor(getResources().getColor(R.color.white));
		}

		if (currentFragment == ONLINE) {
			btnOnline.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			icOnline.setTextColor(getResources().getColor(R.color.white));
			lblOnline.setTextColor(getResources().getColor(R.color.white));
		} else {
			btnOnline.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			icOnline.setTextColor(getResources().getColor(R.color.white));
			lblOnline.setTextColor(getResources().getColor(R.color.white));
		}

		if (currentFragment == REGISTER_AS_DRIVER) {
			btnRegisterDriver.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			icRegisterDriver.setTextColor(getResources()
					.getColor(R.color.white));
			lblRegisterDriver.setTextColor(getResources().getColor(
					R.color.white));
		} else {
			btnRegisterDriver.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			icRegisterDriver.setTextColor(getResources()
					.getColor(R.color.white));
			lblRegisterDriver.setTextColor(getResources().getColor(
					R.color.white));
		}

		if (currentFragment == PASSENGER_PAGE1) {
			btnHome.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			icHome.setTextColor(getResources().getColor(R.color.white));
			lblHome.setTextColor(getResources().getColor(R.color.white));
		} else {
			btnHome.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			icHome.setTextColor(getResources().getColor(R.color.white));
			lblHome.setTextColor(getResources().getColor(R.color.white));
		}

		if (currentFragment == PAYMENT) {
			btnPayment.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			icPayment.setTextColor(getResources().getColor(R.color.white));
			lblPayment.setTextColor(getResources().getColor(R.color.white));
		} else {
			btnPayment.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			icPayment.setTextColor(getResources().getColor(R.color.white));
			lblPayment.setTextColor(getResources().getColor(R.color.white));
		}

		if (currentFragment == SHARE) {
			btnShare.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			icShare.setTextColor(getResources().getColor(R.color.white));
			lblShare.setTextColor(getResources().getColor(R.color.white));
		} else {
			btnShare.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			icShare.setTextColor(getResources().getColor(R.color.white));
			lblShare.setTextColor(getResources().getColor(R.color.white));
		}
		if (currentFragment == RATE) {
			btn_rate.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			icRate.setTextColor(getResources().getColor(R.color.white));
			lblRate.setTextColor(getResources().getColor(R.color.white));
		} else {
			btn_rate.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			icRate.setTextColor(getResources().getColor(R.color.white));
			lblRate.setTextColor(getResources().getColor(R.color.white));
		}
		if (currentFragment == PASSENGER_PROFILE) {
			btn_Pass_Profile.setBackgroundColor(getResources().getColor(
					R.color.color_book));
			ic_Pass_Profile
					.setTextColor(getResources().getColor(R.color.white));
			lbl_Pass_Profile.setTextColor(getResources()
					.getColor(R.color.white));
		} else {
			btn_Pass_Profile.setBackgroundColor(getResources().getColor(
					R.color.menu_content_background));
			ic_Pass_Profile
					.setTextColor(getResources().getColor(R.color.white));
			lbl_Pass_Profile.setTextColor(getResources()
					.getColor(R.color.white));
		}

	}

	// --------------------------------------------
	// --- Fragment Manager
	// --------------------------------------------
	private void initFragment() {
		fm = getSupportFragmentManager();

		fragments = new Fragment[TOTAL_FRAGMENT];

		fragments[PROFILE] = fm.findFragmentById(R.id.fragmentProfileFragment);
		fragments[TRIP_HISTORY] = fm
				.findFragmentById(R.id.fragmentHistoryFragment);
		fragments[HELP] = fm.findFragmentById(R.id.fragmentHelpFragment);
		fragments[REGISTER_AS_DRIVER] = fm
				.findFragmentById(R.id.fragmentRegisterFragment);
		fragments[PASSENGER_PAGE1] = fm
				.findFragmentById(R.id.fragmentPassenger1);
		fragments[WAIT_DRIVER_CONFIRM] = fm
				.findFragmentById(R.id.fragmentWaitDriverConfirmFragment);
		fragments[ONLINE] = fm
				.findFragmentById(R.id.fragmentBeforeOnlineFragment);
		fragments[PAYMENT] = fm.findFragmentById(R.id.fragmentPaymentFragment);

		fragments[SHARE] = fm.findFragmentById(R.id.fragmentShareFragment);
		fragments[RATE] = fm.findFragmentById(R.id.fragmentRateFragment);
		fragments[PASSENGER_PROFILE] = fm
				.findFragmentById(R.id.fragmentPassengerProfileFragment);
		showFragment(PASSENGER_PAGE1);
	}

	private void initFragmentProfile() {
		fm = getSupportFragmentManager();

		fragments = new Fragment[TOTAL_FRAGMENT];

		fragments[PROFILE] = fm.findFragmentById(R.id.fragmentProfileFragment);
		fragments[TRIP_HISTORY] = fm
				.findFragmentById(R.id.fragmentHistoryFragment);
		fragments[HELP] = fm.findFragmentById(R.id.fragmentHelpFragment);
		fragments[REGISTER_AS_DRIVER] = fm
				.findFragmentById(R.id.fragmentRegisterFragment);
		fragments[PASSENGER_PAGE1] = fm
				.findFragmentById(R.id.fragmentPassenger1);
		fragments[WAIT_DRIVER_CONFIRM] = fm
				.findFragmentById(R.id.fragmentWaitDriverConfirmFragment);
		fragments[ONLINE] = fm
				.findFragmentById(R.id.fragmentBeforeOnlineFragment);
		fragments[PAYMENT] = fm.findFragmentById(R.id.fragmentPaymentFragment);

		fragments[SHARE] = fm.findFragmentById(R.id.fragmentShareFragment);
		fragments[RATE] = fm.findFragmentById(R.id.fragmentRateFragment);
		fragments[PASSENGER_PROFILE] = fm
				.findFragmentById(R.id.fragmentPassengerProfileFragment);
		showFragment(PROFILE);
	}

	public void showFragment(int fragmentIndex) {
		FragmentTransaction transaction = fm.beginTransaction();
		currentFragment = fragmentIndex;
		updateMenuUI();
		for (int i = 0; i < fragments.length; i++) {
			if (i == fragmentIndex) {
				if (fragmentIndex == PASSENGER_PAGE1) {
					PassengerPage1Fragment.setView(PASSENGER_PAGE1);
					transaction.show(fragments[i]);
				} else {
					transaction.show(fragments[i]);
				}
			} else {
				transaction.hide(fragments[i]);
			}
		}
		transaction.commit();
	}

	public void showFragmentOffer() {
		FragmentTransaction transaction = fm.beginTransaction();
		currentFragment = ONLINE;
		updateMenuUI();
		for (int i = 0; i < fragments.length; i++) {
			if (i == PASSENGER_PAGE1) {
				PassengerPage1Fragment.setView(ONLINE);
				transaction.show(fragments[i]);

			} else {
				transaction.hide(fragments[i]);
			}
		}
		transaction.commit();
	}

	// --------------------------------------------
	// --- Main activity
	// --------------------------------------------
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
