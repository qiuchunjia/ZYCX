package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.model.ModelNotifyCommment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:18:33 类描述：这个类是实现
 *
 */

public class NotifySingleReplyActivity extends BaseActivity {
	private ModelNotifyCommment mComment;
	private EditText et_content;

	@Override
	public String setCenterTitle() {
		return "回复";
	}

	@Override
	public void initIntent() {
		mComment = (ModelNotifyCommment) getDataFromIntent(getIntent(), null);
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_notify_single_replay;
	}

	@Override
	public void initView() {
		et_content = (EditText) findViewById(R.id.et_content);
		titleSetRightTitle("回复评论");
		Title title = getTitleClass();
		title.tv_title_right.setOnClickListener(this);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_title_right:
			String content = et_content.getText().toString();
			if (!TextUtils.isEmpty(content)) {

			}
			break;

		default:
			break;
		}

	}

}
