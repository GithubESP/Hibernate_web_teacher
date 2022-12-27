package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Item;
import util.DBservice;

public class ItemDaoImpl implements ItemDao {

	DataSource ds = null;

	//增
	public static PreparedStatement link(String sql) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(DBservice.getDbUrl(), DBservice.getUser(),
		DBservice.getPassword());
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}
	
	
	@Override    
	public void insert(Item item)  {
		String sql = "INSERT INTO MyItems " + " ( Pd_name, Pd_description, Pd_price, "
				+ " Pd_qty, Pd_image, Pd_date, Pd_ltime) " + " VALUES ( ?, ?, ?, ?, ?, ?, ?)";
		try (
				PreparedStatement ps=ItemDaoImpl.link(sql);)
		{	
			
			ps.setString(1, item.getPd_name());
			ps.setString(2, item.getPd_description());
			ps.setInt(3, item.getPd_price());
			ps.setInt(4, item.getPd_qty());
			ps.setBlob(5, item.getPd_image());
			ps.setDate(6, (Date) item.getPd_date());
			ps.setDate(7, (Date) item.getPd_last_update());
			ps.executeUpdate();
			System.out.println("yes");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("err");
			e.printStackTrace();
		}

	}
	
	//刪
	public void deleteById(int Pd_id) {
		String sql = "DELETE FROM MyItems WHERE Pd_id = ?";

		try (PreparedStatement ps=ItemDaoImpl.link(sql);
		) {
			ps.setInt(1, Pd_id);
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#deleteBook()發生例外: " 
										+ ex.getMessage());
		}
	}
	
	
	//改
	public void updateItem(Item item) {
		String sql = "UPDATE MyItems SET " 
				+ " Pd_name=?,  Pd_description=?,  Pd_price=?, Pd_qty = ?, Pd_image = ?, "
				+ " Pd_date=?, Pd_ltime=? WHERE Pd_Id = ?";
		try (
				PreparedStatement ps=ItemDaoImpl.link(sql);){
			ps.setString(1, item.getPd_name());
			ps.setString(2, item.getPd_description());
			ps.setInt(3, item.getPd_price());
			ps.setInt(4, item.getPd_qty());
			ps.setBlob(5, item.getPd_image());
			ps.setDate(6, (Date) item.getPd_date());
			ps.setDate(7, (Date) item.getPd_last_update());
			ps.setInt(8, item.getPd_id());
			ps.executeUpdate();
			System.out.println("yes");
			
		}catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
	}
		
	
}
	
	//查
		public Item selectItem(int Pd_id) {
			Item item = new Item();
			String sql = "SELECT * FROM MyItems WHERE Pd_id = ?";
			try {
					
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection(DBservice.getDbUrl(), DBservice.getUser(),
				DBservice.getPassword());
				PreparedStatement ps = con.prepareStatement(sql);
					
				ps.setInt(1, Pd_id);
				try (
					ResultSet rs = ps.executeQuery();
				){
					while (rs.next()) {
						// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
						    	
						item.setPd_id(rs.getInt("Pd_id"));
						item.setPd_name(rs.getString("Pd_name"));
						item.setPd_description(rs.getString("Pd_description"));
						item.setPd_price(rs.getInt("Pd_price"));
						item.setPd_qty(rs.getInt("Pd_qty"));
						item.setPd_image(rs.getBlob("Pd_image"));
						item.setPd_date(rs.getDate("Pd_date"));
						item.setPd_last_update(rs.getDate("Pd_ltime"));
				}
					con.close();
				}catch (SQLException ex) {
					ex.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return item;
}
		//查多筆
		public List<Item> selectAll() {
			
			List<Item> list = new ArrayList<>();
			String sql = "SELECT * FROM MyItems ";
			try {
					
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection(DBservice.getDbUrl(), DBservice.getUser(),
				DBservice.getPassword());
				PreparedStatement ps = con.prepareStatement(sql);
					
		
				try (
					ResultSet rs = ps.executeQuery();
							
				){
					while (rs.next()) {
						// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
						Item item = new Item();
							item.setPd_id(rs.getInt("Pd_id"));
							item.setPd_name(rs.getString("Pd_name"));
							item.setPd_description(rs.getString("Pd_description"));
							item.setPd_price(rs.getInt("Pd_price"));
							item.setPd_qty(rs.getInt("Pd_qty"));
							item.setPd_image(rs.getBlob("Pd_image"));
							item.setPd_date(rs.getDate("Pd_date"));
							item.setPd_last_update(rs.getDate("Pd_ltime"));
							list.add(item);
						
						
				}
					con.close();
				}catch (SQLException ex) {
					ex.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return list;
}


		@Override
		public List<Item> search(String type, String word) {
			List<Item> list = new ArrayList<>();
			String sql = "SELECT * FROM MyItems WHERE "+type+" LIKE '%"+word+"%'";
			try {
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection(DBservice.getDbUrl(), DBservice.getUser(),
				DBservice.getPassword());
				PreparedStatement ps = con.prepareStatement(sql);
					
		
				try (
					ResultSet rs = ps.executeQuery();
							
				){
					while (rs.next()) {
						// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
						Item item = new Item();
							item.setPd_id(rs.getInt("Pd_id"));
							item.setPd_name(rs.getString("Pd_name"));
							item.setPd_description(rs.getString("Pd_description"));
							item.setPd_price(rs.getInt("Pd_price"));
							item.setPd_qty(rs.getInt("Pd_qty"));
							item.setPd_image(rs.getBlob("Pd_image"));
							item.setPd_date(rs.getDate("Pd_date"));
							item.setPd_last_update(rs.getDate("Pd_ltime"));
							list.add(item);
						
						
				}
					con.close();
				}catch (SQLException ex) {
					ex.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return list;
		}


		@Override
		public void close() {
			// TODO Auto-generated method stub
			
		}


		
}
