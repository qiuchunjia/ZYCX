package com.zhiyicx.zycx.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.fragment.BaseListFragment;
import com.zhiyicx.zycx.modle.NetData;
import com.zhiyicx.zycx.net.NetComTools;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/1/14.
 */
public class ZiXunListAdapter extends LoadListAdapter {

	private Context mContext = null;
	private int mType = 0;
	private LayoutInflater mInflater = null;
	private String mKey = null;

	public ZiXunListAdapter(BaseListFragment ctx, ArrayList<JSONObject> list,
			int type) {
		super(ctx, list);
		mContext = ctx.mContext;
		mType = type;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public void refreshNew(Handler handler, int count) throws Exception {
		NetData.getZiXunNewList(mContext, handler, count, mType);
	}

	@Override
	public void refreshHeader(Handler handler, JSONObject obj) throws Exception {
		int id = 0;
		if (obj != null)
			id = obj.optInt("id");
		NetData.ZiXunRefHeaderList(mContext, handler, 20, mType, id);
	}

	@Override
	public void refreshFooter(Handler handler, JSONObject obj) throws Exception {
		int id = 0;
		if (obj != null)
			id = obj.optInt("id");
		if (mKey != null)
			NetData.ZiXunSearchList(mContext, handler, 20, mKey, id);
		else
			NetData.ZiXunRefFooterList(mContext, handler, 20, mType, id);
	}

	@Override
	public void searchNew(Handler handler, String key) throws Exception {
		mKey = key;
		NetData.ZiXunSearchList(mContext, handler, 20, key, -1);
	}

	class ViewHolder {
		TextView mTitle;
		TextView mDate;
		TextView mReads;
		TextView mFrom;
		ImageView mPreview;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		ViewHolder holder;
		if (view == null) {
			view = mInflater.inflate(R.layout.item_zhixun, null);
			holder = new ViewHolder();
			holder.mTitle = (TextView) view.findViewById(R.id.tv_content);
			holder.mDate = (TextView) view.findViewById(R.id.tv_date);
			holder.mReads = (TextView) view.findViewById(R.id.tv_num);
			holder.mFrom = (TextView) view.findViewById(R.id.tv_from);
			holder.mPreview = (ImageView) view
					.findViewById(R.id.iv_photo);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		try {
			JSONObject jsonObject = list.get(i);
			holder.mTitle.setText(jsonObject.get("title").toString());
			holder.mDate.setText(jsonObject.get("cTime").toString());
			String count = jsonObject.get("readCount").toString();
			if(count.length() > 3){
				count = "999+";
			}
			holder.mReads.setText(count);
			NetComTools.getInstance(mContext).loadNetImage(holder.mPreview,
					jsonObject.get("cover").toString(), R.drawable.bg_loading,
					144, 144);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return view;
	}
}
