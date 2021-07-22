package com.kymdan.backend.services.customer;

import com.kymdan.backend.entity.Customer;
import com.kymdan.backend.model.AppUserDTO;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findByEmail(String email) {
        return this.customerRepository.findByEmail(email);
    }

    @Override
    public Customer findByName(String name) {
        return this.customerRepository.findByFullName(name);
    }

    @Override
    public MessageDTO editInformation(AppUserDTO appUserDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Customer customer = this.customerRepository.findByEmail(appUserDTO.getEmail());
            customer.setBirthday(appUserDTO.getBirthday());
            customer.setAddress(appUserDTO.getAddress());
            customer.setPhone(appUserDTO.getPhone());

            messageDTO.setMessage("Sửa thông tin tài khoản thành công !");
            this.customerRepository.save(customer);
        } catch (Exception e) {
            messageDTO.setMessage("Lỗi hệ thống ! Vui lòng thử lại sau !");
        }

        return messageDTO;
    }

    @Override
    public MessageDTO editPassword(String username, String oldPassword, String newPassword) {
        return null;
    }
}
