package com.kymdan.backend.services.account;

import com.kymdan.backend.entity.AppAccount;
import com.kymdan.backend.model.AccountDTO;
import com.kymdan.backend.model.MessageDTO;

public interface AppAccountService {
    MessageDTO save(AccountDTO accountDTO);

    AppAccount findByUsername(String username);
}
