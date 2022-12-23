package t6_21class.createTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import t6_21class.bean.ClassBean;
import t6_21class.bean.MemberBean;
import t6_21class.util.ConnectionSMMS;


public class insertClass {
	
	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元
	static QueryRunner queryRunner =new QueryRunner(ConnectionSMMS.createMSSQLConnection());
	
	
	public static void insertIntoClassTables() {
		
	}
	
	public static void main(String[] args) throws IOException, SQLException {

		
		File file = new File("data/classList.dat");
		
		String line = "";

		int count = 0;

		try (FileInputStream fis = new FileInputStream(file);
				 InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				 BufferedReader br = new BufferedReader(isr);
			) {
				while ((line = br.readLine()) != null) {
					System.out.println("line=" + line);
					// 去除 UTF8_BOM: \uFEFF
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					ClassBean cl = new ClassBean();
//					cl.setClassId(Integer.parseInt(token[0].trim()));
					cl.setClassName(token[1]);
					cl.setClassTeacher(token[2].trim());
					cl.setClassPrice(Double.parseDouble(token[3].trim()));
//					cl.setDiscount(Double.parseDouble(token[4].trim()));
					// 讀取圖片檔
					Blob blob1 = DBService.fileToBlob(token[5].trim());
					cl.setClassPicture(blob1);
					cl.setClassCategory(token[6].trim());
					
					saveClass(cl);
				}
				// 印出資料新增成功的訊息
				System.out.println("Book資料新增成功");
			}
		
		File file2 = new File("data/memberList.dat");
		
		String line2 = "";

		int count2 = 0;
		
		try(     FileInputStream fis = new FileInputStream(file2);
				 InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				 BufferedReader br = new BufferedReader(isr);
            ) {
			while ((line2 = br.readLine()) != null) {
				System.out.println("line=" + line2);
				// 去除 UTF8_BOM: \uFEFF
				if (line2.startsWith(UTF8_BOM)) {
					line2 = line2.substring(1);
				}
				String[] token = line2.split("\\|");
				MemberBean mb = new MemberBean();
				mb.setMemberId(Integer.parseInt(token[0].trim()));
				mb.setMemberAccount(token[1]);
				mb.setMemberPassword(token[2]);
				
				saveMember(mb);
			}
			
		} catch (Exception e) {
			System.out.println("Member資料新增成功");
		}
	}
	
	public static void saveClass(ClassBean classbean) {
		QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());

	String sqls = "insert into ClassTables"
			+ "(className,classTeacher,classPrice,classPicture,classCategory)"+ "VALUES (,?,?,?,?,?)";

	try {		
		int result= queryRunner.update(sqls,classbean.getClassName(),classbean.getClassTeacher(),classbean.getClassPrice(),classbean.getClassPicture(),classbean.getClassCategory());
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	public static void saveMember(MemberBean memberBean) {
		QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());

	String sqls = "insert into MemberTable"
			+ "(memberId,memberAccount,memberPassword)"+ "VALUES (?,?,?)";

	try {		
		int result= queryRunner.update(sqls,memberBean.getMemberId(),memberBean.getMemberAccount(),memberBean.getMemberPassword());
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


}
