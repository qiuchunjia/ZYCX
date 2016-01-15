package qcjlibrary.model;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午2:24:04 类描述：这个类是实现
 *
 */

public class ModelExperienceDetailItem1 extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/****
	 * "post_id":"16", "lasted_time":"1449631546", "childCount":1,
	 * "recommend":"0", "total_comments":0, "username":"我们要不要那么早起来", "content":
	 * "Dddddd is only one who is the best thing", "title":"do you think"
	 * 
	 * 
	 * 
	 ****/
	private String post_id;
	private String weiba_id;

	private String lasted_time;
	private String childCount;
	private String recommend;
	private String total_comments;
	private String username;
	private String content;
	private String title;

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getWeiba_id() {
		return weiba_id;
	}

	public void setWeiba_id(String weiba_id) {
		this.weiba_id = weiba_id;
	}

	public String getLasted_time() {
		return lasted_time;
	}

	public void setLasted_time(String lasted_time) {
		this.lasted_time = lasted_time;
	}

	public String getChildCount() {
		return childCount;
	}

	public void setChildCount(String childCount) {
		this.childCount = childCount;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getTotal_comments() {
		return total_comments;
	}

	public void setTotal_comments(String total_comments) {
		this.total_comments = total_comments;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
