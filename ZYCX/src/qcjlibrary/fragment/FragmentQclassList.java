package qcjlibrary.fragment;

import java.util.ArrayList;
import java.util.List;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.activity.HomeActivity.onStatusChangedListener;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import android.os.Bundle;
import android.view.View;
import qcjlibrary.adapter.QclassAdapter;
import qcjlibrary.api.api.QclassImpl;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelQclass;
import qcjlibrary.model.ModelQclassDetail;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.L;

public class FragmentQclassList extends BaseFragment{

	/**
	 * 轻课堂分类页面
	 * @author Tan
	 * @since 2015.12.31
	 * */
	
	private QclassAdapter mAdapter;
	private CommonListView mCommonListView;
	private int mType = 0;
	private int status = 0;
	private List<Model> mList;
	private ModelQclassDetail detail;
	private QclassImpl qclassImpl;
	
	public FragmentQclassList newInstanse(int type){
		FragmentQclassList f = new FragmentQclassList();
		Bundle bundle = new Bundle();
		bundle.putInt("type", type);
		f.setArguments(bundle);
		return f;
	}
	
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void initIntentData() {
		Bundle bundle = getArguments();
		mType = bundle.getInt("type");
	}

	@Override
	public int getLayoutId() {
		// TODO 自动生成的方法存根
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(2);
	}

	@Override
	public void initListener() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void initData() {
		mList = new ArrayList<Model>();
		detail = new ModelQclassDetail();
		qclassImpl = new QclassImpl();
		detail.setClass_id(mType);
		sendRequest(qclassImpl.indexItem(detail), ModelQclass.class, 0);
		Thinksns.homeAct.setOnStatusChangedListener(new onStatusChangedListener() {
			
			@Override
			public void onStatusChange(int status) {
				if(mAdapter != null){
					mAdapter.setStatus(status);
				}
				detail.setStatus(status);
				L.d("Cathy", "status: "+status);
				sendRequest(qclassImpl.indexItem(detail), ModelQclass.class, 0);
			}
		});
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		// TODO 自动生成的方法存根
		Object object = super.onResponceSuccess(str, class1);
		if(object instanceof ModelQclass){
			ModelQclass mQclass = (ModelQclass)object;
			if(mList != null){
				mList.clear();
				if(mQclass.getList() != null){
					mList.addAll(mQclass.getList());
					mAdapter = new QclassAdapter(this, mList, detail);
					mCommonListView.setAdapter(mAdapter);
				}
			}
		}
		return object;
	}
	
}
