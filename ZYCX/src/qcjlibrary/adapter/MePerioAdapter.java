package qcjlibrary.adapter;

import java.util.List;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.adapter.base.ViewHolder;
import qcjlibrary.api.api.PeriodicalImpl;
import qcjlibrary.api.api.ZhiXunImpl;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelPeriodical;
import qcjlibrary.model.ModelPeriodicalIndex;
import qcjlibrary.model.ModelZiXun;
import qcjlibrary.model.ModelZiXunDetail;
import qcjlibrary.model.base.Model;
import qcjlibrary.response.DataAnalyze;
import qcjlibrary.util.L;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:06:10
 * 
 * 类描述：期刊首页数据适配器
 *
 */

public class MePerioAdapter extends BAdapter {

	
	public MePerioAdapter(BaseActivity activity, List<Model> list) {
		super(activity, list);
	}

	public MePerioAdapter(BaseFragment fragment, List<Model> list) {
		super(fragment, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_me_periodical, null);
			initView(convertView, holder);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		bindDataToView(holder, position);
		return convertView;
	}

	private void bindDataToView(ViewHolder holder, int position) {
		if (holder != null) {
			L.d("Cathy", "mList adapter:"+mList.size());
			ModelPeriodical mData = (ModelPeriodical) mList.get(position);
			mApp.displayImage(mData.getCover(), holder.iv_perio_icon);
			holder.tv_title.setText(mData.getPeriodical_name());
			holder.tv_date.setText(mData.getCtime());
			holder.tv_title_flag.setText(mData.getPeriodical_num());
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
			holder.iv_perio_icon = (ImageView) convertView
					.findViewById(R.id.iv_perio_icon);
			holder.tv_title = (TextView) convertView
					.findViewById(R.id.tv_title);
			holder.tv_title_flag = (TextView) convertView
					.findViewById(R.id.tv_title_flag);
			holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
		}
	}

	@Override
	public void refreshNew() {
		requstMessage(new ModelPeriodical(), REFRESH_NEW);
	}

	@Override
	public void refreshHeader(Model item, int count) {
		if(item instanceof ModelPeriodical){
			ModelPeriodical mData = (ModelPeriodical) item;
			mData.setLastid(mData.getSort()+"");
			requstMessage(mData, REFRESH_HEADER);
		}
	}

	@Override
	public void refreshFooter(Model item, int count) {
		if(item instanceof ModelPeriodical){
			ModelPeriodical mData = (ModelPeriodical) item;
			mData.setMaxid(mData.getSort()+"");
			requstMessage(mData, REFRESH_FOOTER);
		}
	}

	@Override
	public int getTheCacheType() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Object getReallyList(Object object, Class type2) {
		if(object instanceof List<?>){
			@SuppressWarnings("unchecked")
			List<ModelPeriodical> list = (List<ModelPeriodical>) object;
			return list;
		}
		return null;
	}

	private void requstMessage(ModelPeriodical mData, int type) {
		PeriodicalImpl impl = new PeriodicalImpl();
		sendRequest(impl.index(mData), ModelPeriodical.class, REQUEST_GET, type);
	}
	
	@Override
	public Object onResponceSuccess(String str, Class class1) {
		// TODO 自动生成的方法存根
		return DataAnalyze.parseData(str, class1);
	}

}
