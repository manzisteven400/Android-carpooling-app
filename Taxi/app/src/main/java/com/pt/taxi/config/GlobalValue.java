package com.pt.taxi.config;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

public final class GlobalValue {

	private static GlobalValue mGlobalValue;

	public static GlobalValue getInstance() {
		if (mGlobalValue == null) {
			synchronized (GlobalValue.class) {
				if (mGlobalValue == null) {
					mGlobalValue = new GlobalValue();
				}
			}
		}
		return mGlobalValue;
	}

	public static boolean DEBUG_MODE = true;
	public static boolean DEBUG_DB = true;
	public static ArrayList<String> arrCity = new ArrayList<String>();
	public static int valueItemsPerPage = 3;
	public static String UTILS_PARAM_NOTIF = "0";
	public static String UTILS_NOTIF = "notif";
	public static LatLng addLatLng;
	public static boolean fromGetLocation = false;
	// public static boolean IS_LOGIN = false;
}
