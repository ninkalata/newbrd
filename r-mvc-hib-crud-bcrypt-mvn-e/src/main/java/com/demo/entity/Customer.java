package com.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code")
	private int code;

	@Column(name = "customerName")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$" ,message = "Invalid name")
	@NotNull(message = "Invalid name")
    private String customerName;

	@Column(name = "customerAddress")
	@NotNull(message = "Invalid Address")
	private String customerAddress;

	@Column(name = "customerPinCode")
    @Size(max=6,message = "Pin code should be 6 digits")
	@NotNull(message = "Pin code should be 6 digits")
    private String customerPinCode;
	
	@NotEmpty(message = "Email address cannot be empty")
	@Email(message = "Invalid email address, e.g. valid email address: example@gmail.com")
	@Column(name = "customerEmail")
	private String customerEmail;

	@Column(name = "contactNumber")
	@NotNull(message = "Invalid contact Number")
	private String contactNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "registrationDate")
    private Date registrationDate;

	@Column(name = "createdBy")
	@NotNull(message = "Invalid ")
	private String createdBy;

	@Column(name = "modifiedDate")
	@NotNull(message = "Invalid ")
	private String modifiedDate;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPinCode() {
		return customerPinCode;
	}

	public void setCustomerPinCode(String customerPinCode) {
		this.customerPinCode = customerPinCode;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(java.util.Date now) {
		this.registrationDate = (Date) now;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Customer [code=" + code + ", customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", customerPinCode=" + customerPinCode + ", customerEmail=" + customerEmail + ", contactNumber="
				+ contactNumber + ", registrationDate=" + registrationDate + ", createdBy=" + createdBy
				+ ", modifiedDate=" + modifiedDate + "]";
	}



}