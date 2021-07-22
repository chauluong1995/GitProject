package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.Customer;
import com.kymdan.backend.model.AccountDTO;
import com.kymdan.backend.model.AppUserDTO;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.services.account.AppAccountService;
import com.kymdan.backend.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    AppAccountService appAccountService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerNewCustomer(@RequestBody AccountDTO accountDTO) {
        if (appAccountService.findByUsername(accountDTO.getUsername()) != null) {
            return ResponseEntity.ok(new MessageDTO("Tên đăng nhập này đã được đăng kí ! Vui lòng điền tên đăng nhập khác !"));
        } else if (customerService.findByEmail(accountDTO.getAppUser().getEmail()) != null) {
            return ResponseEntity.ok(new MessageDTO("Email này đã được đăng kí ! Vui lòng nhập email khác !"));
        } else {
            return ResponseEntity.ok(appAccountService.save(accountDTO));
        }
    }

    @GetMapping("/information/{name}")
    public ResponseEntity<Customer> getInformationByEmail(@PathVariable String name) {
        Customer customer = this.customerService.findByName(name);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping(value = "/edit-information")
    public ResponseEntity<?> editInformation(@RequestBody AppUserDTO appUserDTO) {
        return ResponseEntity.ok(customerService.editInformation(appUserDTO));
    }

    @GetMapping("/edit-password/{username}/{oldPassword}/{newPassword}")
    public ResponseEntity<?> editPassword(@PathVariable String username, @PathVariable String oldPassword,
                                          @PathVariable String newPassword) {
        return ResponseEntity.ok(customerService.editPassword(username, oldPassword, newPassword));
    }
}
