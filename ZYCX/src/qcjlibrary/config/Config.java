package qcjlibrary.config;

/**
 * author：qiuchunjia time：上午10:53:55 类描述：这个类是实现
 *
 */

public class Config {
	// -----------------------------activity之间或者fragment之间需要传递的值需要用到-------------------------------------------------
	public static final String ACTIVITY_TRANSFER_BUNDLE = "activity_transfer_bundle"; // 用于activity之间数据传递bundle

	public static final String LOCALVIDEO = "localvideo";
	public static final String LOCALMUSIC = "LocalMusic";

	// -----------------------------访问shareprefrence用到-------------------------------------------------
	public static final String USER_DATA = "user_data";
	public static final String MOBILE = "mobile";
	public static final String PWD = "pwd";
	public static final String USERID = "userid";
	public static final String OAUTH_TOKEN = "oauth_token";
	public static final String OAUTH_TOKEN_SECRET = "oauth_token_secret";
	public static final String UID = "uid";
	public static final String SCHOOL_ID = "school_id";
	public static final String UNAME = "uname";
	public static final String IS_INIT = "is_init";
	public static final String SEX = "sex";
	public static final String FACEURL = "faceurl";
	public static final String SCHOOL_NAME = "school_name";
	public static final String AUTOGRAPH = "autograph";
	public static final String EMAIL = "email";
	/************** 用于线团学校选择用 *******************/
	public static final String SCHOOL_NAME_CHOOSE = "school_name_choose";
	public static final String SCHOOL_ID_CHOOSE = "school_id_choose";

	public static final String OPEN_MESSAGE = "open_message";
	public static final String CURRENT_PROVINCE = "current_province";
	public static final String CURRENT_SCHOOL = SCHOOL_NAME;
	public static final String ISNOT_GUIDE = "ISNOT_GUIDE";
	public static final String GENDER = "gender";

	/************** 病例需要用到的 *******************/
	public static final String TYPE_DATE = "type_date";
	public static final String TYPE_GENDER = "type_gender";
	public static final String TYPE_MARRY = "type_marry";
	public static final String TYPE_EDUCATION = "type_education";
	public static final String TYPE_HOME = "type_home";// 籍贯
	public static final String TYPE_ADDRESS = "type_address"; // 居住地
	
	/************** 用药提醒需要用到的 *******************/
	public static final String TYPE_DAILY = "type_daily";
	public static final String TYPE_TIME = "type_time";
	public static final String TYPE_TIME_LIST = "type_time_list";
	
}
