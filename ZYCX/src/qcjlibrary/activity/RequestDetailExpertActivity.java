package qcjlibrary.activity;

import java.util.List;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.model.ModelRequestAnswerComom;
import qcjlibrary.model.ModelRequestDetailExpert;
import qcjlibrary.model.ModelRequestFlag;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.ModelRequestRelate;
import qcjlibrary.model.base.Model;
import qcjlibrary.widget.RoundImageView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:31:08 类描述：这个类是实现
 *
 */

public class RequestDetailExpertActivity extends BaseActivity {
	private TextView expert_tv_title;
	private TextView expert_tv_content;
	private TextView tv_flag_value;
	private TextView tv_flag_value2;
	private RoundImageView riv_icon;
	private TextView tv_username;
	private TextView tv_date;
	private LinearLayout ll_relate;

	private LinearLayout ll_expert_repaly;// 专家回复列表
	private EditText et_content;// 发送内容
	private TextView tv_send;// 专家回复列表

	private TextView tv_expert_user;
	private TextView tv_expert_date;
	private TextView tv_expertcontent;
	private TextView find_more;

	// 数据model赛
	private ModelRequestItem mRequestItem;

	@Override
	public String setCenterTitle() {
		return "问题详情";
	}

	@Override
	public void initIntent() {
		mRequestItem = (ModelRequestItem) getDataFromIntent(getIntent(), null);
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_request_detail_expert;
	}

