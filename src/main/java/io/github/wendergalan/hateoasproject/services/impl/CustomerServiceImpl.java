package io.github.wendergalan.hateoasproject.services.impl;

import io.github.wendergalan.hateoasproject.controllers.CustomerController;
import io.github.wendergalan.hateoasproject.models.Customer;
import io.github.wendergalan.hateoasproject.services.CustomerService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public ResponseEntity allCustomers() {
        List<Customer> customers = new ArrayList<>(createCustomers().values());
        customers.forEach(customer -> {
            // Adiciona ele mesmo
            customer.add(linkTo(CustomerController.class).withSelfRel().withType(HttpMethod.GET.toString()));
            // Adiciona o get by ID
            customer.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getCustomerId())).withRel("details").withType(HttpMethod.GET.toString()));
            // Adiciona a remoção do item
            customer.add(linkTo(methodOn(CustomerController.class).deleteById(customer.getCustomerId())).withRel("delete").withType(HttpMethod.DELETE.toString()));
            // Adiciona o save item
            customer.add(linkTo(methodOn(CustomerController.class).update(customer.getCustomerId(), customer)).withRel("update").withType(HttpMethod.PUT.toString()));
        });
        return ResponseEntity.ok(customers);
    }

    @Override
    public ResponseEntity getCustomerDetail(final long customerId) {
        Customer customer = createCustomers().get(customerId);
        // Adiciona a própria URL
        customer.add(linkTo(methodOn(CustomerController.class).getCustomerById(customerId)).withSelfRel().withType(HttpMethod.GET.toString()));
        // Adiciona a busca de todos os itens
        customer.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers").withType(HttpMethod.GET.toString()));
        // Adiciona a remoção do item
        customer.add(linkTo(methodOn(CustomerController.class).deleteById(customerId)).withRel("delete").withType(HttpMethod.DELETE.toString()));
        return ResponseEntity.ok(customer);
    }

    @Override
    public ResponseEntity deleteById(long customerId) {
        // Implementes
        return null;
    }

    @Override
    public ResponseEntity save(Customer customer) {
        // Detalhes do item
        customer.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getCustomerId())).withRel("details").withType(HttpMethod.GET.toString()));
        // Busca todos
        customer.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers").withType(HttpMethod.GET.toString()));
        // Update item
        customer.add(linkTo(methodOn(CustomerController.class).update(customer.getCustomerId(), customer)).withRel("update").withType(HttpMethod.PUT.toString()));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getCustomerId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity update(long customerId, Customer customer) {
        return null;
    }

    private HashMap<Long, Customer> createCustomers() {
        HashMap<Long, Customer> customerMap = new HashMap<>();
        final Customer customerOne = new Customer(1L, "Jane", "ABC Company");
        final Customer customerTwo = new Customer(2L, "Bob", "XYZ Company");
        final Customer customerThree = new Customer(3L, "Tim", "CKV Company");

        customerMap.put(1L, customerOne);
        customerMap.put(2L, customerTwo);
        customerMap.put(3L, customerThree);
        return customerMap;
    }

}
