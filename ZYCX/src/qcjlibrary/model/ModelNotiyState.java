package qcjlibrary.model;

import qcjlibrary.model.base.Model;

public class ModelNotiyState extends Model{
	/**
	 * 是否已读
	 */
	private static final long serialVersionUID = 739012560173073715L;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
