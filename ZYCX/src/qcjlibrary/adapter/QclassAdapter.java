package qcjlibrary.adapter;

import java.util.List;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.adapter.base.ViewHolder;
import qcjlibrary.api.api.QclassImpl;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelQclass;
import qcjlibrary.model.ModelQclassDetail;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.SpanUtil;

/**
 * 轻课堂分类数据适配器
 * 
 * @author Tan
 * @since 12.31
 */

public class QclassAdapter extends BAdapter {

	private ModelQclassDetail detail;
	private String update_head;
	private String update_tail;
	private int status;

	public QclassAdapter(BaseActivity activity, List<Model> list) {
		super(activity, list);
	}

	public QclassAdapter(BaseFragment fragment, List<Model> mList, ModelQclassDetail detail) {
		super(fragment, mList);
		this.detail = detail;
		update_head = "已更新";
		update_tail = "课";
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_qing_class, null);
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
			ModelQclassDetail mDetail = (ModelQclassDetail) mList.get(position);
			if (mDetail != null) {
				holder.tv_title.setText(mDetail.getCourse_name());
				holder.tv_content.setText(mDetail.getContent());
				String watch_num = mDetail.getWatch_num() + "";
				if (watch_num.length() > 3) {
					watch_num = "999+";
				}
				holder.tv_num.setText(watch_num);
				holder.tv_update.setText("");
				holder.tv_update.append(update_head);
				holder.tv_update.append(SpanUtil.setForegroundColorSpan(mDetail.getVideo_num() + "", 0, 0,
						mBaseActivity.getResources().getColor(R.color.text_yellow)));
				holder.tv_update.append(update_tail);
				mApp.displayImage(mDetail.getCover(), holder.iv_vedio);
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
			holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			holder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
			holder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);
			holder.tv_update = (TextView) convertView.findViewById(R.id.tv_update);
			holder.iv_vedio = (ImageView) convertView.findViewById(R.id.iv_vedio);
		}
	}

	@Override
	public void refreshNew() {
		detail.setStatus(status);
		requstMessage(detail, REFRESH_NEW);
	}

	@Override
	public void refreshHeader(Model item, int count) {
		refreshNew();
		// if (item instanceof ModelQclassDetail) {
		// ModelQclassDetail detail = (ModelQclassDetail) item;
		// detail.setStatus(status);
		// detail.setLastid(detail.getCourse_id() + "");
		// requstMessage(detail, REFRESH_HEADER);
		// }
	}

	@Override
	public void refreshFooter(Model item, int count) {
		if (item instanceof ModelQclassDetail) {
			ModelQclassDetail detailitem = (ModelQclassDetail) item;
			detail.setStatus(status);
			detail.setLastid(detailitem.getCourse_id() + "");
			requstMessage(detail, REFRESH_FOOTER);
		}
	}

	@Override
	public int getTheCacheType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getReallyList(Object object, Class type2) {
		if (object instanceof ModelQclass) {
			ModelQclass mQclass = (ModelQclass) object;
			if (status == 2 && mList != null) {
				mList.clear();
			}
			return mQclass.getList();
		}
		return null;
	}

	/**
	 * 请求咨询内容
	 * 
	 * @param data
	 * @param type
	 */
	private void requstMessage(ModelQclassDetail data, int type) {
		QclassImpl qClassImpl = new QclassImpl();
		sendRequest(qClassImpl.indexItem(data), ModelQclass.class, 0, type);
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
