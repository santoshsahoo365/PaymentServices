package com.photonInfotech.citiBankPOC.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.photonInfotech.citiBankPOC.validation.annotation.Phone;

import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Country cannot be null")
	@Size(min = 2, max = 35, message = "Country must be 2 to 35 characters")
	private String country;

	@NotNull(message = "State cannot be null")
	@Size(min = 2, max = 30, message = "State must be 2 to 30 characters")
	private String state;

	@NotNull(message = "City cannot be null")
	@Size(min = 2, max = 100, message = "City must be 2 to 100 characters")
	private String city;

	@NotNull(message = "ZipCode cannot be null")
	@Size(min = 2, max = 30, message = "Zipcode must be 2 to 30 characters")
	private String zipcode;

	@NotNull(message = "Address Line1 cannot be null")
	@Size(min = 2, max = 100, message = "Address Line 1 must be 2 to 100 characters")
	private String addressLine1;

	private String addressLine2;

	@Phone(message = "Phone number must be 10 digits and allowed formats are 1234567890,123-456-7890,(123)456-7890")
	@Column(unique = true, nullable = false)
	@NotNull(message = "Phone Number cannot be null")
	private String phoneNo;

	@NotNull(message = "Mobile Number or not cannot be null")
	private boolean isMobileNumber;

	@NotNull(message = "Enabled or not cannot be null")
	private boolean enabled;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Set<AddressType> addressType;

	public Address() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo.replaceAll("[().\\s-]+", "");
	}

	public boolean isMobileNumber() {
		return isMobileNumber;
	}

	public void setMobileNumber(boolean isMobileNumber) {
		this.isMobileNumber = isMobileNumber;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<AddressType> getAddressType() {
		return addressType;
	}

	public void setAddressType(Set<AddressType> addressType) {
		this.addressType = addressType;
	}
}
