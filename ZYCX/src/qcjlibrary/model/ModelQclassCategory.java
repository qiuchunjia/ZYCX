package qcjlibrary.model;

import qcjlibrary.model.base.Model;

public class ModelQclassCategory extends Model{

	/**
	 * 轻课堂分类数据
	 * @author Tan
	 * @since 12.31
	 */
	private static final long serialVersionUID = 8993545251297646048L;

	private int class_id;
	private String imooc_class_name;
	private int sort;
	
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getImooc_class_name() {
		return imooc_class_name;
	}
	public void setImooc_class_name(String imooc_class_name) {
		this.imooc_class_name = imooc_class_name;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	@Override
	public String toString() {
		return "ModelQclassDetail [class_id="+class_id+", imooc_class_name="
				+imooc_class_name+", sort="+sort+"]";
	}
}
