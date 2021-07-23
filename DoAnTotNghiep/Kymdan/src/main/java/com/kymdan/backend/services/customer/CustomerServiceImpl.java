package com.kymdan.backend.services.customer;

import com.kymdan.backend.entity.AppAccount;
import com.kymdan.backend.entity.Customer;
import com.kymdan.backend.model.AppUserDTO;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.repository.AppAccountRepository;
import com.kymdan.backend.repository.CustomerRepository;
import com.kymdan.backend.services.account.AppAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    AppAccountRepository appAccountRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AppAccountService appAccountService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

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
        MessageDTO messageDTO = new MessageDTO();
        AppAccount account = this.appAccountService.findByUsername(username);

        if (bcryptEncoder.matches(oldPassword, account.getPassword())) {
            account.setPassword(bcryptEncoder.encode(newPassword));
            this.appAccountRepository.save(account);
            messageDTO.setMessage("Thay đổi mật khẩu thành công !");
        } else {
            messageDTO.setMessage("Sai mật khẩu ! Vui lòng thử lại sau !");
        }

        return messageDTO;
    }
}
