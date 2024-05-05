package com.application.rest.controllers;
import com.application.rest.exception.BadRequestException;
import com.application.rest.exception.ResourceNotFoundException;
import com.application.rest.model.dto.CustomerDTO;
import com.application.rest.model.payload.Message;
import com.application.rest.services.ICustomerService;
import com.application.rest.utils.ResponseUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Message<List<CustomerDTO>>> findAll(){
       List<CustomerDTO> getList =  customerService.listAll();
       if(getList == null || getList.isEmpty()){
          throw new ResourceNotFoundException("customer");
       }
        return ResponseUtils.createResponse(Message.success(getList),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Message<CustomerDTO>> create(@RequestBody @Valid CustomerDTO customerDto){
        CustomerDTO customerSave=null;
        try{
             customerSave = customerService.save(customerDto);
            return ResponseUtils.createResponse(Message.success(customerSave),HttpStatus.CREATED);
        }catch (DataAccessException e){
            throw new BadRequestException(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Message<CustomerDTO>> update(@PathVariable Long id, @RequestBody @Valid CustomerDTO customerDto){
        CustomerDTO customerUpdate=null;
        try{
            if(customerService.existById(id)){
                 customerDto.setId(id);
                 customerUpdate = customerService.save(customerDto);
                 return ResponseUtils.createResponse(Message.success(customerUpdate),HttpStatus.CREATED);
            }else{
                throw new ResourceNotFoundException("customer","id",id);
            }
        }catch (DataAccessException e){
           throw new BadRequestException(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            CustomerDTO customerDelete = customerService.findById(id);
            customerService.delete(customerDelete);
            return ResponseUtils.createResponse(Message.success(customerDelete),HttpStatus.OK);
        }catch (DataAccessException e){
            return ResponseUtils.createResponse(Message.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Message<CustomerDTO>> showById(@PathVariable Long id){
        CustomerDTO customer = customerService.findById(id);
        if(customer == null){
           throw  new ResourceNotFoundException("customer","id",id);
        }
        return  ResponseUtils.createResponse(Message.success(customer),HttpStatus.OK);
    }
}
