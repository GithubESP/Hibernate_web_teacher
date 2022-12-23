package t6_21class.bean;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="classTables")
public class ClassBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="classId")
	private int classId;
//	private String classIdStr;
//	private String classNo;
	@Column(name="className")
	private String className;
	@Column(name="classTeacher")
	private String classTeacher;
	@Column(name="classPrice")
	private Double classPrice;
//	@Column(name="classPriceStr")
//	private String classPriceStr;
	@Column(name="classCategory")
	private String classCategory;
//	@Column(name="discount")
//	private Double discount;
	@Column(name="classPicture")
	private Blob classPicture;
//	private String discountStr;
	
//	public String getClassIdStr() {
//		return classIdStr;
//	}
//	
//	public void setClassIdStr(String classIdStr) {
//		this.classIdStr = classIdStr;
//	}
	public ClassBean(int classId, String className, String classTeacher, Double classPrice, String classCategory,
			Double discount, Blob classPicture) {
		super();
		this.classId = classId;
		this.className = className;
		this.classTeacher = classTeacher;
		this.classPrice = classPrice;
		this.classCategory = classCategory;
//		this.discount = discount;
		this.classPicture = classPicture;
	}
	
	public ClassBean(String className, String classTeacher, Double classPrice, String classCategory,
			Blob classPicture) {
		super();
		this.className = className;
		this.classTeacher = classTeacher;
		this.classPrice = classPrice;
		this.classCategory = classCategory;
		this.classPicture = classPicture;
	}
	public ClassBean(int classId,String className, String classTeacher, Double classPrice, String classCategory,
			Blob classPicture) {
		super();
		this.classId = classId;
		this.className = className;
		this.classTeacher = classTeacher;
		this.classPrice = classPrice;
		this.classCategory = classCategory;
		this.classPicture = classPicture;
	}

	public ClassBean(int classId, String classNo, String className, String classTeacher, Double classPrice,
			String classPriceStr, String classCategory, Double discount, Blob classPicture, String discountStr) {
		super();
		this.classId = classId;
//		this.classNo = classNo;
		this.className = className;
		this.classTeacher = classTeacher;
		this.classPrice = classPrice;
//		this.classPriceStr = classPriceStr;
		this.classCategory = classCategory;
//		this.discount = discount;
		this.classPicture = classPicture;
//		this.discountStr = discountStr;
	}

	public ClassBean() {
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}
	public Double getClassPrice() {
		return classPrice;
	}
	public void setClassPrice(Double classPrice) {
		this.classPrice = classPrice;
	}
	public String getClassCategory() {
		return classCategory;
	}
	public void setClassCategory(String classCategory) {
		this.classCategory = classCategory;
	}
//	public Double getDiscount() {
//		return discount;
//	}
//	public void setDiscount(Double discount) {   //0.8, 0.75
//		this.discount = discount;
//		if (discount == 1) {
//			discountStr = "";
//		} else {
//			int dnt = (int)(discount * 100);
//			if (dnt % 10 == 0) {
//				discountStr = (dnt / 10) + "折";
//			} else {
//				discountStr = " "  + dnt + "折";
//			} 
//			
//		}
//	}
	public Blob getClassPicture() {
		return classPicture;
	}
	public void setClassPicture(Blob blob) {
		this.classPicture = blob;
	}

//	public String getDiscountStr() {
//		return discountStr;
//	}
	
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + ", classTeacher=" + classTeacher
				+ ", classPrice=" + classPrice + ", classCategory=" + classCategory 
				+ ", classPicture=" + classPicture +  "]";
	}
//	public String getClassPriceStr() {
//		return classPriceStr;
//	}
//	public void setClassPriceStr(String classPriceStr) {
//		this.classPriceStr = classPriceStr;
//	}
//	public String getClassNo() {
//		return classNo;
//	}
//	public void setClassNo(String classNo) {
//		this.classNo = classNo;
//	}
	public String getDescription() {
		return getClassTeacher().substring(0, 3) + " " 
				+ getClassName();
	}

}
