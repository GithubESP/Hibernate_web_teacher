package util;


public class DBservice {
	public  static final String host = "127.0.0.1";
	
	public  static final String DB_SQLSERVER = "SQLSERVER";
	private static final String DBURL_SQLServer = "jdbc:sqlserver://" + host + ":1433;databaseName=sixteamDB";
	public  static final String USERID_SQLServer = "sa";
	public  static final String PSWD_SQLServer = "sixteam";
	public  static final String nameMs = "java:comp/env/jdbc/BookDataMsSQL";
	
	private static final String CREATE_Item_SQL = "Create TABLE MyItems " 
			+ "(Pd_id            int NOT NULL IDENTITY Primary Key , "
			+ " Pd_name          varchar(100), " 
			+ " Pd_description   varchar(500), " 
			+ " Pd_price      	int, "
			+ " Pd_qty           int, " 
			+ " Pd_image        image, " 
			+ " Pd_date         datetime, "
			+ " Pd_ltime        datetime"
			+ " ) ";
	
	private static final String CREATE_Order_SQL = "Create TABLE MyOrders " 
			+ "(od_id            int NOT NULL IDENTITY Primary Key , "
			+ " od_date          datetime, " 
			+ " od_lastupdate_date   datetime, " 
			+ " cus_id      	int, "
			+ " od_address      varchar(500), " 
			+ " ) ";
	
	private static final String CREATE_OrderItem_SQL = "Create TABLE MyOrderItems " 
			+ "(od_id          int NOT NULL , "
			+ " Pd_id          int NOT NULL , "
			+ " PRIMARY KEY(od_id,Pd_id)"
			+ " ) ";
	
	public static String getCreateItems() {
		String create = null;
		
			create = CREATE_Item_SQL;
		
		return create;
	}
	
	
	public static String getDbUrl() {
		String url = null;
		
			url = DBURL_SQLServer;
		
		System.out.println("url=" + url);
		return url;
	}

	public static String getUser() {
		String user = null;
		
			user = USERID_SQLServer;
		
		return user;
	}

	public static String getPassword() {
		String pswd = null;
		
			pswd = PSWD_SQLServer;
		
		return pswd;
	}
	
	public static String getCreateOrders() {
		String create = null;
		
			create = CREATE_Order_SQL;
		
		return create;
	}
	
	public static String getCreateOrderItems() {
		String create = null;
		
			create = CREATE_OrderItem_SQL;
		
		return create;
	}
	
}
