package cn.itcast.pojo;

import java.util.List;

public class QueryVo {
	private Items items;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	private Integer[] ids;

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	//批量删除列表
    private List<Items> updateitemsList;

	public List<Items> getUpdateitemsList() {
		return updateitemsList;
	}
	public void setUpdateitemsList(List<Items> updateitemsList) {
		this.updateitemsList = updateitemsList;
	}
    

}
