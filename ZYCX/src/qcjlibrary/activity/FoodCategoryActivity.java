package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.FoodCategoryAdapter;
import qcjlibrary.listview.base.CommonListView;
<<<<<<< HEAD
import qcjlibrary.model.ModelFood;
import qcjlibrary.model.ModelFoodCategory;
import qcjlibrary.model.ModelFoodSearch;
import qcjlibrary.model.base.Model;
=======
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class FoodCategoryActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private FoodCategoryAdapter mAdapter;
<<<<<<< HEAD
	private ModelFoodSearch mSearch = new ModelFoodSearch();;
=======
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "谷类";
	}

	@Override
	public void initIntent() {
<<<<<<< HEAD
		Model model = (Model) getDataFromIntent(getIntent(), null);
		if (model instanceof ModelFood) {
			ModelFood food = (ModelFood) model;
			mSearch.setState(0);
			mSearch.setType_id(Integer.valueOf(food.getId()));
			titleSetCenterTitle(food.getType_name());
		} else if (model instanceof ModelFoodCategory) {
			ModelFoodCategory categoryood = (ModelFoodCategory) model;
			mSearch.setState(1);
			mSearch.setType_id(Integer.valueOf(categoryood.getId()));
			titleSetCenterTitle(categoryood.getClass_name());
		} else if (model instanceof ModelFoodSearch) {
			mSearch = (ModelFoodSearch) model;
			titleSetCenterTitle(mSearch.getKey());
		}
=======

>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(0);
<<<<<<< HEAD
		mAdapter = new FoodCategoryAdapter(this, mSearch);
=======
		mAdapter = new FoodCategoryAdapter(this, null);
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
<<<<<<< HEAD
				if (mSearch.getState() == 0) {
					// 食材详情
					mCommonListView.stepToNextActivity(parent, view, position,
							FoodSingleDetailActivity.class);
				} else if (mSearch.getState() == 1) {
					// 食疗方详情
					mCommonListView.stepToNextActivity(parent, view, position,
							FoodWaySingleDetail.class);
				}
=======
				mCommonListView.stepToNextActivity(parent, view, position,
						FoodCategorySingleDetail.class);
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
			}
		});
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stubF

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}
