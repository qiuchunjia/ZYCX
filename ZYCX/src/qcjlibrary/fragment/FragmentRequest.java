package qcjlibrary.fragment;

import java.util.ArrayList;
import java.util.List;
import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import qcjlibrary.activity.RequestDetailCommonActivity;
import qcjlibrary.activity.RequestDetailExpertActivity;
import qcjlibrary.activity.SearchNewActivity;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.adapter.RequestAnswerAdapter;
import qcjlibrary.config.Config;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelRequest;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.ModelRequestSearch;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.DisplayUtils;

public class FragmentRequest extends BaseFragment{

	private CommonListView mCommonListView;
	private RequestAnswerAdapter mRequestAdapter;
	/** 问答搜索 **/
	private ModelRequestSearch mRequestSearch;
	private List<Model> mItemList;
	
	@Override
	public void onClick(View v) {
		
	}

	@Override
	public void initIntentData() {
		
	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_search;
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
		mItemList = new ArrayList<Model>();
		mRequestSearch = new ModelRequestSearch();
		mApp.searchAct.setOnSearchListener(new OnSearchTouchListerer() {
			
			@Override
			public void onSearchTouch(String key, int searchType) {
				// TODO 自动生成的方法存根
				Log.d("Cathy", "request:"+key+" searchType:"+ searchType);
				if(searchType == Config.TYPE_REQUEST){
					Log.d("Cathy", "request:"+key);
					mRequestSearch.setKey(key);
					sendRequest(mApp.getRequestImpl().search(mRequestSearch),
							ModelRequest.class, REQUEST_GET);
				}
			}
		});
	}
	
	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelRequest) {
			ModelRequest request = (ModelRequest) object;
			Object data = request.getList();
			mItemList = (List<Model>) data;
			mRequestAdapter = new RequestAnswerAdapter(FragmentRequest.this, mItemList, mRequestSearch);
			mCommonListView.setAdapter(mRequestAdapter);
		}
		judgeTheMsg(object);
		return object;
	}

	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		initData();
	}
	
}
