package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.MePerioAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.api.api.PeriodicalImpl;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelPeriodical;
import qcjlibrary.model.ModelPeriodicalIndex;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.L;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.activity.QiKanDetailsActivity;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class MePerioActivity extends BaseActivity {
	private CommonListView mCommonListView;

	private BAdapter mAdapter;
	private List<Model> mList;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {

		return "我的期刊";

	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(20);
	}

	@Override
	public void initData() {
		mList = new ArrayList<Model>();
		PeriodicalImpl params = new PeriodicalImpl();
		sendRequest(params.index(), ModelPeriodicalIndex.class, 0);
	}

	@Override
	public void initListener() {
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position, 
						QiKanDetailsActivity.class);
			}
		});
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		// TODO 自动生成的方法存根
		Object object = super.onResponceSuccess(str, class1);
		if(object instanceof ModelPeriodicalIndex){
			List<ModelPeriodical> list = ((ModelPeriodicalIndex) object).getData();
			if(mList != null && list != null){
				mList.clear();
				mList.addAll(list);
				mAdapter = new MePerioAdapter(this, mList);
				mCommonListView.setAdapter(mAdapter);
				L.d("Cathy", "mList:"+mList.size());
			}
		}
		return object;
	}
	
}
