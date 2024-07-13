package com.sapient.users.service;

import com.sapient.users.dto.CustomerDetailsDto;

public interface ICustomerService {

    CustomerDetailsDto fetchCustomerDetails(Long mobileNumber);
    Long createCustomer(CustomerDetailsDto customerDetailsDto);


}
