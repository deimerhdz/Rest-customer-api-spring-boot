package com.application.rest.mappers;

import com.application.rest.model.dto.CustomerDTO;
import com.application.rest.model.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerDTO customerDTO);

    CustomerDTO toCustomerDTO(Customer customer);
}
