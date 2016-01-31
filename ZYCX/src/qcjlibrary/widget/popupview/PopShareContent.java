package qcjlibrary.widget.popupview;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.SocializeEntity;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.util.Utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import qcjlibrary.config.Config;
import qcjlibrary.model.ModelShareContent;
import qcjlibrary.util.ToastUtils;
import qcjlibrary.widget.popupview.base.PopView;

public class PopShareContent extends PopView {
	private LinearLayout ll_share_1;
	private LinearLayout ll_share_2;
	private LinearLayout ll_share_3;
	private LinearLayout ll_share_4;
	private LinearLayout ll_share_5;
	private LinearLayout ll_share_6;
	private TextView tv_share_cancel;
	private UMSocialService mController;
	private ModelShareContent mShareContent;

	public PopShareContent(Activity activity, Object object, PopResultListener resultListener) {
		super(activity, object, resultListener);
	}

	@Override
	public int getLayoutId() {
		return R.layout.pop_share_content;
	}

	@Override
	public void initPopView() {
		ll_share_1 = (LinearLayout) findViewbyId(R.id.ll_share_1);
		ll_share_2 = (LinearLayout) findViewbyId(R.id.ll_share_2);
		ll_share_3 = (LinearLayout) findViewbyId(R.id.ll_share_3);
		ll_share_4 = (LinearLayout) findViewbyId(R.id.ll_share_4);
		ll_share_5 = (LinearLayout) findViewbyId(R.id.ll_share_5);
		ll_share_6 = (LinearLayout) findViewbyId(R.id.ll_share_6);
		tv_share_cancel = (TextView) findViewbyId(R.id.tv_share_cancel);

	}

	@Override
	public void initPopData(Object object) {
		mController = UMServiceFactory.getUMSocialService("com.umeng.share");
		if (object instanceof ModelShareContent) {
			mShareContent = (ModelShareContent) object;
			if (mShareContent.getType().equals(Config.SHARE_TEXT)) {
				Utils.shareText(mActivity, mController, mShareContent.getTitle(), mShareContent.getUrl());
			} else if (mShareContent.getType().equals(Config.SHARE_VIDEO)) {
				Utils.shareVidoe(mActivity, mController, mShareContent.getTitle(), mShareContent.getUrl());
			}
		}

	}

	@Override
	public void setPopLisenter(PopResultListener listener) {
		ll_share_1.setOnClickListener(new MyOnclickListener());
		ll_share_2.setOnClickListener(new MyOnclickListener());
		ll_share_3.setOnClickListener(new MyOnclickListener());
		ll_share_4.setOnClickListener(new MyOnclickListener());
		ll_share_5.setOnClickListener(new MyOnclickListener());
		ll_share_6.setOnClickListener(new MyOnclickListener());
		tv_share_cancel.setOnClickListener(new MyOnclickListener());
	}

	// 发短信
	private void sendSMS(String content) {
		Uri smsToUri = Uri.parse("smsto:");
		Intent sendIntent = new Intent(Intent.ACTION_VIEW, smsToUri);
		sendIntent.putExtra("sms_body", content);
		sendIntent.setType("vnd.android-dir/mms-sms");
		mActivity.startActivity(sendIntent);
	}

	private class MyOnclickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.ll_share_1:
				sendSMS(mShareContent.getTitle() + mShareContent.getUrl());
				break;

			case R.id.ll_share_2:
				mController.directShare(mActivity, SHARE_MEDIA.WEIXIN, mShareListener);
				break;

			case R.id.ll_share_3:
				mController.directShare(mActivity, SHARE_MEDIA.WEIXIN_CIRCLE, mShareListener);
				break;

			case R.id.ll_share_4:
				mController.directShare(mActivity, SHARE_MEDIA.TENCENT, mShareListener);
				break;

			case R.id.ll_share_5:
				mController.directShare(mActivity, SHARE_MEDIA.QQ, mShareListener);
				break;

			case R.id.ll_share_6:
				mController.directShare(mActivity, SHARE_MEDIA.SINA, mShareListener);
				break;
			case R.id.tv_share_cancel:
				mPopWindow.dismiss();
				break;

			}
		}

	}

	/**
	 * 分享监听器
	 */
	SnsPostListener mShareListener = new SnsPostListener() {

		@Override
		public void onStart() {

		}

		@Override
		public void onComplete(SHARE_MEDIA platform, int stCode, SocializeEntity entity) {
			if (stCode == 200) {
				ToastUtils.showToast("分享成功");
			} else if(stCode == 0000) {
				ToastUtils.showToast("分享失败" + stCode);
			}
			mPopWindow.dismiss();
		}
	};
}
