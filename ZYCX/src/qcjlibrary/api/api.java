package qcjlibrary.api;

import qcjlibrary.model.ModelCancerCategory;
import qcjlibrary.model.ModelRequestAnswerComom;
import qcjlibrary.model.ModelRequestAsk;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.ModelRequestSearch;
import qcjlibrary.model.ModelZiXunDetail;
import qcjlibrary.model.base.Model;
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

	public static final String LASTID = "lastid"; // 上来刷新
	public static final String MAXID = "maxid"; // 下拉加载更多

	public static final String APPNAME = "3g";
	public static final String API = "api";

	/**
	 * 添加token到params
	 * 
	 * @param params
	 * @return
	 */
	public static RequestParams getToken(RequestParams params) {
		PreferenceUtil preferenceUtil = PreferenceUtil.getInstance(Thinksns
				.getContext());
		params.add("oauth_token", preferenceUtil.getString("oauth_token", ""));
		params.add("oauth_token_secret",
				preferenceUtil.getString("oauth_token_secret", ""));
		return params;
	}

	/**
	 * token的测试数据
	 * 
	 * @param params
	 * 
	 * @return
	 */
	public static RequestParams getTestToken(RequestParams params) {
		params.add("oauth_token", "18e22c9690b5e01ce224a58f401eb995");
		params.add("oauth_token_secret", "be826a6243b7f9c0800ac82ce692c2f7");
		return params;
	}

	/**
	 * 分页
	 * 
	 * @param params
	 * @param model
	 * @return
	 */
	public static RequestParams getChangePage(RequestParams params, Model model) {
		if (model != null && params != null) {
			if (model.getLastid() != null && !model.getLastid().equals("")) {
				params.add(LASTID, model.getLastid());
			}
			if (model.getMaxid() != null && !model.getMaxid().equals("")) {
				params.add(MAXID, model.getMaxid());
			}
		}
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

	public static final class RequestImpl implements RequestIm {

		@Override
		public RequestParams index(ModelRequestItem item) {
			RequestParams params = new RequestParams();
			params.add(APP, API);
			params.add(MOD, ASK);
			params.add(ACT, INDEX);
			params = getTestToken(params);
			if (item != null) {
				params.add(ID, item.getId());
				params.add(TYPE, item.getType());
				params = getChangePage(params, item);
				Log.i("paramstest", params.toString());
				return params;
			}
			return params;
		}

		@Override
		public RequestParams search(ModelRequestSearch search) {
			if (search != null) {
				RequestParams params = new RequestParams();
				params.add(APP, API);
				params.add(MOD, ASK);
				params.add(ACT, SEARCH);
				params.add(KEY, search.getKey());
				params.add(TYPE, search.getType());
				params.add(CAT, search.getCat());
				Log.i("paramstest", params.toString());
				return getTestToken(params);
			}
			return null;
		}

		@Override
		public RequestParams addQuestion(ModelRequestAsk ask) {
			if (ask != null) {
				RequestParams params = new RequestParams();
				params.add(APP, API);
				params.add(MOD, ASK);
				params.add(ACT, ADDQUESTION);

				params.add(QID, ask.getQid());
				params.add(CONTENT, ask.getContent());
				params.add(QUESTION_DETAIL, ask.getQuestion_detail());
				params.add(IS_EXPERT, ask.getIs_expert());
				params.add(CID, ask.getCid());
				params.add(TYPE, ask.getType());
				params.add(TOPICS, ask.getTopics());
				Log.i("paramstest", params.toString());
				return getTestToken(params);
			}
			return null;
		}

		@Override
		public RequestParams answer(ModelRequestItem item) {
			if (item != null) {
				RequestParams params = new RequestParams();
				params.add(APP, API);
				params.add(MOD, ASK);
				params.add(ACT, ANSWER);
				params.add(ID, item.getQuestion_id());
				return getTestToken(params);
			}
			return null;
		}

		@Override
		public RequestParams saveAnswer(ModelRequestAnswerComom answerComom) {
			if (answerComom != null) {
				RequestParams params = new RequestParams();
				params.add(APP, API);
				params.add(MOD, ASK);
				params.add(ACT, SAVEANSWER);
				params.add(QID, answerComom.getQid());
				params.add(CONTENT, answerComom.getContent());
				params.add(AUID, answerComom.getAuid());
				return getTestToken(params);
			}
			return null;
		}

		@Override
		public RequestParams commentList(ModelRequestAnswerComom answerComom) {
			if (answerComom != null) {
				RequestParams params = new RequestParams();
				params.add(APP, API);
				params.add(MOD, ASK);
				params.add(ACT, COMMENTLIST);
				params.add(AID, answerComom.getAnswer_id());
				return getTestToken(params);
			}
			return null;
		}

		@Override
		public RequestParams answerComment(ModelRequestAnswerComom answerComom) {
			if (answerComom != null) {
				RequestParams params = new RequestParams();
				params.add(APP, API);
				params.add(MOD, ASK);
				params.add(ACT, ANSWERCOMMENT);
				params.add(AID, answerComom.getAnswer_id());
				params.add(CONTENT, answerComom.getContent());
				Log.i("answerComment", params.toString());
				return getTestToken(params);
			}
			return null;
		}

		@Override
		public RequestParams setBestAnswer(ModelRequestAnswerComom answerComom) {
			if (answerComom != null) {
				RequestParams params = new RequestParams();
				params.add(APP, API);
				params.add(MOD, ASK);
				params.add(ACT, SETBESTANSWER);
				params.add(AID, answerComom.getAnswer_id());
				params.add(TYPE, answerComom.getType());
				params.add(QID, answerComom.getQid());
				Log.i("setBestAnswer", params.toString());
				return getTestToken(params);
			}
			return null;
		}

		@Override
		public RequestParams addComment(ModelRequestAnswerComom answerComom) {
			if (answerComom != null) {
				RequestParams params = new RequestParams();
				params.add(APP, API);
				params.add(MOD, ASK);
				params.add(ACT, ADDCOMMENT);
				params.add(CID, answerComom.getComment_id());
				params.add(CONTENT, answerComom.getContent());
				Log.i("addComment", params.toString());
				return getTestToken(params);
			}
			return null;
		}
	}
}
