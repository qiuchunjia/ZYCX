package qcjlibrary.api;

import qcjlibrary.model.ModelMeAddress;
import qcjlibrary.model.ModelUser;

import com.loopj.android.http.RequestParams;

/**
 * author：qiuchunjia time：下午2:57:11
 * 
 * 这个接口实现用户的相关消息，比如说登陆注册啊， 等等反正跟用户有关的都用这个接口
 *
 */

public interface UserIm {
	// 接口需要的操作参数
	public static final String PERSONAGE = "Personage";
	public static final String EDITUSERDATA = "edituserdata";
	public static final String AREALIST = "arealist";
	// 接口需要的操作参数
	public static final String SEX = "sex";
	public static final String INTRO = "intro";
	public static final String CANCER = "cancer";
	public static final String BIRTHDAY = "birthday";
	public static final String LOCATION = "location";
	public static final String CITY_IDS = "city_ids";
	public static final String UNAME = "uname";
	public static final String AREA_ID = "area_id";

	/**
	 * 个人中心-个人资料修改
	 * 
	 * @param user
	 * @return
	 */
	public RequestParams edituserdata(ModelUser user);

	/**
	 * @param address
	 * @return
	 */
	public RequestParams arealist(ModelMeAddress address);
}
