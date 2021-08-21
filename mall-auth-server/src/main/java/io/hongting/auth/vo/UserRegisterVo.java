package io.hongting.auth.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author hongting
 * @create 2021 07 21 3:43 PM
 */

@Data
public class UserRegisterVo {

    @NotEmpty(message = "cannot be empty")
    @Length(min=6, max=18, message="username between 6 - 18 characters")
    private  String userName;

    @NotEmpty(message = "cannot be empty")
    @Length(min=6, max=18, message="password between 6 - 18 characters")
    private String password;

    @NotEmpty(message = "cannot be empty")
    @Pattern(regexp = "^(01)[0-46-9]*[0-9]{7,8}$")
    private String phone;

    @NotEmpty(message = "cannot be empty")
    private String code;
}
