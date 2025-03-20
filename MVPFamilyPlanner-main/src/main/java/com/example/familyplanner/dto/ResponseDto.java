package com.example.familyplanner.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseDto{
    @NotBlank
    private String name;

    @Email(message = "Email is required")
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$",
            message = "Password must contain at least one special character (!@#$%^&* etc.)")
    @Size(min = 8,max =25, message = "Password should have at least 8 symbols")
    private String password;
}

