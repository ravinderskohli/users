package com.sapient.users.service.impl;

import com.sapient.users.dto.CustomerDetailsDto;
import com.sapient.users.entity.Customer;
import com.sapient.users.exception.ResourceNotFoundException;
import com.sapient.users.mapper.CustomerMapper;
import com.sapient.users.repository.CustomerRepository;
import com.sapient.users.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Override
    public CustomerDetailsDto fetchCustomerDetails(Long customerId) {
       Customer customer = customerRepository.findByCustomerId(customerId).orElseThrow( () ->
               new ResourceNotFoundException("Customer","customerId", customerId+""));
        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer,new CustomerDetailsDto());

        return customerDetailsDto;
    }

    @Override
    public Long createCustomer(CustomerDetailsDto customerDetailsDto) {
        Customer customer = createNewCustomer(customerDetailsDto);
        Customer savedCustomer = customerRepository.save(customer);
        logger.info("Create new customer", savedCustomer.getCustomerId());
        return  savedCustomer.getCustomerId();

/*        if(!Objects.nonNull(savedCustomer))
            sendCommunication(customerDetailsDto);*/
    }

    private Customer createNewCustomer(CustomerDetailsDto customerDetailsDto) {
        Customer customer = new Customer();
        long randomCustomerNumber = 1000000000L + new Random().nextInt(900000000);
        customer.setCustomerId(randomCustomerNumber);
        customer.setName(customerDetailsDto.getName());
        customer.setEmail(customerDetailsDto.getEmail());
        customer.setMobileNumber(customerDetailsDto.getMobileNumber());

        return customer;
    }
}

