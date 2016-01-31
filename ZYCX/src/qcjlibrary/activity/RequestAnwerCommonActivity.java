package qcjlibrary.activity;

import java.util.List;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.LoginActivity;
import com.zhiyicx.zycx.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.RequestCommonAdapter;
import qcjlibrary.adapter.TestSectionedAdapter;
import qcjlibrary.adapter.base.OnTabselectedListener;
import qcjlibrary.listview.base.pinnedheaderlistview.PinnedHeaderListView;
import qcjlibrary.listview.base.pinnedheaderlistview.PinnedHeaderListView.OnMyItemClickListener;
import qcjlibrary.model.ModelCancerCategory;
import qcjlibrary.model.ModelRequest;
import qcjlibrary.model.ModelRequestAsk;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.base.Model;
import qcjlibrary.widget.popupview.PopCancerCategory;

public class RequestAnwerCommonActivity extends BaseActivity {

	private RelativeLayout rl_space;
	private LinearLayout ll_top;
	private ImageView iv_zoom;
	private TextView tv_find;
	private EditText et_find;
	private ImageView iv_1;
	private ImageView iv_2;
	private ImageView iv_3;
	private LinearLayout ll_4;
	private ImageView iv_4;
	private TextView tv_1;
	private TextView tv_2;
	private TextView tv_3;
	private TextView tv_4;
	private List<ModelCancerCategory> mCancerList; // 癌症种类

	private ModelRequestItem mRequestItem; // 请求数据

	private Title mTitle;

	private ModelRequestAsk mAsk;

	private PinnedHeaderListView pinnedListView;
	private LayoutInflater inflater;
	private LinearLayout header;
	private RequestCommonAdapter mAdapter;
	private TestSectionedAdapter commonAdapter;

	@Override
	public void onClick(View v) {
		// resetImage();
		switch (v.getId()) {
		case R.id.rl_space:
			mApp.startActivity_qcj(this, RequestSearchActivity.class, sendDataToBundle(new Model(), null));
			break;
		// case R.id.iv_1:
		// iv_1.setImageResource(R.drawable.medica_green);
		// setTypeAdapter("0");
		// mAdapter.doRefreshNew();
		// break;
		//
		// case R.id.iv_2:
		// setTypeAdapter("1");
		// mAdapter.doRefreshNew();
		// iv_2.setImageResource(R.drawable.umbrella_green);
		// break;
		// case R.id.iv_3:
		// setTypeAdapter("2");
		// mAdapter.doRefreshNew();
		// iv_3.setImageResource(R.drawable.heart_green);
		// break;
		// case R.id.iv_4:
		// iv_4.setImageResource(R.drawable.more_green);
		// if (mCancerList != null && mCancerList.size() > 0) {
		// PopCancerCategory category = new PopCancerCategory(this, mCancerList,
		// this);
		// category.showPop(iv_4, Gravity.RIGHT, 0, 0);
		//
		// } else {
		// sendRequest(mApp.getRequestImpl().index(null), ModelRequest.class,
		// 0);
		// }
		// break;
		}

	}

	@Override
	public String setCenterTitle() {
		// TODO 自动生成的方法存根
		return "问答";
	}

	@Override
	public void initIntent() {
		// TODO 自动生成的方法存根

	}

	@Override
	public int getLayoutId() {
		// TODO 自动生成的方法存根
		return R.layout.header_activity_main;
	}

	@Override
	public void initView() {
		// TODO 自动生成的方法存根
		titleSetRightImage(R.drawable.chuangjianjingli);
		mTitle = getTitleClass();

		pinnedListView = (PinnedHeaderListView) findViewById(R.id.pinnedListView);
		// pinnedListView.setDividerHeight(DisplayUtils.dp2px(mApp, 10));
		// 添加头部视图
		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		header = (LinearLayout) inflater.inflate(R.layout.item_request_header, null);
		pinnedListView.addHeaderView(header);
		// 头部图片
		iv_1 = (ImageView) header.findViewById(R.id.iv_1);
		iv_2 = (ImageView) header.findViewById(R.id.iv_2);
		iv_3 = (ImageView) header.findViewById(R.id.iv_3);
		iv_4 = (ImageView) header.findViewById(R.id.iv_4);
		rl_space = (RelativeLayout) header.findViewById(R.id.rl_space);
		iv_zoom = (ImageView) header.findViewById(R.id.iv_zoom);
		tv_find = (TextView) header.findViewById(R.id.tv_find);
		et_find = (EditText) header.findViewById(R.id.et_find);
	}

