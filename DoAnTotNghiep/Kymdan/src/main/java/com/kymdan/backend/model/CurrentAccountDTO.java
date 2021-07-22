package com.kymdan.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentAccountDTO {
    private Long id;
    private String username;
    private String token;
    private String fullName;
    private String role;
}
