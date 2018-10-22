package com.photonInfotech.citiBankPOC.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.photonInfotech.citiBankPOC.validation.annotation.DateAnnotation;

@Embeddable
public class BusinessIdentification {
    @NotNull(message = "Business ID Type cannot be null")
    private String idType;

    @NotNull(message = "Business State Issued cannot be null")
    private String stateIssued;

    @NotNull(message = "Business Issuing Agency cannot be null")
    private String issuingAgency;

    @NotNull(message = "Business Issue Date cannot be null")
    @Size(min = 8, max = 25, message = "Business Issue Date has to be 10 characters long.")
    @DateAnnotation(message = "Valid Date format is YYYY-MM-DD and MM/DD/YYYY")
    private String issueDate;

    @NotNull(message = "Business hasissuedate or not cannot be blank")
    private boolean hasIssueDate;

    @NotNull(message = "Business Id number cannot be blank")
    private String idNumber;

    public BusinessIdentification() {
        super();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getStateIssued() {
        return stateIssued;
    }

    public void setStateIssued(String stateIssued) {
        this.stateIssued = stateIssued;
    }

    public String getIssuingAgency() {
        return issuingAgency;
    }

    public void setIssuingAgency(String issuingAgency) {
        this.issuingAgency = issuingAgency;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isHasIssueDate() {
        return hasIssueDate;
    }

    public void setHasIssueDate(boolean hasIssueDate) {
        this.hasIssueDate = hasIssueDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

}
