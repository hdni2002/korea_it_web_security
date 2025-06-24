package com.koreait.SpringSecurityStudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SignupReqDto {
    private String username;
    private String password;
    private String email;

}
