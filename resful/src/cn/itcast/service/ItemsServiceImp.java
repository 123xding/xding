package cn.itcast.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.dao.ItemsMapper;
import cn.itcast.pojo.Items;

@Service
public class ItemsServiceImp implements ItemServices {
	@Resource
    private ItemsMapper itemsMapper;
	@Override
	public List<Items> findItemsList() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	//根据id查询项目信息
	@Override
	public Items getItemsDetailById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}
	//修改
	@Override
	public void updateItems(Items items) {
		itemsMapper.updateByPrimaryKeySelective(items);
	}

}
