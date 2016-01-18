package qcjlibrary.fragment;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import qcjlibrary.activity.MsgNotifyDetailActivity;
import qcjlibrary.adapter.NotifyAdapter;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.swipelistview.SwipeMenu;
import qcjlibrary.listview.base.swipelistview.SwipeMenuListView;
import qcjlibrary.listview.base.swipelistview.SwipeMenuListView.OnMenuItemClickListener;
import qcjlibrary.model.ModelMsg;
import qcjlibrary.model.ModelNotifyNotice;

/**
 * author：qiuchunjia time：下午3:13:46 类描述：这个类是实现
 *
 */

public class FragmentNotify extends BaseFragment {

	private SwipeMenuListView mCommonListView;
	private NotifyAdapter mAdapter;

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

}
