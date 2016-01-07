package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.MePerioAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.api.api.PeriodicalImpl;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelPeriodical;
import qcjlibrary.model.ModelPeriodicalIndex;
import qcjlibrary.model.base.Model;
import qcjlibrary.response.DataAnalyze;
import qcjlibrary.util.L;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.activity.QiKanDetailsActivity;

/**
 * author：qiuchunjia time：下午5:33:01 
 * 类描述：展示期刊list数据
 */

public class MePerioActivity extends BaseActivity {
	
	private CommonListView mCommonListView;
	private BAdapter mAdapter;

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
		mCommonListView.setDividerHeight(40);
	}

	@Override
	public void initData() {
		mAdapter = new MePerioAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);
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

}
