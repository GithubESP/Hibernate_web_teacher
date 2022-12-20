package t6_10.bean;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Alt + Shift + S -> S [toString]
// Alt + Shift + S -> O [Constructor]
// Alt + Shift + S -> R [get set]

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id; //id
	
	@Column(name = "account")
	String account; //帳號
	
	@Column(name = "img")
	Blob image; //圖片
	
	@Column(name = "password")
	String password; //密碼
	
//	String name; //姓名
//	String nickName; //姓名
//	
//
//	String address; //地址
//	String email; //郵件
//	String phone; //電話
//	String gender; //性別
//	Integer age; //年齡
//	
//
//	String fileName;
//	
//
//	Timestamp registerDate; //註冊時間
//	Timestamp lastConsumptionDate; //最後消費時間
//	Timestamp lastLoginDate; //最後登入時間
//	Integer consumption; //消費總額
	

	
	public Account(Integer id, String account, String password, Blob image) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.image = image;
	}


	public Account(Integer id, String account, String password) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
	}
	
	public Account(Integer id) {
		super();
		this.id = id;
	}
	
	
	public Account() {
//		super();
	}




	// Alt + Shift + S -> S
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}





	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}




	public Blob getImage() {
		return image;
	}


	public void setImage(Blob image) {
		this.image = image;
	}

	




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=");
		builder.append(id);
		builder.append(", account=");
		builder.append(account);
		builder.append(", image=");
		builder.append(image);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}


	public Account(Integer id, String account, Blob image, String password) {
		super();
		this.id = id;
		this.account = account;
		this.image = image;
		this.password = password;
	}


	// Alt + Shift + S -> O




	
	
}
