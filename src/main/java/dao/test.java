package dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import model.Item;

public class test {
	

	public static void main(String[] args) throws ParseException {
		ItemDao id = new ItemDaoImpl();
		 DateFormat df=new SimpleDateFormat("yyyy/MM/dd");
		 //增
		Item it = new Item();
//		it.setPd_id(1);
//		it.setPd_name("產品名");
//		it.setPd_description("內褲");
//		it.setPd_price(999);
//		it.setPd_qty(11);
//		it.setPd_image(null);
//		it.setPd_date(new Date(99,01,01));
//		it.setPd_last_update(new Date(99,01,01));
//		id.save(it);
		//System.out.println(id.selectItem(1).getPd_price());
		
		for (Item item : id.selectAll()) {
			System.out.println(item.getPd_price());
		}
		 //刪
//		 id.deleteById(2);
		//改
		 
	}

}