	@Override
	public void initView() {
		titleSetRightImage(R.drawable.fenxiang);
		expert_tv_title = (TextView) findViewById(R.id.expert_tv_title);
		expert_tv_content = (TextView) findViewById(R.id.expert_tv_content);
		tv_flag_value = (TextView) findViewById(R.id.tv_flag_value);
		tv_flag_value2 = (TextView) findViewById(R.id.tv_flag_value2);
		riv_icon = (RoundImageView) findViewById(R.id.riv_icon);
		tv_username = (TextView) findViewById(R.id.tv_username);
		tv_date = (TextView) findViewById(R.id.tv_date);
		ll_relate = (LinearLayout) findViewById(R.id.ll_relate);

		ll_expert_repaly = (LinearLayout) findViewById(R.id.ll_expert_repaly);
		et_content = (EditText) findViewById(R.id.et_content);
		tv_send = (TextView) findViewById(R.id.tv_send);

		tv_expert_user = (TextView) findViewById(R.id.tv_expert_user);
		tv_expert_date = (TextView) findViewById(R.id.tv_expert_date);
		tv_expertcontent = (TextView) findViewById(R.id.tv_expertcontent);
		find_more = (TextView) findViewById(R.id.find_more);
	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.iv_title_right1.setOnClickListener(this);
		sendRequest(mApp.getRequestImpl().answer(mRequestItem),
				ModelRequestDetailExpert.class, REQUEST_GET);
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelRequestDetailExpert) {
			ModelRequestDetailExpert detailExpert = (ModelRequestDetailExpert) object;
			addDataToHeadAndFlag(detailExpert.getQuestion(),
					detailExpert.getTopic_list());
			addDataToExpertAnswer(detailExpert.getAnswer(),
					detailExpert.getCommentlist());
			addDataToRelate(detailExpert.getOther_question());
		}
		return object;
	}

	/**
	 * 添加数据到相关模块
	 * 
	 * @param other_question
	 */
	private void addDataToRelate(List<ModelRequestRelate> other_question) {
		if (other_question != null) {
			if (ll_relate.getChildCount() > 0) {
				ll_relate.removeAllViews();
			}
			for (int i = 0; i < other_question.size(); i++) {
				ModelRequestRelate relate = other_question.get(i);
				View view = mInflater.inflate(
						R.layout.item_request_detail_relate, null);
				/*********** 初始化布局问答布局 ********************/
				TextView tv_relate_title = (TextView) view
						.findViewById(R.id.tv_relate_title);
				TextView tv_watch_num = (TextView) view
						.findViewById(R.id.tv_watch_num);
				/*********** 初始化布局问答布局 end ********************/
				tv_relate_title.setText(relate.getTitle());
				tv_watch_num.setText("浏览次数：" + relate.getView_count());
				ll_relate.addView(view);
			}
		}
	}

	/**
	 * 添加数据到问答模块
	 * 
	 * @param answer
	 */
	private void addDataToExpertAnswer(ModelRequestAnswerComom data,
			List<ModelRequestAnswerComom> answers) {
		if (data != null) {
			tv_expert_date.setText(data.getTime());
			tv_expertcontent.setText(data.getAnswer_content());
			find_more.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

				}
			});
		}
		if (answers != null) {
			if (ll_expert_repaly.getChildCount() > 0) {
				ll_expert_repaly.removeAllViews();
			}
			for (int i = 0; i < answers.size(); i++) {
				final ModelRequestAnswerComom answerComom = answers.get(i);
				answerComom.setQid(mRequestItem.getQuestion_id());
				addDataToComment(answerComom);
			}
		}

	}

	private void addDataToComment(final ModelRequestAnswerComom answerComom) {
		if (answerComom != null) {
			View view = mInflater.inflate(R.layout.item_request_expert_repaly,
					null);
			/*********** 初始化布局问答布局 ********************/
			TextView tv_user = (TextView) view.findViewById(R.id.tv_user);
			TextView tv_date = (TextView) view.findViewById(R.id.tv_date);
			TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
			/*********** 初始化布局问答布局 end ********************/
			if (answerComom.getFrom().equals("expert")) {
				tv_user.setText("专家建议");
				tv_user.setTextColor(getResources().getColor(
						R.color.text_yellow));
			} else if (answerComom.getFrom().equals("user")) {
				tv_user.setText("追加提问");
				tv_user.setTextColor(getResources()
						.getColor(R.color.text_green));
			}
			tv_content.setText(answerComom.getContent());
			tv_date.setText(answerComom.getTime());
			ll_expert_repaly.addView(view);
		}
	}

	/**
	 * 添加数据到头部和表情部分
	 * 
	 * @param question
	 * @param topic_list
	 */
	private void addDataToHeadAndFlag(ModelRequestItem question,
			List<ModelRequestFlag> topic_list) {
		if (question != null) {
			expert_tv_title.setText(question.getQuestion_content());
			expert_tv_content.setText(question.getQuestion_detail());
			mApp.displayImage(question.getUser_face(), riv_icon);
			tv_username.setText(question.getUser_name());
			tv_date.setText(question.getTime());
		}
		if (topic_list != null) {
			for (int i = 0; i < topic_list.size(); i++) {
				ModelRequestFlag flag = topic_list.get(i);
				tv_flag_value.setText(flag.getTitle());
			}
		}
	}

	@Override
	public void initListener() {
		tv_flag_value2.setOnClickListener(this);
		tv_send.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_answer:
			mApp.startActivityForResult_qcj(this,
					RequestDetailReponceSingleActivity.class,
					sendDataToBundle(mRequestItem, null));
			break;

		case R.id.tv_flag_value2:
			mApp.startActivity_qcj(this, RequestFlagActivity.class,
					sendDataToBundle(new Model(), null));
			break;
		case R.id.iv_title_right1:
			// mApp.startActivity_qcj(this, RequestDetailResponceActivity.class,
			// sendDataToBundle(new Model(), null));
			break;
		case R.id.tv_send:
			String content = et_content.getText().toString();
			if (!TextUtils.isEmpty(content)) {
				ModelRequestAnswerComom answerComom = new ModelRequestAnswerComom();
				answerComom.setContent(content);
				//TODO
				sendRequest(mApp.getRequestImpl().answerComment(answerComom),
						ModelRequestDetailExpert.class, REQUEST_GET);
			}
			break;
		}

	}
}
