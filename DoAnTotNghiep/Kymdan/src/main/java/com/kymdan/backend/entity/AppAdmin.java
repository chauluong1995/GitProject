package com.kymdan.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "app_admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "full_name", columnDefinition = "VARCHAR(50)")
    private String fullName;

    @Column(name = "gender", columnDefinition = "VARCHAR(50)")
    private String gender;

    @Column(name = "birthday", columnDefinition = "DATE")
    private LocalDate birthday;

    @Column(name = "address", columnDefinition = "VARCHAR(50)")
    private String address;

    @Column(name = "phone", columnDefinition = "VARCHAR(50)")
    private String phone;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    // relationship

    @OneToOne
    @JoinColumn(name = "app_account_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private AppAccount appAccount;
}
