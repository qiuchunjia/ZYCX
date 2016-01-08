package qcjlibrary.activity;

import java.util.List;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.RequestAnswerAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelCancerCategory;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.ModelRequestSearch;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.DisplayUtils;

/**
 * author：qiuchunjia time：上午11:56:18 类描述：这个类是实现
 *
 */

public class CancerCategoryActivity extends BaseActivity {

	private CommonListView mCommonListView;
	private BAdapter mAdapter;
	private ModelCancerCategory mCategory;
	ModelRequestSearch mSearch = new ModelRequestSearch();
	private List<Model> mItemList;

	@Override
	public String setCenterTitle() {
		return "癌种类别";
	}

	@Override
	public void initIntent() {
		mCategory = (ModelCancerCategory) getDataFromIntent(getIntent(), null);
	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(
				getApplicationContext(), 10));
		if (mCategory != null) {
			titleSetCenterTitle(mCategory.getTitle() + "");
		}
	}

	@Override
	public void initData() {
		mSearch.setCat(mCategory.getId());
		mAdapter = new RequestAnswerAdapter(this, mSearch);
		mCommonListView.setAdapter(mAdapter);
	}

	@Override
	public void initListener() {
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (position > 0) {
					ModelRequestItem item = (ModelRequestItem) parent.getItemAtPosition(position);
					if (item.getIs_expert().equals("0")) {
						mCommonListView.stepToNextActivity(parent, view,
								position, RequestDetailCommonActivity.class);
					} else if (item.getIs_expert().equals("1")) {
						mCommonListView.stepToNextActivity(parent, view,
								position, RequestDetailExpertActivity.class);
					}
				}
			}
		});

	}

	@Override
	public void onClick(View v) {
	}

}
