package com.application.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 2, message = "Name must be minimum of two characters")
    private String name;

    @Email(message = "Email Address is not valid")
    private String email;

    @NotEmpty
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Size(max = 16, message = "Password must be maximum of 16 characters long")
    // @Pattern(regexp="")
    private String password;

    @NotNull
    private String about;

}
