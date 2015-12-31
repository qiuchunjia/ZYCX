package qcjlibrary.model;

import java.util.List;

import qcjlibrary.model.base.Model;

public class ModelQclass extends Model {

	/**
	 * 轻课堂数据
	 * 
	 * @author Tan @since12.31
	 */
	private static final long serialVersionUID = -4835093238000671993L;

	private List<ModelQclassDetail> list;
	private List<ModelQclassCategory> category;

	public List<ModelQclassDetail> getList() {
		return list;
	}
	public void setList(List<ModelQclassDetail> list) {
		this.list = list;
	}
	public List<ModelQclassCategory> getCategory() {
		return category;
	}
	public void setCategory(List<ModelQclassCategory> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ModelQclass [list=" + list + ", category=" + category + "]";
	}
}
