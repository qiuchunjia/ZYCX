package qcjlibrary.model;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午2:24:04 类描述：这个类是实现
 *
 */

public class ModelExperiencePostDetailItem extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/****
	 * 
	 "post_id": "7", "ctime": "1447815508", "content": "ddddd", "url":
	 * "http://demo-qingko.zhiyicx.com/index.php?app=weiba&mod=Index&act=api_post_detail&post_id=7"
	 * , "childCount": 2
	 * 
	 * ****/
	private String post_id;
	private String ctime;
	private String content;
	private String url;
	private String childCount;

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getChildCount() {
		return childCount;
	}

	public void setChildCount(String childCount) {
		this.childCount = childCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
