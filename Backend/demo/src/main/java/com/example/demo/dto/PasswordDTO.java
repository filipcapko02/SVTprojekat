package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordDTO {
    private String OldPassword;
    private String NewPassword1;
    private String NewPassword2;
}
