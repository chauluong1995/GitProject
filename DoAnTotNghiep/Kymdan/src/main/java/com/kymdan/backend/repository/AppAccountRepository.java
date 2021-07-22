package com.kymdan.backend.repository;

import com.kymdan.backend.entity.AppAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppAccountRepository extends JpaRepository<AppAccount, Long> {
    AppAccount findByUsername(String username);
}
