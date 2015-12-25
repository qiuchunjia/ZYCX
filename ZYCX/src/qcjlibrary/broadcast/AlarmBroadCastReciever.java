package qcjlibrary.broadcast;

import android.content.Context;
import android.content.Intent;
import qcjlibrary.broadcast.base.BaseBroadCast;
import qcjlibrary.util.ToastUtils;

public class AlarmBroadCastReciever extends BaseBroadCast{

	
	@Override
	public void onReceive(Context context, Intent intent) {
		String mAction = intent.getAction();
		//开机广播
		if(mAction.equals(Intent.ACTION_BOOT_COMPLETED)){
		}
		if(mAction.equals("alarm.alert.short")){
			ToastUtils.showLongToast(context, "该吃药了！！");
			//发送通知
			sendNotification(context);
			//播放短提示音
			context.startService(new Intent("alert_music"));
		}
	}

	private void sendNotification(Context context) {
		//推送？
	}
	
}
