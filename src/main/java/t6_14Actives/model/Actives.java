package t6_14Actives.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "templeActive")
public class Actives {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activeID;
	
	private String activeName;
	
	private Blob activeImg;
	
	private String activeDescription;
	
	public Actives(String activeName, String activeDescription, Date activeStartDate, Date activeEndDate,
			String activeLocation, String activeHost) {
		super();
		this.activeName = activeName;
		this.activeDescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}





	private Date activeStartDate;
	private Date activeEndDate;
	
	private String activeLocation;
	private String activeHost;
	
	
	
	

	public Actives(Integer activeID, String activeName, String activeDescription, Date activeStartDate,
			Date activeEndDate, String activeLocation, String activeHost) {
		super();
		this.activeID = activeID;
		this.activeName = activeName;
		this.activeDescription = activeDescription;
		this.activeStartDate = activeStartDate;
		this.activeEndDate = activeEndDate;
		this.activeLocation = activeLocation;
		this.activeHost = activeHost;
	}





	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Actives [activeID=").append(activeID).append(", activeName=").append(activeName)
				.append(", activeImg=").append(activeImg).append(", activeDescription=").append(activeDescription)
				.append(", activeStartDate=").append(activeStartDate).append(", activeEndDate=").append(activeEndDate)
				.append(", activeLocation=").append(activeLocation).append(", activeHost=").append(activeHost)
				.append("]");
		return builder.toString();
	}





	public Integer getActiveID() {
		return activeID;
	}





	public void setActiveID(Integer activeID) {
		this.activeID = activeID;
	}





	public String getActiveName() {
		return activeName;
	}





	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}





	public Blob getActiveImg() {
		return activeImg;
	}





	public void setActiveImg(Blob activeImg) {
		this.activeImg = activeImg;
	}





	public String getActiveDescription() {
		return activeDescription;
	}





	public void setActiveDescription(String activeDescription) {
		this.activeDescription = activeDescription;
	}





	public Date getActiveStartDate() {
		return activeStartDate;
	}





	public void setActiveStartDate(Date activeStartDate) {
		this.activeStartDate = activeStartDate;
	}





	public Date getActiveEndDate() {
		return activeEndDate;
	}





	public void setActiveEndDate(Date activeEndDate) {
		this.activeEndDate = activeEndDate;
	}





	public String getActiveLocation() {
		return activeLocation;
	}





	public void setActiveLocation(String activeLocation) {
		this.activeLocation = activeLocation;
	}





	public String getActiveHost() {
		return activeHost;
	}





	public void setActiveHost(String activeHost) {
		this.activeHost = activeHost;
	}





	public Actives() {
	}

}
