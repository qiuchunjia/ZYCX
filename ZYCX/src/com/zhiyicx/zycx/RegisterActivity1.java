package com.zhiyicx.zycx;

import org.json.JSONObject;

import com.zhiyicx.zycx.config.MyConfig;
import com.zhiyicx.zycx.net.JsonDataListener;
import com.zhiyicx.zycx.net.NetComTools;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import qcjlibrary.activity.UserAgreenmentActivity;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.model.ModelUser;
import qcjlibrary.util.ToastUtils;

/**
 * 注册类
 *
 * @author Mr . H
 *
 */
public class RegisterActivity1 extends BaseActivity {

	private EditText et_mobile;
	private EditText et_vertify;
	private TextView tv_vertify_code;
	private Button btn_next;
	private ImageView iv_choose;
	private TextView tv_user_agreenment;

	private ModelUser mUser;
	private Handler mHandle = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.arg1 > 1) {
				tv_vertify_code.setText(msg.what + "s");
			} else {
				tv_vertify_code.setText("获取验证码");
			}

		};
	};

	@Override
	public String setCenterTitle() {
		return "注册";
	}

	@Override
	public void initIntent() {
		// Intent intent = getIntent();
		// String type_uid = intent.getStringExtra("type_uid");
		// String type = intent.getStringExtra("type");
		// String token = intent.getStringExtra("access_token");
		Object object = getDataFromIntent(getIntent(), null);
		if (object instanceof ModelUser) {
			mUser = (ModelUser) object;
		} else {
			mUser = new ModelUser();
		}

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_register;
	}

	@Override
	public void initView() {
		et_mobile = (EditText) findViewById(R.id.et_mobile);
		et_vertify = (EditText) findViewById(R.id.et_vertify);
		tv_vertify_code = (TextView) findViewById(R.id.tv_vertify_code);
		btn_next = (Button) findViewById(R.id.btn_next);
		iv_choose = (ImageView) findViewById(R.id.iv_choose);
		tv_user_agreenment = (TextView) findViewById(R.id.tv_user_agreenment);
	}

	@Override
	public void initData() {
	}

	@Override
	public void initListener() {
		tv_vertify_code.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		iv_choose.setOnClickListener(this);
		tv_user_agreenment.setOnClickListener(this);
	}

	private boolean isAgreen = true;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_vertify_code:
			sendCode();
			break;

		case R.id.btn_next:
			if (isAgreen) {
				// TODO
				String phone = et_mobile.getText().toString();
				String vetifyCode = et_vertify.getText().toString();
				if (checkThePhoneAndCode(phone, vetifyCode)) {
					mUser.setMobile(phone);
					mUser.setVetifyCode(vetifyCode);
					mApp.startActivity_qcj(this, RegisterActivity2.class, sendDataToBundle(mUser, null));
				}
			}

			break;
		case R.id.iv_choose:
			if (isAgreen) {
				isAgreen = false;
				btn_next.setBackgroundColor(getResources().getColor(R.color.text_more_gray));
			} else {
				isAgreen = true;
				btn_next.setBackgroundColor(getResources().getColor(R.color.main_color));
			}
			break;
		case R.id.tv_user_agreenment:
			Intent intent = new Intent();
			intent.setClass(this, UserAgreenmentActivity.class);
			startActivity(intent);
			break;
		}

	}

	private boolean checkThePhoneAndCode(String phone, String vetifyCode) {
		if (TextUtils.isEmpty(phone)) {
			ToastUtils.showToast("手机号码不能为空");
			return false;
		}
		if (TextUtils.isEmpty(vetifyCode)) {
			ToastUtils.showToast("验证码不能为空");
			return false;
		}
		return true;
	}

	/**
	 * 发送验证码
	 */
	private void sendCode() {
		String str_phonenum = et_mobile.getText().toString().trim();
		String path = MyConfig.GETCODE_URL + "mobile=" + str_phonenum + "&notify=SEND_CODE&type=register";
		NetComTools.getInstance(RegisterActivity1.this).getNetJson(path, new JsonDataListener() {
			@Override
			public void OnReceive(JSONObject jsonObject) {
				try {
					boolean success = (Boolean) jsonObject.get("data");
					if (success) {
						Toast.makeText(RegisterActivity1.this, "短信发送成功!", 1).show();
//						countTime();
					} else {
						Toast.makeText(RegisterActivity1.this, "发送失败," + jsonObject.getString("message"), 1).show();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void OnError(String error) {

			}
		});
	}

	/**
	 * 开启倒计时
	 */
	private void countTime() {

		new Thread() {
			int time = 60;// 默认为60秒 每隔一秒就减一

			@Override
			public void run() {
				while (time > 0) {
					time = time - 1;
					Message message = Message.obtain();
					message.arg1 = time;
					ToastUtils.showToast(time + "s");
					mHandle.sendMessage(message);
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
