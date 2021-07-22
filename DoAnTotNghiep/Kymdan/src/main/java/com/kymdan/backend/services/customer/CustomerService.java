package com.kymdan.backend.services.customer;

import com.kymdan.backend.entity.Customer;
import com.kymdan.backend.model.AppUserDTO;
import com.kymdan.backend.model.MessageDTO;

public interface CustomerService {
    Customer findByEmail(String email);

    Customer findByName(String name);

    MessageDTO editInformation(AppUserDTO appUserDTO);

    MessageDTO editPassword(String username, String oldPassword, String newPassword);
}
