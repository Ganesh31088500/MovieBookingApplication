package com.ganesh.MovieBooking.dto;

public class ContactServiceDTO {
	private Integer contactId;
	private String name;
	private String emailId;
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "ContactService [contactId=" + contactId + ", name=" + name + ", emailId=" + emailId + "]";
	}
}
