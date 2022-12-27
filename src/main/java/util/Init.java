package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBservice;

public class Init {

	public static void main(String[] args) throws SQLException {
		try (
				Connection con = DriverManager.getConnection(
							DBservice.getDbUrl(), 
							DBservice.getUser(),
							DBservice.getPassword()); 
				Statement stmt = con.createStatement();
			){
			stmt.executeUpdate(DBservice.getCreateItems());
			stmt.executeUpdate(DBservice.getCreateOrders());
			stmt.executeUpdate(DBservice.getCreateOrderItems());
			
			//System.out.println("dddddddddddddddddd");
		}catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
