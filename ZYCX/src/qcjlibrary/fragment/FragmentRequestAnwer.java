package qcjlibrary.fragment;

import java.util.List;

import qcjlibrary.activity.RequestDetailCommonActivity;
import qcjlibrary.activity.RequestDetailExpertActivity;
import qcjlibrary.activity.RequestSearchActivity;
import qcjlibrary.adapter.RequestAnswerAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.adapter.base.OnRequestLinstner;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelCancerCategory;
import qcjlibrary.model.ModelFoodIdDetail;
import qcjlibrary.model.ModelRequest;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.DefaultLayoutUtil;
import qcjlibrary.util.DisplayUtils;
import qcjlibrary.widget.popupview.PopCancerCategory;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
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
	private LinearLayout ll_top;
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
	private TextView tv_1;
	private TextView tv_2;
	private TextView tv_3;
	private TextView tv_4;
	private CommonListView mCommonListView;
	private BAdapter mAdapter;
	private List<ModelCancerCategory> mCancerList; // 癌症种类

	private ModelRequestItem mRequestItem; // 请求数据
	private LinearLayout ll_request_head;
	private LinearLayout ll_commonlist_parent;
	
	private float mLastY;
	//private float offset;
	private int llTop;
	private int tvTop;
	
	private View defaultView;
	private boolean isFirst = true;

	@Override
	public void initIntentData() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_request_anwer;
	}

	@Override
	public void initView() {
		ll_top = (LinearLayout) findViewById(R.id.ll_top);
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

		tv_1 = (TextView) findViewById(R.id.tv_1);
		tv_2 = (TextView) findViewById(R.id.tv_2);
		tv_3 = (TextView) findViewById(R.id.tv_3);
		tv_4 = (TextView) findViewById(R.id.tv_4);
		
		ll_request_head = (LinearLayout) findViewById(R.id.ll_request_head);
		ll_commonlist_parent = (LinearLayout) findViewById(R.id.ll_commonlist_parent);

		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(mApp, 10));
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				ModelRequestItem item = (ModelRequestItem) parent.getItemAtPosition(position);
				if (item != null) {
					if (item.getIs_expert().equals("0")) {
						mCommonListView.stepToNextActivity(parent, view, position, RequestDetailCommonActivity.class);
					} else if (item.getIs_expert().equals("1")) {
						mCommonListView.stepToNextActivity(parent, view, position, RequestDetailExpertActivity.class);
					}
				}

			}
		});
	}

	@Override
	public void initData() {
		mRequestItem = new ModelRequestItem();
		setTypeAdapter("0");
		iv_1.setImageResource(R.drawable.medica_green);
		tv_1.setTextColor(getResources().getColor(R.color.text_green));
	}

	/**
	 * 设置type的类型
	 * 
	 * 注释：就这么任性的直接new一个adapter，简单粗暴，反正是外包，管我毛事
	 */
	private void setTypeAdapter(String type) {
		mRequestItem.setType(type);
		mAdapter = new RequestAnswerAdapter(this, mRequestItem);
		mCommonListView.setAdapter(mAdapter);
		/**
		 * 监听是否成功请求数据
		 * */
		mAdapter.setOnRequestLinstner(new OnRequestLinstner() {
			
			@Override
			public void onSuccess(View view) {
				defaultView = view;
				DefaultLayoutUtil.hideDefault(ll_commonlist_parent, defaultView);
			}
			
			@Override
			public void onFailed(View view) {
				defaultView = view;
				isFirst = DefaultLayoutUtil.showDefault(ll_commonlist_parent, view, isFirst);
				TextView tv_reload = (TextView) defaultView.findViewById(R.id.tv_reload);
				tv_reload.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Log.d("Cathy", "onClick");
						mAdapter.doRefreshNew();
					}
				});
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
			PopCancerCategory category = new PopCancerCategory(mActivity, mCancerList, mActivity);
			category.showPop(ll_4, Gravity.RIGHT, 0, 0);
		}
		return object;
	}

	@Override
	public void initListener() {
		rl_space.setOnClickListener(this);
		ll_1.setOnClickListener(this);
		ll_2.setOnClickListener(this);
		ll_3.setOnClickListener(this);
		ll_4.setOnClickListener(this);
		
		mCommonListView.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
			}
		});
		
//		mCommonListView.setOnTouchListener(new OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				switch (event.getAction()) {
//				case MotionEvent.ACTION_DOWN:
//					mLastY = event.getY();
//					break;
//				case MotionEvent.ACTION_MOVE:
//					float offset = event.getY() - mLastY;
//					long time = Math.abs((long) (offset / 10)) * 1000;
//					setAnimator(ll_top, offset, 500);
//					setAnimator(mCommonListView, offset, time);
//					llTop = ll_request_head.getTop();
//					tvTop = tv_1.getTop();
//					//mLastY = event.getY();
//					break;
//				default:
//					break;
//				}
//				return true;
//			}
//		});
		
	}

	@Override
	public void onClick(View v) {
		resetImage();
		switch (v.getId()) {
		case R.id.rl_space:
			mApp.startActivity_qcj(getActivity(), RequestSearchActivity.class,
					mActivity.sendDataToBundle(new Model(), null));
			break;
		case R.id.ll_1:
			iv_1.setImageResource(R.drawable.medica_green);
			tv_1.setTextColor(getResources().getColor(R.color.text_green));
			setTypeAdapter("0");
			mAdapter.doRefreshNew();
			break;

		case R.id.ll_2:
			setTypeAdapter("1");
			mAdapter.doRefreshNew();
			iv_2.setImageResource(R.drawable.umbrella_green);
			tv_2.setTextColor(getResources().getColor(R.color.text_green));
			break;
		case R.id.ll_3:
			setTypeAdapter("2");
			mAdapter.doRefreshNew();
			iv_3.setImageResource(R.drawable.heart_green);
			tv_3.setTextColor(getResources().getColor(R.color.text_green));
			break;
		case R.id.ll_4:
			iv_4.setImageResource(R.drawable.more_green);
			tv_4.setTextColor(getResources().getColor(R.color.text_green));
			if (mCancerList != null && mCancerList.size() > 0) {
				PopCancerCategory category = new PopCancerCategory(mActivity, mCancerList, mActivity);
				category.showPop(ll_4, Gravity.RIGHT, 0, 0);

			} else {
				sendRequest(mApp.getRequestImpl().index(null), ModelRequest.class, 0);
			}
			break;
		}

	}

	/**
	 * 重置图片
	 */
	public void resetImage() {
		iv_1.setImageResource(R.drawable.medica);
		iv_2.setImageResource(R.drawable.umbrella);
		iv_3.setImageResource(R.drawable.heart);
		iv_4.setImageResource(R.drawable.more);
		tv_1.setTextColor(getResources().getColor(R.color.text_more_gray));
		tv_2.setTextColor(getResources().getColor(R.color.text_more_gray));
		tv_3.setTextColor(getResources().getColor(R.color.text_more_gray));
		tv_4.setTextColor(getResources().getColor(R.color.text_more_gray));
	}

	/**
	 * 设置动画
	 * @param Object target 
	 * @param float fromY 
	 * @param float end
	 * @param long time
	 * */
	private void setAnimator(Object target, float offset, long time){
		ObjectAnimator.ofFloat(target, "translationY", offset).
			setDuration(time).start();
	}
	
	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
	}
}
