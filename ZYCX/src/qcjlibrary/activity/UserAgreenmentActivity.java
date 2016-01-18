package qcjlibrary.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.zhiyicx.zycx.R;

import android.view.View;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.model.ModelMsg;

/**
 * author：qiuchunjia time：下午2:23:29 类描述：这个类是实现
 *
 */

public class UserAgreenmentActivity extends BaseActivity {
	private TextView tv_aggreementcontent;

	@Override
	public String setCenterTitle() {
		return "用户协议";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_user_agreenment;
	}

	@Override
	public void initView() {
		tv_aggreementcontent = (TextView) findViewById(R.id.tv_aggreementcontent);
	}

	@Override
	public void initData() {
		sendRequest(mApp.getUserImpl().getProtocol(), ModelMsg.class, REQUEST_GET);

	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(str);
			if (jsonObject.has("data")) {
				String result = jsonObject.getString("data");
				tv_aggreementcontent.setText(result);
			}
			return jsonObject;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
