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
	public static final String USER_DATA = "user_data"; // 用户信息表
														// 由于这个项目是二次开发使用就不报token保存到这里面，
														// 就存这些基本信息吧
	public static final String SEX = "sex";
	public static final String INTRO = "intro";
	public static final String CANCER = "cancer";
	public static final String BIRTHDAY = "birthday";
	public static final String LOCATION = "location";
	public static final String CITY_IDS = "city_ids";
	public static final String UNAME = "uname";
	public static final String AVATAR = "avatar";

	/************** 病例需要用到的 *******************/
	public static final String TYPE_DATE = "type_date";
	public static final String TYPE_GENDER = "type_gender";
	public static final String TYPE_MARRY = "type_marry";
	public static final String TYPE_NATION = "type_nation";
	public static final String TYPE_INSURANCE = "type_insurance";
	public static final String TYPE_EDUCATION = "type_education";
	public static final String TYPE_HOME = "type_home";// 籍贯
	public static final String TYPE_ADDRESS = "type_address"; // 居住地
	// 既往史
	public static final String TYPE_SMOKE = "type_smoke";
	public static final String TYPE_STOP_SMOKE = "type_stop_smoke";
	public static final String TYPE_STOP_SMOKE_TIME = "type_stop_smoke_time";
	public static final String TYPE_DRINK = "type_drink";
	public static final String TYPE_STOP_DRINK = "type_stop_drink";
	public static final String TYPE_STOP_DRINK_TIME = "type_stop_drink_time";
	public static final String TYPE_EATING_HABIT = "type_eating_habit";
	public static final String TYPE_LAST_TIME = "type_last_time";
	// 现病史
	public static final String TYPE_CHECK_START_TIME = "type_check_start_time";
	public static final String TYPE_CHECK_END_TIME = "type_check_end_time";
	public static final String TYPE_CHECK_WAY = "type_check_way";
	public static final String TYPE_LAB_PROJECT = "type_lab_project";
	public static final String TYPE_LAB_CHECK_TIME = "type_lab_check_time";
	public static final String TYPE_VIDEO_PROJECT = "type_video_project";
	public static final String TYPE_VIDEO_CHECK_TIME = "type_video_check_time";
	public static final String TYPE_CHECK_PHOTO = "type_check_photo";
	public static final String TYPE_LAB_PHOTO = "type_lab_photo";
	public static final String TYPE_VIDEO_PHOTO = "type_video_photo";
	/************** 用药提醒需要用到的 *******************/
	public static final String TYPE_DAILY = "type_daily";
	public static final String TYPE_TIME = "type_time";
	public static final String TYPE_TIME_LIST = "type_time_list";
	public static final String SHARED_SAVE_KEY = "id";
	public static final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";

	/*************** 搜索 **************************/
	public static final int TYPE_WEIBO = 0;
	public static final int TYPE_REQUEST = 1;
	public static final int TYPE_INFO = 2;
	public static final int TYPE_QCLASS = 3;
	public static final int TYPE_FOOD = 4;

}
