package t6_27.bean;

import java.sql.Blob;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id; //id
	
	@Column(name="account")
	private String account; //帳號
	
	@Column(name="name")
	private String name; //姓名
	
	@Column(name="nickName")
	private String nickName; //姓名
	
	@Column(name="password")
	private String password; //密碼
	
	@Column(name="address")
	private String address; //地址
	
	@Column(name="email")
	private String email; //郵件
	
	@Column(name="phone")
	private String phone; //電話
	
	@Column(name="gender")
	private String gender; //性別
	
	@Column(name="age")
	private Integer age; //年齡
	
	@Column(name="fileName")
	Blob image; //圖片
	private String fileName;
	
	


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
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
		builder.append(", name=");
		builder.append(name);
		builder.append(", nickName=");
		builder.append(nickName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", address=");
		builder.append(address);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", age=");
		builder.append(age);
		builder.append(", image=");
		builder.append(image);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", registerDate=");
		builder.append("]");
		return builder.toString();
	}


	// Alt + Shift + S -> O
	public Account(Integer id, String account, String name, String nickName, String password, String address,
			String email, String phone, String gender, Integer age, Blob image, String fileName) {
		super();
		this.id = id;
		this.account = account;
		this.name = name;
		this.nickName = nickName;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.image = image;
		this.fileName = fileName;
		}



	
	
}
