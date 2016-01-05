package qcjlibrary.api;

import com.loopj.android.http.RequestParams;

import qcjlibrary.model.ModelQclassDetail;
import qcjlibrary.model.ModelQclassPlay;

public interface QclassIm {
	public static final String COURSE = "Course";
	public static final String SYSTEM = "System";
	public static final String INDEX = "index";
	public static final String CID= "cid";
	public static final String LIMIT= "limit";
	public static final String STATUS= "status";
	public static final String KEY= "Key";
	public static final String WATCH_NUM= "watch_num";
	public static final String GET_DETAIL= "getDetail";
	public static final String GET_COMMENT= "getComment";
	public static final String ADD_COMMENT= "addComment";
	public static final String DEFAULT_ID= "id";
	public static final String CONTENT= "content";
	
	
	/**
	 * 获取首页数据
	 * */
	
	public RequestParams index();

	/**
	 * 获取分类数据
	 * */
	public RequestParams indexItem(ModelQclassDetail detail);
	
	/**
	 * 获取详细信息
	 * */
	public RequestParams detail(ModelQclassPlay detail);
	
	/**
	 * 获取评论
	 * */
	public RequestParams getCmt(ModelQclassPlay detail);
	
	/**
	 * 发送评论
	 * */
	public RequestParams sendCmt(ModelQclassPlay detail);
}
