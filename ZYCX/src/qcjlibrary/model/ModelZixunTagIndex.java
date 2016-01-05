package qcjlibrary.model;

import java.util.List;

import qcjlibrary.model.base.Model;

public class ModelZixunTagIndex extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ModelZiXunDetail> list;
	private String tag_name;

	public List<ModelZiXunDetail> getList() {
		return list;
	}

	public void setList(List<ModelZiXunDetail> list) {
		this.list = list;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
