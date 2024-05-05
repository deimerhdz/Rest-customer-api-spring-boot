package com.application.rest.model.dao;

import com.application.rest.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer,Long> {

}
