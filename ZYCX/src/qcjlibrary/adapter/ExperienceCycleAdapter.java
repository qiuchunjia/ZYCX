package qcjlibrary.adapter;

import java.util.List;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.adapter.base.ViewHolder;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelExperienceDetailItem1;
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

	public ExperienceCycleAdapter(BaseActivity activity,
			ModelExperienceDetailItem1 detailItem1) {
		super(activity, null);
	}

	public ExperienceCycleAdapter(BaseFragment fragment,
			ModelExperienceDetailItem1 detailItem1) {
		super(fragment, null);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = initView(holder);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		bindDataToView(holder, position);
		return convertView;
	}

	private void bindDataToView(ViewHolder holder, int position) {
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
	private View initView(ViewHolder holder) {
		View view = null;
		if (holder != null) {
			view = mInflater.inflate(R.layout.item_experience_cycle, null);
			holder.tv_date_mouth = (TextView) view
					.findViewById(R.id.tv_date_mouth);
			holder.tv_date_day = (TextView) view.findViewById(R.id.tv_date_day);
			holder.tv_date_week = (TextView) view
					.findViewById(R.id.tv_date_week);
			holder.tv_date_year = (TextView) view
					.findViewById(R.id.tv_date_year);
			holder.tv_date_content = (TextView) view
					.findViewById(R.id.tv_date_content);
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
