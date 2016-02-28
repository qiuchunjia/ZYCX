package qcjlibrary.activity;

import org.json.JSONObject;

import com.zhiyicx.zycx.LoginActivity;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.activity.QClassDetailsActivity;
import com.zhiyicx.zycx.config.MyConfig;
import com.zhiyicx.zycx.net.JsonDataListener;
import com.zhiyicx.zycx.net.NetComTools;
import com.zhiyicx.zycx.util.Utils;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.util.EditTextUtils;
import qcjlibrary.util.L;
import qcjlibrary.util.ToastUtils;
import qcjlibrary.widget.popupview.PopQclassCmt;

public class QclassCmtSendActivity extends BaseActivity {

	/**
	 * 轻课堂发表评论
	 * @author Tan
	 * @since 1.19
	 * */
	private EditText edt_qclass_send;
	private TextView tv_title_right;
	private String mDefId;
	private String content;
	
	@Override
	public void onClick(View v) {
	}

	@Override
	public String setCenterTitle() {
		// TODO 自动生成的方法存根
		return "课程";
	}

	@Override
	public void initIntent() {
		mDefId = (String) getDataFromIntent(getIntent(), "mDefId");
	}

	@Override
	public int getLayoutId() {
		// TODO 自动生成的方法存根
		return R.layout.activity_qclass_cmt_send;
	}

	@Override
	public void initView() {
		titleSetRightTitle("评论");
		edt_qclass_send = (EditText) findViewById(R.id.edt_qclass_send);
		tv_title_right = (TextView) findViewById(R.id.tv_title_right);
	}

	@Override
	public void initData() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void initListener() {
		
		edt_qclass_send.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				content = s.toString();
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				if(content.length() > 400){
					ToastUtils.showLongToast(QclassCmtSendActivity.this, "评论不可超过400字");
					content = content.substring(0, 400);
					edt_qclass_send.setText(content);
				}
			}
		});
		//发表评论
		tv_title_right.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				content = edt_qclass_send.getText().toString();
				if(content != null && !content.startsWith(" ")){
					if(content.length() > 400){
						ToastUtils.showLongToast(QclassCmtSendActivity.this, "评论不可超过400字");
						return;
					}
					if(EditTextUtils.containsEmoji(content)){
						ToastUtils.showLongToast(QclassCmtSendActivity.this , "不可输入表情");
						return;
					}
					sendCmt(content);
				} else{
					ToastUtils.showLongToast(QclassCmtSendActivity.this, "请正确输入评论");
				}
			}
		});
	}
	
	/**
	 * 发送评论到服务器
	 * 
	 * @param String
	 *            content 评论内容
	 */
	private void sendCmt(String content) {
		String url = MyConfig.QCLASS_ADDCMT_URL + Utils.getTokenString(this) + "&id=" + mDefId;
		url += "&content=" + Utils.getUTF8String(content);
		NetComTools netComTools = NetComTools.getInstance(this);
		netComTools.getNetJson(url, new JsonDataListener() {
			@Override
			public void OnReceive(JSONObject jsonObject) {
				L.d("send cmt data, " + jsonObject.toString());
				try {
					int code = jsonObject.getInt("code");
					if (code == 0) {
						ToastUtils.showLongToast(QclassCmtSendActivity.this, "评论成功");
						// mCmtEdit.setText("");
						onBackPressed();
					} else {
						String msg = jsonObject.getString("message");
						if (!TextUtils.isEmpty(msg))
							Utils.showToast(QclassCmtSendActivity.this, msg);
					}
				} catch (Exception e) {
				}
			}

			@Override
			public void OnError(String error) {
			}
		});
		// mCmdWindow.dismiss();
	}
}
