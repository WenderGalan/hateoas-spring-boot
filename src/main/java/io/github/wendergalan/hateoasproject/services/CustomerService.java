package io.github.wendergalan.hateoasproject.services;

import io.github.wendergalan.hateoasproject.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> allCustomers();

    Customer getCustomerDetail(final String id);

}
