package t6_21class.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="memberTable")
public class  MemberBean{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="memberId")
	int memberId;
	@Column(name="memberAccount")
	String memberAccount;
	@Column(name="memberPassword")
	String memberPassword;
	public MemberBean(int memberId, String memberAccount, String memberPassword) {
		super();
		this.memberId = memberId;
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
	}
	public int getMemberId() {
		return memberId;
	}
	
	public MemberBean(String memberAccount, String memberPassword) {
		super();
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public MemberBean() {
		super();
	}
	

}
