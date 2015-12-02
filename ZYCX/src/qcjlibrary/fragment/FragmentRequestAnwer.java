package qcjlibrary.fragment;

import java.util.List;

import qcjlibrary.activity.RequestDetailActivity;
import qcjlibrary.adapter.RequestAnswerAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelCancerCategory;
import qcjlibrary.model.ModelRequest;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.DisplayUtils;
import qcjlibrary.widget.popupview.PopCancerCategory;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
	private BAdapter mAdapter;
	private List<ModelCancerCategory> mCancerList; // 癌症种类
	private List<Model> mItemList; // 内容集合

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
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(mApp, 10));
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position,
						RequestDetailActivity.class);
			}
		});
	}

	@Override
	public void initData() {
		sendRequest(mApp.getRequestImpl().index(), ModelRequest.class, 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelRequest) {
			ModelRequest request = (ModelRequest) object;
			mCancerList = request.getFenlei();
			Object data = request.getList();
			mItemList = (List<Model>) data;
			Log.i("cancerlist",
					mCancerList.toString() + "       " + mItemList.toString());
			mAdapter = new RequestAnswerAdapter(this, mItemList);
			mCommonListView.setAdapter(mAdapter);
		}
		return object;
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
			PopCancerCategory category = new PopCancerCategory(mActivity, null,
					mActivity);
			category.showPop(ll_4, Gravity.RIGHT, 0, 0);
			break;

		}

	}

}
