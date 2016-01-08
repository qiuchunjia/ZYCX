package qcjlibrary.model;

import org.json.JSONException;
import org.json.JSONObject;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：上午10:48:31 类描述：这个类是实现
 *
 */

public class ModelZiXunCategory extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private int fenlei_id;
	private String isColl;

	public ModelZiXunCategory() {

	}

	public ModelZiXunCategory(JSONObject jsonObject) {
//		try {
//
//			if (jsonObject.has("title")) {
//				this.setTitle(jsonObject.getString("title"));
//			}
//			if (jsonObject.has("fenlei_id")) {
//				this.setFenlei_id((jsonObject.getInt("fenlei_id")));
//			}
//
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFenlei_id() {
		return fenlei_id;
	}

	public void setFenlei_id(int fenlei_id) {
		this.fenlei_id = fenlei_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getIsColl() {
		return isColl;
	}

	public void setIsColl(String isColl) {
		this.isColl = isColl;
	}

	@Override
	public String toString() {
		return "ModelZiXunCategory [title=" + title + ", fenlei_id="
				+ fenlei_id + "]";
	}

}
