package t6_6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Temple")
public class TempleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "templeId")
	private String templeId;   			// 編號
	
	@Column(name = "templeName")
	private String templeName;   			// 寺廟名稱
	
	@Column(name = "deitiesName")
	private String deitiesName;   			// 主祀神
	
	@Column(name = "administrative")
	private String administrative;       			// 行政區
	
	@Column(name = "address")
	private String address;				// 地址
	
	@Column(name = "register")
	private String register;     			// 登記別
	
	@Column(name = "sect")
	private String sect;     			// 教別
	
	@Column(name = "phone")
	private String phone;				// 電話
	
	@Column(name = "principal")
	private String principal;				// 負責人
	
	@Column(name = "other")
	private String other;				// 其他
	
	@Column(name = "WGS84X")
	private Double WGS84X;				// X座標
	
	@Column(name = "WGS84Y")
	private Double WGS84Y;				// Y座標
	
	@Column(name = "uniformnumbers")
	private Integer uniformnumbers;		//統一編號
//	private FileInputStream
	
	
	public TempleBean(String templeId, String templeName, String deitiesName, String administrative, String address,
			String register, String sect, String phone, String principal, String other, Double wGS84X, Double wGS84Y,
			int uniformnumbers) {
		super();
		this.templeId = templeId;
		this.templeName = templeName;
		this.deitiesName = deitiesName;
		this.administrative = administrative;
		this.address = address;
		this.register = register;
		this.sect = sect;
		this.phone = phone;
		this.principal = principal;
		this.other = other;
		this.WGS84X = wGS84X;
		this.WGS84Y = wGS84Y;
		this.uniformnumbers = uniformnumbers;
	}
	
	public TempleBean(String templeName, String deitiesName, String administrative, String address, String register,
		String sect, String phone, String principal, String other, Double wGS84X, Double wGS84Y,
		Integer uniformnumbers) {
		this.templeName = templeName;
		this.deitiesName = deitiesName;
		this.administrative = administrative;
		this.address = address;
		this.register = register;
		this.sect = sect;
		this.phone = phone;
		this.principal = principal;
		this.other = other;
		this.WGS84X = wGS84X;
		this.WGS84Y = wGS84Y;
		this.uniformnumbers = uniformnumbers;
	}



	public TempleBean() {
		
	}

	@Override
	public String toString() {
		return "編號=" + templeId + ", 廟名=" + templeName + ", 主祀神=" + deitiesName
				+ ", 行政區=" + administrative + ", 地址=" + address + ", 登記別=" + register + ", 教別="
				+ sect + ", 電話=" + phone + ", 負責人=" + principal + ", 其他=" + other + ", 座標X=" + WGS84X
				+ ", 座標Y=" + WGS84Y + ", 統一編號=" + uniformnumbers + "]";
	}

	public String getTempleId() {
		return templeId;
	}
	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}
	public String getTempleName() {
		return templeName;
	}
	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}
	public String getDeitiesName() {
		return deitiesName;
	}
	public void setDeitiesName(String deitiesName) {
		this.deitiesName = deitiesName;
	}
	public String getAdministrative() {
		return administrative;
	}
	public void setAdministrative(String administrative) {
		this.administrative = administrative;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getSect() {
		return sect;
	}
	public void setSect(String sect) {
		this.sect = sect;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Double getWGS84X() {
		return WGS84X;
	}
	public void setWGS84X(Double wGS84X) {
		WGS84X = wGS84X;
	}
	public Double getWGS84Y() {
		return WGS84Y;
	}
	public void setWGS84Y(Double wGS84Y) {
		WGS84Y = wGS84Y;
	}

	public Integer getUniformnumbers() {
		return uniformnumbers;
	}

	public void setUniformnumbers(Integer uniformnumbers) {
		this.uniformnumbers = uniformnumbers;
	}
	

}

