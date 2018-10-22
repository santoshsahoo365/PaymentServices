package com.photonInfotech.citiBankPOC.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.photonInfotech.citiBankPOC.validation.annotation.DateAnnotation;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column(unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ApiModelProperty(notes = "Name should have atleast 2 characters")
	@Column(unique = true)
	@NotNull(message = "Name cannot be blank")
	@Size(min = 2, max = 100, message = "Name must be 2 to 100 characters")
	private String name;

	@NotNull(message = "Federal Tax ID is needed")
	private String fedTaxId;

	private String doingBusinessAsName;

	@NotNull(message = "The date of establishment cannot be null")
	@Size(min = 8, max = 25, message = "The date of establishment has to be 10 characters long.")
	@DateAnnotation(message = "Valid Date format is YYYY-MM-DD and MM/DD/YYYY")
	private String dateEstablished;

	@NotNull(message = "Formed in USA or not cannot be null")
	private boolean formedInUsa;

	@NotNull(message = "Current Client or not cannot be null")
	private boolean currentClient;

	@NotNull(message = "Trade on Stocks or not cannot be null")
	private boolean tradeOnStocks;

	@Column(unique = true, nullable = false)
	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email format")
	@Size(min = 2, max = 100, message = "Email must be 2 to 100 characters")
	private String email;

	@Valid
	@Embedded
	private NAICS naics;

	@Valid
	@Embedded
	private BusinessIdentification businessIdentification;

	@Valid
	@Embedded
	private BusinessSize businessSize;

	@NotNull
	private boolean enabled;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@Valid
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Set<Address> address;

	@Valid
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Set<AccountType> accountType;

	public Account() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFedTaxId() {
		return fedTaxId;
	}

	public void setFedTaxId(String fedTaxId) {
		this.fedTaxId = fedTaxId;
	}

	public String getDoingBusinessAsName() {
		return doingBusinessAsName;
	}

	public void setDoingBusinessAsName(String doingBusinessAsName) {
		this.doingBusinessAsName = doingBusinessAsName;
	}

	public String getDateEstablished() {
		return dateEstablished;
	}

	public void setDateEstablished(String dateEstablished) {
		this.dateEstablished = dateEstablished;
	}

	public boolean isFormedInUsa() {
		return formedInUsa;
	}

	public void setFormedInUsa(boolean formedInUsa) {
		this.formedInUsa = formedInUsa;
	}

	public boolean isCurrentClient() {
		return currentClient;
	}

	public void setCurrentClient(boolean currentClient) {
		this.currentClient = currentClient;
	}

	public boolean isTradeOnStocks() {
		return tradeOnStocks;
	}

	public void setTradeOnStocks(boolean tradeOnStocks) {
		this.tradeOnStocks = tradeOnStocks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NAICS getNaics() {
		return naics;
	}

	public void setNaics(NAICS naics) {
		this.naics = naics;
	}

	public BusinessIdentification getBusinessIdentification() {
		return businessIdentification;
	}

	public void setBusinessIdentification(BusinessIdentification businessIdentification) {
		this.businessIdentification = businessIdentification;
	}

	public BusinessSize getBusinessSize() {
		return businessSize;
	}

	public void setBusinessSize(BusinessSize businessSize) {
		this.businessSize = businessSize;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<AccountType> getAccountType() {
		return accountType;
	}

	public void setAccountType(Set<AccountType> accountType) {
		this.accountType = accountType;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

}
