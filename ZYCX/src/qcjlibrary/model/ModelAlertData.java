package qcjlibrary.model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import qcjlibrary.model.base.Model;

public class ModelAlertData extends Model {

	/**
	 * 用药提醒数据实体类
	 */
	private static final long serialVersionUID = 7231591816696089340L;

	private int id;
	private String user;// 用药者名称
	private String medicine;// 药品名称
	private String med_time;// 重复时间列表，逗号隔开
	private String stime;// 开始时间
	private String period;// 周期
	private String ctime;// 周期
	private int med_num;// 提醒次数
	private boolean isExit;// 是否已经存在
	private int is_remind;// 是否开启

	public ModelAlertData() {
		super();
	}

	public ModelAlertData(JSONObject data) {
		try {
			if (data.has("id")) {
				setId(data.getInt("id"));
			}
			if (data.has("user")) {
				setUser(data.getString("user"));
			}
			if(data.has("medicine")){
				setMedicine(data.getString("medicine"));
			}
			if(data.has("stime")){
				setStime(data.getString("stime"));
			}
			if(data.has("period")){
				setPeriod(data.getString("period"));
			}
			if(data.has("med_num")){
				setMed_num(data.getInt("med_num"));
			}
			if(data.has("is_remind")){
				setIs_remind(data.getInt("is_remind"));
			}
			if(data.has("ctime")){
				setCtime(data.getString("ctime"));
			}
			if(data.has("med_time")){
				JSONArray timeArray = data.getJSONArray("med_time");
				int len = timeArray.length();
				String timeStr = "";
				for (int i = 0; i < len; i++) {
					//JSONObject item = timeArray.getJSONObject(i);
					timeStr = timeStr +","+timeArray.getString(i);
				}
				timeStr = timeStr.substring(1, timeStr.length() - 1);
				setMed_time(timeStr);
			}
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getMed_time() {
		return med_time;
	}

	public void setMed_time(String med_time) {
		this.med_time = med_time;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getMed_num() {
		return med_num;
	}

	public void setMed_num(int med_num) {
		this.med_num = med_num;
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}

	public int getIs_remind() {
		return is_remind;
	}

	public void setIs_remind(int is_remind) {
		this.is_remind = is_remind;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	
}
