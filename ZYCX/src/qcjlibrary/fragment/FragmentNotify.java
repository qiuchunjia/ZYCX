package qcjlibrary.fragment;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import qcjlibrary.activity.MsgNotifyDetailActivity;
import qcjlibrary.adapter.NotifyAdapter;
import qcjlibrary.adapter.base.OnRequestLinstner;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.swipelistview.SwipeMenu;
import qcjlibrary.listview.base.swipelistview.SwipeMenuListView;
import qcjlibrary.listview.base.swipelistview.SwipeMenuListView.OnMenuItemClickListener;
import qcjlibrary.model.ModelMsg;
import qcjlibrary.model.ModelNotifyNotice;
import qcjlibrary.util.DefaultLayoutUtil;

/**
 * author：qiuchunjia time：下午3:13:46 类描述：这个类是实现
 *
 */

public class FragmentNotify extends BaseFragment {

	private SwipeMenuListView mCommonListView;
	private NotifyAdapter mAdapter;
	private LinearLayout ll_common_delete_parent;

	@Override
	public void initIntentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_common_layout_delete;
	}

	@Override
	public void initView() {
		mCommonListView = (SwipeMenuListView) findViewById(R.id.mCommonListView);
		ll_common_delete_parent = (LinearLayout) findViewById(R.id.ll_common_delete_parent);
		mCommonListView.setDividerHeight(5);
		mAdapter = new NotifyAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position, MsgNotifyDetailActivity.class);
				
			}
		});
		mCommonListView.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
				ModelNotifyNotice notice = (ModelNotifyNotice) mCommonListView.getItemAtPosition(position);
				sendRequest(mApp.getNotifyImpl().delOne(notice), ModelMsg.class, REQUEST_GET);
				return false;
			}
		});
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (judgeTheMsg(object)) {
			mAdapter.doRefreshHeader();
		}
		return object;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		mAdapter.setOnRequestLinstner(new OnRequestLinstner() {
			
			@Override
			public void onSuccess(View view) {
				// TODO 自动生成的方法存根
				DefaultLayoutUtil.hideDefault(ll_common_delete_parent, view);
			}
			
			@Override
			public void onFailed(View view) {
				// TODO 自动生成的方法存根
				DefaultLayoutUtil.showDefault(ll_common_delete_parent, view);
				TextView tv_reload = (TextView) view.findViewById(R.id.tv_reload);
				tv_reload.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						mAdapter.doRefreshNew();
					}
				});
			}
		});
	}

	/**
	 * 清空里面的通知里面的数据后 调用，刷新，这个是msgnotifyDetailActivity调用
	 */
	public void DeleteAllMessage() {
		if (mAdapter != null) {
			mAdapter.deleteAlltheItem();
		}
	}

	@Override
	public void onClick(View v) {

	}
	
	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		if(mAdapter != null){
			mAdapter.refreshNew();
		}
	}

}
