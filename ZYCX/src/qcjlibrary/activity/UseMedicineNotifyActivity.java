package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.UseMedicineNotifyAdapter;
import qcjlibrary.adapter.base.BAdapter;
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
		int count = Thinksns.id;
		if(count < 1){
			return;
		}
		for (int i = 1; i < Thinksns.id; i++) {
			String totalData = SharedPreferencesUtil.getData(this, "i", " ").toString();
			if(!totalData.equals(" ")){
				String[] mDataArr = totalData.split(",");
				ModelAlertData mData = new ModelAlertData();
				boolean isOpen = true;
				if(mDataArr[0].equals("false")){
					isOpen = true;
				}
				String userName = mDataArr[1];
				String medicineName = mDataArr[2];
				String repeatDaily = mDataArr[3];
				String startTime = mDataArr[4];
				String timeList = mDataArr[5];
				mData.setId(i);
				mData.setExit(true);
				mData.setOpen(isOpen);
				mData.setUserName(userName);
				mData.setMedicineName(medicineName);
				mData.setRepeatDaily(repeatDaily);
				mData.setStartTime(startTime);
				mData.setTimeList(timeList);
				mAlertList.add(mData);
			}
		}
		mAdapter = new UseMedicineNotifyAdapter(this, mAlertList);
		mCommonListView.setAdapter(mAdapter);
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
