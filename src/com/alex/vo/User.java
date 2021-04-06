package com.alex.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer id;
    private String username;
    public String password;
}
