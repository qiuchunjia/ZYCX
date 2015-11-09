package qcjlibrary.model;

import org.json.JSONException;
import org.json.JSONObject;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午2:49:44 类描述：这个类是实现
 *
 */

public class ModelMsg extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int status;
	private String msg;

	public ModelMsg(JSONObject jsonObject) {
		try {

			if (jsonObject.has("status")) {
				this.setStatus(jsonObject.getInt("status"));
			}
			if (jsonObject.has("msg")) {
				this.setMsg(jsonObject.getString("msg"));
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
