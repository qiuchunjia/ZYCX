package qcjlibrary.model;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：上午10:48:31 类描述：这个类是实现
 *
 */

public class ModelZiXunDetail extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uid;
	private String id;
	private String title;
	private String cover;
	private String readCount;
	private String cTime;
	private String praise; // 赞的数量
	private String is_praise;// 是否赞

	// 更具需要多添加的属性
	private int fenlei_id;
	private String tag_id; // 用于标签搜索
	private String isColl; // 是否收藏

	public ModelZiXunDetail() {
		// try {
		//
		// if (jsonObject.has("uid")) {
		// this.setUid(jsonObject.getString("uid"));
		// }
		// if (jsonObject.has("id")) {
		// this.setId(jsonObject.getString("id"));
		// }
		// if (jsonObject.has("title")) {
		// this.setTitle(jsonObject.getString("title"));
		// }
		// if (jsonObject.has("cover")) {
		// this.setCover(jsonObject.getString("cover"));
		// }
		// if (jsonObject.has("readCount")) {
		// this.setReadCount(jsonObject.getString("readCount"));
		// }
		// if (jsonObject.has("cTime")) {
		// this.setcTime(jsonObject.getString("cTime"));
		// }
		//
		// } catch (JSONException e) {
		// e.printStackTrace();
		// }
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getFenlei_id() {
		return fenlei_id;
	}

	public void setFenlei_id(int fenlei_id) {
		this.fenlei_id = fenlei_id;
	}

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}

	public String getIsColl() {
		return isColl;
	}

	public void setIsColl(String isColl) {
		this.isColl = isColl;
	}

	public String getPraise() {
		return praise;
	}

	public void setPraise(String praise) {
		this.praise = praise;
	}

	public String getIs_praise() {
		return is_praise;
	}

	public void setIs_praise(String is_praise) {
		this.is_praise = is_praise;
	}

	@Override
	public String toString() {
		return "ModelZiXunDetail [uid=" + uid + ", id=" + id + ", title=" + title + ", cover=" + cover + ", readCount="
				+ readCount + ", cTime=" + cTime + ", fenlei_id=" + fenlei_id + ", tag_id=" + tag_id + "]";
	}

}
