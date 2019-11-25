package io.github.wendergalan.hateoasproject.services;

import io.github.wendergalan.hateoasproject.models.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity allCustomers();

    ResponseEntity getCustomerDetail(final long id);

    ResponseEntity deleteById(long customerId);

    ResponseEntity save(Customer customer);

    ResponseEntity update(long customerId, Customer customer);
}
