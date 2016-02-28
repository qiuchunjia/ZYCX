package qcjlibrary.activity;

import java.util.List;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.ExperienceCycleAdapter;
import qcjlibrary.adapter.RequestAnswerAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelRequest;
import qcjlibrary.model.ModelRequestDetailCommon;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.ModelRequestSearch;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.DefaultLayoutUtil;
import qcjlibrary.util.DisplayUtils;
import qcjlibrary.util.ToastUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView.OnEditorActionListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.unit.SociaxUIUtils;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class RequestSearchActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private BAdapter mAdapter;
	private EditText et_find;
	private ImageView iv_zoom;
	private List<Model> mItemList;
	private ModelRequestSearch mSearch;
	/** 网络异常时的缺省图 **/
	private View defaultView;
	private LinearLayout ll_commonlist_parent;

	@Override
	public String setCenterTitle() {
		return "问答搜索";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_request_search;
	}

	@Override
	public void initView() {
		mSearch = new ModelRequestSearch();
		et_find = (EditText) findViewById(R.id.et_find);
		iv_zoom = (ImageView) findViewById(R.id.iv_zoom);
		ll_commonlist_parent = (LinearLayout) findViewById(R.id.ll_commonlist_parent);
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(getApplicationContext(), 20));
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (position > 0) {
					ModelRequestItem item = (ModelRequestItem) parent.getItemAtPosition(position);
					if (item.getIs_expert().equals("0")) {
						mCommonListView.stepToNextActivity(parent, view, position, RequestDetailCommonActivity.class);
					} else if (item.getIs_expert().equals("1")) {
						mCommonListView.stepToNextActivity(parent, view, position, RequestDetailExpertActivity.class);
					}
				}
			}
		});
	}

	@Override
	public void initData() {
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelRequest) {
			SociaxUIUtils.hideSoftKeyboard(this, et_find);
			ModelRequest request = (ModelRequest) object;
			Object data = request.getList();
			mItemList = (List<Model>) data;
			mAdapter = new RequestAnswerAdapter(this, mItemList, mSearch);
			mCommonListView.setAdapter(mAdapter);
		}
		judgeTheMsg(object);
		return object;
	}

	@Override
	public void initListener() {
		iv_zoom.setOnClickListener(this);

		// 监听回车按钮,将回车按钮改为搜索按钮
		et_find.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				search();
				return true;
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_zoom:
			search();
			break;

		}
	}

	private void search() {
		String searchStr = et_find.getText().toString();
		if (searchStr != null || !searchStr.equals("")) {
			mSearch.setKey(searchStr);
			sendRequest(mApp.getRequestImpl().search(mSearch), ModelRequest.class, REQUEST_GET);
		} else {
			ToastUtils.showToast("内容不能为空");
		}
	}

	@Override
	public View onRequestFailed() {
		// TODO 自动生成的方法存根
		defaultView = super.onRequestFailed();
		TextView tv_reload = (TextView) defaultView.findViewById(R.id.tv_reload);
		tv_reload.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				search();
			}
		});
		DefaultLayoutUtil.showDefault(ll_commonlist_parent, defaultView);
		return defaultView;
	}

	@Override
	public View onRequestSuccess() {
		// TODO 自动生成的方法存根
		defaultView = super.onRequestSuccess();
		DefaultLayoutUtil.hideDefault(ll_commonlist_parent, defaultView);
		return defaultView;
	}

}
