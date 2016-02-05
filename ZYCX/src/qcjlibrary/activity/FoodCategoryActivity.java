package qcjlibrary.activity;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.FoodCategoryAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelFood;
import qcjlibrary.model.ModelFoodCancer;
import qcjlibrary.model.ModelFoodCategory;
import qcjlibrary.model.ModelFoodSearch;
import qcjlibrary.model.ModelFoodSymptom;
import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class FoodCategoryActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private FoodCategoryAdapter mAdapter;

	private ModelFoodSearch mSearch = new ModelFoodSearch();;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "谷类";
	}

	@Override
	public void initIntent() {

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
			String key = mSearch.getKey();
			if(key.length() > 5){
				key = key.substring(0, 4)+"...";
			}
			titleSetCenterTitle(key);
		} else if (model instanceof ModelFoodSymptom) {
			ModelFoodSymptom foodSymptom = (ModelFoodSymptom) model;
			mSearch.setState(2);
			mSearch.setType(foodSymptom.getId());
		} else if (model instanceof ModelFoodCancer) {
			ModelFoodCancer foodCancer = (ModelFoodCancer) model;
			mSearch.setState(3);
			mSearch.setType(foodCancer.getId());

		}

	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(0);

		mAdapter = new FoodCategoryAdapter(this, mSearch);

		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				if (mSearch.getState() == 0) {
					// 食材详情
					mCommonListView.stepToNextActivity(parent, view, position, FoodSingleDetailActivity.class);
				} else if (mSearch.getState() >= 1) {
					// 食疗方详情
					mCommonListView.stepToNextActivity(parent, view, position, FoodWaySingleDetail.class);
				}

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