	@Override
	public void initData() {
		// TODO 自动生成的方法存根
		mRequestItem = new ModelRequestItem();
		setTypeAdapter("0");
		iv_1.setImageResource(R.drawable.medica_green);
		mAsk = new ModelRequestAsk();
		mAsk.setIs_expert("0");
	}

	/**
	 * 设置type的类型
	 * 
	 * 注释：就这么任性的直接new一个adapter，简单粗暴，反正是外包，管我毛事 ↑ from qcj :)
	 */
	private void setTypeAdapter(String type) {
		mRequestItem.setType(type);
		mAdapter = new RequestCommonAdapter(this, mRequestItem);
		// 监听tab选择
		mAdapter.setOnTabselectedListener(new OnTabselectedListener() {

			@Override
			public void onTabSelectde(int index) {
				resetImage();
				switch (index) {
				case 0:
					iv_1.setImageResource(R.drawable.medica_green);
					setTypeAdapter("0");
					commonAdapter.doRefreshNew();
					break;
				case 1:
					iv_2.setImageResource(R.drawable.umbrella_green);
					setTypeAdapter("1");
					commonAdapter.doRefreshNew();
					break;
				case 2:
					iv_3.setImageResource(R.drawable.heart_green);
					setTypeAdapter("2");
					commonAdapter.doRefreshNew();
					break;
				case 3:
					iv_4.setImageResource(R.drawable.more_green);
					if (mCancerList != null && mCancerList.size() > 0) {
						PopCancerCategory category = new PopCancerCategory(RequestAnwerCommonActivity.this, mCancerList,
								RequestAnwerCommonActivity.this);
						category.showPop(iv_4, Gravity.RIGHT, 0, 0);

					} else {
						sendRequest(mApp.getRequestImpl().index(null), ModelRequest.class, 0);
					}
					break;

				default:
					break;
				}

			}
		});
		commonAdapter = new TestSectionedAdapter(this, null);
		pinnedListView.setAdapter(mAdapter);
	}

	@Override
	public void initListener() {
		// TODO 自动生成的方法存根
		rl_space.setOnClickListener(this);
		iv_1.setOnClickListener(this);
		iv_2.setOnClickListener(this);
		iv_3.setOnClickListener(this);
		iv_4.setOnClickListener(this);

		pinnedListView.setOnItemClickListener(new OnMyItemClickListener() {

			@Override
			public void onMyItemClick(AdapterView<?> adapterView, View view, int section, int position, long id) {
				mAdapter.setItemIndex(position);
				ModelRequestItem item = (ModelRequestItem) adapterView.getItemAtPosition(position);
				if (item != null) {
					if (item.getIs_expert().equals("0")) {
						pinnedListView.stepToNextActivity(adapterView, view, position,
								RequestDetailCommonActivity.class);
					} else if (item.getIs_expert().equals("1")) {
						pinnedListView.stepToNextActivity(adapterView, view, position,
								RequestDetailExpertActivity.class);
					}
				}
			}

			@Override
			public void onSectionClick(AdapterView<?> adapterView, View view, int section, long id) {

			}

		});

		// 发表普通问答
		mTitle.iv_title_right1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isLogin()) {
					mApp.startActivity_qcj(RequestAnwerCommonActivity.this, RequestSendTopicActivity.class,
							sendDataToBundle(mAsk, null));
				} else {
					mApp.startActivity_qcj(RequestAnwerCommonActivity.this, LoginActivity.class, null);
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelRequest) {
			ModelRequest request = (ModelRequest) object;
			mCancerList = request.getFenlei();
			PopCancerCategory category = new PopCancerCategory(this, mCancerList, this);
			category.showPop(iv_4, Gravity.RIGHT, 0, 0);
		}
		return object;
	}

	/**
	 * 重置图片
	 */
	public void resetImage() {
		iv_1.setImageResource(R.drawable.medica);
		iv_2.setImageResource(R.drawable.umbrella);
		iv_3.setImageResource(R.drawable.heart);
		iv_4.setImageResource(R.drawable.more);
	}

	/**
	 * 设置动画
	 * 
	 * @param Object
	 *            target
	 * @param float
	 *            fromY
	 * @param float
	 *            end
	 * @param long
	 *            time
	 */
	private void setAnimator(Object target, float offset, long time) {
		ObjectAnimator.ofFloat(target, "translationY", offset).setDuration(time).start();
	}

}
