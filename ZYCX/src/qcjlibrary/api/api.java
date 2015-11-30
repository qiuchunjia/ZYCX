package qcjlibrary.api;

import qcjlibrary.model.ModelZiXunCategory;
import qcjlibrary.model.ModelZiXunDetail;
import android.util.Log;

import com.loopj.android.http.RequestParams;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import com.zhiyicx.zycx.util.PreferenceUtil;

/**
 * author：qiuchunjia time：下午4:34:59 类描述：这个类是实现对请求的数据的封装
 *
 */

public class api {
	public static final String APP = "app";
	public static final String MOD = "mod";
	public static final String ACT = "act";

	public static final String APPNAME = "3g";

	public static RequestParams getToken(RequestParams params) {
		PreferenceUtil preferenceUtil = PreferenceUtil.getInstance(Thinksns
				.getContext());
		params.add("oauth_token", preferenceUtil.getString("oauth_token", ""));
		params.add("oauth_token_secret",
				preferenceUtil.getString("oauth_token_secret", ""));
		return params;
	}

	public static RequestParams test() {
		RequestParams params = new RequestParams();
		params.add("app", "api");
		params.add("mod", "Event");
		params.add("act", "eventList");
		return params;
	}

	public static final class ZhiXunImpl implements ZhixunIm {

		@Override
		public RequestParams index() {
			RequestParams params = new RequestParams();
			params.add(APP, APPNAME);
			params.add(MOD, NEWS);
			params.add(ACT, INDEX);
			Log.i("param", params.toString());
			return params;
		}

		@Override
		public RequestParams indexItem(ModelZiXunDetail detail) {
			if (detail != null) {
				RequestParams params = new RequestParams();
				params.add(APP, APPNAME);
				params.add(MOD, NEWS);
				params.add(ACT, INDEX);
				params.add(CID, String.valueOf(detail.getFenlei_id()));
				if (detail.getLastid() != null
						&& !detail.getLastid().equals("")) {
					params.add(LASTID, detail.getLastid());
				}
				if (detail.getMaxid() != null && !detail.getMaxid().equals("")) {
					params.add(MAXID, detail.getMaxid());
				}
				return getToken(params);
			}
			return null;
		}
	}
}
