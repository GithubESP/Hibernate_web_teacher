package t6_21class.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class  ConnectionSMMS {
	public static HikariDataSource createMSSQLConnection() {
		HikariConfig config = new HikariConfig("C:\\_SpringBoot\\workspaceA\\SecondServlet\\src\\main\\java\\jdbc.properties");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	
	}
}
