package qcjlibrary.fragment;

import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.component.CommentList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import qcjlibrary.activity.RequestDetailCommonActivity;
import qcjlibrary.activity.RequestDetailExpertActivity;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.util.DisplayUtils;

public class FragmentRequest extends BaseFragment{

	private CommonListView mCommonListView;
	
	@Override
	public void onClick(View v) {
		
	}

	@Override
	public void initIntentData() {
		
	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_request;
	}

	@Override
	public void initView() {
		// TODO 自动生成的方法存根
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(mApp, 10));
		
	}

	@Override
	public void initListener() {
		
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ModelRequestItem item = (ModelRequestItem) parent
						.getItemAtPosition(position);
				if (item != null) {
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
	public void initData() {
		
	}

}
