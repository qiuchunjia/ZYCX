package qcjlibrary.fragment;

import java.util.ArrayList;

import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.config.Config;
import qcjlibrary.model.ModelQclassDetail;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.L;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.activity.QClassDetailsActivity;
import com.zhiyicx.zycx.adapter.QClassListAdapter;
import com.zhiyicx.zycx.fragment.BaseListFragment;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import com.zhiyicx.zycx.sociax.listener.OnTouchListListener;
import com.zhiyicx.zycx.sociax.unit.Anim;
import com.zhiyicx.zycx.util.Utils;
import com.zhiyicx.zycx.widget.LoadListView;

/**
 * 轻课堂 搜索
 * @author Tan
 * @since 12.30
 */
public class FragmentQclass extends BaseListFragment implements LoadListView.OnItemListener
{

    private QClassListAdapter mAdapter;
    private LoadListView mList;
    private String key = null;
    private boolean isLoad = false;
    private boolean isCreate = false;

    @Override
    public OnTouchListListener getListView() {
        return mList;
    }

    @Override
    public void doRefreshHeader() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mCustView = inflater.inflate(R.layout.qclass_list_layout, container, false);
        mList = (LoadListView) mCustView.findViewById(android.R.id.list);
        ArrayList<JSONObject> data = new ArrayList<JSONObject>();
        mAdapter = new QClassListAdapter(this, data, -2);
        mList.setAdapter(mAdapter, System.currentTimeMillis(), mContext);
        mList.setOnItemListener(this);
        mList.setVisibility(View.INVISIBLE);
//        mList.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Model model = (Model) parent.getItemAtPosition(position);
//				Bundle bundle = new Bundle();
//				bundle.putSerializable(Config.ACTIVITY_TRANSFER_BUNDLE, model);
//				Intent mIntent = new Intent(getActivity(), QClassDetailsActivity.class);
//				mIntent.putExtras(bundle);
//				startActivity(mIntent);
//			}
//		});
        mAdapter.loadSearchData(Utils.getUTF8String(""));
        return mCustView;
    }

    @Override
    public void onClick(View view, int position, long id) {
        JSONObject jsonObject = mAdapter.getItem(position-1);
        try {
            int _id = jsonObject.getInt("course_id");
            String img_url = jsonObject.getString("cover");
            Bundle bundle = new Bundle();
            ModelQclassDetail model = new ModelQclassDetail();
            model.setCourse_id(_id);
            model.setCover(img_url);
			bundle.putSerializable(Config.ACTIVITY_TRANSFER_BUNDLE, model);
            Intent intent = new Intent(mContext, QClassDetailsActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
            Anim.in(mContext);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        if(!isLoad){
        	loadData(false);
//        }
    }

    @Override
	public void loadData(boolean isLoadNew) {
    	
    	Thinksns.searchAct.setOnSearchListener(new OnSearchTouchListerer() {
			
			@Override
			public void onSearchTouch_Weibo(String key) {
			}
			
			@Override
			public void onSearchTouch_Request(String key) {
			}
			
			@Override
			public void onSearchTouch_Qclass(String key) {
				setKey(key);
				mAdapter.loadSearchData(Utils.getUTF8String(key));
				mList.setSelectionFromTop(0, 20);
//				isLoad = true;
			}
			
			@Override
			public void onSearchTouch_Info(String key) {
			}
			
			@Override
			public void onSearchTouch_Food(String key) {
			}
		});
        
    }

    public void doSearch(String key)
    {
        if(TextUtils.isEmpty(key))
            return;
        this.key = Utils.getUTF8String(key);
        if(mContext != null) {
            loadData(false);
        }
    }
    
    private void setKey(String key){
    	this.key = key;
    }
    
    //仅当可见时才加载内容
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
    	// TODO 自动生成的方法存根
    	super.setUserVisibleHint(isVisibleToUser);
    	
    	if(!isCreate){
    		return;
    	}
    	if(isVisibleToUser){
//    		loadData(true);
    	}
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// TODO 自动生成的方法存根
    	super.onCreate(savedInstanceState);
    	isCreate = true;
    }
}
