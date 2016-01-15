package qcjlibrary.activity;

import java.util.List;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.StringAdapter;
import qcjlibrary.model.ModelFoodCancer;
import qcjlibrary.model.ModelFoodSymptom;

public class FoodTwoChooseActivity extends BaseActivity {
	public static final String TYPE_SYMPTOM = "3";
	public static final String TYPE_CANCER = "4";
	private ListView mListView;
	private StringAdapter mAdapter;
	private String[] data;
	private String mCurrent; // 类型
	private List<ModelFoodSymptom> mSympToms;
	private List<ModelFoodCancer> mCancers;

	@Override
	public String setCenterTitle() {
		return "对症食疗方";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initIntent() {
		mSympToms = (List<ModelFoodSymptom>) getDataFromIntent(getIntent(), TYPE_SYMPTOM);
		mCancers = (List<ModelFoodCancer>) getDataFromIntent(getIntent(), TYPE_CANCER);
		if (mSympToms != null) {
			mCurrent = TYPE_SYMPTOM;
		} else {
			mCurrent = TYPE_CANCER;
		}
	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_layout;
	}

	@Override
	public void initView() {
		mListView = (ListView) findViewById(R.id.mListView);

	}

	@Override
	public void initData() {
		if (mCurrent.equals(TYPE_SYMPTOM)) {
			data = new String[mSympToms.size()];
			for (int i = 0; i < mSympToms.size(); i++) {
				data[i] = mSympToms.get(i).getSymptom_name();
			}
		} else {
			data = new String[mCancers.size()];
			for (int i = 0; i < mCancers.size(); i++) {
				data[i] = mCancers.get(i).getCancer_name();
			}
		}
		mAdapter = new StringAdapter(this, data);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (mCurrent.equals(TYPE_SYMPTOM)) {
					mApp.startActivity_qcj(FoodTwoChooseActivity.this, FoodCategoryActivity.class,
							sendDataToBundle(mSympToms.get(position), null));
				} else {
					mApp.startActivity_qcj(FoodTwoChooseActivity.this, FoodCategoryActivity.class,
							sendDataToBundle(mCancers.get(position), null));
				}
			}
		});
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
