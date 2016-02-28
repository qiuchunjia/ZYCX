package qcjlibrary.adapter;

import qcjlibrary.util.DisplayUtils;
import qcjlibrary.util.UIUtils;
import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午2:59:55 类描述：这个类是实现
 *
 */

public class FoodFuctionGvAdapter extends BaseAdapter {
	private Context mContext;
	private String[] mData;
	private LayoutInflater mInflater;
	private int mSingleWidth;

	public FoodFuctionGvAdapter(Context context, String[] strings) {
		this.mContext = context;
		this.mData = strings;
		mInflater = LayoutInflater.from(mContext);
		int width = UIUtils.getWindowWidth(mContext)
				- DisplayUtils.dp2px(mContext, 40);
		mSingleWidth = width / 3;
	}

	@Override
	public int getCount() {
		return mData.length;
	}

	@Override
	public Object getItem(int position) {
		return mData[position];
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = new TextView(mContext);
		GridView.LayoutParams params = new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT,
				GridView.LayoutParams.WRAP_CONTENT);
//		GridView.LayoutParams params = new GridView.LayoutParams(mSingleWidth,
//				GridView.LayoutParams.WRAP_CONTENT);
		textView.setLayoutParams(params);
		textView.setGravity(Gravity.CENTER);
		textView.setMaxLines(1);
		textView.setEllipsize(TruncateAt.END);
		textView.setBackgroundResource(R.drawable.view_border_gray_16);
		textView.setTextColor(mContext.getResources().getColor(
				R.color.text_gray));
		textView.setTextSize(17);
		textView.setText(mData[position]);
		return textView;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
