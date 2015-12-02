package qcjlibrary.adapter;

import java.util.List;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.adapter.base.ViewHolder;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.base.Model;
import qcjlibrary.widget.RoundImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:06:10
 * 
 * 类描述：这个类是实现专家提问列表
 *
 */

public class ExperienceCycleAdapter extends BAdapter {
	private final int TYPETITLE = 0; // title
	private final int TYPECONTENT = 1;// 日历轨迹

	public ExperienceCycleAdapter(BaseActivity activity, List<Model> list) {
		super(activity, list);
	}

	public ExperienceCycleAdapter(BaseFragment fragment, List<Model> list) {
		super(fragment, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		int type = judgeTheType(position);
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = initView(holder, type);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		bindDataToView(holder, position, type);
		return convertView;
	}

	/**
	 * 判断加载哪一个界面
	 * 
	 * @param pos
	 * @return
	 */
	private int judgeTheType(int pos) {
		if (pos == TYPETITLE) {
			return TYPETITLE;
		}
		return TYPECONTENT;
	}

	private void bindDataToView(ViewHolder holder, int position, int type) {
		if (holder != null) {
			// TODO 添加数据
		}
	}

	/**
	 * 初始化布局
	 * 
	 * @param convertView
	 * @param holder
	 */
	private View initView(ViewHolder holder, int type) {
		View view = null;
		if (holder != null) {
			if (type == TYPETITLE) {
				view = mInflater.inflate(R.layout.item_experience_cycle_title,
						null);
				holder.iv_cycle_icon = (RoundImageView) view
						.findViewById(R.id.iv_cycle_icon);
				holder.tv_username = (TextView) view
						.findViewById(R.id.tv_username);
				holder.tv_has_update = (TextView) view
						.findViewById(R.id.tv_has_update);
				holder.tv_flag_key = (TextView) view
						.findViewById(R.id.tv_flag_key);
				holder.tv_flag_value = (TextView) view
						.findViewById(R.id.tv_flag_value);
				holder.tv_date = (TextView) view.findViewById(R.id.tv_date);
			} else if (type == TYPECONTENT) {
				view = mInflater.inflate(R.layout.item_experience_cycle, null);
				holder.tv_date_mouth = (TextView) view
						.findViewById(R.id.tv_date_mouth);
				holder.tv_date_day = (TextView) view
						.findViewById(R.id.tv_date_day);
				holder.tv_date_week = (TextView) view
						.findViewById(R.id.tv_date_week);
				holder.tv_date_year = (TextView) view
						.findViewById(R.id.tv_date_year);
				holder.tv_date_content = (TextView) view
						.findViewById(R.id.tv_date_content);
			}
		}
		return view;
	}

	@Override
	public void refreshNew() {
		sendRequest(null, null, 1, 1);
	}

	@Override
	public void refreshHeader(Model item, int count) {
		sendRequest(null, null, 1, 1);
	}

	@Override
	public void refreshFooter(Model item, int count) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getItemViewType(int position) {
		return judgeTheType(position);
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getTheCacheType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Model> getReallyList(Object object, Class type2) {
		// TODO Auto-generated method stub
		return null;
	}

}
