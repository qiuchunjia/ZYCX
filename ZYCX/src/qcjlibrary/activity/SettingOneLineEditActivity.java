package qcjlibrary.activity;

import com.zhiyicx.zycx.R;

import qcjlibrary.activity.base.BaseActivity;
import android.view.View;
import android.widget.EditText;

/**
 * author：qiuchunjia time：下午2:39:22 类描述：这个类是实现
 *
 */

public class SettingOneLineEditActivity extends BaseActivity {
	private EditText et_oneline;
	private int mCurrentPosition = -1;

	// 根据传过来的数据来设置title的名字
	public final static int DECLARATION = 0; // 宣言;
	public final static int NICK = 1; // 昵称;
	public final static int GENDER = 2; // 性别;
	public final static int BIRTHDAY = 3; // 生日;
	public final static int LOCATION = 4; // 地址;
	public final static int CANCERCATEGORY = 5; // 癌种;

	@Override
	public String setCenterTitle() {
		return "设置";
	}

	@Override
	public void initIntent() {
		mCurrentPosition = (Integer) getDataFromIntent(getIntent(), null);
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_edit_oneline;
	}

	@Override
	public void initView() {
		titleSetRightTitle("修改");
		et_oneline = (EditText) findViewById(R.id.et_oneline);
		judgeTheTitle(mCurrentPosition);
	}

	/**
	 * 根据activity传来的值来判断从而设置title的名字
	 * 
	 * @param mCurrentPosition2
	 */
	private void judgeTheTitle(int position) {
		switch (position) {
		case DECLARATION:
			titleSetCenterTitle("抗癌宣言");
			break;

		case NICK:
			titleSetCenterTitle("昵称");
			break;

		case GENDER:
			titleSetCenterTitle("性别");
			break;

		case BIRTHDAY:
			titleSetCenterTitle("生日");
			break;
		case LOCATION:
			titleSetCenterTitle("地址");
			break;

		case CANCERCATEGORY:
			titleSetCenterTitle("癌种");
			break;

		}
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
