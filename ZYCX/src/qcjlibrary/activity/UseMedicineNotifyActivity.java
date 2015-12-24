package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.UseMedicineNotifyAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.config.Config;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelAlertData;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.DisplayUtils;
import qcjlibrary.util.SharedPreferencesUtil;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import com.baidu.mapapi.search.share.ShareUrlResult;
import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.android.Thinksns;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class UseMedicineNotifyActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private BAdapter mAdapter;

	private List<Model> mAlertList;
	
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
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		titleSetRightImage(R.drawable.tianjia);
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(this, 10));
		
		
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
		mAlertList = new ArrayList<Model>();
		int count = (Integer) SharedPreferencesUtil.getData(this, Config.SHARED_SAVE_KEY, 0);
		if(count < 1){
			return;
		}
		for (int i = 1; i <= count; i++) {
			String totalData = SharedPreferencesUtil.getData(this, i+"", "null").toString();
			if(!totalData.equals("null")){
				String[] mDataArr = totalData.split(",");
				ModelAlertData mData = new ModelAlertData();
				boolean isOpen = true;
				if(mDataArr[0].equals("false")){
					isOpen = false;
				}
				String userName = mDataArr[1];
				String medicineName = mDataArr[2];
				String repeatDaily = mDataArr[3];
				String repeatCount = mDataArr[4];
				String startTime = mDataArr[5];
				String timeList = mDataArr[6];
				mData.setId(i);
				mData.setExit(true);
				mData.setOpen(isOpen);
				mData.setUserName(userName);
				mData.setMedicineName(medicineName);
				mData.setRepeatDaily(repeatDaily);
				mData.setRepeatCount(repeatCount);
				mData.setStartTime(startTime);
				mData.setTimeList(timeList);
				mAlertList.add(mData);
			}
		}
		int len = mAlertList.size();
		Log.d("Cathy", "len:"+len);
		if(len > 0){
			mAdapter = new UseMedicineNotifyAdapter(this, mAlertList);
			mCommonListView.setAdapter(mAdapter);
		}
	}

	@Override
	public void initListener() {
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position,
						MedicineEditNotifyActivity.class);

			}
		});
	}

}
