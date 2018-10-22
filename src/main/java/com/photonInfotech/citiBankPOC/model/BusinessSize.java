package com.photonInfotech.citiBankPOC.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class BusinessSize {

    @NotNull(message = "Annual Sales cannot be blank")
    private String annualSales;

    @NotNull(message = "Employee Count cannot be blank")
    private int employeeCount;

    public BusinessSize() {
        super();
    }

    public String getAnnualSales() {
        return annualSales;
    }

    public void setAnnualSales(String annualSales) {
        this.annualSales = annualSales;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
}
