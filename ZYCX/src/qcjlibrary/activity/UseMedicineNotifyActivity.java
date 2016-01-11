package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.UseMedicineNotifyAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.api.api.AlarmImpl;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.listview.base.swipelistview.SwipeMenu;
import qcjlibrary.listview.base.swipelistview.SwipeMenuListView;
import qcjlibrary.listview.base.swipelistview.SwipeMenuListView.OnMenuItemClickListener;
import qcjlibrary.model.ModelAlertData;
import qcjlibrary.model.ModelMsg;
import qcjlibrary.model.base.Model;
import qcjlibrary.response.DataAnalyze;
import qcjlibrary.util.DisplayUtils;
import qcjlibrary.util.ToastUtils;
import android.app.AlarmManager;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;
import com.zhiyicx.zycx.R;

/**
 * author：tan time：下午5:7:01 类描述：用药提醒，闹钟界面
 */

public class UseMedicineNotifyActivity extends BaseActivity {
	private SwipeMenuListView mSwipeMenuListView;
	private UseMedicineNotifyAdapter mAdapter;
	private List<Model> mList;
	boolean isDel = false;
	private AlarmImpl impl;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "用药提醒";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.swipe_menu_listview;
	}

	@Override
	public void initView() {
		titleSetRightImage(R.drawable.tianjia);
		mSwipeMenuListView = (SwipeMenuListView) findViewById(R.id.mSwipeMenuListView);
		mSwipeMenuListView.setDividerHeight(DisplayUtils.dp2px(this, 10));

	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.iv_title_right1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mApp.startActivity_qcj(UseMedicineNotifyActivity.this, 
						MedicineEditNotifyActivity.class, null);
			}
		});
		mList = new ArrayList<Model>();
		impl = new AlarmImpl();
		sendRequest(impl.index(), ModelAlertData.class, REQUEST_GET);
	}

	@Override
	public void initListener() {
		mSwipeMenuListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mSwipeMenuListView.stepToNextActivity(parent, view, position, 
						MedicineEditNotifyActivity.class);

			}
		});
		
		/**
		 * 监听滑动删除,调用适配器中delete方法，删除服务器中数据
		 * */
		mSwipeMenuListView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
				isDel = true;
				sendRequest(impl.delete((ModelAlertData)mList.get(position)), 
						ModelMsg.class, REQUEST_POST);
				return false;
			}
		});
	}
	
	@Override
	public Object onResponceSuccess(String str, Class class1) {
		// TODO 自动生成的方法存根
		Object object;
		if(isDel){
			object = DataAnalyze.parseDataByGson(str, class1);
		} else{
			object = DataAnalyze.parseData(str, class1);
		}
		if(object instanceof List<?>){
			if(mList != null){
				mList.clear();
				mList.addAll((List<ModelAlertData>) object);
				if(mAdapter != null){
					mAdapter.notifyDataSetChanged();
				} else{
					mAdapter = new UseMedicineNotifyAdapter(this, mList);
					mSwipeMenuListView.setAdapter(mAdapter);
				}
			}
		}
		if(object instanceof ModelMsg){
			isDel = false;
			ModelMsg msg = (ModelMsg) object;
			if(msg.getCode() == 0){
				sendRequest(impl.index(), ModelAlertData.class, REQUEST_GET);
			}
			ToastUtils.showLongToast(getApplicationContext(), msg.getMessage());
		}
		return object;
	}
}
