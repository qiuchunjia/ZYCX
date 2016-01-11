package qcjlibrary.model;

import java.util.List;

import qcjlibrary.model.base.Model;

public class ModelAlertList extends Model{

	/**
	 * 闹钟列表
	 */
	private static final long serialVersionUID = -8863490505229643556L;

	private List<ModelAlertData> list;

	public List<ModelAlertData> getList() {
		return list;
	}

	public void setList(List<ModelAlertData> list) {
		this.list = list;
	}
	
}
