package qcjlibrary.model;

import qcjlibrary.model.base.Model;

public class ModelSearchIndex extends Model{

	/**
	 * 首页不同的页面跳转到搜索界面时的下标Index
	 */
	private static final long serialVersionUID = 3814794010669978396L;

	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
