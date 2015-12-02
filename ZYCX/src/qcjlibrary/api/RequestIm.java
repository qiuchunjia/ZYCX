package qcjlibrary.api;

import com.loopj.android.http.RequestParams;

/**
 * author：qiuchunjia time：下午4:59:50 类描述：这个类是实现 问答模块
 *
 */

public interface RequestIm {
	public static final String ASK = "Ask";
	public static final String INDEX = "index";

	/**
	 * 问答首页
	 * 
	 * @return
	 */
	public RequestParams index();
}
