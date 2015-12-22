package qcjlibrary.model;

import qcjlibrary.model.base.Model;

public class ModelAlertData extends Model{

	/**
	 * 用药提醒数据实体类
	 */
	private static final long serialVersionUID = 7231591816696089340L;
	
	private int id;
	private String userName;//用药者名称
	private String medicineName;//药品名称
	private int repeatDay;//重复频率
	private String alertTime;//提醒时间
	private String startTime;//开始时间
	private int repeatCount;//重复次数，最多四次
	private boolean isFirst;//是否第一次设置
	
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public int getRepeatCount() {
		return repeatCount;
	}
	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getRepeatDay() {
		return repeatDay;
	}
	public void setRepeatDay(int repeatDay) {
		this.repeatDay = repeatDay;
	}
	public String getAlertTime() {
		return alertTime;
	}
	public void setAlertTime(String alertTime) {
		this.alertTime = alertTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	
}
