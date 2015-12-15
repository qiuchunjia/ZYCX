package qcjlibrary.model;

import org.json.JSONException;
import org.json.JSONObject;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午2:24:04 类描述：这个类是实现
 *
 */

public class ModelExperienceSend extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/****
	 * weiba_id 微吧id 必填
	 * 
	 * parent_id 上级帖子id 选填
	 * 
	 * title 标题 必填
	 * 
	 * post_time 时间 必填
	 * 
	 * body 内容 必填
	 * 
	 * tags 标签 多个以逗号隔开 至少一个 必填
	 * 
	 * oauth_token 必须
	 * 
	 * oauthtokensecret 必须
	 * 
	 * 
	 * ****/
	private String weiba_id;
	private String parent_id;
	private String title;
	private String post_time;
	private String body;
	private String tags;

	public String getWeiba_id() {
		return weiba_id;
	}

	public void setWeiba_id(String weiba_id) {
		this.weiba_id = weiba_id;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPost_time() {
		return post_time;
	}

	public void setPost_time(String post_time) {
		this.post_time = post_time;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
