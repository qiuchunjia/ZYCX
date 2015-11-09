package com.zhiyicx.zycx;

import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zhiyicx.zycx.config.MyConfig;
import com.zhiyicx.zycx.modle.HttpReturnData;
import com.zhiyicx.zycx.net.JsonDataListener;
import com.zhiyicx.zycx.net.NetComTools;
import com.zhiyicx.zycx.tools.MyDesCoder;
import com.zhiyicx.zycx.util.Utils;

/**
 * 设置新密码类
 *
 * @author Mr . H
 *
 */
public class SetNewPd extends Activity implements OnClickListener
{
    final private static String TAG = "SetNewPd";
    private ImageButton mIbBtn_next;
    private TextView tv_showpicturecode;
    private ImageButton mIB_forget_getcode;
    private EditText et_phoneOrmail, et_forget_phonecode, et_forget_picturecode;
    String accountNumber, codeNumber;
    HttpReturnData httpReturnData = new HttpReturnData();

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.forget_password_layout);
        getPictureCode();
        initView();
    }

    private void initView()
    {
        tv_showpicturecode = (TextView) findViewById(R.id.tv_showpicturecode);
        mIbBtn_next = (ImageButton) findViewById(R.id.btn_forget_next);
        mIB_forget_getcode = (ImageButton) findViewById(R.id.IB_forget_getcodephone);
        et_phoneOrmail = (EditText) findViewById(R.id.et_phoneOrmail);
        et_forget_phonecode = (EditText) findViewById(R.id.et_forget_phonecode);
        et_forget_picturecode = (EditText) findViewById(R.id.et_forget_picturecode);
        tv_showpicturecode.setOnClickListener(this);
        mIbBtn_next.setOnClickListener(this);
        mIB_forget_getcode.setOnClickListener(this);
        findViewById(R.id.btn_back).setOnClickListener(this);

    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tv_showpicturecode:
                getPictureCode();
                break;

            case R.id.btn_forget_next:
                btn_Next();
                break;

            case R.id.IB_forget_getcodephone:
                getCode();
                break;
            case R.id.btn_back:
                finish();
        }
    }

    /**
     * 下一步，发送手机或者邮箱和验证码
     */
    public void btn_Next()
    {
        if (!strContrast())
        {
            Toast.makeText(getApplicationContext(), "图片验证码错误", 0).show();
        } else
        {

            accountNumber = et_phoneOrmail.getText().toString().trim();
            httpReturnData.setStrForgetAccountNum(accountNumber);
            codeNumber = et_forget_phonecode.getText().toString().trim();
            // httpReturnData.setStrForgetPhoneCode(codeNumber);
            String path = MyConfig.FORGET_BTN_NEXT_URL + "&uid=" + URLEncoder.encode(accountNumber) + "&verify=" + URLEncoder.encode(codeNumber);

            NetComTools.getInstance(this).getNetJson(path, new JsonDataListener() {
                @Override
                public void OnReceive(JSONObject jsonObject) {
                    Log.d(TAG, "User test jsonObject:" + jsonObject.toString());
                    try {
                        boolean success = (Boolean)jsonObject.get("data");
                        if(success)
                        {
                            Log.d(TAG, "User test success!");
                            String numsString = jsonObject.getString("code");
                            httpReturnData.setStrForgetBtnNextRData(numsString);
                            jumpResetWdUI();
                        }else
                        {
                        	String txt = jsonObject.optString("message", "验证失败");
                        	Utils.showToast(SetNewPd.this, txt);
                            //Log.d(TAG, "User test fail," + (String)jsonObject.get("message"));
                        }
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                @Override
                public void OnError(String error) {
                    Log.d(TAG, "User test error, " + error);
                }
            });
        }
    }

    /**
     * 跳转重新设置密码界面
     */
    public void jumpResetWdUI()
    {
        if (httpReturnData.getStrForgetBtnNextRData().equals("0"))
        {
            Intent intent = new Intent();
            intent.setClass(SetNewPd.this, SureNewPd.class);
            Bundle bundle = new Bundle();
            bundle.putString("accountNum", et_phoneOrmail.getText().toString().trim());
            bundle.putString("accountCode", et_forget_phonecode.getText().toString().trim());
            intent.putExtras(bundle);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "跳转重新设置密码界面", 0).show();
        } else
        {
            Toast.makeText(getApplicationContext(), "验证码错误", 0).show();
        }
    }

    /**
     * 获取。找回密码界面中的手机验证码获取邮箱验证码
     */
    public void getCode()
    {
        String str = et_phoneOrmail.getText().toString();
        if (str.indexOf("@") > -1)
        {
            accountNumber = et_phoneOrmail.getText().toString().trim();
            String pictureCodeString = et_forget_picturecode.getText().toString().trim();
            String path = MyConfig.FORGETMAIL_URL + "&email=" + URLEncoder.encode(accountNumber) + "&notify=mail_code" + "&type=recover" + "&verify=" + pictureCodeString + "&_debug=hequanli";
            NetComTools.getInstance(this).getNetJson(path, new JsonDataListener() {
                @Override
                public void OnReceive(JSONObject jsonObject) {
                    try {
                        boolean success = (Boolean)jsonObject.get("data");
                        if(success)
                        {
                            //Log.d(TAG, "Send code to mail success!");
                            Utils.showToast(SetNewPd.this, "验证码发送成功");
                        }else
                        {
                        	String txt = jsonObject.optString("message", "验证码发送失败");
                        	Utils.showToast(SetNewPd.this, txt);
                            //Log.d(TAG, "Send code to mail fail," + (String)jsonObject.get("message"));
                        }
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                @Override
                public void OnError(String error) {
                	Utils.showToast(SetNewPd.this, "验证码发送失败");
                    Log.d(TAG, "Send code to mail error, " + error);
                }
            });
        } else
        {
            accountNumber = et_phoneOrmail.getText().toString().trim();
            String pictureCodeString = et_forget_picturecode.getText().toString().trim();
            String path = MyConfig.FORGETPHONE_URL + "&mobile=" + URLEncoder.encode(accountNumber) + "&notify=SEND_CODE" + "&type=recover" + "&verify=" + pictureCodeString + "&_debug=hequanli";
            NetComTools.getInstance(this).getNetJson(path, new JsonDataListener() {
                @Override
                public void OnReceive(JSONObject jsonObject) {
                    try {
                        boolean success = (Boolean)jsonObject.get("data");
                        if(success)
                        {
                            //Log.d(TAG, "Send code to phone success!");
                        	Utils.showToast(SetNewPd.this, "验证码发送成功");
                        }else
                        {
                            //Log.d(TAG, "Send code to phone fail," + (String)jsonObject.get("message"));
                        	String txt = jsonObject.optString("message", "验证码发送失败");
                        	Utils.showToast(SetNewPd.this, txt);
                        }
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                @Override
                public void OnError(String error) {
                	Utils.showToast(SetNewPd.this, "验证码发送失败");
                    Log.d(TAG, "Send code to phone error, " + error);
                }
            });
        }
    }

    /**
     * 获取。找回密码界面中的图片验证码
     */
    public void getPictureCode()
    {
        String path = MyConfig.PICTURECODE_URL + "mode=1" + "&length=4";
        NetComTools.getInstance(this).getNetJson(path, new JsonDataListener() {
            @Override
            public void OnReceive(JSONObject jsonObject) {
                jsonPictureCode(jsonObject);
            }

            @Override
            public void OnError(String error) {
                Log.d(TAG, "Get picture dode error, "+ error);
            }
        });

    }

    /**
     * 设置图片验证码
     *
     * @param string
     *            网络请求返回数据
     */
    public void jsonPictureCode(JSONObject jsonObject)
    {
        try
        {
            String dataString = MyDesCoder.decodeValue("THINKSNS", (String) jsonObject.get("data"));
            tv_showpicturecode.setText(dataString);
            httpReturnData.setStrForgetPictureCode(dataString);
        } catch (JSONException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 图片验证码
     *
     * 判断用户输入的验证和产生的验证码是否一样
     */
    public boolean strContrast()
    {
        String strPicetureCode = et_forget_picturecode.getText().toString().trim();
        if (strPicetureCode.equals(httpReturnData.getStrForgetPictureCode()))
        {
            return true;
        } else
        {
            return false;
        }
    }
}
