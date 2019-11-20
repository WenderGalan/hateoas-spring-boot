package io.github.wendergalan.hateoasproject.models;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

public class Customer extends RepresentationModel {
    private String customerId;
    private String customerName;
    private String companyName;

    public Customer(String customerId, String customerName, String companyName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.companyName = companyName;
        this.add(new Link("http://localhost:8080/customers/10A"));
    }

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
