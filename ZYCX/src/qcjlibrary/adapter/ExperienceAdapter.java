package qcjlibrary.adapter;

import java.util.List;

import com.zhiyicx.zycx.R;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import qcjlibrary.activity.CancerSingleActivity;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.base.ViewHolder;
import qcjlibrary.model.ModelExperience;
import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午5:06:10
 * 
 * 类描述：这个类是实现专家提问列表
 *
 */

public class ExperienceAdapter extends BaseAdapter {
	private BaseActivity mActivity;
	private List<ModelExperience> mList;
	private LayoutInflater mInflater;

	public ExperienceAdapter(BaseActivity baseActivity, List<ModelExperience> list) {
		this.mActivity = baseActivity;
		this.mList = list;
		mInflater = LayoutInflater.from(mActivity);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_experience_gv, null);
			initView(convertView, holder);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		bindDataToView(holder, position);
		return convertView;
	}

	@SuppressLint("NewApi")
	private void bindDataToView(ViewHolder holder, int position) {
		if (holder != null) {
			ModelExperience experience = mList.get(position);
			if (experience != null) {
				mActivity.mApp.displayImage(experience.getLogo(), holder.iv_cancer_icon);
				holder.tv_cancer_name.setText(experience.getWeiba_name());
				holder.tv_cancer_numer.setText("成员： " + experience.getFollower_count());
				holder.tv_cancer_experence.setText("经历： " + experience.getThread_count());
				holder.rl_1.setTag(experience);
				holder.rl_1.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Model model = (Model) v.getTag();
						mActivity.mApp.startActivity_qcj(mActivity, CancerSingleActivity.class,
								mActivity.sendDataToBundle(model, null));
					}
				});
			}

		}
	}

	/**
	 * 初始化布局
	 * 
	 * @param convertView
	 * @param holder
	 */
	private void initView(View convertView, ViewHolder holder) {
		if (convertView != null && holder != null) {
			holder.iv_cancer_icon = (ImageView) convertView.findViewById(R.id.iv_cancer_icon);
			holder.tv_cancer_name = (TextView) convertView.findViewById(R.id.tv_cancer_name);
			holder.tv_cancer_numer = (TextView) convertView.findViewById(R.id.tv_cancer_numer);
			holder.tv_cancer_experence = (TextView) convertView.findViewById(R.id.tv_cancer_experence);
			holder.rl_1 = (RelativeLayout) convertView.findViewById(R.id.rl_1);

		}
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
}
