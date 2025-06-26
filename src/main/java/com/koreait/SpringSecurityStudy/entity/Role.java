package com.koreait.SpringSecurityStudy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleNameKor;
}
