package com.application.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotBlank
    @Size(min = 3, message = "Must be at least 3 letter long")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "Must be at least minimum of 10")
    private String categoryDescription;

}
