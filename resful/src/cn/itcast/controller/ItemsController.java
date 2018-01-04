package cn.itcast.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.itcast.exception.CustomerException;
import cn.itcast.pojo.Items;
import cn.itcast.pojo.QueryVo;
import cn.itcast.service.ItemServices;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Resource
	private ItemServices itemsService;
	@RequestMapping(value="/list",method=RequestMethod.GET)
    public String  findItemsList(Model model) throws CustomerException{
		//商品列表（临时数据）
		List<Items> itemsList = itemsService.findItemsList();
		// 将查询结果返回给页面
		// 在底层就相当于request.setAttribute(属性名, 属性值)
		model.addAttribute("itemsList", itemsList);
		return "itemList";
    }
	//修改
	@RequestMapping(value="/detail/{itemId}",method=RequestMethod.GET)
	public String  getItemsDetailById(@PathVariable(value="itemId") Integer id,Model model){
		/*Integer id=Integer.valueOf(request.getParameter("id"))*/;
		Items items=itemsService.getItemsDetailById(id);
		//设置返回给页面的数据
		model.addAttribute("item", items);
		return "editItem";
	}
	//更新
	@RequestMapping(value="/detail",method=RequestMethod.PUT)
	public String updateItem(Items items) throws IllegalStateException, IOException{
		itemsService.updateItems(items);
		return "redirect:/items/detail/"+items.getId();
	}
	//查询
	@RequestMapping("/queryitem")
	public String searchItems(QueryVo query){
		System.out.println(query);
		return "success";
	}
	//测试json-pojo
	@RequestMapping(value="/detail",method=RequestMethod.DELETE)
	@ResponseBody
	public Items sendJson(@RequestBody Items items){
		System.out.println(items);
		items.setDetail("aaaa");
		return items;
	}

}
