package com.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private Short role;
    private Short gender;
    private String email;
    private String phone;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
