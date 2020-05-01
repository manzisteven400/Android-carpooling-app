package com.pt.taxi.config;

public class WebServiceConfig {

	public static final int REQUEST_TIME_OUT = 30000;
	public static int RESULT_OK = 1;
	public static int LOGIN_NORMAL = 0;
	public static int LOGIN_FACEBOOK = 1;

	// ===================== DOMAIN =====================
	public static String PROTOCOL_HTTP = "http://";
	public static String SERVER_NAME = "117.7.238.103:8888/realestate-demo";
	public static String PATH = "/backend/api/";
	public static String APP_DOMAIN = PROTOCOL_HTTP + SERVER_NAME + PATH;

	// ===================== WEB SERVICE LINK =====================
	public final static String GET_ALL_REALESTATE = APP_DOMAIN
			+ "showAllEstate";
	public static String GET_AGENT_LIST = APP_DOMAIN + "showHostAgentList";

	// ===================== KEY =====================
	public final static String KEY_JSON_STATUS = "status";
	public final static String KEY_JSON_DATA = "data";
	public final static String JSON_STATUS_SUCCESS = "SUCCESS";
	public final static String JSON_STATUS_ERROR = "error";
	public static final String KEY_MESSAGE = "message";
	//

}
