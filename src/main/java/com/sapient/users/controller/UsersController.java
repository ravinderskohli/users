package com.sapient.users.controller;

import com.sapient.users.dto.CustomerDetailsDto;
import com.sapient.users.dto.ResponseDto;
import com.sapient.users.service.ICustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CRUD REST API for Users")
@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class UsersController {
    private  ICustomerService iCustomerService;
/*
   // public UsersController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }
*/

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDetailsDto> fetchUserDetails(@RequestParam Long customerId) {
        CustomerDetailsDto customerDetailsDto = iCustomerService.fetchCustomerDetails(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerDetailsDto customerDetailsDto) {
         Long customerId  = iCustomerService.createCustomer(customerDetailsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", "User created successfully", customerId));
    }

}
