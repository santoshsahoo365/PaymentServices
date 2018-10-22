package com.photonInfotech.citiBankPOC.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class NAICS {

    @NotNull(message = "Category Description cannot be blank")
    private String categoryDescription;

    @NotNull(message = "Sub-Category Description cannot be blank")
    private String subcategoryDescription;

    @NotNull(message = "NAICS Classification cannot be blank")
    private String naicsClassification;

    @NotNull(message = "Business Classification cannot be blank")
    private String businessClassification;

    public NAICS() {
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getSubcategoryDescription() {
        return subcategoryDescription;
    }

    public void setSubcategoryDescription(String subcategoryDescription) {
        this.subcategoryDescription = subcategoryDescription;
    }

    public String getNaicsClassification() {
        return naicsClassification;
    }

    public void setNaicsClassification(String naicsClassification) {
        this.naicsClassification = naicsClassification;
    }

    public String getBusinessClassification() {
        return businessClassification;
    }

    public void setBusinessClassification(String businessClassification) {
        this.businessClassification = businessClassification;
    }

}
