package com.kymdan.backend.repository;

import com.kymdan.backend.entity.AppAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppAdminRepository extends JpaRepository<AppAdmin, Long> {
}
