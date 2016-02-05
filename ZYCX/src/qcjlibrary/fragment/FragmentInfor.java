package qcjlibrary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.config.Config;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.L;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.adapter.ZiXunListAdapter;
import com.zhiyicx.zycx.fragment.BaseListFragment;
import com.zhiyicx.zycx.activity.QClassDetailsActivity;
import com.zhiyicx.zycx.activity.ZiXUnContentActivity;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import com.zhiyicx.zycx.sociax.listener.OnTouchListListener;
import com.zhiyicx.zycx.sociax.unit.Anim;
import com.zhiyicx.zycx.util.Utils;
import com.zhiyicx.zycx.widget.LoadListView;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/1/17.
 */
public class FragmentInfor extends BaseListFragment {

    private ZiXunListAdapter mAdapter;
    private LoadListView mListView;
    private String key = null;
    private boolean isLoad = false;
    private boolean isCreate = false;

    @Override
    public OnTouchListListener getListView() {
        return mListView;
    }

    @Override
    public void doRefreshHeader() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mCustView = inflater.inflate(R.layout.zixun_list, container, false);
        mListView = (LoadListView)mCustView.findViewById(R.id.zixun_list);
        loadData(false);
        mListView.setDividerHeight(0);
        mListView.setOnItemListener(new LoadListView.OnItemListener() {
            @Override
            public void onClick(View view, int position, long id) {
                JSONObject jsonObject = mAdapter.getItem(position-1);
                try {
                    int _id = jsonObject.getInt("id");
                    int uid = jsonObject.getInt("uid");
                    String title = jsonObject.getString("title");
                    Intent intent = new Intent(mContext, ZiXUnContentActivity.class);
                    intent.putExtra("id", _id);
                    intent.putExtra("uid", uid);
                    intent.putExtra("title", title);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                    Anim.in(mContext);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Model model = (Model) parent.getItemAtPosition(position);
				Bundle bundle = new Bundle();
				bundle.putSerializable(Config.ACTIVITY_TRANSFER_BUNDLE, model);
				Intent mIntent = new Intent(mContext, ZiXUnContentActivity.class);
				mIntent.putExtras(bundle);
				startActivity(mIntent);
				Anim.in(mContext);
			}
		});
        ArrayList<JSONObject> data = new ArrayList<JSONObject>();
        mAdapter = new ZiXunListAdapter(this, data, -2);
        mListView.setAdapter(mAdapter, System.currentTimeMillis(), mContext);
        mListView.setVisibility(View.INVISIBLE);
        mAdapter.loadSearchData(Utils.getUTF8String(""));
        return mCustView;
    }

    @Override
    public void onResume() {
        super.onResume();
//       if(!isLoad){
//        }
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
			}
			
			@Override
			public void onSearchTouch_Info(String key) {
				setKey(key);
				mAdapter.loadSearchData(Utils.getUTF8String(key));
		        mListView.setSelectionFromTop(0, 20);
//		        isLoad = true;
			}
			
			@Override
			public void onSearchTouch_Food(String key) {
			}
		});
        
    }
    
    private void setKey(String key){
    	this.key = Utils.getUTF8String(key);
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
