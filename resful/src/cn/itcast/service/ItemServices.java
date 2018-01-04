package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Items;

public interface ItemServices {
	public List<Items> findItemsList();

	public Items getItemsDetailById(Integer id);

	public void updateItems(Items items);

}
