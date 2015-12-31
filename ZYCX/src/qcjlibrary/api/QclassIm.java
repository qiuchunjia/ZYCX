package qcjlibrary.api;

import com.loopj.android.http.RequestParams;

import qcjlibrary.model.ModelQclassDetail;

public interface QclassIm {
	public static final String COURSE = "Course";
	public static final String SYSTEM = "System";
	public static final String INDEX = "index";
	public static final String CID= "cid";
	public static final String LIMIT= "limit";
	public static final String STATUS= "status";
	public static final String KEY= "Key";
	public static final String WATCH_NUM= "watch_num";
	
	
	/**
	 * 获取首页数据
	 * */
	
	public RequestParams index();

	/**
	 * 获取分类数据
	 * */
	public RequestParams indexItem(ModelQclassDetail detail);
	
	
}
