package qcjlibrary.activity;

import java.util.ArrayList;
import java.util.List;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.model.base.Model;
import android.view.View;
import android.widget.LinearLayout;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:31:08 类描述：这个类是实现
 *
 */

public class RequestChooseCancerActivity extends BaseActivity {
	private LinearLayout ll_choose_cancer;
	private List<Model> mList;

	@Override
	public String setCenterTitle() {
		return "选择癌种";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_request_choose_cancer;
	}

	@Override
	public void initView() {
		titleSetRightTitle("提交");
		ll_choose_cancer = (LinearLayout) findViewById(R.id.ll_choose_cancer);

	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.tv_title_right.setOnClickListener(this);
		mList = new ArrayList<Model>();
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		mList.add(new Model());
		addDataToView(mList);
	}

	/**
	 * 添加数据到界面
	 * 
	 * @param list
	 */
	private void addDataToView(List<Model> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				View view = mInflater
						.inflate(R.layout.item_choose_cancer, null);
				ll_choose_cancer.addView(view);
			}
		}
	}

	@Override
	public void initListener() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_title_right:
			mApp.startActivity_qcj(this,
					RequestSendTopicCommitedActivity.class,
					sendDataToBundle(new Model(), null));
			break;

		default:
			break;
		}

	}
}
