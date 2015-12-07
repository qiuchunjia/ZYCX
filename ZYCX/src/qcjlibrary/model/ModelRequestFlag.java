package qcjlibrary.model;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午3:51:40 类描述：这个类是实现
 *
 */

public class ModelRequestFlag extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * "domain":"1976", "title":"测试"
	 */
	private String domain;
	private String title;

	public ModelRequestFlag() {
		// TODO Auto-generated constructor stub
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
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
