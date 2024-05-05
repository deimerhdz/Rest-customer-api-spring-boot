package com.application.rest.services.impl;
import com.application.rest.controllers.CustomerController;
import com.application.rest.mappers.CustomerMapper;
import com.application.rest.model.dao.CustomerDao;
import com.application.rest.model.dto.CustomerDTO;
import com.application.rest.model.entity.Customer;
import com.application.rest.services.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    CustomerMapper customerMapper;
    Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public List<CustomerDTO> listAll() {

        List<Customer> customers = (List<Customer>) customerDao.findAll();
        List<CustomerDTO> customerDTOS = customers.stream().map(customer -> customerMapper.toCustomerDTO(customer)).collect(Collectors.toList());
        return customerDTOS;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDto) {
        Customer customer = customerMapper.toCustomer(customerDto);
        return customerMapper.toCustomerDTO(customerDao.save(customer));
    }

    @Override
    public CustomerDTO findById(Long id) {
        return customerMapper.toCustomerDTO(customerDao.findById(id).orElse(null));
    }

    @Override
    public void delete(CustomerDTO customerDto) {
        Customer customer = customerMapper.toCustomer(customerDto);
        customerDao.delete(customer);
    }

    @Override
    public boolean existById(Long id) {
        return customerDao.existsById(id);
    }
}
