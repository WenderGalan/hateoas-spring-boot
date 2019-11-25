package io.github.wendergalan.hateoasproject.controllers;

import io.github.wendergalan.hateoasproject.models.Customer;
import io.github.wendergalan.hateoasproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity getCustomerById(@PathVariable long customerId) {
        return customerService.getCustomerDetail(customerId);
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        return customerService.allCustomers();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity deleteById(@PathVariable long customerId) {
        return customerService.deleteById(customerId);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity update(@PathVariable long customerId, @RequestBody Customer customer) {
        return customerService.update(customerId, customer);
    }
}
