package qcjlibrary.fragment;

import java.util.ArrayList;
import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import qcjlibrary.activity.FoodWaySingleDetail;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.config.Config;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelFoodSearchAll;
import qcjlibrary.model.base.Model;

public class FragmentSearchFood extends BaseFragment {

	private CommonListView mCommonListView;
	private ModelFoodSearchAll mFoodSearchAll;
	private ArrayList<Model> mSearchList;
	private boolean isCreate = false;

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
	}

	@Override
	public void initListener() {
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				// 食材详情
				// mCommonListView.stepToNextActivity(parent, view, position,
				// FoodSingleDetailActivity.class);
				// 食疗方详情
				mCommonListView.stepToNextActivity(parent, view, position, FoodWaySingleDetail.class);

			}
		});

	}

	@Override
	public void initData() {

	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		// TODO 自动生成的方法存根
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelFoodSearchAll) {
			ModelFoodSearchAll mData = new ModelFoodSearchAll();

		}
		judgeTheMsg(object);
		return object;
	}

	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		Log.d("Cathy", "food:onResume");
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
			public void onSearchTouch(String key, int searchType) {
				// TODO 自动生成的方法存根
				Log.d("Cathy", "food:" + key + " searchType:" + searchType);
				if (searchType == Config.TYPE_FOOD) {
					Log.d("Cathy", "food:" + key);
					mFoodSearchAll = new ModelFoodSearchAll();
					mFoodSearchAll.setKey(key);
					sendRequest(mApp.getFoodImpl().food_search_all(mFoodSearchAll), ModelFoodSearchAll.class, 0);
				}
			}
		});
	}
}
