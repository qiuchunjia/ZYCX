package qcjlibrary.model;

import qcjlibrary.model.base.Model;

public class ModelShareContent extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type; // 分享的类型
	private String title; // 分享的标题
	private String url; // 分享的链接

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
