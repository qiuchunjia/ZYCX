package qcjlibrary.activity;

import java.util.ArrayList;
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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.RequestCommonAdapter;
import qcjlibrary.adapter.TestSectionedAdapter;
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
	private LinearLayout ll_4;
	private TextView tv_1;
	private TextView tv_2;
	private TextView tv_3;
	private TextView tv_4;
	// 头部视图控件
	private TextView header_tv_1;
	private TextView header_tv_2;
	private TextView header_tv_3;
	private TextView header_tv_4;
	private ImageView iv_1;
	private ImageView iv_2;
	private ImageView iv_3;
	private ImageView iv_4;
	private LinearLayout ll_request_icon;
	private RelativeLayout rl_request_tab;
	private ImageView iv_tab_line;
	
	private List<ModelCancerCategory> mCancerList; // 癌症种类

	private ModelRequestItem mRequestItem; // 请求数据

	private Title mTitle;

	private ModelRequestAsk mAsk;

	private PinnedHeaderListView pinnedListView;
	private LayoutInflater inflater;
	private LinearLayout header;
	private RequestCommonAdapter mAdapter;
	private TestSectionedAdapter commonAdapter;
	private List<TextView> tvList;
	private List<ImageView> imgHeaderList;
	private List<TextView> tvHeaderList;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_space:
			mApp.startActivity_qcj(this, RequestSearchActivity.class, sendDataToBundle(new Model(), null));
			break;
		case R.id.tv_01:
			resetImage();
			setSelected(0);
			iv_1.setImageResource(R.drawable.medica_green);
			setTypeAdapter("0");
			break;

		case R.id.tv_02:
			setTypeAdapter("1");
			resetImage();
			setSelected(1);
			iv_2.setImageResource(R.drawable.umbrella_green);
			break;
		case R.id.tv_03:
			setTypeAdapter("2");
			resetImage();
			setSelected(2);
			iv_3.setImageResource(R.drawable.heart_green);
			break;
		case R.id.tv_04:
			resetImage();
			setSelected(3);
			iv_4.setImageResource(R.drawable.more_green);
			if (mCancerList != null && mCancerList.size() > 0) {
				PopCancerCategory category = new PopCancerCategory(this, mCancerList, this);
				category.showPop(iv_4, Gravity.RIGHT, 0, 0);

			} else {
				sendRequest(mApp.getRequestImpl().index(null), ModelRequest.class, 0);
			}
			break;
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

		rl_request_tab = (RelativeLayout) findViewById(R.id.rl_request_tab);
		pinnedListView = (PinnedHeaderListView) findViewById(R.id.pinnedListView);
		tv_1 = (TextView) findViewById(R.id.tv_01);
		tv_2 = (TextView) findViewById(R.id.tv_02);
		tv_3 = (TextView) findViewById(R.id.tv_03);
		tv_4 = (TextView) findViewById(R.id.tv_04);
		//pinnedListView.setDividerHeight(10);
		pinnedListView.setDividerHeight(0);
		// 添加头部视图
		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		header = (LinearLayout) inflater.inflate(R.layout.item_request_header, null);
		pinnedListView.addHeaderView(header);
		// 头部图片
		iv_1 = (ImageView) header.findViewById(R.id.iv_1);
		iv_2 = (ImageView) header.findViewById(R.id.iv_2);
		iv_3 = (ImageView) header.findViewById(R.id.iv_3);
		iv_4 = (ImageView) header.findViewById(R.id.iv_4);
		header_tv_1 = (TextView) header.findViewById(R.id.tv_01);
		header_tv_2 = (TextView) header.findViewById(R.id.tv_02);
		header_tv_3 = (TextView) header.findViewById(R.id.tv_03);
		header_tv_4 = (TextView) header.findViewById(R.id.tv_04);
		rl_space = (RelativeLayout) header.findViewById(R.id.rl_space);
		ll_request_icon = (LinearLayout) header.findViewById(R.id.ll_request_icon);
		iv_zoom = (ImageView) header.findViewById(R.id.iv_zoom);
		tv_find = (TextView) header.findViewById(R.id.tv_find);
		et_find = (EditText) header.findViewById(R.id.et_find);
		iv_tab_line = (ImageView) header.findViewById(R.id.iv_tab_line);
	}

	@Override
	public void initData() {
		// TODO 自动生成的方法存根
		mRequestItem = new ModelRequestItem();
		setTypeAdapter("0");
		iv_1.setImageResource(R.drawable.medica_green);
		mAsk = new ModelRequestAsk();
		mAsk.setIs_expert("0");
		green = mApp.getActivity().getResources().getColor(R.color.text_green);
		gray = mApp.getActivity().getResources().getColor(R.color.text_gray);

		tvList = new ArrayList<TextView>();
		imgHeaderList = new ArrayList<ImageView>();
		tvHeaderList = new ArrayList<TextView>();
		
		tvList.add(tv_1);
		tvList.add(tv_2);
		tvList.add(tv_3);
		tvList.add(tv_4);
		imgHeaderList.add(iv_1);
		imgHeaderList.add(iv_2);
		imgHeaderList.add(iv_3);
		imgHeaderList.add(iv_4);
		tvHeaderList.add(header_tv_1);
		tvHeaderList.add(header_tv_2);
		tvHeaderList.add(header_tv_3);
		tvHeaderList.add(header_tv_4);

	}

	/**
	 * 设置type的类型
	 * 
	 * 注释：就这么任性的直接new一个adapter，简单粗暴，反正是外包，管我毛事 ↑ from qcj :)
	 */
	private void setTypeAdapter(String type) {
		mRequestItem.setType(type);
		mAdapter = new RequestCommonAdapter(this, mRequestItem);
//		commonAdapter = new TestSectionedAdapter(this, null);
		pinnedListView.setAdapter(mAdapter);
		mAdapter.doRefreshNew();
	}

	@Override
	public void initListener() {
		// TODO 自动生成的方法存根
		rl_space.setOnClickListener(this);
		tv_1.setOnClickListener(this);
		tv_2.setOnClickListener(this);
		tv_3.setOnClickListener(this);
		tv_4.setOnClickListener(this);

		setTabListener();

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

		pinnedListView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
//				if(scrollState == SCROLL_STATE_FLING){
//					Log.d("Cathy", " top "+Math.abs(header.getTop()));
//				}
				
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				int headerTop = Math.abs(header.getTop());
				int iconTop = ll_request_icon.getHeight() + rl_space.getHeight() + 20;
				
				if (headerTop >= iconTop) {
					//header.setVisibility(View.GONE);
					rl_request_tab.setVisibility(View.VISIBLE);
				} else {
					//header.setVisibility(View.VISIBLE);
					if(firstVisibleItem >= 2){
						rl_request_tab.setVisibility(View.VISIBLE);
					} else{
						rl_request_tab.setVisibility(View.GONE);
					}
				}
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

	private void setTabListener() {
		iv_1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				resetImage();
				setSelected(0);
				iv_1.setImageResource(R.drawable.medica_green);
				setTypeAdapter("0");
			}
		});

		header_tv_1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				resetImage();
				setSelected(0);
				iv_1.setImageResource(R.drawable.medica_green);
				setTypeAdapter("0");
			}
		});

		iv_2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				resetImage();
				setSelected(1);
				iv_2.setImageResource(R.drawable.umbrella_green);
				setTypeAdapter("1");
			}
		});

		header_tv_2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				resetImage();
				setSelected(1);
				iv_2.setImageResource(R.drawable.umbrella_green);
				setTypeAdapter("1");
			}
		});
		iv_3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				resetImage();
				setSelected(2);
				iv_3.setImageResource(R.drawable.heart_green);
				setTypeAdapter("2");
			}
		});

		header_tv_3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				resetImage();
				setSelected(2);
				iv_3.setImageResource(R.drawable.heart_green);
				setTypeAdapter("2");
			}
		});
		iv_4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				resetImage();
				setSelected(3);
				iv_4.setImageResource(R.drawable.more_green);
				if (mCancerList != null && mCancerList.size() > 0) {
					PopCancerCategory category = new PopCancerCategory(RequestAnwerCommonActivity.this, mCancerList,
							RequestAnwerCommonActivity.this);
					category.showPop(tv_4, Gravity.RIGHT, 0, 0);
				} else {
					sendRequest(mApp.getRequestImpl().index(null), ModelRequest.class, REQUEST_GET);
				}
			}
		});

		header_tv_4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				resetImage();
				setSelected(3);
				iv_4.setImageResource(R.drawable.more_green);
				if (mCancerList != null && mCancerList.size() > 0) {
					PopCancerCategory category = new PopCancerCategory(RequestAnwerCommonActivity.this, mCancerList,
							RequestAnwerCommonActivity.this);
					category.showPop(tv_4, Gravity.RIGHT, 0, 0);
				} else {
					sendRequest(mApp.getRequestImpl().index(null), ModelRequest.class, REQUEST_GET);
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

	private int green;
	private int gray;

	public void setSelected(int index) {
		for (int i = 0; i < tvList.size(); i++) {
			if (index == i) {
				tvList.get(i).setTextColor(green);
				tvHeaderList.get(i).setTextColor(green);
			} else {
				tvList.get(i).setTextColor(gray);
				tvHeaderList.get(i).setTextColor(gray);
			}
		}
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
