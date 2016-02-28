package qcjlibrary.adapter.base;

import android.view.View;

	/**
	 * 用于在适配器中请求数据时使用
	 * */
public interface OnRequestLinstner {
	/**
	 * 请求失败
	 * */
	public void onFailed(View view);
	/**
	 * 请求成功
	 * */
	public void onSuccess(View view);
}
