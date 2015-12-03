package qcjlibrary.activity;

import java.util.List;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.RequestAnswerAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelCancerCategory;
import qcjlibrary.model.ModelRequest;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.ModelRequestSearch;
import qcjlibrary.model.base.Model;
import android.util.Log;
import android.view.View;

import com.zhiyicx.zycx.R;

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
		mCommonListView.setDividerHeight(20);
		if (mCategory != null) {
			titleSetCenterTitle(mCategory.getTitle() + "");
		}
	}

	@Override
	public void initData() {
		mSearch.setCat(mCategory.getId());
		sendRequest(mApp.getRequestImpl().search(mSearch), ModelRequest.class,
				REQUEST_GET);
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelRequest) {
			ModelRequest request = (ModelRequest) object;
			Object data = request.getList();
			mItemList = (List<Model>) data;
			mAdapter = new RequestAnswerAdapter(this, mItemList, mSearch);
			mCommonListView.setAdapter(mAdapter);
		}
		return object;
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
	}

}
