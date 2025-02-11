package admin_user.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingDto {
	
	private String visitorNamesurname;
    private String identityNumber;
    private String addressInfull;
    private String relationship;
    private String centre;
    private String visitorEmail;
    private String visitorPhone;
    private String inmateName;
    private String inmateRegistration;
    private LocalDate visitDate;
    private LocalTime visitTime;
    private String message;
    
    
	public BookingDto(String visitorNamesurname, String identityNumber, String addressInfull, String relationship,
			String centre, String visitorEmail, String visitorPhone, String inmateName, String inmateRegistration,
			LocalDate visitDate, LocalTime visitTime, String message) {
		super();
		this.visitorNamesurname = visitorNamesurname;
		this.identityNumber = identityNumber;
		this.addressInfull = addressInfull;
		this.relationship = relationship;
		this.centre = centre;
		this.visitorEmail = visitorEmail;
		this.visitorPhone = visitorPhone;
		this.inmateName = inmateName;
		this.inmateRegistration = inmateRegistration;
		this.visitDate = visitDate;
		this.visitTime = visitTime;
		this.message = message;
	}


	


	public String getVisitorNamesurname() {
		return visitorNamesurname;
	}


	public void setVisitorNamesurname(String visitorNamesurname) {
		this.visitorNamesurname = visitorNamesurname;
	}


	public String getIdentityNumber() {
		return identityNumber;
	}


	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}


	public String getAddressInfull() {
		return addressInfull;
	}


	public void setAddressInfull(String addressInfull) {
		this.addressInfull = addressInfull;
	}


	public String getRelationship() {
		return relationship;
	}


	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}


	public String getCentre() {
		return centre;
	}


	public void setCentre(String centre) {
		this.centre = centre;
	}


	public String getVisitorEmail() {
		return visitorEmail;
	}


	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}


	public String getVisitorPhone() {
		return visitorPhone;
	}


	public void setVisitorPhone(String visitorPhone) {
		this.visitorPhone = visitorPhone;
	}


	public String getInmateName() {
		return inmateName;
	}


	public void setInmateName(String inmateName) {
		this.inmateName = inmateName;
	}


	public String getInmateRegistration() {
		return inmateRegistration;
	}


	public void setInmateRegistration(String inmateRegistration) {
		this.inmateRegistration = inmateRegistration;
	}


	public LocalDate getVisitDate() {
		return visitDate;
	}


	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}


	public LocalTime getVisitTime() {
		return visitTime;
	}


	public void setVisitTime(LocalTime visitTime) {
		this.visitTime = visitTime;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
    
	
    
	

}
