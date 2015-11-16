package qcjlibrary.adapter.base;

import qcjlibrary.img.RoundImageView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * author：qiuchunjia time：下午2:49:17 类描述：这个类是实现
 *
 */

public class ViewHolder {
	/******************* 专家提问item ************************/
	public TextView tv_title;
	public TextView tv_answer;
	public TextView tv_expert_answer;
	public TextView tv_date;
	public RelativeLayout rl_agree;
	public ImageView iv_yes;
	public ImageView iv_no;
	public TextView tv_agree;
	public TextView tv_noagree;

	/******************* 专家提问item end ************************/
	/******************* 消息中的回复item ************************/
	public RoundImageView riv_msg_icon;
	public TextView tv_user;
	// public RoundImageView tv_title;
	public TextView tv_other_replay;
	// public RoundImageView tv_date;
	public TextView tv_replay;

	/******************* 消息中的回复item end ************************/
	/******************* 消息中的praise item ************************/
	// public TextView riv_msg_icon;
	// public TextView tv_user;
	// public TextView tv_title;
	// public TextView tv_date;
	// public TextView tv_other_replay;
	/******************* 消息中的 praise item end ************************/
	/******************* 消息中的notify item ************************/
	public ImageView iv_msg_notify;
	public TextView tv_notify;
	public TextView tv_notify_content;
	public TextView tv_notify_date;
	/******************* 消息中的 praise item end ************************/
	/******************* 我的期刊 item ************************/
	public ImageView iv_perio_icon;
	// public ImageView tv_title;
	public TextView tv_title_flag;
	// public ImageView tv_date;

	/******************* 我的期刊 item end ************************/
	/******************* 食物种类 item ************************/
	public ImageView iv_food_icon;
	public TextView tv_food_name;
	public TextView tv_food_function;
	public TextView tv_cancer;

	/******************* 食物种类 item end ************************/

}
