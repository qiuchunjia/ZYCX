package qcjlibrary.api;

import qcjlibrary.model.ModelNotifyCommment;
import qcjlibrary.model.ModelNotifyDig;
import qcjlibrary.model.ModelNotifyNotice;

import com.loopj.android.http.RequestParams;

/**
 * author：qiuchunjia time：下午2:07:15 类描述：这个类是实现消息的接口
 *
 */

public interface NotifyIm {
	// 接口需要的操作参数
	public static final String NOTICE = "Notice";

	public static final String COMMENTLIST = "commentlist"; // 消息--评论列表
	public static final String NOTICELIST = "noticelist"; // 消息-通知列表
	public static final String DIGGLIST = "digglist"; // 消息-点赞列表
	public static final String READNOTICE = "readnotice"; // 消息-点击消息标记为已读
	public static final String DELONE = "delOne"; // 消息-删除一条系统通知
	public static final String DELALL = "delAll"; // 消息-清空一个用户的系统通知
	public static final String PERSONAGE = "Personage"; // 消息-未读
	public static final String NOTICE_STATE = "notice_state"; // 消息-未读

	// 接口需要传的值的键
	public static final String ID = "id";

	/**
	 * 消息--评论列表
	 * 
	 * @param commment
	 * @return
	 */
	public RequestParams commentlist(ModelNotifyCommment commment);

	/**
	 * 消息-通知列表
	 * 
	 * @param notice
	 * @return
	 */
	public RequestParams noticelist(ModelNotifyNotice notice);

	/**
	 * 消息-点赞列表
	 * 
	 * @param dig
	 * @return
	 */
	public RequestParams digglist(ModelNotifyDig dig);

	/**
	 * 消息-点击消息标记为已读
	 * 
	 * @param notice
	 * @return
	 */
	public RequestParams readnotice(ModelNotifyNotice notice);

	/**
	 * 消息-删除一条系统通知
	 * 
	 * @param notice
	 * @return
	 */
	public RequestParams delOne(ModelNotifyNotice notice);

	/**
	 * 消息-清空一个用户的系统通知
	 * 
	 * @return
	 */
	public RequestParams delAll();
	
	/**
	 * 消息 是否已读 新加
	 * 
	 * */
	public RequestParams isRead();

}
