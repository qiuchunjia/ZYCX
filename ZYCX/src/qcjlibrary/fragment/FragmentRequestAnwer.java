package qcjlibrary.fragment;

import qcjlibrary.activity.CaseHistoryActivity;
import qcjlibrary.activity.PatientMeActivity;
import qcjlibrary.activity.UseMedicineNotifyActivity;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.base.Model;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:03:45 类描述：这个类是实现
 *
 */

public class FragmentRequestAnwer extends BaseFragment {
	private RelativeLayout rl_space;
	private ImageView iv_zoom;
	private TextView tv_find;
	private EditText et_find;
	private LinearLayout ll_1;
	private ImageView iv_1;
	private LinearLayout ll_2;
	private ImageView iv_2;
	private LinearLayout ll_3;
	private ImageView iv_3;
	private LinearLayout ll_4;
	private ImageView iv_4;
	private CommonListView mCommonListView;

	@Override
	public void initIntentData() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_request_anwer;
	}

	@Override
	public void initView() {
		rl_space = (RelativeLayout) findViewById(R.id.rl_space);
		iv_zoom = (ImageView) findViewById(R.id.iv_zoom);
		tv_find = (TextView) findViewById(R.id.tv_find);
		et_find = (EditText) findViewById(R.id.et_find);
		ll_1 = (LinearLayout) findViewById(R.id.ll_1);
		iv_1 = (ImageView) findViewById(R.id.iv_1);
		ll_2 = (LinearLayout) findViewById(R.id.ll_2);
		iv_2 = (ImageView) findViewById(R.id.iv_2);
		ll_3 = (LinearLayout) findViewById(R.id.ll_3);
		iv_3 = (ImageView) findViewById(R.id.iv_3);
		ll_4 = (LinearLayout) findViewById(R.id.ll_4);
		iv_4 = (ImageView) findViewById(R.id.iv_4);
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		ll_1.setOnClickListener(this);
		ll_2.setOnClickListener(this);
		ll_3.setOnClickListener(this);
		ll_4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_1:
			// mApp.startActivity_qcj(getActivity(), PatientMeActivity.class,
			// mActivity.sendDataToBundle(new Model(), null));
			break;

		case R.id.ll_2:

			break;
		case R.id.ll_3:
			// mApp.startActivity_qcj(getActivity(), CaseHistoryActivity.class,
			// mActivity.sendDataToBundle(new Model(), null));
			break;
		case R.id.ll_4:

			break;

		}

	}

}
