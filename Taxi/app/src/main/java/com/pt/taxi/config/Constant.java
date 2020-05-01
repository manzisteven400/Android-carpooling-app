package com.pt.taxi.config;

import android.content.Context;

//This file is used to save all keys such as admod key, facebook key, twitter key, etc...
public class Constant {
	public static Context context;
	// admob banner key
	public static final String BANNER_ADMOD_KEY = "";
	public static final String INTERSTITIAL_ADMOD_KEY = "";
	public static final String GOOGLE_ANALYTIC_KEY = "";
	//
	public static final double MY_COMPANY_LONG = 105.802513;
	public static final double MY_COMPANY_LAT = 21.042875;

	// Paypal config
	public static final String PAYPAL_CLIENT_APP_ID = "ARR3YZ29JFSRJVIto4SXEqW3s9IddLWdEz5QM8e8VniV-OimdTQDE8VWOBmENwFgAq9P2wZA202z8YYd";
	public static final String PAYPAL_RECEIVE_EMAIL_ID = "huy.phamngoc1987-facilitator@gmail.com";

	// Status // CREATED
	public static final String STATUS_0 = "CRIADO";
	// REJECT
	public static final String STATUS_1 = "REJEITADO";
	// IN PROCESS
	public static final String STATUS_2 = "EM PROCESSO";
	// READY
	public static final String STATUS_3 = "PRONTO";
	// DELIVERED
	public static final String STATUS_4 = "ENTREGUE";
	// FAIL
	public static final String STATUS_5 = "FALHOU";
	// ON THE WAY
	public static final String STATUS_6 = "A CAMINHO";
	// ALL STATUS
	public static final String STATUS_7 = "TODOS STATUS";

	public static final String NONE = "Nenhum";

	

	public static final String STATUS_CREATED = "0";
	public static final String STATUS_REJECT = "1";
	public static final String STATUS_IN_PROCESS = "2";
	public static final String STATUS_READY = "3";
	public static final String STATUS_DELIVERED = "4";
	public static final String STATUS_FAIL = "5";
	public static final String STATUS_ON_THE_WAY = "6";
	public static final String STATUS_ALL = "7";

	// ROLE
	public static final String ROLE_NORMAL_USER = "0";
	public static final String ROLE_USER_DELIVERY = "1";
	public static final String ROLE_CHEF_USER = "2";
	public static final String ROLE_ADMIN_USER = "3";

	// SCREEN TYPE
	public static final int SCREEN_TYPE_MY_ORDER = 0;
	public static final int SCREEN_TYPE_NEW_ORDER = 1;
	public static final int SCREEN_TYPE_ADMIN_ORDER = 2;

	// ACTION
	public static final String NEW_ACTION_DEFAULT = "-1";
	public static final String NEW_ACTION_REJECT = "0";
	public static final String NEW_ACTION_ASSIGN_TO_ME = "1";

}
