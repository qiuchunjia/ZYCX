package qcjlibrary.api;

import com.loopj.android.http.RequestParams;

import qcjlibrary.model.ModelAlertData;

public interface AlarmIm {
	/**
	 * 闹钟数据获取
	 * 
	 * @author Tan
	 */
	public static final String MEDREMINDER = "Medreminder";
	public static final String ADD = "add";
	public static final String INDEX = "index";

	/**
	 * demo-qingko.zhiyicx.com/index.php?app=api&mod=Medreminder&act=index 首页
	 * 获取闹钟列表 必须登录
	 */
	public RequestParams index();

	/**
	 * demo-qingko.zhiyicx.com/index.php?app=api&mod=Medreminder&act=add 添加闹钟
	 * string oauth_token 必填
	 * 
	 * string oauthtokensecret 必填
	 * 
	 * user 服药者姓名 必填
	 * 
	 * medicine 药物名称 必填
	 * 
	 * period 用药周期 必填
	 * 
	 * med_num 用药次数 必填
	 * 
	 * med_time 用药时间 必填 （多个时间用逗号隔开）
	 * 
	 * stime 用药开始时间 必填
	 * 
	 * is_remind 是否开启提醒（0：提醒 1：关闭 默认为0） 选填
	 */
	public RequestParams add(ModelAlertData mData);

	/**
	 * 删除闹钟 demo-qingko.zhiyicx.com/index.php?app=api&mod=Medreminder&act=del
	 * string oauth_token 必填
	 * 
	 * string oauthtokensecret 必填
	 * 
	 * id 服药提醒ID 必填
	 */
	public RequestParams delete(ModelAlertData mData);

	/**
	 * 修改闹钟 demo-qingko.zhiyicx.com/index.php?app=api&mod=Medreminder&act=edit
	 * string oauth_token 必填
	 * 
	 * string oauthtokensecret 必填
	 * 
	 * id 服药提醒ID 必填
	 * 
	 * user 服药者姓名 选填
	 * 
	 * medicine 药物名称 选填
	 * 
	 * period 用药周期 选填
	 * 
	 * med_num 用药次数 选填
	 * 
	 * med_time 用药时间 选填 （多个时间用逗号隔开）
	 * 
	 * stime 用药开始时间 选填
	 * 
	 * is_remind 是否开启提醒（0：提醒 1：关闭 默认为0） 选填
	 */
	public RequestParams update(ModelAlertData mData);
}
