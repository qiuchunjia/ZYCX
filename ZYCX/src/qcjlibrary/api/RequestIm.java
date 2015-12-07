package qcjlibrary.api;

import qcjlibrary.model.ModelRequestAnswerComom;
import qcjlibrary.model.ModelRequestAsk;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.ModelRequestSearch;

import com.loopj.android.http.RequestParams;

/**
 * author：qiuchunjia time：下午4:59:50 类描述：这个类是实现 问答模块
 *
 */

public interface RequestIm {
	public static final String ASK = "Ask";
	public static final String INDEX = "index";
	public static final String SEARCH = "search";
	public static final String ADDQUESTION = "addQuestion";
	public static final String ANSWER = "answer";
	public static final String SAVEANSWER = "saveAnswer";

	public static final String ID = "id";
	public static final String KEY = "key";
	public static final String TYPE = "type";
	public static final String CAT = "cat";
	public static final String QID = "qid";
	public static final String CONTENT = "content";
	public static final String QUESTION_DETAIL = "question_detail ";
	public static final String IS_EXPERT = "is_expert";
	public static final String CID = "cid";
	// public static final String TYPE = "type";
	public static final String TOPICS = "topics";
	public static final String AUID = "auid";

	/**
	 * 问答首页
	 * 
	 * @return
	 */
	public RequestParams index(ModelRequestItem item);

	/**
	 * 搜索
	 * 
	 * @param search
	 * @return
	 */
	public RequestParams search(ModelRequestSearch search);

	/**
	 * 添加问题
	 * 
	 * @param ask
	 * @return
	 */
	public RequestParams addQuestion(ModelRequestAsk ask);

	/**
	 * 问答 问题详细页
	 * 
	 * @param item
	 * @return
	 */
	public RequestParams answer(ModelRequestItem item);

	/**
	 * 问答 回答问题
	 * 
	 * @param item
	 * @return
	 */
	public RequestParams saveAnswer(ModelRequestAnswerComom answerComom);
}
