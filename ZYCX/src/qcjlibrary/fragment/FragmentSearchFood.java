package qcjlibrary.fragment;

import java.util.ArrayList;
import java.util.List;

import com.zhiyicx.zycx.R;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import qcjlibrary.activity.FoodSingleDetailActivity;
import qcjlibrary.activity.FoodWaySingleDetail;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.adapter.FoodSearchAllAdapter;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelFoodIdDetail;
import qcjlibrary.model.ModelFoodIdDetailInfo;
import qcjlibrary.model.ModelFoodSearch0;
import qcjlibrary.model.ModelFoodSearchAll;
import qcjlibrary.model.ModelFoodSearchIndex;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.L;
import qcjlibrary.util.ToastUtils;

public class FragmentSearchFood extends BaseFragment {

	private CommonListView mCommonListView;
	private boolean isCreate = false;
	private FoodSearchAllAdapter mAdapter;
	private ModelFoodSearchAll mFoodSearchAll;
	private List<Model> mList;
	
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void initIntentData() {
		// TODO 自动生成的方法存根

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_search;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(0);
	}

	@Override
	public void initListener() {
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				Model model = (Model) parent.getItemAtPosition(position);
				Bundle data = mActivity.sendDataToBundle(model, null);
				if(model instanceof ModelFoodSearch0){
					mApp.startActivity_qcj(getActivity(), FoodSingleDetailActivity.class, data);
				} else{
					mApp.startActivity_qcj(getActivity(), FoodWaySingleDetail.class, data);
				}

			}
		});

	}

	@Override
	public void initData() {
		mList = new ArrayList<Model>();
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		// TODO 自动生成的方法存根
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelFoodSearchIndex) {
			ModelFoodSearchIndex mSearch = (ModelFoodSearchIndex) object;
			if(mSearch.getFoodList() !=null){
				mList.addAll(mSearch.getFoodList());
			}
			if(mSearch.getSideList() != null){
				mList.addAll(mSearch.getSideList());
			}
			mAdapter = new FoodSearchAllAdapter(this, mList);
			mCommonListView.setAdapter(mAdapter);
		} else {
			ToastUtils.showToast("暂时没有相关内容！");
		}
		judgeTheMsg(object);
		return object;
	}

	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		// initData();
	}

	// 仅当可见时才加载内容
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		// TODO 自动生成的方法存根
		super.setUserVisibleHint(isVisibleToUser);

		if (!isCreate) {
			return;
		}
		if (isVisibleToUser) {
			getData();
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		isCreate = true;
	}

	private void getData() {
		// TODO 自动生成的方法存根
		mApp.searchAct.setOnSearchListener(new OnSearchTouchListerer() {
			
			@Override
			public void onSearchTouch_Weibo(String key) {
			}
			
			@Override
			public void onSearchTouch_Request(String key) {
			}
			
			@Override
			public void onSearchTouch_Qclass(String key) {
			}
			
			@Override
			public void onSearchTouch_Info(String key) {
			}
			
			@Override
			public void onSearchTouch_Food(String key) {
				// TODO 自动生成的方法存根
				mFoodSearchAll = new ModelFoodSearchAll();
				mFoodSearchAll.setKey(key);
				sendRequest(mApp.getFoodImpl().food_search_all(mFoodSearchAll), 
						ModelFoodSearchIndex.class, 0);
			}
		});
	} 
}
