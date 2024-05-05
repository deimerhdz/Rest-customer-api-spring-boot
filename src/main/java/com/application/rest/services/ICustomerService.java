package com.application.rest.services;

import com.application.rest.model.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO>  listAll();
    CustomerDTO save(CustomerDTO customer);
    CustomerDTO findById(Long id);
    void delete (CustomerDTO customer);
    boolean existById(Long id);
}
