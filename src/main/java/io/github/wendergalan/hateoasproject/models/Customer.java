package io.github.wendergalan.hateoasproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
public class Customer extends RepresentationModel {
    private long customerId;
    private String customerName;
    private String companyName;
}
